package com.telecom.dados.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.telecom.dados.model.ContatoModel;

@Repository
public interface ContatoRepository {
	
	public ContatoModel findFirstByNome(String nome);
	public List<ContatoModel> findAllByNomeIgnoreCaseContaining(String nome);

}
