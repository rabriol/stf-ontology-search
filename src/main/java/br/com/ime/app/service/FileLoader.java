package br.com.ime.app.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by rabriol on 3/19/17.
 */
@Service
public class FileLoader {

    public String loadSPARQL(String sparqlFile) throws IOException {
        String queryString = "";

        BufferedReader br = new BufferedReader(new FileReader(sparqlFile));
        String line;
        while ((line = br.readLine()) != null) {
            queryString += line + "\n";
        }
        return queryString;
    }
}
