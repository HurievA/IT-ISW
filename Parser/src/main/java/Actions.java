import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;

public final class Actions {

    // сохраняем объект в XML файл
    public static void convertObjectToXml(Array student, String filePath) throws FileNotFoundException,ParserConfigurationException, JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(Array.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(student, new File(filePath));
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
}
