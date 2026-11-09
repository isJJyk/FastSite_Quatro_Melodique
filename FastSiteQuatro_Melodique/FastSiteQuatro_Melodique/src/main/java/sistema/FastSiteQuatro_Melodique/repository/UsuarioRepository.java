package sistema.FastSiteQuatro_Melodique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.FastSiteQuatro_Melodique.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Override //Override já que herda o "findById" do próprio JpaRepository
    Optional<Usuario> findById(Long id);

    List<Usuario> findByLogin(String login);
}
