package com.locauts.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ClinicaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome_Clinica;
    private String endereco_Clinica; 
    private boolean instituicao_Privada;
    private int telefone;

    private String especialidade;
    private int numero_Alas;
    private String cnpj;
    private int horario_Atendimento;

    @OneToMany(mappedBy = "clinica", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    
    @JsonManagedReference
    private List<Funcionario> funcionarios;
    //Criamos os construtores(um vazio e outro não)
    public ClinicaModel(){

    }
    public ClinicaModel(String nome_Clinica, String endereco_Clinica, boolean instituicao_Privada,
            int telefone, String especialidade, int numero_Alas, String cnpj, int horario_Atendimento) {
        
        this.nome_Clinica = nome_Clinica;
        this.endereco_Clinica = endereco_Clinica;
        this.instituicao_Privada = instituicao_Privada;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.numero_Alas = numero_Alas;
        this.cnpj = cnpj;
        this.horario_Atendimento = horario_Atendimento;
    }
    //getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isInstituicao_Privada() {
        return instituicao_Privada;
    }
    public void setInstituicao_Privada(boolean instituicao_Privada) {
        this.instituicao_Privada = instituicao_Privada;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    public int getNumero_Alas() {
        return numero_Alas;
    }
    public void setNumero_Alas(int numero_Alas) {
        this.numero_Alas = numero_Alas;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public int getHorario_Atendimento() {
        return horario_Atendimento;
    }
    public void setHorario_Atendimento(int horario_Atendimento) {
        this.horario_Atendimento = horario_Atendimento;
    }
    public String getNome_Clinica() {
        return nome_Clinica;
    }
    public void setNome_Clinica(String nome_Clinica) {
        this.nome_Clinica = nome_Clinica;
    }
    public String getEndereco_Clinica() {
        return endereco_Clinica;
    }
    public void setEndereco_Clinica(String endereco_Clinica) {
        this.endereco_Clinica = endereco_Clinica;
    }
    
    //Criamos o setFuncionario e adicionamos um novo funcionario na classe Funcionario
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    public void addFuncionarios(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
}
