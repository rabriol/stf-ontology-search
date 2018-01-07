package br.com.ime.app.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rabriol on 2/12/17.
 */
@Service
public class QueryRegexExtractor {

    public QueryType get(String query) {
        for (QueryType queryType : QueryType.values()) {
            Pattern pattern = Pattern.compile(queryType.getRegex());

            Matcher matcher = pattern.matcher(query);

            if (matcher.find()) {
                return queryType;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new QueryRegexExtractor().get("Quais ministros do STF enquanto relatores dão provimento sim para ação direta de inconstitucionalidade"));
    }
}
