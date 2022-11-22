package Model;

public class Usuarios {
    private String carnet;
    private String nom_usuario;
    private String ape_usuario;
    private String tipo;
    private String telcasa;
    private String celular;
    private String email;
    private String estado;
    private String clave;
    private int acessosistemas;
    private int esadministrador;

    public Usuarios(String carnet, String nom_usuario, String ape_usuario, String tipo, String telcasa, String celular, String email, String estado, String clave, int acessosistemas, int esadministrador) {
        this.carnet = carnet;
        this.nom_usuario = nom_usuario;
        this.ape_usuario = ape_usuario;
        this.tipo = tipo;
        this.telcasa = telcasa;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.clave = clave;
        this.acessosistemas = acessosistemas;
        this.esadministrador = esadministrador;
    }

    public Usuarios(String nom_usuario, String ape_usuario, String tipo, String telcasa, String celular, String email, String estado, String clave, int acessosistemas, int esadministrador) {
        this.nom_usuario = nom_usuario;
        this.ape_usuario = ape_usuario;
        this.tipo = tipo;
        this.telcasa = telcasa;
        this.celular = celular;
        this.email = email;
        this.estado = estado;
        this.clave = clave;
        this.acessosistemas = acessosistemas;
        this.esadministrador = esadministrador;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getApe_usuario() {
        return ape_usuario;
    }

    public void setApe_usuario(String ape_usuario) {
        this.ape_usuario = ape_usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelcasa() {
        return telcasa;
    }

    public void setTelcasa(String telcasa) {
        this.telcasa = telcasa;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getAcessosistemas() {
        return acessosistemas;
    }

    public void setAcessosistemas(int acessosistemas) {
        this.acessosistemas = acessosistemas;
    }

    public int getEsadministrador() {
        return esadministrador;
    }

    public void setEsadministrador(int esadministrador) {
        this.esadministrador = esadministrador;
    }
}
