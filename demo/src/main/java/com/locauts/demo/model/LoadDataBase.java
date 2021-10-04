package com.locauts.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import com.locauts.demo.controller.ClinicaController;

import java.util.ArrayList;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean 
    CommandLineRunner initDataBase(ClinicaRepository repository, FuncionarioRepository repository2){
        return args->{
            /*Codigo de inserção de dados inicias do banco
              Primeira clinica no banco*/
            ClinicaModel clinica_braganca = new ClinicaModel("Clinica Bragança", "Rua Passarinhos Cantantes,", true, 40314400, "clinico geral", 42 , "152424637", 8);
            List<Funcionario> lista_funcionarios = new ArrayList<>();
            
            //Adicionando os Funcionarios no banco
            Funcionario funcionario01 = new Funcionario("Rosalvo Rodrigues Antônio","87643859227",5000.00,"médico especializado em pediatria");
            lista_funcionarios.add(funcionario01);
            
            Funcionario funcionario02 = new Funcionario("Jéssica Lúcia de Paula","76365349715",2000.00,"enfermeira");
            lista_funcionarios.add(funcionario02);

            clinica_braganca.setFuncionarios(lista_funcionarios);

            //Segunda clinica adicionada ao banco
            ClinicaModel clinica_atibaia = new ClinicaModel("Clinica Atibaia", "Rua dos Bobos, 00", false, 40313333, "neurologia", 35,  "1524289637", 9);
            lista_funcionarios = new ArrayList<>();

            //Adicionando Funcionarios da segunda clinica no banco
            Funcionario funcionario03 = new Funcionario("Mariana Vanessa Minnitti", "28363352374", 1500.00,"supervisora");
            lista_funcionarios.add(funcionario03);

            Funcionario funcionario04 = new Funcionario("Lucas Henriques Machado de Souza", "29736327643", 1327.00, "secretario");
            lista_funcionarios.add(funcionario04);

            clinica_atibaia.setFuncionarios(lista_funcionarios);

            //Salvando no banco e informando ao usuario
            log.info("Inserindo:" + repository.save(clinica_braganca)); 
            log.info("Inserindo:" + repository.save(clinica_atibaia)); 
            
        };
    }
}
