package ch.sebastianhaeni.semantic.web;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

public class Converter {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: converter <input> <out format:rdf,ttl,n3,nt>");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFormat = args[1];

        System.out.println("Reading " + inputFile);

        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // use the FileManager to find the input file
        InputStream in = FileManager.get().open(inputFile);
        if (in == null) {
            throw new IllegalArgumentException("File: " + inputFile + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);

        // write it to standard out
        model.write(System.out, parseFormat(outputFormat));
    }

    private static String parseFormat(String outputFormat) {
        if (outputFormat.equals("rdf")) {
            return "RDF/XML-ABBREV";
        }
        if (outputFormat.equals("ttl")) {
            return "TTL";
        }
        if (outputFormat.equals("n3")) {
            return "N3";
        }
        if (outputFormat.equals("nt")) {
            return "N-TRIPLE";
        }

        System.out.println("The format '" + outputFormat + "' is not supported");
        System.exit(1);
        return null;
    }
}
