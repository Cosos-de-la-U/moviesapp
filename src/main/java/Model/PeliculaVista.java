package Model;

public class PeliculaVista {
    private int idpeliculavista;
    private int idpelicula;
    private String carnet;
    private String comentario;
    private int calificacion;

    public PeliculaVista(int idpeliculavista, int idpelicula, String carnet, String comentario, int calificacion) {
        this.idpeliculavista = idpeliculavista;
        this.idpelicula = idpelicula;
        this.carnet = carnet;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public PeliculaVista(int idpelicula, String carnet, String comentario, int calificacion) {
        this.idpelicula = idpelicula;
        this.carnet = carnet;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public int getIdpeliculavista() {
        return idpeliculavista;
    }

    public void setIdpeliculavista(int idpeliculavista) {
        this.idpeliculavista = idpeliculavista;
    }

    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
