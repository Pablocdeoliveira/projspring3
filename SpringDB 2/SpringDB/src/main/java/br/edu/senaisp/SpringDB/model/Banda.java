package br.edu.senaisp.SpringDB.model;


import br.edu.senaisp.SpringDB.model.dto.BandaDTO;
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Banda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String nome;

	private int anoLancamento;
	
	private String vocalista;
	
	public Banda() {}
	
	public Banda(Integer id, String nome, int anoLancamento) {
		this.id = id;
		this.nome = nome;
		this.anoLancamento = anoLancamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public BandaDTO converte() {
		BandaDTO bDTO = 
				new BandaDTO(
						this.getId(), 
						this.getNome());
		return bDTO;
	}
	
	public static Banda desverte(BandaDTO bDTO) {

		return 	new Banda(bDTO.getId(),
					bDTO.getNome(),
						0);
		
	}	
	
}
