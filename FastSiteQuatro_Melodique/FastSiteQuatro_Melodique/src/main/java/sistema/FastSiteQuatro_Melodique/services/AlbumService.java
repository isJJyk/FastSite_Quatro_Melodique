package sistema.FastSiteQuatro_Melodique.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sistema.FastSiteQuatro_Melodique.entities.Album;
import sistema.FastSiteQuatro_Melodique.entities.Musica;
import sistema.FastSiteQuatro_Melodique.repository.AlbumRepository;
import sistema.FastSiteQuatro_Melodique.repository.MusicaRepository;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private MusicaRepository musicaRepository;

    @Transactional
    public Album adicionarAlbum(Album album) {
        return albumRepository.save(album);
    }
    @Transactional(readOnly = true)
    public Album procurarPorId(Long albumId){
        return albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Não foi possível encontrar algum álbum"));
    }
    @Transactional(readOnly = true)
    public List<Album> procurarPorTitulo(String tituloAlbum){
        List<Album> albums = albumRepository.findByTituloAlbumContaining(tituloAlbum);
        if (albums.isEmpty()){
            throw  new RuntimeException("Não foi possível encontrar algum álbum");
        }
        return albums;
    }

    @Transactional
    public Album atualizarAlbum(Long albumId, Album novosDados){
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar este álbum"));
        //Requisição Put

        album.setTituloAlbum(novosDados.getTituloAlbum());
        album.setArtista(novosDados.getArtista());
        album.setLancamentoData(novosDados.getLancamentoData());
        album.setMusicas(novosDados.getMusicas());

        return albumRepository.save(album);
    }

    @Transactional
    public Album adicionarMusicaEmAlbum(Long albumId, Long musicaId) {
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Album não encontrado"));
        //Requisição Post

        Musica musica = musicaRepository.findById(musicaId).orElseThrow(() -> new RuntimeException("Música não encontrada"));

        album.getMusicas().add(musica);
        return albumRepository.save(album);

    }
    @Transactional
    public void deletarAlbum(Long albumId){
        Album albumExistente = albumRepository.findById(albumId).orElseThrow(() -> new RuntimeException("Album não encontrado"));

        albumRepository.delete(albumExistente);
    }

}
