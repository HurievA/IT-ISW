import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Random;

public final class Editor {

public static void editor(org.w3c.dom.Document document) {
        NodeList array = document.getDocumentElement().getElementsByTagName("dishes");

        for (int i = 0; i < array.getLength(); i++) {
            Node elements = array.item(i);
            Attr countAttr = document.createAttribute("count");
            countAttr.setValue(String.valueOf(new Random().nextInt(100 - 0) & Integer.MAX_VALUE));
            elements.getAttributes().setNamedItem(countAttr);
                if (elements.getAttributes().getNamedItem("link") != null) {
                elements.getAttributes().removeNamedItem("link");
                }
            NodeList element = elements.getChildNodes();
            for (int a = 0; a < element.getLength(); a++) {
                Node productElement = element.item(a);
                    if (productElement.getNodeName().equals("name"))
                        { productElement.getFirstChild().setNodeValue(productElement.getFirstChild().getNodeValue().toUpperCase()); }
                    if (a == element.getLength() - 1) { Node node;
                        if (((DeferredElementImpl) elements).getElementsByTagName("detail").getLength() != 0) { node = ((DeferredElementImpl) elements).getElementsByTagName("detail").item(0);
                        } else { node = document.createElement("detail");
                        elements.appendChild(node);}
                    org.w3c.dom.Element stat = document.createElement("status");
                    stat.appendChild(document.createTextNode("Аvailable"));
                    org.w3c.dom.Element id = document.createElement("id");
                    id.appendChild(document.createTextNode(String.valueOf(new Random().nextInt(100000-10000) & Integer.MAX_VALUE)));
                    node.appendChild(stat);
                    node.appendChild(id);}
            }
        }
    }
}