package ru.vlsu.psytest.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.psytest.domain.User;
import ru.vlsu.psytest.service.*;
import ru.vlsu.psytest.service.dto.*;
import ru.vlsu.psytest.web.rest.AnswerResource;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestServiceImpl implements TestService {
    private final Logger log = LoggerFactory.getLogger(AnswerResource.class);

    private final QuestionService questionService;

    private final AnswerService answerService;

    private final ResultTestService resultTestService;

    private final QuestionTypeService questionTypeService;

    private final UserService userService;

    public TestServiceImpl(QuestionService questionService, AnswerService answerService, ResultTestService resultTestService, QuestionTypeService questionTypeService, UserService userService) {
        this.questionService = questionService;
        this.answerService = answerService;
        this.resultTestService = resultTestService;
        this.questionTypeService = questionTypeService;
        this.userService = userService;
    }

    @Override
    public ResultTestDTO solveTest(List<AnswerDTO> answers, String username) {
        log.debug("Request to save solve for test");

        List<QuestionDTO> questions = questionService.findAll();

        if (answers.size() != questions.size()) {
            //TODO throw exception
            return null;
        }
        ResultTestDTO result = new ResultTestDTO(0,0,0,0,0,0,0,0,0,0,null);
        if (username != "ANONIM") {
            Optional<UserDTO> user = userService.findUserByUserName(username);
            result.setUserId(user.get().getId());
        }

        for (AnswerDTO answer: answers) {
            Optional<QuestionDTO> question = questionService.findOne(answer.getQuestionId());
            Optional<QuestionTypeDTO> questionType = questionTypeService.findOne(question.get().getQuestionTypeId());

            switch (questionType.get().getType()) {
                case EXTRAVERSION_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setExtraversionType(result.getSensitivityType() + questionType.get().getCoefficient());
                        } else {
                            result.setExtraversionType(result.getSensitivityType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case SPONTANEITY_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setSpontaneityType(result.getSpontaneityType() + questionType.get().getCoefficient());
                        } else {
                            result.setSpontaneityType(result.getSpontaneityType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case AGGRESSIVENESS_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setAggressivenessType(result.getAggressivenessType() + questionType.get().getCoefficient());
                        } else {
                            result.setAggressivenessType(result.getAggressivenessType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case RIGIDITY_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setRigidityType(result.getRigidityType() + questionType.get().getCoefficient());
                        } else {
                            result.setRigidityType(result.getRigidityType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case INTROVERSION_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setIntroversionType(result.getIntroversionType() + questionType.get().getCoefficient());
                        } else {
                            result.setIntroversionType(result.getIntroversionType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case SENSITIVITY_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setSensitivityType(result.getSensitivityType() + questionType.get().getCoefficient());
                        } else {
                            result.setSensitivityType(result.getSensitivityType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case ANXIETY_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setAnxietyType(result.getAnxietyType() + questionType.get().getCoefficient());
                        } else {
                            result.setAnxietyType(result.getAnxietyType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case LABILITY_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setLabilityType(result.getLabilityType() + questionType.get().getCoefficient());
                        } else {
                            result.setLabilityType(result.getLabilityType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case LIE_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setLieType(result.getLieType() + questionType.get().getCoefficient());
                        } else {
                            result.setLieType(result.getLieType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
                case AGGRAVATION_TYPE:
                    if (answer.isAnswer()) {
                        if (question.get().isIsAdd()) {
                            result.setAggravationType(result.getAggravationType() + questionType.get().getCoefficient());
                        } else {
                            result.setAggravationType(result.getAggravationType() - questionType.get().getCoefficient());
                        }
                    }
                    break;
            }
        }
        result.setFinishedAt(Instant.now());
        result = resultTestService.save(result);
        for (AnswerDTO answer: answers) {
            answer.setResultTestId(result.getId());
            answerService.save(answer);
        }
        return result;
    }
}
