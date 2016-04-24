package ch.sebastianhaeni.semantic.web;

import org.junit.Test;

public class DBPediaQueryTester {
    @Test
    public void query1() {
        Helper.executeQueryOnEndpoint("http://dbpedia.org/sparql", "dbpedia/query1.sparql");
    }

    @Test
    public void query2() {
        Helper.executeQueryOnEndpoint("http://dbpedia.org/sparql", "dbpedia/query2.sparql");
    }

    @Test
    public void query3() {
        Helper.executeQueryOnEndpoint("http://dbpedia.org/sparql", "dbpedia/query3.sparql");
    }

    @Test
    public void query4() {
        Helper.executeQueryOnEndpoint("http://dbpedia.org/sparql", "dbpedia/query4.sparql");
    }
}
