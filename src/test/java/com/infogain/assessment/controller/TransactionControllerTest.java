package com.infogain.assessment.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infogain.assessment.repository.TransactionRepository;
import com.infogain.assessment.service.TransactionResponse;
import com.infogain.assessment.service.TransactionService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class TransactionControllerTest {
	
	@Mock
	TransactionService transactionService;
	
	
	
	@Autowired
	private MockMvc mockMvc;
	
	

	@Test
	void test() throws Exception {
		String inputString = "{\"total\":290,\"monthly\":[{\"month\":8,\"rewardpoint\":100}]}";
		ObjectMapper mapper = new ObjectMapper();
		TransactionResponse map = mapper.readValue(inputString, TransactionResponse.class);
		when(transactionService.getRewardForEachMonth(1, LocalDateTime.now())).thenReturn(map);
		
		  mockMvc.perform(
				  get("/transaction/rewards")
				  .queryParam("id", String.valueOf(1))
				  .queryParam("date", LocalDateTime.now().toString())
				  ).andExpect(status().isOk())
		  		  .andExpect(content().contentType(MediaType.APPLICATION_JSON));
		  		
		  		
		 
		 
		
	}

}
