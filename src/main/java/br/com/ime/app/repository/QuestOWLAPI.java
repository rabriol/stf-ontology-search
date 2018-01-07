package br.com.ime.app.repository;

import it.unibz.inf.ontop.sesame.SesameVirtualRepo;
import org.openrdf.query.Query;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQuery;
import org.openrdf.query.TupleQueryResultHandler;
import org.openrdf.query.resultio.sparqljson.SPARQLResultsJSONWriter;
import org.openrdf.repository.RepositoryConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;

/**
 * Created by rabriol on 1/29/17.
 */
@Repository
public class QuestOWLAPI {

    @Value("${owl.file.name}")
    public String owlFileName;

    @Value("${obda.file.name}")
    public String obdaFileName;

    public String executeQuery(String queryString) throws Exception {

        System.out.println();
        System.out.println("The input SPARQL query:");
        System.out.println("=======================");
        System.out.println(queryString);
        System.out.println();

        // create and initialize repo
        boolean existential = false;
        String rewriting = "TreeWitness";
        SesameVirtualRepo repo = new SesameVirtualRepo("stf_repo",
                owlFileName,
                obdaFileName,
                existential,
                rewriting);

        repo.initialize();

        RepositoryConnection conn = repo.getConnection();

        // execute query
        Query query = conn.prepareQuery(QueryLanguage.SPARQL, queryString);

        TupleQuery tq = (TupleQuery) query;

        // you can use a FileOutputStream if you want to output to a file
        OutputStream out = new ByteArrayOutputStream();
        TupleQueryResultHandler writer = new SPARQLResultsJSONWriter(out);

        // execute the query and write the result directly to file
        tq.evaluate(writer);

        repo.shutDown();

        return out.toString();

    }

    public static void main(String[] args) throws Exception {
        QuestOWLAPI api = new QuestOWLAPI();
        //api.executeQuery("");
        api.executeQuery("");
    }
}
