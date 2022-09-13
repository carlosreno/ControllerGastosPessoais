package GastosPessoais.APi_Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_tell")
	private Long id;
	
	private String numero;
	
	@JsonIgnore
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@ForeignKey(name = "user_id")
	private Usuario user;
	
	
}
