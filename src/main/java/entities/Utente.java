package entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Utenti")
@Data
public class Utente {
	@Id
	@GeneratedValue
	private int id;
	@Autowired
	private String username;
	private String nomeCompleto;
	private String email;

	@OneToMany(mappedBy = "utente")
	private List<Prenotazione> prenotazioni;

	public Utente(String username, String nomeCompleto, String email) {
		this.username = username;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
	}
}
