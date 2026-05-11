package com.funcionarios.service;

import com.funcionarios.model.Funcionario;
import com.funcionarios.repository.FuncionarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public List<Funcionario> listarTodos(){
        List<Funcionario> funcionarios = repository.findAll();
        return funcionarios;
    }

    public Funcionario buscarPorId(Long id){
        Funcionario funcionarioEncontrado = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        return funcionarioEncontrado;
    }

    public Funcionario salvarFuncionario(Funcionario funcionario){
        Funcionario funcionarioSalvo = repository.save(funcionario);
        return funcionarioSalvo;
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario){
        Funcionario funcionarioEncontrado = repository.findById(id).orElseThrow(() -> new IllegalArgumentException());

        BeanUtils.copyProperties(funcionario, funcionarioEncontrado, "id");

        return funcionarioEncontrado;
    }

    public List<Funcionario> buscarPorDepartamento(String departamento){
        List<Funcionario> funcionariosEncontrados = repository.findByDepartamento(departamento);
        return funcionariosEncontrados;
    }

    public List<Funcionario> buscarPorCargo(String cargo){
        List<Funcionario> funcionariosEncontrados = repository.findByCargo(cargo);
        return funcionariosEncontrados;
    }

    public void excluirFuncionario(Long id){
        Funcionario funcionarioEncontrado = repository.findById(id).orElseThrow(()-> new IllegalArgumentException());

        repository.delete(funcionarioEncontrado);
    }
}
