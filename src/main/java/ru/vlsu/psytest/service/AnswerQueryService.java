package ru.vlsu.psytest.service;

import java.util.List;

import javax.persistence.criteria.JoinType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.jhipster.service.QueryService;

import ru.vlsu.psytest.domain.Answer;
import ru.vlsu.psytest.domain.*; // for static metamodels
import ru.vlsu.psytest.repository.AnswerRepository;
import ru.vlsu.psytest.service.dto.AnswerCriteria;
import ru.vlsu.psytest.service.dto.AnswerDTO;
import ru.vlsu.psytest.service.mapper.AnswerMapper;

/**
 * Service for executing complex queries for {@link Answer} entities in the database.
 * The main input is a {@link AnswerCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AnswerDTO} or a {@link Page} of {@link AnswerDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AnswerQueryService extends QueryService<Answer> {

    private final Logger log = LoggerFactory.getLogger(AnswerQueryService.class);

    private final AnswerRepository answerRepository;

    private final AnswerMapper answerMapper;

    public AnswerQueryService(AnswerRepository answerRepository, AnswerMapper answerMapper) {
        this.answerRepository = answerRepository;
        this.answerMapper = answerMapper;
    }

    /**
     * Return a {@link List} of {@link AnswerDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AnswerDTO> findByCriteria(AnswerCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Answer> specification = createSpecification(criteria);
        return answerMapper.toDto(answerRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link AnswerDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AnswerDTO> findByCriteria(AnswerCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Answer> specification = createSpecification(criteria);
        return answerRepository.findAll(specification, page)
            .map(answerMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AnswerCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<Answer> specification = createSpecification(criteria);
        return answerRepository.count(specification);
    }

    /**
     * Function to convert {@link AnswerCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Answer> createSpecification(AnswerCriteria criteria) {
        Specification<Answer> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), Answer_.id));
            }
            if (criteria.getAnswer() != null) {
                specification = specification.and(buildSpecification(criteria.getAnswer(), Answer_.answer));
            }
            if (criteria.getQuestionId() != null) {
                specification = specification.and(buildSpecification(criteria.getQuestionId(),
                    root -> root.join(Answer_.question, JoinType.LEFT).get(Question_.id)));
            }
            if (criteria.getResultTestId() != null) {
                specification = specification.and(buildSpecification(criteria.getResultTestId(),
                    root -> root.join(Answer_.resultTest, JoinType.LEFT).get(ResultTest_.id)));
            }
        }
        return specification;
    }
}
