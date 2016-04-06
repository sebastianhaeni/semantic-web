package ch.sebastianhaeni.semantic.web;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


class Helper {

    static void executeQueryOnModel(String modelFile, String queryFile) {
        Model model = Helper.loadModel(modelFile);
        Query query = Helper.loadQuery(queryFile);

        QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
        ResultSet results = queryExecution.execSelect();
        ResultSetFormatter.out(System.out, results, query);
    }

    private static Model loadModel(String file) {

        String inputFile = "src/test/resources/" + file;

        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // use the FileManager to find the input file
        InputStream in = FileManager.get().open(inputFile);
        if (in == null) {
            throw new IllegalArgumentException("File: " + inputFile + " not found");
        }

        // read the RDF/XML file
        model.read(in, null, Converter.parseInputFormat(file));

        return model;
    }

    private static Query loadQuery(String file) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get("src/test/resources/" + file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String queryString = new String(encoded);

        return QueryFactory.create(queryString);
    }
}
