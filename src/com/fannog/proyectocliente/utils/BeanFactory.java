package com.fannog.proyectocliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BeanFactory {

    private final InitialContext ctx;

    private static final ThreadLocal<BeanFactory> BEANS = ThreadLocal.withInitial(BeanFactory::create);

    private BeanFactory(InitialContext initialContext) {
        this.ctx = initialContext;
    }

    public <T> T lookup(String entity) throws Exception {
        String jdniName = "ejb:ProyectoServidor/ProyectoEJB-ejb/" + entity + "DAOImpl!com.fannog.proyectoservidor.DAO." + entity + "DAO";

        try {
            return (T) ctx.lookup(jdniName);
        } catch (NamingException e) {
            throw new Exception("Could not find jndi: " + jdniName, e);
        }
    }

    public static BeanFactory local() {
        return BEANS.get();
    }

    public static BeanFactory create() {
        try {
            return new BeanFactory(new InitialContext());
        } catch (NamingException e) {
            throw new RuntimeException("Could not create a new context", e);
        }
    }
}
