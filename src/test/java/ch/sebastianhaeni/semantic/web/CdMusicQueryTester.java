package ch.sebastianhaeni.semantic.web;

import org.junit.Test;

public class CdMusicQueryTester {

    @Test
    public void query1() {
        Helper.executeQueryOnModel("lecture/cdmusic.ttl", "lecture/query1.sparql");
    }

    @Test
    public void query2() {
        Helper.executeQueryOnModel("lecture/cdmusic.ttl", "lecture/query2.sparql");
    }

    @Test
    public void query3() {
        Helper.executeQueryOnModel("lecture/cdmusic.ttl", "lecture/query3.sparql");
    }

    @Test
    public void query4() {
        Helper.executeQueryOnModel("lecture/cdmusic.ttl", "lecture/query4.sparql");
    }

    @Test
    public void query5() {
        Helper.executeQueryOnModel("lecture/cdmusic.ttl", "lecture/query5.sparql");
    }

}
