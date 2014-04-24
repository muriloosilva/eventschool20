package models;

import java.sql.Date;
import java.sql.Timestamp;

import util.DataHourFormat;

public class Evento {
	
	private int id_evento;
	private String nome;
	private String descricao;
	private String local;
	private Date dataInicio;
	private Date dataFim;
	private Timestamp dataInicioInscricoes;
	private Timestamp dataFimInscricoes;
	private String telefone;
	private String email;
	
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public String getDataInicioFormatada() {
		return DataHourFormat.formatarData(dataInicio);
	}
	
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataFimFormatada() {
		return DataHourFormat.formatarData(dataFim);
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Timestamp getDataInicioInscricoes() {
		return dataInicioInscricoes;
	}
	public void setDataInicioInscricoes(Timestamp dataInicioInscricoes) {
		this.dataInicioInscricoes = dataInicioInscricoes;
	}
	public Timestamp getDataFimInscricoes() {
		return dataFimInscricoes;
	}
	public void setDataFimInscricoes(Timestamp dataFimInscricoes) {
		this.dataFimInscricoes = dataFimInscricoes;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
