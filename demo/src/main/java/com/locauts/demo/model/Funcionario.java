package com.locauts.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_fun;
    private String cpf;
    private Double salario;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "clinica_fk")
    @JsonBackReference
    private ClinicaModel clinica;

    //Construtores (um com parametros e outro sem)
    public Funcionario(){

    }

    public Funcionario(String nome_fun, String cpf, double salario, String cargo) {
        this.nome_fun = nome_fun;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome_fun() {
        return nome_fun;
    }
    public void setNome_fun(String nome_fun) {
        this.nome_fun = nome_fun;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    //Criamos um getClinica e criamos uma clinica na classe ClinicaModel
    public ClinicaModel getClinica() {
        return clinica;
    }

    public void setClinica(ClinicaModel clinica) {
        this.clinica = clinica;
    }

    
}
