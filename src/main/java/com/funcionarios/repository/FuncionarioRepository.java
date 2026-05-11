package com.funcionarios.repository;

import com.funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

    List<Funcionario> findByDepartamentoContainingIgnoreCase(String departamento);

    List<Funcionario> findByCargoContainingIgnoreCase(String cargo);
}
