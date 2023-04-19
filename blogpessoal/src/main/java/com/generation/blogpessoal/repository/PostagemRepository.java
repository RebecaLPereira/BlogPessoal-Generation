package com.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.blogpessoal.model.Postagem;

//Arquivo responsavel por conversar com a tabela POSTAGEM (tb_postagens)do banco de dados
//O JpaRepository será responsável por conversar com a tabela postagem e devolver uma resposta para o POSTAGEMREPOSITORY.
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	public List<Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);

}
