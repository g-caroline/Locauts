package com.locauts.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
      //Criamos um FuncionarioRepository que faz parte do processo de salvar no banco de dados
}

