package com.siml.shop.Member;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "{file:src/main/webapp/WEB-INF/spring/**/*.xml}")
@WebAppConfiguration
public class JoinControllerTest {
	@Inject
	WebApplicationContext wac;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testJoin() {
		
	}

	@Test
	public void testTerms() {
	}

	@Test
	public void testTermsBooleanMemberDTOModel() {
	}

	@Test
	public void testJoinForm1() {
	}

	@Test
	public void testIdCheck() {
	}

}
