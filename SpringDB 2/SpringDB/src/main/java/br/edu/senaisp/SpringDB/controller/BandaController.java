package br.edu.senaisp.SpringDB.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.SpringDB.model.Banda;
import br.edu.senaisp.SpringDB.model.dto.BandaDTO;
import br.edu.senaisp.SpringDB.repository.IBandaRepository;


@RestController
@RequestMapping("/banda")
public class BandaController {
	
    @Autowired
	IBandaRepository repository;	

	@GetMapping()
	public List<BandaDTO> ListaBandas() {
		List<BandaDTO> tmp =  
				new ArrayList<>();
		for (Banda b : repository.findAll()) {
			tmp.add(b.converte());
			
		} 
		return tmp; 
	}
	
	@GetMapping("/{id}")
	public Optional<Banda> BuscaPorId(@PathVariable int id) {
		Optional<Banda> banda = repository.findById(id);
		
		return banda;
	}
	
	@PutMapping("/{id}")
	public String Altera(@RequestBody Banda banda, @PathVariable int id) 
	{
		banda.setNome(banda.getNome());
		return String.valueOf(  banda  ) ;
	}
	
	@PostMapping()
	public Banda Novo(@RequestBody Banda banda) {
		repository.save(banda);
		return banda;
	}
	
}
