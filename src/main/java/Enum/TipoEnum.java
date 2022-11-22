package Enum;

import Model.EnumTipoLista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum TipoEnum {
    Usuario("Usuario", 0),
    Administrador("Administrador", 1);

    private final String nombre;
    private final int id;
    private static final List<EnumTipoLista> listaTipo;

    TipoEnum(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    static {
        listaTipo = new ArrayList<EnumTipoLista>();
        for (TipoEnum tipoEnum : TipoEnum.values()) {
            String nombre = tipoEnum.getNombre();
            int id = tipoEnum.getId();
            listaTipo.add( new EnumTipoLista(nombre, id));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public static List<EnumTipoLista> getListaTipo(){
        return Collections.unmodifiableList(listaTipo);
    }
}
