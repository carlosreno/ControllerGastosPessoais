package GastosPessoais.APi_Model;

import java.text.DecimalFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Dividas {
		
	@Id
	@GeneratedValue(generator = "seq_id_dividas", strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	private DecimalFormat valordivida;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@ForeignKey(name = "user_id")
	private Usuario user;
	
}
