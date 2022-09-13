package GastosPessoais.APi_Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping(value = "/cadastrar", produces = "application.json")
	public ResponseEntity<Usuario> CadastrarUser(@RequestBody Usuario user){
		
		Usuario userSalvo = usuarioRepository.save(user);
		
		return new ResponseEntity<Usuario>(userSalvo, HttpStatus.OK);
	}
	@GetMapping(value = "/",  produces = "application.json")	
	public ResponseEntity<List<Usuario>> ListarTodosUsers(){
		List<Usuario> listUsers = (List<Usuario>) usuarioRepository.findAll();
		
		return new ResponseEntity<List<Usuario>>(listUsers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = "application.json")
	public ResponseEntity<Usuario> listarPorId(@PathVariable (value =  "id") Long id){
		Optional<Usuario> userBD = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(userBD.get(),HttpStatus.OK);
		
	}
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> AtualizarUserId(@RequestBody Usuario user){
		Usuario userAtualizado = usuarioRepository.save(user);
		return new ResponseEntity<Usuario>(userAtualizado, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<String> deletarUserId(@PathVariable (value = "id") Long id){
		usuarioRepository.deleteById(id);
		
		return new ResponseEntity<String>("deletado", HttpStatus.OK);
	}
	
	
}
