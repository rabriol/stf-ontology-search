package br.com.ime.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rabriol on 2/12/17.
 */
@Service
public class QuerySelector {

    @Autowired
    private QueryRegexExtractor queryRegexExtractor;

    @Autowired
    private QueryFileDescriptor queryFileDescriptor;

    public String getQueryFileName(String query) {
        QueryType queryType = queryRegexExtractor.get(query);

        if (QueryType.BY_MINISTRO_RELATOR_PROVIMENTO_SIM_ADI.equals(queryType)) {
            return queryFileDescriptor.getQueryMinistroRelatoresProvimentosSimADI();
        }

        if (QueryType.BY_MINISTRO_DESAFIADO.equals(queryType)) {
            return queryFileDescriptor.getQueryMinistroDesafiados();
        }

        if (QueryType.BY_MINISTRO_DESAFIADOR.equals(queryType)) {
            return queryFileDescriptor.getQueryMinistroDesafiadores();
        }

        if (QueryType.BY_DECISAO_UNANIME.equals(queryType)) {
            return queryFileDescriptor.getQueryDecisaoUnanime();
        }

        return "";
    }
}
