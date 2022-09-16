package GastosPessoais.APi_Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import GastosPessoais.APi_Model.TiposDeDividas;
import GastosPessoais.APi_Repository.TpdiviRepository;

@RestController
@RequestMapping("/tpgastos")
public class TipoGastoController {
	
	@Autowired
	private TpdiviRepository tpdiviRepository;
	
	@PostMapping(value = "/cadastrar")
	public ResponseEntity<TiposDeDividas> CadastrarGasto(@RequestBody TiposDeDividas tiposDeDividas){
		TiposDeDividas tpdivSave = tpdiviRepository.save(tiposDeDividas);
		
		return new ResponseEntity<TiposDeDividas>(tpdivSave, HttpStatus.OK);
	}
}
