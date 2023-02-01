package com.cg.onlinevegetablestore.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinevegetablestore.entity.Vegetables;
import com.cg.onlinevegetablestore.exception.ResourceNotFoundException;
import com.cg.onlinevegetablestore.service.IVegitableService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest
public class VegetablesControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IVegitableService vegetablesService;
	
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private Vegetables vegetables;
	private Vegetables vegetables1;
	@BeforeEach
	public void init() {
		vegetables = new Vegetables(1L, "Potatoes", 45, "Veggies");
		vegetables1 = new Vegetables(3L, "Carrot", 45, "Veggies");
	
	}
	
	@Test
	public void testAddVegetables() throws Exception{
		when(vegetablesService.addVegetables((Vegetables) any(Vegetables.class))).thenReturn(vegetables);
	}
	
	@Test
	public void testlistAllVegetables() {
		List<Vegetables> veggieList = new ArrayList<Vegetables>();
		veggieList.add(vegetables);
		veggieList.add(vegetables1);
		when(vegetablesService.listAllVegetables()).thenReturn(veggieList);
	}
	
	@Test
	public void testgetVegetablesById() throws ResourceNotFoundException {	
		when(vegetablesService.getVegetablesById(anyLong())).thenReturn(vegetables);
	}

}