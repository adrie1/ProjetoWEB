package com.uepb.web.projetoFinal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.uepb.web.projetoFinal.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	Optional<Projeto> findByNome(String nome);

}
