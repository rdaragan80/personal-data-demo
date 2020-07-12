package com.example.personaldata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.personaldata.controller.PersonalDataController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private PersonalDataController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
