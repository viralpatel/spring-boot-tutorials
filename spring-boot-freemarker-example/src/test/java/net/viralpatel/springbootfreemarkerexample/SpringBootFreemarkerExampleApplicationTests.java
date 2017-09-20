package net.viralpatel.springbootfreemarkerexample;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class SpringBootFreemarkerExampleApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private CustomerService customerService;

	@Test
	public void testIndexPage() {

		ResponseEntity<String> response = testRestTemplate.getForEntity("/", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).contains("Steve");
	}

	@Test
	public void testDeleteCustomer() {

		
		Customer customer = customerService.find(101).get();
		customerService.remove(101);

		List<Customer> all = customerService.findAll();

		assertThat(all).doesNotContain(customer);

	}

	@Test
	public void testAddCustomer() {

		Customer customer = new Customer(211, "Donald Duck", "donald@duck.com", LocalDate.of(2000, 10, 10));

		customerService.add(customer);

		assertThat(customerService.findAll()).contains(customer);

	}
}
