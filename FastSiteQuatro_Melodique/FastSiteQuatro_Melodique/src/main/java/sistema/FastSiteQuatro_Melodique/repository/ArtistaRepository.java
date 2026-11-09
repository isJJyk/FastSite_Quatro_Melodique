package sistema.FastSiteQuatro_Melodique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.FastSiteQuatro_Melodique.entities.Artista;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista,Long> {
    @Override
    Optional<Artista> findById(Long id);

    Optional<Artista> findByArtista(String artista);

    List<Artista> findByArtistaContaining(String artista);
}
