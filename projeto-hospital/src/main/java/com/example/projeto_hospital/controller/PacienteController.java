package com.example.projeto_hospital.controller;

import com.example.projeto_hospital.model.Paciente;
import com.example.projeto_hospital.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Indica que esta classe é um controlador Spring MVC.
@RequestMapping("/pacientes") // Define o prefixo da URL para todas as rotas deste controlador.
public class PacienteController {

    @Autowired // Injeta automaticamente uma instância de PacienteService.
    private PacienteService pacienteService;

    @GetMapping("/cadastrar") // Mapeia a URL "/pacientes/cadastrar" para este método.
    public String cadastrar(Model model) {
        model.addAttribute("paciente", new Paciente()); // Adiciona um novo objeto Paciente ao modelo.
        return "cadastrarPaciente"; // Retorna o nome da view (template Thymeleaf).
    }

    @PostMapping("/salvar") // Mapeia a URL "/pacientes/salvar" para este método (requisição POST).
    public String salvar(@ModelAttribute Paciente paciente) {
        pacienteService.save(paciente); // Salva o paciente no banco de dados.
        return "redirect:/pacientes/listar"; // Redireciona para a lista de pacientes.
    }

    @GetMapping("/listar") // Mapeia a URL "/pacientes/listar" para este método.
    public String listar(Model model) {
        model.addAttribute("pacientes", pacienteService.findAll()); // Adiciona a lista de pacientes ao modelo.
        return "listarPacientes"; // Retorna o nome da view (template Thymeleaf).
    }

    @GetMapping("/editar/{id}") // Mapeia a URL "/pacientes/editar/{id}" para este método.
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("paciente", pacienteService.findById(id)); // Adiciona o paciente ao modelo.
        return "editarPaciente"; // Retorna o nome da view (template Thymeleaf).
    }

    @PostMapping("/atualizar") // Mapeia a URL "/pacientes/atualizar" para este método (requisição POST).
    public String atualizar(@ModelAttribute Paciente paciente) {
        pacienteService.update(paciente); // Atualiza o paciente no banco de dados.
        return "redirect:/pacientes/listar"; // Redireciona para a lista de pacientes.
    }

    @GetMapping("/deletar/{id}") // Mapeia a URL "/pacientes/deletar/{id}" para este método.
    public String deletar(@PathVariable Long id) {
        pacienteService.delete(id); // Deleta o paciente do banco de dados.
        return "redirect:/pacientes/listar"; // Redireciona para a lista de pacientes.
    }
}