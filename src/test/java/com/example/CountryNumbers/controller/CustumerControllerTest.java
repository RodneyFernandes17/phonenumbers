package com.example.CountryNumbers.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.CountryNumbers.entity.Customer;
import com.example.CountryNumbers.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustumerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerServiceImpl customerServiceImpl;

	ArrayList<Customer> mockCustomerList = new ArrayList<Customer>(
			Arrays.asList(new Customer(1, "rodney", "(238) 9596544"), new Customer(2, "rivaldo", "(280) 9596560"),
					new Customer(3, "felisberta", "(265) 9596580")));

	String exampleCustomerJason = "{\"id\": 1,\"name\": \"Yosaf Karrouch\", \"phone\": \"(212) 698054317\" }";

	@Test
	public void getCustomersByCountry(String country) throws Exception {
		Mockito.when(customerServiceImpl.getCustomersByCountry(Mockito.anyString())).thenReturn(mockCustomerList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customersbycountry/Cape Verde")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		String expected = "{{id: 1, name: rodney,phone: (238) 9596544}, {id: 2, name: rivaldo, phone: (280) 9596560}, {id: 3, name: felisberta, phone: (265) 9596580}  }";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
