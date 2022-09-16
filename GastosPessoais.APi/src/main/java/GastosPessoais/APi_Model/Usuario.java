package GastosPessoais.APi_Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_id_user")
	private Long id;
	private String nomecompleto;
	private String funcao;	
	
	private String Email;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
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
	private Double salario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomecompleto() {
		return nomecompleto;
	}
	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public List<Dividas> getDividas() {
		return dividas;
	}
	public void setDividas(List<Dividas> dividas) {
		this.dividas = dividas;
	}
	public List<Telefone> getListTell() {
		return listTell;
	}
	public void setListTell(List<Telefone> listTell) {
		this.listTell = listTell;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
