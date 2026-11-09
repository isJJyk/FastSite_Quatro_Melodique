package sistema.FastSiteQuatro_Melodique.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100, name = "titulo_album")
    private String tituloAlbum;

    @ManyToOne
    @JoinColumn(nullable = false, name = "artista_id")
    private Artista artista;

    @Column(nullable = false,length = 100,name = "lancamento_data")
    private LocalDate lancamentoData;

    @NotEmpty(message = "Insira pelo menos uma música para o álbum")
    @OneToMany(mappedBy = "album",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Musica> musicas = new ArrayList<>();

    public  Album(){

    }

    public Album(String tituloAlbum, Artista artista, LocalDate lancamentoData){
        this.tituloAlbum = tituloAlbum;
        this.artista = artista;
        this.lancamentoData = lancamentoData;
    }

    public Long getId() {
        return id;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public LocalDate getLancamentoData() {
        return lancamentoData;
    }

    public void setLancamentoData(LocalDate lancamentoData) {
        this.lancamentoData = lancamentoData;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }
}
