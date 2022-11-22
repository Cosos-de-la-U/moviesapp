package Model;

import java.io.InputStream;

public class Fotos {
    private int idfoto;
    private int idpelicula;
    private InputStream foto;
    private String primera;

    public Fotos(int idfoto, int idpelicula, InputStream foto, String primera) {
        this.idfoto = idfoto;
        this.idpelicula = idpelicula;
        this.foto = foto;
        this.primera = primera;
    }

    public Fotos(int idpelicula, InputStream foto, String primera) {
        this.idpelicula = idpelicula;
        this.foto = foto;
        this.primera = primera;
    }

    public int getIdfoto() {
        return idfoto;
    }

    public void setIdfoto(int idfoto) {
        this.idfoto = idfoto;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getPrimera() {
        return primera;
    }

    public void setPrimera(String primera) {
        this.primera = primera;
    }
}
