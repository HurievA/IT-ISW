import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.Random;

public final class Parser {

    public static Array getPage(Document document){

        Array array = new Array();

        Elements elements = document.select("div.product-content");
            for (Element element : elements) {

                Array.Dish dish = new Array.Dish();
                Array.Dish.info Fdish = new Array.Dish.info();

                dish.setName(element.select("a").attr("title"));
                dish.setCost(element.getElementsByClass("woocommerce-Price-amount amount").text());
                dish.setWeight(element.select("em").text());
                dish.setLink(element.select("a.product-link").attr("href"));
                dish.setInfo(Fdish);
                dish.getInfo().setReview(element.select("span.star-rating__count").text());
                dish.getInfo().setConsist(element.select("div.product-description__content").text());


                array.getArray().add(dish);
            }
            return array;
        }

    }
