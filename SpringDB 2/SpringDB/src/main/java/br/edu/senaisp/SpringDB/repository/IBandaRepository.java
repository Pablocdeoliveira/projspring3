package br.edu.senaisp.SpringDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.senaisp.SpringDB.model.Banda;

public interface IBandaRepository 
	extends JpaRepository<Banda, Integer> {

}
