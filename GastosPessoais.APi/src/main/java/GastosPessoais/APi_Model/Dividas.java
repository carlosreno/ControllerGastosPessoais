package GastosPessoais.APi_Model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Dividas {
		
	@Id
	@GeneratedValue(generator = "seq_id_dividas", strategy = GenerationType.AUTO)
	private Long id;
	
	private String descricao;
	
	@OneToOne
	@JoinColumn(columnDefinition = "id", foreignKey = @ForeignKey(name = "tipodivida_id"))
	private TiposDeDividas tipodivida;
	
	private Double valordivida;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dataDeVencimento;
	
	public Date getDataDeVencimento() {
		return dataDeVencimento;
	}
	
	public void setDataDeVencimento(Date dataDeVencimento) {
		this.dataDeVencimento =dataDeVencimento;
		
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(foreignKey = @ForeignKey(name = "user_id"))
	private Usuario user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TiposDeDividas getTipodivida() {
		return tipodivida;
	}

	public void setTipodivida(TiposDeDividas tipodivida) {
		this.tipodivida = tipodivida;
	}

	
	

	public Double getValordivida() {
		return valordivida;
	}

	public void setValordivida(Double valordivida) {
		this.valordivida = valordivida;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}
	
	
}
