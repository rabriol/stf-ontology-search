package br.com.ime.app.controllers;

import br.com.ime.app.repository.QuestOWLAPI;
import br.com.ime.app.service.FileLoader;
import br.com.ime.app.service.QuerySelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rabriol on 1/29/17.
 */
@Controller
public class QueryEndpoint {

    @Autowired
    private QuerySelector querySelector;

    @Autowired
    private QuestOWLAPI questOWLAPI;

    @Autowired
    private FileLoader fileLoader;

    @Value("${query.acordao}")
    private String acordaoQueryFile;

    @RequestMapping(value = "/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String find(@RequestParam("query") String query) throws Exception {
        String sparqlFile = querySelector.getQueryFileName(query);

        String queryString = fileLoader.loadSPARQL(sparqlFile);

        String json = questOWLAPI.executeQuery(queryString);

        return json;
    }

    @RequestMapping(value = "/acordao/{acordaoId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String findById(@PathVariable("acordaoId") String acordaoId) throws Exception {

        String queryString = fileLoader.loadSPARQL(acordaoQueryFile).replace("${acordaoId}", acordaoId);

        System.out.println(queryString);

        String json = questOWLAPI.executeQuery(queryString);

        return json;
    }
}
