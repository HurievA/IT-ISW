import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.DC_11;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;

public class RDF {

    public static void ConvertToRdf(Document doc) throws IOException {

        NodeList dishes = doc.getElementsByTagName("dishes");
        Model model = ModelFactory.createDefaultModel();
        for (int i = 0; i < dishes.getLength(); i++) {
            Node node = dishes.item(i);
            Element element = (Element) dishes.item(i);
            Resource resource = model.createResource(node.getAttributes().getNamedItem("link").getNodeValue());
            if (i < 10) { resource.addProperty(DC_11.language, "en"); }
            else { resource.addProperty(DC_11.language, "ru"); }
            resource.addProperty(DC_11.identifier, String.valueOf(i));
            resource.addProperty(DC_11.description, element.getElementsByTagName("cost").item(0).getFirstChild().getNodeValue());
            resource.addProperty(DC_11.title, element.getElementsByTagName("name").item(0).getFirstChild().getNodeValue());
        }
        OutputStream outputStream = new FileOutputStream(new File("rdf.xml"));
        model.write(outputStream);
        outputStream.close();
    }

    public static void readrdf(String rdfFile) {
        Model model = ModelFactory.createDefaultModel();
        InputStream inputStream = FileManager.get().open(rdfFile);
        model.read(inputStream, null);
        ResIterator resIterator = model.listResourcesWithProperty(DC_11.language);
        System.out.println("Всего: " + resIterator.toList().size() * 4);
        ResIterator resIterator1 = model.listResourcesWithProperty(DC_11.language);
        while (resIterator1.hasNext()) {
            System.out.println(resIterator1.next().listProperties(DC_11.title).toModel().toString());
            System.out.println(resIterator1.next().listProperties(DC_11.description).toModel().toString());
            System.out.println(resIterator1.next().listProperties(DC_11.language).toModel().toString());
            System.out.println(resIterator1.next().listProperties(DC_11.identifier).toModel().toString());
            System.out.println("");
        }
        ResIterator resIterator3 = model.listResourcesWithProperty(DC_11.language, "en");
        while (resIterator3.hasNext()) {
            System.out.println(resIterator3.nextResource().getRequiredProperty(DC_11.title).getObject());
        }
    }
}