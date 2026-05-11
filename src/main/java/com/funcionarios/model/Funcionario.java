package com.funcionarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @NotBlank(message = "O cargo é obrigatório.")
    private String cargo;

    @NotBlank(message = "O departamento é obrigatório.")
    private String departamento;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotNull(message = "O salário é obrigatório.")
    @Positive(message = "O salário deve ser maior que zero.")
    private BigDecimal salario;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cargo, String departamento, String email, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
        this.email = email;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
