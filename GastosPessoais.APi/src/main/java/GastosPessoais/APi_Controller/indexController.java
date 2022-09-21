package GastosPessoais.APi_Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import GastosPessoais.APi_Model.Usuario;
import GastosPessoais.APi_Repository.UsuarioRepository;

@RequestMapping("/usuario")
@RestController
public class indexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@PostMapping(value = "/cadastrar", produces = "application/json")
	public ResponseEntity<Usuario> CadastrarUser(@RequestBody Usuario user){
		
		for (int i = 0; i < user.getDividas().size(); i++) {
			user.getDividas().get(i).setUser(user);
		}
		
		for (int i = 0; i < user.getListTell().size(); i++) {
			user.getListTell().get(i).setUser(user);
		}
		
		
		
		Usuario userSalvo = usuarioRepository.save(user);
		
		return new ResponseEntity<Usuario>(userSalvo, HttpStatus.OK);
	}
	@GetMapping(value = "/",  produces = "application/json")	
	public ResponseEntity<List<Usuario>> ListarTodosUsers(){
		List<Usuario> listUsers = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(listUsers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Usuario> listarPorId(@PathVariable (value =  "id") Long id){
		Optional<Usuario> userBD = usuarioRepository.findById(id);
		
		System.out.println(userBD.toString());
		return new ResponseEntity<Usuario>(userBD.get(),HttpStatus.OK);
		
	}
	@PutMapping(value = "/atualizar", produces = "application/json")
	public ResponseEntity<Usuario> AtualizarUserId(@RequestBody Usuario user){
		
		
		for (int i = 0; i < user.getDividas().size(); i++) {
			user.getDividas().get(i).setUser(user);
		}
		
		for (int i = 0; i < user.getListTell().size(); i++) {
			user.getListTell().get(i).setUser(user);
		}
		
		Usuario userAtualizado = usuarioRepository.save(user);
		return new ResponseEntity<Usuario>(userAtualizado, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/deletar/{id}", produces = "application/json")
	public ResponseEntity<String> deletarUserId(@PathVariable (value = "id") Long id){
		try {
			
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			if (e instanceof EmptyResultDataAccessException) {
				return new ResponseEntity<String>("Usuario não existe", HttpStatus.OK);
			}
		}
		
		
		return new ResponseEntity<String>("deletado", HttpStatus.OK);
	}
	
	
}
