package com.Cosmo.salaoBeleza.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "agendamentos", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"data", "hora"})
})
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate data;
    private LocalTime hora;
    private String servico;

  
    public Long getId() {
         return id; }

    public void setId(Long id) {
         this.id = id; }

    public String getNome() {
         return nome; }

    public void setNome(String nome) {
         this.nome = nome; }

    public LocalDate getData() {
         return data; }

    public void setData(LocalDate data) { 
        this.data = data; }

    public LocalTime getHora() {
         return hora; }

    public void setHora(LocalTime hora) {
         this.hora = hora; }

    public String getServico() {
         return servico; }

    public void setServico(String servico) {
         this.servico = servico; }
}