package Helpers;

import Model.Usuarios;
import Enum.SesionEnum;

import javax.servlet.http.HttpSession;

public class SessionChecker {

    public static SesionEnum checkSession(HttpSession session){

        Usuarios userSession = (Usuarios) session.getAttribute("usuarioSession");

        if (userSession == null) {
            return SesionEnum.NULA;
        }

        if (checkSessionAccess(userSession)){
            if (checkSessionAdmin(userSession)) {
                return SesionEnum.ADMIN;
            }
            return SesionEnum.USUARIO;
        }
        return SesionEnum.INHABILITADO;

    }

    public static boolean checkSessionAdmin(Usuarios userSession){
        if (userSession.getEsadministrador() == 1){
            return true;
        }
        return false;
    }

    public static boolean checkSessionAccess(Usuarios userSession){
        if (userSession.getAcessosistemas() == 1){
            return true;
        }
        return false;
    }

}
