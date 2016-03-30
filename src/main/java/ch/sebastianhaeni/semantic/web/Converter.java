package ch.sebastianhaeni.semantic.web;

import org.apache.commons.io.FilenameUtils;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

public class Converter {

    private interface Format {
        String RDF = "RDF/XML-ABBREV";
        String TTL = "TTL";
        String N3 = "N3";
        String NT = "N-TRIPLE";
    }

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
        model.read(in, null, parseInputFormat(inputFile));

        // write it to standard out
        model.write(System.out, parseFormat(outputFormat));
    }

    private static String parseInputFormat(String inputFile) {
        return parseFormat(FilenameUtils.getExtension(inputFile).toLowerCase());
    }

    private static String parseFormat(String outputFormat) {
        if (outputFormat.equals("rdf")) {
            return Format.RDF;
        }
        if (outputFormat.equals("ttl")) {
            return Format.TTL;
        }
        if (outputFormat.equals("n3")) {
            return Format.N3;
        }
        if (outputFormat.equals("nt")) {
            return Format.NT;
        }

        System.out.println("The format '" + outputFormat + "' is not supported");
        System.exit(1);
        return null;
    }
}
