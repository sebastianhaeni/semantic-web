package ch.sebastianhaeni.semantic.web;

import org.junit.Test;

public class QueryTester {

    @Test
    public void query1() throws Exception {
        Helper.executeQueryOnModel("vc-db-1.rdf", "q1.sparql");
    }

    @Test
    public void query2() throws Exception {
        Helper.executeQueryOnModel("vc-db-1.rdf", "q2.sparql");
    }

    @Test
    public void query3() throws Exception {
        Helper.executeQueryOnModel("vc-db-1.rdf", "q3.sparql");
    }

    @Test
    public void query4() throws Exception {
        Helper.executeQueryOnModel("vc-db-1.rdf", "q4.sparql");
    }

    @Test
    public void query5() throws Exception {
        Helper.executeQueryOnModel("vc-db-1.rdf", "q5.sparql");
    }

    @Test
    public void query6() throws Exception {
        Helper.executeQueryOnModel("vc-db-1.rdf", "q6.sparql");
    }

    @Test
    public void query7() throws Exception {
        Helper.executeQueryOnModel("vc-db-2.rdf", "q7.sparql");
    }

}
