package sistema.FastSiteQuatro_Melodique.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sistema.FastSiteQuatro_Melodique.entities.Artista;
import sistema.FastSiteQuatro_Melodique.repository.ArtistaRepository;

import java.util.List;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    @Transactional
    public Artista adicionarArtista(Artista artista){
        return artistaRepository.save(artista);
    }
    @Transactional(readOnly = true)
    public Artista procurarPorId(Long artistaId){
        return artistaRepository.findById(artistaId).orElseThrow(() -> new RuntimeException("Artista com esse ID não encontrado"));

    }

    @Transactional
    public Artista atualizarArtista(Long artistaId,Artista novosDados){
        Artista artista = artistaRepository.findById(artistaId).orElseThrow(() -> new RuntimeException("Não foi possível atualizar os dados deste artista"));

        artista.setArtista(novosDados.getArtista());
        artista.setBiografia(novosDados.getBiografia());
        artista.setGenero_musical(novosDados.getGenero_musical());
        artista.setPais_origem(novosDados.getPais_origem());
        artista.setDataInicioAtividade(novosDados.getDataInicioAtividade());
        artista.setStatusCarreira(novosDados.getStatusCarreira());

        return artistaRepository.save(artista);
    }

    @Transactional
    public void deletarArtista(Long artistaId){
        Artista artistaExistente = artistaRepository.findById(artistaId).orElseThrow(() -> new RuntimeException("Não foi possível deletar o artista"));
        artistaRepository.delete(artistaExistente);
    }

    @Transactional(readOnly = true)
    public List<Artista> procurarArtistaPorNome(String artista){
        List<Artista> artistas = artistaRepository.findByArtistaContaining(artista);
        if (artistas.isEmpty()){
            throw new RuntimeException("Artista não encontrado");
        }
        return artistas;
    }
}
