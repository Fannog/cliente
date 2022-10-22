package com.fannog.proyectocliente.utils;

import javax.naming.InitialContext;

public class BeanFactory {

    private final InitialContext ctx;

    private BeanFactory(InitialContext initialContext) {
        this.ctx = initialContext;
    }

    public <T> T lookup(String entity) {
        String jdniName = "ejb:ProyectoServidor/ProyectoEJB-ejb/" + entity + "DAOImpl!com.fannog.proyectoservidor.DAO." + entity + "DAO";
        try {
            return (T) ctx.lookup(jdniName);
        } catch (Exception e) {
            throw new RuntimeException("Could not find jndi: " + jdniName, e);
        }
    }

    public static BeanFactory create() {
        try {
            return new BeanFactory(new InitialContext());
        } catch (Exception e) {
            throw new RuntimeException("Could not create a new context", e);
        }
    }
}
