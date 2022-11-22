package Model.ViewModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;

public class FotosViewModel {
    private int idfoto;
    private String nombre;
    private int idpelicula;
    private byte[] foto;
    private String primera;

    public FotosViewModel(int idfoto, String nombre, int idpelicula, byte[] foto, String primera) throws IOException {
        this.idfoto = idfoto;
        this.nombre = nombre;
        this.idpelicula = idpelicula;
        this.foto = foto;
        this.primera = primera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getFoto() throws UnsupportedEncodingException {
        return "data:image/jpg;base64," + Base64.getEncoder().encodeToString(this.foto);
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getPrimera() {
        return primera;
    }

    public void setPrimera(String primera) {
        this.primera = primera;
    }
}
