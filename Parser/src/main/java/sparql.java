import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;

public class sparql{

    public static void one() throws Exception {
    Model model = FileManager.get().loadModel("lab5.xml");
    System.out.println("#1");
    String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
            "SELECT (COUNT(*) as ?count)" +
            "WHERE {?a ?b ?c .}";
    Query q = QueryFactory.create(sparql);
    QueryExecution qEx = QueryExecutionFactory.create(q, model);
    ResultSet resultSet = qEx.execSelect();
    System.out.println(resultSet.nextSolution());
}

    public static void two() throws Exception {
        Model model = FileManager.get().loadModel("lab5.xml");
        System.out.println("#2");
        String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
                "SELECT ?a \n" +
                "WHERE {?b dc:title ?a .}" +
                "LIMIT 1";
        Query q = QueryFactory.create(sparql);
        QueryExecution qEx = QueryExecutionFactory.create(q, model);
        ResultSet resultSet = qEx.execSelect();
        System.out.println(resultSet.nextSolution());
    }
    public static void three() throws Exception {
        Model model = FileManager.get().loadModel("lab5.xml");
        System.out.println("#3");
        String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
            "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
            "PREFIX mk: <https://roll-club.kh.ua/#> " +
            "SELECT ?a\n" +
            "WHERE {\n" +
            "?a rdf:type/rdfs:subClassOf* mk:vegetarian\n" +
            "}";
        Query q = QueryFactory.create(sparql);
        QueryExecution qEx = QueryExecutionFactory.create(q, model);
        ResultSet resultSet = qEx.execSelect();
        while (resultSet.hasNext()) {
            System.out.println(resultSet.nextSolution());
        }
    }
    public static void four() throws Exception {
        Model model = FileManager.get().loadModel("lab5.xml");
        System.out.println("#4");
        String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
                "SELECT ?price\n" +
                "WHERE {\n" +
                "?b dc:description ?price\n" +
                "}";
        Query q = QueryFactory.create(sparql);
        QueryExecution qEx = QueryExecutionFactory.create(q, model);
        ResultSet resultSet = qEx.execSelect();
        while (resultSet.hasNext()) {
            System.out.println(resultSet.nextSolution());
        }
    }
    public static void five() throws Exception {
        Model model = FileManager.get().loadModel("lab5.xml");
        System.out.println("#5");
        String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
                "PREFIX rc: <https://roll-club.kh.ua/#> " +
                "SELECT ?subclass\n" +
                "WHERE {\n" +
                "?subclass rdfs:subClassOf* rc:big\n" +
                "}";
        Query q = QueryFactory.create(sparql);
        QueryExecution qEx = QueryExecutionFactory.create(q, model);
        ResultSet resultSet = qEx.execSelect();
        while (resultSet.hasNext()) {
            System.out.println(resultSet.nextSolution());
        }
    }
    public static void six() throws Exception {
        Model model = FileManager.get().loadModel("lab5.xml");
        System.out.println("#6");
        String sparql = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
                "SELECT ?title\n" +
                "WHERE {\n" +
                "?x dc:title ?title " +
                "FILTER regex(?title, 'Сет', 'i')" +
                "}";
        Query q = QueryFactory.create(sparql);
        QueryExecution qEx = QueryExecutionFactory.create(q, model);
        ResultSet resultSet = qEx.execSelect();
        while (resultSet.hasNext()) {
            System.out.println(resultSet.nextSolution());
        }

        System.out.println("#7");
        String sparql1 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX dc: <http://purl.org/dc/elements/1.1/> " +
                "SELECT ?title WHERE {?title dc:description ?description\n" +
                "FILTER (?description <= '370' ) }";
        Query q1 = QueryFactory.create(sparql1);
        QueryExecution qEx1 = QueryExecutionFactory.create(q1, model);
        ResultSet resultSet1 = qEx1.execSelect();
        while (resultSet1.hasNext()) {
            System.out.println(resultSet1.nextSolution());
        }
    }

}