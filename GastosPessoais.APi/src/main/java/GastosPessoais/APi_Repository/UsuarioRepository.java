package GastosPessoais.APi_Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import GastosPessoais.APi_Model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
