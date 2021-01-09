package br.com.itau.integrator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.itau.integrador.util.Util;

@SpringBootTest(classes = Util.class)
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class CepControllerTest {
	

	@Test
	public void testarCEPValido() {
		String cep = "12345678";
		boolean resultado = Util.validarCEP(cep);
		assertEquals(resultado, true);
		
	}
	
	@Test
	public void testarCEPInvalido() {
		String cep = "1234567";
		boolean resultado = Util.validarCEP(cep);
		assertEquals(resultado, false);
	}

	@Test
	public void testarCEPInvalido2() {
		String cep = "123456789";
		boolean resultado = Util.validarCEP(cep);
		assertEquals(resultado, false);
		
	}
	@Test
	public void testarCEPInvalido3() {
		String cep = "asdfghjk";
		boolean resultado = Util.validarCEP(cep);
		assertEquals(resultado, false);
		
	}
}

