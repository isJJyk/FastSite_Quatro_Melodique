package sistema.FastSiteQuatro_Melodique.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sistema.FastSiteQuatro_Melodique.entities.Musica;
import sistema.FastSiteQuatro_Melodique.repository.MusicaRepository;

import java.util.List;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepository;

    @Transactional
    public Musica adicionarMusica(Musica musica) {
        return musicaRepository.save(musica);
    }
    @Transactional(readOnly = true)
    public Musica procurarPorId(Long musicaId){
        return musicaRepository.findById(musicaId).orElseThrow(() -> new RuntimeException("Não foi possivel encontrar uma musica com esse ID"));

    }

    @Transactional
    public Musica atualizarMusica(Long musicaId, Musica novosDados){
        Musica musica = musicaRepository.findById(musicaId).orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados desta música"));

        musica.setTituloMusica(novosDados.getTituloMusica());
        musica.setArtista(novosDados.getArtista());
        musica.setAlbum(novosDados.getAlbum());
        musica.setGeneroMusica(novosDados.getGeneroMusica());
        musica.setDuracao(novosDados.getDuracao());
        musica.setDataLancamento(novosDados.getDataLancamento());

        return musicaRepository.save(musica);
    }

    @Transactional
    public void deletarMusica(Long musicaId){
        Musica musicaExistente = musicaRepository.findById(musicaId).orElseThrow(() -> new RuntimeException("Não foi possível encontrar essa música"));

        musicaRepository.delete(musicaExistente);
    }

    @Transactional(readOnly = true)
    public List<Musica> procurarMusicaPorNome(String tituloMusica) {
        List<Musica> musicas = musicaRepository.findByTituloMusicaContaining(tituloMusica);
        if (musicas.isEmpty()) {
            throw new RuntimeException("Música não Encontrada");
        }

        return musicas;
    }
    @Transactional(readOnly = true)
    public List<Musica> procurarMusicaPorGenero(String generoMusica) {
        List<Musica> musicas = musicaRepository.findByGeneroMusica(generoMusica);
        if (musicas.isEmpty()) {
            throw new RuntimeException("Estilo de Música não Encontrado");
        }

        return musicas;
    }
}
