package com.personal.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.personal.junit.dto.Employee;
import com.personal.junit.service.EmployeeService;

@SpringBootTest
class JunitTestApplicationTests {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	@MockBean
	EmployeeService employeeServ;
	

	@Test
	void contextLoads() throws Exception {
		/*
		 * 
		 * this.mockMvc.perform(get("/employee")).andExpect(status().isOk())
		 * .andExpect(content().contentType("application/json;"))
		 * .andExpect(jsonPath("$.name").value("Lalatendu")).andExpect(jsonPath(
		 * "$.empId").value("9090")) .andExpect(jsonPath("$.dept").value("FMM"));
		 * 
		 */}
	
	@Test
	void empTests() throws Exception{
		when(employeeServ.getEmployee()).thenReturn(new Employee("Swadesh","6767","Mindfire"));
	assertEquals(employeeServ.getEmployee().getDept(),"Mindfre");
	}
	
	
	

}
