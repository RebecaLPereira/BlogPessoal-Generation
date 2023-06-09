package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
//A Anotação @Entity indica que esta Classe define uma entidade, ou seja, ela será utilizada para gerar uma tabela no Banco de dados da aplicação.
@Table(name = "tb_postagens")
//A Anotação @Table indica o nome da Tabela no Banco de dados.
public class Postagem {
	
	@Id
	//A Anotação @Id inidica que o Atributo anotado será a Chave Primária (Primary Key - PK) da Tabela tb_postagens.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//A Anotação @GeneratedValue define que o valor do atributo anotado será gerado pelo banco de dados.
	//o strategy define a estrategia de geração de valor, o IDENTITY define que esse valor sera gerado com um auto_increment no campo
	private Long id;
	// Define o tipo e o nome de um atributo da "tb_postagens"
	
	@NotBlank(message = "O atributo título é Obrigatório!")
	//A anotação @NotBlank não permite que o Atributo seja Nulo ou contenha apenas espaços em branco. Você pode configurar uma mensagem para o usuário através do Atributo message.
	@Size(min = 5, max = 1000, message = "O atributo título deve conter no mínimo 05 e no máximo 100 caracteres")
	//A anotação @Size, define a quantidade de caracteres minimos e maximos que um atributo deve receber
	//Caso não receba um valor entre o minimo e o maximo, a mensagem configurada será exibida.
	private String titulo;
	// Define o tipo e o nome de um atributo da "tb_postagens"

	@NotBlank(message = "O atributo texto é Obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo texto deve conter no mínimo 10 e no máximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	//A anotação @UpdateTimestamp pega a data atual do computador assim que alguem faz uma postagem, e armazena essa data no campo destinado (no caso data)
	private LocalDateTime data;

	@ManyToOne
	//A anotação @ManyToOne indica que a Classe Postagem será o lado N:1 e terá um Objeto da Classe Tema.
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagens")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Getters - os gets de cada atributo, são responsáveis por pegar a informação do objeto.
	//Setters - os sets de cada atributo, são responsáveis por inserir uma informação no objeto.
}
