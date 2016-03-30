package ch.sebastianhaeni.semantic.web;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.ontology.OntProperty;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;

public class GenerateAnimalModel {
    public static void main(String[] args) {

        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.RDFS_MEM);

        String BASE = "http://www.example.org/livingbeings#";
        model.setNsPrefix("lb", BASE);

        OntClass feature = model.createClass(BASE + "Feature");
        OntClass environment = model.createClass(BASE + "Environment");
        OntClass animal = model.createClass(BASE + "Animal");
        OntClass mammal = model.createClass(BASE + "Mammal");
        OntClass fish = model.createClass(BASE + "Fish");
        OntClass whale = model.createClass(BASE + "Whale");
        OntClass bear = model.createClass(BASE + "Bear");
        OntClass cat = model.createClass(BASE + "Cat");

        OntProperty has = model.createOntProperty(BASE + "has");
        OntProperty livesIn = model.createOntProperty(BASE + "livesin");

        has.setDomain(mammal);
        has.setRange(feature);

        livesIn.setDomain(animal);
        livesIn.setRange(environment);

        Resource fur = model.createOntResource(BASE + "Fur");
        Resource vertebra = model.createResource(BASE + "Vertebra");
        Resource water = model.createResource(BASE + "Water");

        fur.addProperty(RDF.type, feature);
        water.addProperty(RDF.type, environment);

        mammal.setSuperClass(animal);
        mammal.setPropertyValue(has, vertebra);

        fish.setSuperClass(animal);
        fish.setPropertyValue(livesIn, water);

        whale.setSuperClass(mammal);
        whale.setPropertyValue(livesIn, water);

        bear.setSuperClass(mammal);
        bear.setPropertyValue(has, fur);

        cat.setSuperClass(mammal);
        cat.setPropertyValue(has, fur);


        model.write(System.out, "RDF/XML-ABBREV", BASE);
    }

}
