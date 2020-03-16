import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public final class Main {
    public static void main(String[] args) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        Document document;
        document = Jsoup.connect("https://roll-club.kh.ua/tovar-category/nabory/").get();
        Array dishes = Parser.getPage(document);
        String fileName = "D:\\Programming\\IT\\Parser\\result2.xml";
        Actions.convertObjectToXml(dishes, fileName);
        org.w3c.dom.Document xml = Actions.marshall(dishes);
        System.out.println("Validator is " + Actions.validator(xml,"D:\\Programming\\IT\\Parser\\src\\main\\java\\schema1.xsd"));
    }
}
