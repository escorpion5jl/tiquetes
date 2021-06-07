package edu.gonet.vuelos.application;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import edu.gonet.vuelos.business.util.Business.Constants.ErrorCode;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class vuelosTests {
	
	@LocalServerPort
	private int port;
	
	@Value("${server.servlet.context-path}")
	private String contextPath;

	@Value("${local.management.port}")
	private int mgtPort;
	
	@Value("${management.endpoints.web.base-path}")
	private String actuatorContextPath;

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private final static String TEST_DOMAIN = "http://localhost:";
	
	private void checkBussinesService (String service) {
		
		String url = TEST_DOMAIN + this.port + this.contextPath + service;
		
		System.out.println("Testing service: " + url);
		
		var entity = this.testRestTemplate.getForEntity(url, Map.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		then(entity.getBody().get("responseCode")).isIn(ErrorCode.SUCCESS);
	}
	
	@Test
	public void validateInfoApplication() throws Exception {
		
		String endpoint = "/info";
		
		System.out.println("Testing actuator: " + endpoint);
		
		var entity = this.testRestTemplate.getForEntity(
				TEST_DOMAIN + this.mgtPort + this.actuatorContextPath + endpoint, Map.class);
		
		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	

	@Test
	public void validateTiquetes() throws Exception {
		
		//TODO: hacer create y tomar el id de respuesta para consultar y remover dato durp
		String endpoint = String.format("vuelos/api/tiquetes/", 1);
		
		checkBussinesService(endpoint);
	}
}
