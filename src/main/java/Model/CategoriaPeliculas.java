package Model;

public class CategoriaPeliculas {
    private int idcatpelicula;
    private int idpelicula;
    private int idcategoria;

    public CategoriaPeliculas(int idcatpelicula, int idpelicula, int idcategoria) {
        this.idcatpelicula = idcatpelicula;
        this.idpelicula = idpelicula;
        this.idcategoria = idcategoria;
    }

    public CategoriaPeliculas(int idcatpelicula, int idpelicula) {
        this.idcatpelicula = idcatpelicula;
        this.idpelicula = idpelicula;
    }

    public int getIdcatpelicula() {
        return idcatpelicula;
    }

    public void setIdcatpelicula(int idcatpelicula) {
        this.idcatpelicula = idcatpelicula;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
}

