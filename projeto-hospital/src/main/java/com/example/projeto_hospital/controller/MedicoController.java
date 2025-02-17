package com.example.projeto_hospital.controller;

import com.example.projeto_hospital.model.Medico;
import com.example.projeto_hospital.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // Indica que esta classe é um controlador Spring MVC.
@RequestMapping("/medicos") // Define o prefixo da URL para todas as rotas deste controlador.
public class MedicoController {

    @Autowired // Injeta automaticamente uma instância de MedicoService.
    private MedicoService medicoService;

    @GetMapping("/cadastrar") // Mapeia a URL "/medicos/cadastrar" para este método.
    public String cadastrar(Model model) {
        model.addAttribute("medico", new Medico()); // Adiciona um novo objeto Medico ao modelo.
        return "cadastrarMedico"; // Retorna o nome da view (template Thymeleaf).
    }

    @PostMapping("/salvar") // Mapeia a URL "/medicos/salvar" para este método (requisição POST).
    public String salvar(@ModelAttribute Medico medico) {
        medicoService.save(medico); // Salva o médico no banco de dados.
        return "redirect:/medicos/listar"; // Redireciona para a lista de médicos.
    }

    @GetMapping("/listar") // Mapeia a URL "/medicos/listar" para este método.
    public String listar(Model model) {
        model.addAttribute("medicos", medicoService.findAll()); // Adiciona a lista de médicos ao modelo.
        return "listarMedicos"; // Retorna o nome da view (template Thymeleaf).
    }

    @GetMapping("/editar/{id}") // Mapeia a URL "/medicos/editar/{id}" para este método.
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("medico", medicoService.findById(id)); // Adiciona o médico ao modelo.
        return "editarMedico"; // Retorna o nome da view (template Thymeleaf).
    }

    @PostMapping("/atualizar") // Mapeia a URL "/medicos/atualizar" para este método (requisição POST).
    public String atualizar(@ModelAttribute Medico medico) {
        medicoService.update(medico); // Atualiza o médico no banco de dados.
        return "redirect:/medicos/listar"; // Redireciona para a lista de médicos.
    }

    @GetMapping("/deletar/{id}") // Mapeia a URL "/medicos/deletar/{id}" para este método.
    public String deletar(@PathVariable Long id) {
        medicoService.delete(id); // Deleta o médico do banco de dados.
        return "redirect:/medicos/listar"; // Redireciona para a lista de médicos.
    }
}
