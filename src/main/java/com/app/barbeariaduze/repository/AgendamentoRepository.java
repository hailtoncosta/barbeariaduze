package com.app.barbeariaduze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.barbeariaduze.model.Agendamento;

@Transactional
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{

}
