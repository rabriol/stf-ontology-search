package br.com.ime.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rabriol on 2/12/17.
 */
@Configuration
public class QueryFileDescriptor {

    @Value("${query.ministros.relatores.provimentos.sim.adi}")
    private String queryMinistroRelatoresProvimentosSimADI;

    @Value("${query.ministros.desafiados}")
    private String queryMinistroDesafiados;

    @Value("${query.ministros.desafiadores}")
    private String queryMinistroDesafiadores;

    @Value("${query.ministros.menos.desafiados}")
    private String queryMinistroMenosDesafiados;

    @Value("${query.decisao.unanime}")
    private String queryDecisaoUnanime;

    public String getQueryMinistroRelatoresProvimentosSimADI() {
        return queryMinistroRelatoresProvimentosSimADI;
    }

    public void setQueryMinistroRelatoresProvimentosSimADI(String queryMinistroRelatoresProvimentosSimADI) {
        this.queryMinistroRelatoresProvimentosSimADI = queryMinistroRelatoresProvimentosSimADI;
    }

    public String getQueryMinistroDesafiados() {
        return queryMinistroDesafiados;
    }

    public void setQueryMinistroDesafiados(String queryMinistroDesafiados) {
        this.queryMinistroDesafiados = queryMinistroDesafiados;
    }

    public String getQueryMinistroDesafiadores() {
        return queryMinistroDesafiadores;
    }

    public void setQueryMinistroDesafiadores(String queryMinistroDesafiadores) {
        this.queryMinistroDesafiadores = queryMinistroDesafiadores;
    }

    public String getQueryMinistroMenosDesafiados() {
        return queryMinistroMenosDesafiados;
    }

    public void setQueryMinistroMenosDesafiados(String queryMinistroMenosDesafiados) {
        this.queryMinistroMenosDesafiados = queryMinistroMenosDesafiados;
    }

    public String getQueryDecisaoUnanime() {
        return queryDecisaoUnanime;
    }

    public void setQueryDecisaoUnanime(String queryDecisaoUnanime) {
        this.queryDecisaoUnanime = queryDecisaoUnanime;
    }
}
