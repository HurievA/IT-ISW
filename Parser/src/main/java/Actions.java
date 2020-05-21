import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class Actions {

    // сохраняем объект в XML файл
    public static void convertObjectToXml(Array dish, String filePath) throws FileNotFoundException,ParserConfigurationException, JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Array.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(dish, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Document marshall(Array xml) throws ParserConfigurationException, JAXBException {
        Marshaller marshaller = JAXBContext.newInstance(xml.getClass()).createMarshaller();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        Document document = documentBuilder.newDocument();
        marshaller.marshal(xml, document);
        return document;
    }

    public static boolean validator(Document xml, String xsd) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source file = new StreamSource(new File(xsd));
        Schema schema = factory.newSchema(file);
        Validator validator = schema.newValidator();

        try {
            validator.validate(new DOMSource(xml));
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static boolean validator2(String xmlDocument, String xsdSchema) throws SAXException {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder parser = dbf.newDocumentBuilder();
            Document document = parser.parse(new File(xmlDocument));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Source schemaFile = new StreamSource(new File(xsdSchema));
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(document));
            return true;
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            System.out.println("Error");
            e.printStackTrace();
            return false;

        }
    }

    public static Document get(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(xmlPath);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.parse(file);
    }

    public static void saveNew(Document document, String pathToSave) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
       transformer.setOutputProperty(OutputKeys.INDENT, "yes");
       transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(pathToSave));
        transformer.transform(source, result);
    }

}
