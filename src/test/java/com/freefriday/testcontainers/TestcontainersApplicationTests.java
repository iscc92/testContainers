package com.freefriday.testcontainers;

import com.freefriday.testcontainers.model.Customer;
import com.freefriday.testcontainers.service.CustomerDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TestcontainersApplicationTests extends ContainerAbstractClass{

	@Autowired
	private CustomerDao costumerDao;

	@Test
	void measuringDbSize() {
		//Given & When
		List<Customer> customers = costumerDao.findAll();

		//Then
		assertThat(customers).hasSize(2);
	}

}
