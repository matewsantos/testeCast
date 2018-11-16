package br.com.testecast.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_pessoa")
public @Data class EntidadePessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")
	private Integer idPessoa;
 
	@Column(name="nome")	
	private String nome;
 
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="tpLogradouro")
	private String tpLogradouro;
	
	@Column(name="logradouro")
	private String logradouro;
	
	@Column(name="numero")
	private int numero;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="telefoneCelular")
	private String telefoneCelular;
	
	@Column(name="telefoneResidencial")
	private String telefoneResidencial;
	
 }
