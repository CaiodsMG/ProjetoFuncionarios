package com.funcionarios.controller;

import com.funcionarios.model.Funcionario;
import com.funcionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Funcionario buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/buscarPorDepartamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> buscarPorDepartamento(@RequestParam String departamento){
        return service.buscarPorDepartamento(departamento);
    }

    @GetMapping("/buscarPorCargo")
    @ResponseStatus(HttpStatus.OK)
    public List<Funcionario> buscarPorCargo(@RequestParam String cargo){
        return service.buscarPorCargo(cargo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario salvarFuncionario(@RequestBody Funcionario funcionario){
        return service.salvarFuncionario(funcionario);
    }

    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Funcionario atualizarFuncionar(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return service.atualizarFuncionario(id, funcionario);
    }

    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirFuncionario(@PathVariable Long id){
        service.excluirFuncionario(id);
    }
}
