package Model.ViewModel;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class PeliculasViewModel {
    private int idpelicula;
    private String nombre;
    private String nomb_ingles;
    private int idcategoria;
    private String categoria;
    private byte[] foto;
    private int yearp;
    private int duracion;

    public PeliculasViewModel(int idpelicula, String nombre, String nomb_ingles, int idcategoria, String categoria, int yearp, int duracion) {
        this.idpelicula = idpelicula;
        this.nombre = nombre;
        this.nomb_ingles = nomb_ingles;
        this.idcategoria = idcategoria;
        this.categoria = categoria;
        this.yearp = yearp;
        this.duracion = duracion;
    }

    public PeliculasViewModel(int idpelicula, String nombre, String nomb_ingles, byte[] foto, String categoria, int yearp, int duracion) {
        this.idpelicula = idpelicula;
        this.nombre = nombre;
        this.nomb_ingles = nomb_ingles;
        this.categoria = categoria;
        this.foto = foto;
        this.yearp = yearp;
        this.duracion = duracion;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomb_ingles() {
        return nomb_ingles;
    }

    public void setNomb_ingles(String nomb_ingles) {
        this.nomb_ingles = nomb_ingles;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFoto() throws UnsupportedEncodingException {
        return "data:image/jpg;base64," + Base64.getEncoder().encodeToString(this.foto);
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getYearp() {
        return yearp;
    }

    public void setYearp(int yearp) {
        this.yearp = yearp;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
