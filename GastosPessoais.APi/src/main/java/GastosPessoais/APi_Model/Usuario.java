package GastosPessoais.APi_Model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_user")
	private Long id;
	private String nomecompleto;
	private String funcao;
	private String salario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Dividas> dividas = new ArrayList<Dividas>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Telefone> listTell = new ArrayList<Telefone>();
	
	private String login;
	private String senha;
	private String cep;
	private String logradouro;
	private String uf;
	private String bairro;
	
}
