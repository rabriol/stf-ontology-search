package br.com.ime.app.service;

/**
 * Created by rabriol on 2/12/17.
 */
public enum QueryType {
    BY_MINISTRO_RELATOR_PROVIMENTO_SIM_ADI("[\\wâãé ]*(relator[es]*)+[\\wwâãé ]*(provimento[s]*)+[\\wwâãé ]*(sim)+[\\wwâãé ]*(ação direta de inconstitucionalidade)+"),
    BY_MINISTRO_DESAFIADO("[\\wâãé ]*(ministro[s]*)[\\wâãé ]*(desafiado[s]*)((?!r))"),
    BY_MINISTRO_DESAFIADOR("[\\wâãé ]*(ministro[s]*)[\\wâãé ]*(desafiador[es]*)((?!s))"),
    BY_DECISAO_UNANIME("[\\wâãé ]*(un[aâ]nime[s]*)[\\wâãé ]*");

    private String regex;


    QueryType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
