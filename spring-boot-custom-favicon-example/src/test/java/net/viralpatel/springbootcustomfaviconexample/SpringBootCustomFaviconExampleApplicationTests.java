package net.viralpatel.springbootcustomfaviconexample;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringBootCustomFaviconExampleApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testIfCustomeFaviconIsReturned() {
		
		HttpHeaders headers = restTemplate.headForHeaders("/favicon.ico");
		
		assertThat(headers.getContentLength()).isEqualTo(5430);

	}

}
