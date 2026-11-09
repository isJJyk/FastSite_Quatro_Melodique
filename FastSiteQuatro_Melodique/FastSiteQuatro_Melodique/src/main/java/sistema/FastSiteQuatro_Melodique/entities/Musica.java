package sistema.FastSiteQuatro_Melodique.entities;

import jakarta.persistence.*;
import sistema.FastSiteQuatro_Melodique.enums.GeneroMusica;

import java.time.Duration;
import java.time.LocalDate;


@Entity
@Table(name = "musica")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "titulo_musica")
    private String tituloMusica;

    @ManyToOne
    @JoinColumn(nullable = false, name = "artista_id")
    private Artista artista;

    @ManyToOne
    @JoinColumn(nullable = false,name = "album_id")
    private Album album;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100, name = "genero_musica")
    private GeneroMusica generoMusica;

    @Column(nullable = false, name = "duracao")
    private Duration duracao;

    @Column(nullable = false, length = 100, name = "data_lancamento")
    private LocalDate dataLancamento;

    public Musica() {

    }

    public Musica(String tituloMusica, Artista artista,Album album, GeneroMusica generoMusica, Duration duracao, LocalDate dataLancamento) {
        this.tituloMusica = tituloMusica;
        this.artista = artista;
        this.album = album;
        this.generoMusica = generoMusica;
        this.duracao = duracao;
        this.dataLancamento = dataLancamento;

    }

    public Long getId() {
        return id;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public GeneroMusica getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(GeneroMusica generoMusica) {
        this.generoMusica = generoMusica;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


}
