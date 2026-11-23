package com.Cosmo.salaoBeleza.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Cosmo.salaoBeleza.model.Agendamento;
import com.Cosmo.salaoBeleza.repository.AgendamentoRepository;

@RestController
@RequestMapping("/api/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository repository;

    @GetMapping
    public List<Agendamento> listarPorData(@RequestParam("data") String data) {
        return repository.findByData(LocalDate.parse(data));
    }

    @PostMapping
    public ResponseEntity<String> criarAgendamento(@RequestBody Agendamento agendamento) {
        try {
            repository.save(agendamento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Agendamento realizado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Este horário já está ocupado!");
        }
    }
}
