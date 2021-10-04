package com.locauts.demo.controller;

import java.util.List;

import com.locauts.demo.model.ClinicaModel;
import com.locauts.demo.model.ClinicaRepository;
import com.locauts.demo.model.Funcionario;
import com.locauts.demo.model.FuncionarioRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClinicaController {
    private static final Logger log = LoggerFactory.getLogger(ClinicaController.class);
    @Autowired
    ClinicaRepository clinicaRepository;
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    //Retorna todas as clinicas que estão no banco de dados
    @GetMapping("/clinica")
    public List<ClinicaModel> getClinica(){
        return (List<ClinicaModel>) clinicaRepository.findAll();
    }
    /*
    Fizemos este medoto get (teste) apenas para testar a aplicação
    @GetMapping("/teste")
    public String teste(){
        clinicaRepository.findAll();
        return "Os valores encontrados são: Bom diaaa!!!";
    }
    */

    //Adiciona uma clinica ao banco de dados do sistema
    @PostMapping("/clinica/criar")
    public ClinicaModel postClinica(@RequestBody ClinicaModel clinica){
        clinicaRepository.save(clinica);
        if(clinicaRepository.findById(clinica.getId()).isPresent())
            return clinica;
        return null;
    }
    //Retorna apenas a clinica pelo id indicado e seus respectivos funcionarios
    @GetMapping("/clinica/{id}")
    @ResponseBody
    public ClinicaModel getListaById(@PathVariable("id") ClinicaModel clinica){
        return clinica;
    }

    //Retorna funcionario especificamente pelo id
    @GetMapping("/clinica/pegar_funcionario/{id}")
    @ResponseBody
    public Funcionario getListaById(@PathVariable("id") Funcionario funcionario){
        return funcionario;
    }

    //Cria um funcionario e adiciona-o ao banco de dados
    @PostMapping("/clinica/criar_funcionario/{id}")
    public Funcionario postCriarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        if(clinicaRepository.findById(id).isPresent()){
            ClinicaModel clinica = clinicaRepository.findById(id).get();
            log.debug(clinica.getEspecialidade());
            funcionario.setClinica(clinica);
            funcionario= funcionarioRepository.save(funcionario);
            return funcionario;
        }
        return null;
    }
    
    //Altera um funcionario que já está cadastrado no banco
    @PutMapping("/clinica/alterar_funcionario/{id}")
    public Funcionario putAlterarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        if(funcionarioRepository.findById(id).isPresent()){
            Funcionario funcionarioDb = funcionarioRepository.findById(id).get();
            funcionarioDb.setCargo(funcionario.getCargo());
            funcionarioDb.setCpf(funcionario.getCpf());
            funcionarioDb.setNome_fun(funcionario.getNome_fun());
            funcionarioDb.setSalario(funcionario.getSalario());

            funcionarioRepository.save(funcionarioDb);
            return funcionario;
        }
        return null;
    }

    //Deleta um funcionario do banco de dados
    @DeleteMapping("/clinica/deletar_funcionario/{id}")
    public Funcionario deleteFuncionario(@PathVariable Long id){
        if(funcionarioRepository.findById(id).isPresent()){
            Funcionario funcionario = funcionarioRepository.findById(id).get();
            funcionarioRepository.delete(funcionario);
            return funcionario;
        }
        return null;
    }
    
}
