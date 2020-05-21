import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.xquery.XQException;
import java.io.File;
import java.io.IOException;
public final class Main {
    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException, TransformerException, XQException, XPathExpressionException {
        //  Lab1();
        //  Lab2();
        //  Lab3();
            Lab4();
    }

    private static void Lab1() throws IOException, JAXBException, ParserConfigurationException, SAXException {
        Document document;
        document = Jsoup.connect("https://roll-club.kh.ua/tovar-category/nabory/").get();
        Array dishes = Parser.getPage(document);
        String fileName = "D:\\Programming\\IT\\Parser\\result1.xml";
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

    private static void Lab3() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse("result5.xml");
        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathe.run(doc, xPath);
    }

    private static void Lab4() throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse("result.xml");
        RDF.ConvertToRdf(doc);
        RDF.readrdf("rdf.xml");
    }

}
