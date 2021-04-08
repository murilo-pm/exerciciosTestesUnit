package com.telecom.dados;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.telecom.dados.model.ContatoModel;
import com.telecom.dados.repository.ContatoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContatosRepositoryIntegrationTest {

	@Autowired
	private ContatoRepository contatoRepository;

	@Before
	public void start() {
		ContatoModel contato = new ContatoModel("Chefe", "0y", "9xxxxxxx9");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);

		contato = new ContatoModel("Novo Chefe", "0y", "8xxxxxxx8");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);

		contato = new ContatoModel("chefe Mais Antigo", "0y", "7xxxxxxx7");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);

		contato = new ContatoModel("Amigo", "0z", "5xxxxxxx5");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
	}

	@Test
	public void findByNomeRetornaContato() throws Exception {

		ContatoModel contato = contatoRepository.findFirstByNome("Chefe");

		Assert.assertTrue(contato.getNome().equals("Chefe"));
	}

	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContato() {

		List<ContatoModel> contatos = contatoRepository.findAllByNomeIgnoreCaseContaining("chefe");

		Assert.assertEquals(3, contatos.size());
	}

	@After
	public void end() {
		contatoRepository.deleteAll();
	}

	
}
