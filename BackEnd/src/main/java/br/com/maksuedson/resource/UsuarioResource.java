package br.com.maksuedson.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maksuedson.domain.Usuario;
import br.com.maksuedson.repository.UsuarioRepository;

@RestController
@RequestMapping ("/users")
@CrossOrigin(origins = { "http://localhost:3000"})
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository repo;
	
	@GetMapping
	public List<Usuario> listarTodos(){
		return repo.findAll();		
	}
	
	@PostMapping
	public Usuario save(@RequestBody Usuario obj) {
		return repo.save(obj);
	}
	
	@PutMapping(path = "/{id}")
	public Usuario alterar(@PathVariable ("id") Long id, @RequestBody Usuario obj) {
		repo.findById(id);
		return repo.save(obj);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deletar(@PathVariable ("id") Long id) {
		repo.deleteById(id);
	}

}
