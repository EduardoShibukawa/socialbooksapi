package com.algaworks.socialbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.socialbooks.domain.Comentario;

public interface ComentariosRepository extends JpaRepository<Comentario, Long>{		
	
	List<Comentario> findByLivroId(Long livroId);
}
