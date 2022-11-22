package Enum;

import Model.EnumAccesoLista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum AccesoEnum {
    Inhabilitado("Inhabilitado", 0),
    Habilitado("Habilitado", 1);

    private final String nombre;
    private final int id;
    private static final List<EnumAccesoLista> listaAcceso;

    AccesoEnum(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    static {
        listaAcceso = new ArrayList<EnumAccesoLista>();
        for (AccesoEnum accesoEnum : AccesoEnum.values()) {
            String nombre =  accesoEnum.getNombre();
            int id = accesoEnum.getId();
            listaAcceso.add( new EnumAccesoLista(nombre, id));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public static List<EnumAccesoLista> getListaAcceso(){
        return Collections.unmodifiableList(listaAcceso);
    }
}
