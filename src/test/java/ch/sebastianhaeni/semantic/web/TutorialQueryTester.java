package ch.sebastianhaeni.semantic.web;

import org.junit.Test;

public class TutorialQueryTester {

    @Test
    public void query1() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-1.rdf", "tutorial/q1.sparql");
    }

    @Test
    public void query2() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-1.rdf", "tutorial/q2.sparql");
    }

    @Test
    public void query3() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-1.rdf", "tutorial/q3.sparql");
    }

    @Test
    public void query4() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-1.rdf", "tutorial/q4.sparql");
    }

    @Test
    public void query5() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-1.rdf", "tutorial/q5.sparql");
    }

    @Test
    public void query6() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-1.rdf", "tutorial/q6.sparql");
    }

    @Test
    public void query7() throws Exception {
        Helper.executeQueryOnModel("tutorial/vc-db-2.rdf", "tutorial/q7.sparql");
    }

}
