package com.uepb.web.projetoFinal;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uepb.web.projetoFinal.controller.AlunoController;
import com.uepb.web.projetoFinal.dto.AlunoDTO;
import com.uepb.web.projetoFinal.model.Aluno;
import com.uepb.web.projetoFinal.repository.AlunoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AlunoController.class })
class AlunoControllerTest {

	private final String BASE_URL = "/alunos";
	private ObjectMapper objectMapper;

	@Autowired
	private AlunoController restController;

	private MockMvc mockMvc;

	@MockBean
	private AlunoRepository mockRepository;

	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
	}

	@Test
	void getAlunoById() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setId(1L);
		aluno.setNome("Sabrina");
		aluno.setEmail("sabrina@gmail.com");
		aluno.setMatricula("123456");

		when(mockRepository.findById(1L)).thenReturn(Optional.of(aluno));

		mockMvc.perform(get(BASE_URL + "/1L")).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1L)))
				.andExpect(jsonPath("$.nome", is("Sabrina"))).andExpect(jsonPath("$.email", is("sabrina@gmail.com")))
				.andExpect(jsonPath("$.matricula", is("123456")));

		verify(mockRepository, times(1)).findById(1L);
	}
	
	@Test
    void saveAluno() throws Exception {

        AlunoDTO dto = new AlunoDTO();
		dto.setNome("Fulana");
		dto.setEmail("fulana@gmail.com");
		dto.setMatricula("12345666");


        Aluno aluno = new Aluno();
        aluno.setId(1);
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setMatricula(dto.getMatricula());

        when(mockRepository.save(any(Aluno.class))).thenReturn(aluno);

        mockMvc.perform(post(BASE_URL)
                .content(objectMapper.writeValueAsString(dto))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nome", is("Fulana")))
                .andExpect(jsonPath("$.email", is("fulana@gmail.com")))
                .andExpect(jsonPath("$.matricula", is("12345666")));

        verify(mockRepository, times(1)).save(any(Aluno.class));

    }

}
