package br.com.maksuedson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maksuedson.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
