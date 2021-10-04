package com.locauts.demo.model;

import org.springframework.data.repository.CrudRepository;

public interface ClinicaRepository extends CrudRepository <ClinicaModel,Long> {
    //Criamos um ClinicaRepository que faz parte do processo de salvar no banco de dados
}
