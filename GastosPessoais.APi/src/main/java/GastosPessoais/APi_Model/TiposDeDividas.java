package GastosPessoais.APi_Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TiposDeDividas {
	
	@Id
	@GeneratedValue(generator = "seq_tiposdespesa", strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricaoTipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

	
	
}
