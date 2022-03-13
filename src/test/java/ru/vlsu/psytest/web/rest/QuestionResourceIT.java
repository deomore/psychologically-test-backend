package ru.vlsu.psytest.web.rest;

import ru.vlsu.psytest.PsychologicallyTestBackendApp;
import ru.vlsu.psytest.domain.Question;
import ru.vlsu.psytest.domain.QuestionType;
import ru.vlsu.psytest.repository.QuestionRepository;
import ru.vlsu.psytest.service.QuestionService;
import ru.vlsu.psytest.service.dto.QuestionDTO;
import ru.vlsu.psytest.service.mapper.QuestionMapper;
import ru.vlsu.psytest.service.dto.QuestionCriteria;
import ru.vlsu.psytest.service.QuestionQueryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link QuestionResource} REST controller.
 */
