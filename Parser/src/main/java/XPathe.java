import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

public class XPathe {

    public static void xPathTest(Document doc, XPath xPath) throws XPathExpressionException {
        one(doc, xPath);
        two(doc, xPath);
        three(doc, xPath);
        four(doc, xPath);
        five(doc, xPath);
       six(doc, xPath);
        seven(doc, xPath);
        eight(doc, xPath);
        nine(doc, xPath);
        ten(doc, xPath);
    }
    public static void one(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Отримати загальну кількість описаних елементів ");
        System.out.println(nodeList.getLength());
    }

    public static void two(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes/name/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести інформацію1 за однією із характеристик для всіх описаних складних елементів ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }

    public static void three(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[1]/name/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Отримати інформацію за однією із характеристик для одного складного елементу ");
        System.out.println(nodeList.item(0).getNodeValue());
    }

    public static void four(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes/name[string-length() > 1]/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести номер елемента, назва якого складається більше, ніж із одного слова ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }

    public static void five(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[1]/*[1]/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести тільки перший параметр одного складного елемента ");
        System.out.println(nodeList.item(0).getNodeValue());
    }

    public static void six(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[1]/*[2]/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести тільки другий параметр одного складного елемента ");
        System.out.println(nodeList.item(0).getNodeValue());
    }

    public static void seven(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[1]/*[3]/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести тільки третій параметр одного складного елемента ");
        System.out.println(nodeList.item(0).getNodeValue());
    }

    public static void eight(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[/Array/dishes/detail/id > 10000 and /Array/dishes/detail/id < 15000 and contains(name, 'СУ')]/name/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести назву елемента, якщо його ціна знаходиться в заданому діапазоні, а також містить задану послідовність літер у назві. ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }

    public static void nine(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[position() mod 5 = 0]/cost/text() | /Array/dishes[position() mod 5 = 0]/weight/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести інформацію за двома параметрами кожного п’ятого елемента ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }

    public static void ten(Document doc, XPath xPath) throws XPathExpressionException {
        XPathExpression xPathExpression = xPath.compile("/Array/dishes[position() mod 2 = 0]/@count | /Array/dishes[position() mod 2 = 0]/cost/text()");
        NodeList nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Вивести номер елементу (товару, послуги тощо) та додатково, ще один параметр (напр. ціна) для кожного другого складного елемента в документі. ");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }
}