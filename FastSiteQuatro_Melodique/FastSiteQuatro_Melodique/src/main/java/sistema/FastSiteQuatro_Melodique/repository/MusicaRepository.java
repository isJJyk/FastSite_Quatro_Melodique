package sistema.FastSiteQuatro_Melodique.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import sistema.FastSiteQuatro_Melodique.entities.Musica;

import java.util.List;
import java.util.Optional;

public interface MusicaRepository extends JpaRepository<Musica,Long> {
    @Override
    Optional<Musica> findById(Long id);

    Optional<Musica> findByTituloMusica(String tituloMusica);

    List<Musica> findByTituloMusicaContaining(String tituloMusica);

    List<Musica> findByGeneroMusica(String generoMusica);
}
