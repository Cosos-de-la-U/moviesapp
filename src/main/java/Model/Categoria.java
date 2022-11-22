package Model;

public class Categoria {
    private int idcategoria;
    private String categoria;

    public Categoria(int idcategoria, String categoria) {
        this.idcategoria = idcategoria;
        this.categoria = categoria;
    }

    public Categoria(String categoria) {
        this.categoria = categoria;
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
}
