package com.fannog.proyectocliente.utils;

import com.fannog.proyectoservidor.entities.Usuario;

public class Globals {

    private static Usuario loggedUser;

    public static Usuario getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(Usuario loggedUser) {
        Globals.loggedUser = loggedUser;
    }

}
