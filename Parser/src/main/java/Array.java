import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType( name = "Array", propOrder = {
        "dishes"
})
@XmlRootElement( name = "Array")
public class Array{


    protected List<Array.Dish> dishes;

    public List<Array.Dish> getArray() {
        if (this.dishes == null) {
            this.dishes = new ArrayList<>();
        }
        return this.dishes;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(propOrder = {"name", "cost", "weight", "info", "link"})

    public static class Dish {
        private String name;
        private String cost;
        private String weight;
        @XmlAttribute (name = "link")
        private String link;
        private info info;

        public Dish() {
        }

        public Dish(String name, String cost, String weight, String link, info info) {
            this.name = name;
            this.cost = cost;
            this.weight = weight;
            this.link = link;
            this.info = info;
        }


        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }

        public String getCost() {
            return cost;
        }


        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getWeight() {
            return weight;
        }


        public void setWeight(String weight) {
            this.weight = weight;
        }


        public String getLink() {
            return link;
        }


        public void setLink(String link) {
            this.link = link;
        }

        public info getInfo(){
            return info;
        }

        public void setInfo(info info){
            this.info = info;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "info", propOrder = {
                "review",
                "consist"
        })
        public static class info {
            private String review;
            private String consist;

            public String getConsist() {
                return consist;
            }


            public void setConsist(String consist) {
                this.consist = consist;
            }

            public String getReview() {
                return review;
            }


            public void setReview(String review) {
                this.review = review;
            }

            @Override
            public String toString() {
                return
                        ", review='" + review + '\'' +
                        ", consist=" + consist ;
            }
        }
        @Override
        public String toString() {
            return "Dish{" +
                    "name=" + name +
                    ", name='" + name + '\'' +
                    ", cost=" + cost +
                    ", weight='" + weight + '\'' +
                    ", link=" + link +
                    ", info='" + info.toString() + '\'' +
                    '}';
        }
    }
}
