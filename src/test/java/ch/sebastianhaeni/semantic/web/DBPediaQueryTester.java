package ch.sebastianhaeni.semantic.web;

import org.junit.Test;

public class DBPediaQueryTester {
    @Test
    public void query1() {
        Helper.executeQueryOnEndpoint("http://dbpedia.org/sparql", "dbpedia/query1.sparql");
    }
}
