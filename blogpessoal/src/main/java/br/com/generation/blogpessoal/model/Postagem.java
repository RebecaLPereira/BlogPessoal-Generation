package br.com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_postagens")
@Data
public class Postagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo título é obrigatório")
	@Size(min = 5,max = 100, message = "O atributo título deve conter no mínimo 05 caracteres, e no mínimo 100")
	private String titulo;
	
	@NotBlank(message = "O atributo texto é obrigatório")
	@Size(min = 5,max = 100, message = "O atributo texto deve conter no mínimo 10 caracteres, e no mínimo 1000")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
}
