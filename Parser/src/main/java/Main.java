import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException, TransformerException {
       // Lab1();
        Lab2();
    }

    private static void Lab1() throws IOException, JAXBException, ParserConfigurationException, SAXException {
        Document document;
        document = Jsoup.connect("https://roll-club.kh.ua/tovar-category/nabory/").get();
        Array dishes = Parser.getPage(document);
        String fileName = "D:\\Programming\\IT\\Parser\\result3.xml";
        Actions.convertObjectToXml(dishes, fileName);
        org.w3c.dom.Document xml = Actions.marshall(dishes);
        System.out.println("Validator is " + Actions.validator(xml, "D:\\Programming\\IT\\Parser\\src\\main\\java\\schema1.xsd"));
    }

    private static void Lab2() throws IOException, JAXBException, ParserConfigurationException, SAXException, TransformerException {
        org.w3c.dom.Document doc = Actions.get("result2.xml");
        Editor.editor(doc);
        Actions.saveNew(doc,"result5.xml");
        Source xml = new StreamSource(new File("D:\\Programming\\IT\\Parser\\result5.xml"));
        Source xslt = new StreamSource("D:\\Programming\\IT\\Parser\\result.xsl");
        XMLtoHTML.convertXMLToHTML(xml, xslt);
    }
}
