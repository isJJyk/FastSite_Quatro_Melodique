package sistema.FastSiteQuatro_Melodique.entities;

import jakarta.persistence.*;
import sistema.FastSiteQuatro_Melodique.enums.StatusCarreira;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artista")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "artista")
    private String artista;

    @Column(nullable = false, length = 450, name = "bio_artista")
    private String biografia;

    @Column(nullable = false, length = 100, name = "genero_principal")
    private String genero_musical;

    @Column(nullable = false, length = 100, name = "pais_origem")
    private String pais_origem;

    @Column(nullable = false, length = 100, name = "data_inicio_atividade")
    private LocalDate dataInicioAtividade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 100, name = "status_carreira")
    private StatusCarreira statusCarreira;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Album> albums = new ArrayList<>();

    public Artista() {

    }

    public Artista(String artista, String biografia, String genero_musical, String pais_origem, LocalDate dataInicioAtividade, StatusCarreira statusCarreira) {
        this.artista = artista;
        this.biografia = biografia;
        this.genero_musical = genero_musical;
        this.pais_origem = pais_origem;
        this.dataInicioAtividade = dataInicioAtividade;
        this.statusCarreira = statusCarreira;
    }

    public Long getId() {
        return id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getGenero_musical() {
        return genero_musical;
    }

    public void setGenero_musical(String genero_musical) {
        this.genero_musical = genero_musical;
    }

    public String getPais_origem() {
        return pais_origem;
    }

    public void setPais_origem(String pais_origem) {
        this.pais_origem = pais_origem;
    }

    public LocalDate getDataInicioAtividade() {
        return dataInicioAtividade;
    }

    public void setDataInicioAtividade(LocalDate dataInicioAtividade) {
        this.dataInicioAtividade = dataInicioAtividade;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
