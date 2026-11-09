package sistema.FastSiteQuatro_Melodique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sistema.FastSiteQuatro_Melodique.entities.Album;

import java.util.List
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album,Long> {
    @Override
    Optional<Album> findById(Long id);

    Optional<Album> findByTituloAlbum(String tituloAlbum);

    List<Album> findByTituloAlbumContaining(String tituloAlbum);

}
