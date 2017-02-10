package datamanager;

import com.company.People;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

/**
 * Created by root on 10.02.17.
 */
public class DataManager {


    public static void serialize(People people) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation();

        Document doc = impl.createDocument(null, null, null);

        Element element = doc.createElement("Object");
        element.setAttribute("type",people.getClass().getSimpleName());
        for (Field field : people.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Element element1 = doc.createElement("fields");
            element1.setAttribute("type", field.getType().getSimpleName());
            element1.setAttribute("id", field.getName());
            element1.setAttribute("value", field.get(people).toString());
            element.appendChild(element1);
        }
        doc.appendChild(element);

        StreamResult result = new StreamResult(new File("test.xml"));
        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        StreamResult consoleResult = new StreamResult(System.out);
    }

    public static void serializeCollection(Collection<People> collection) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation impl = builder.getDOMImplementation();

        Document doc = impl.createDocument(null, null, null);


        Element rootElement = doc.createElement("Collection");
        rootElement.setAttribute("type",People.class.getSimpleName());
        for (People people : collection) {
            Element element = element = doc.createElement("Object");
            element.setAttribute("type",People.class.getSimpleName());
            for (Field field : people.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Element element1 = doc.createElement("fields");
                element1.setAttribute("type", field.getType().getSimpleName());
                element1.setAttribute("id", field.getName());
                element1.setAttribute("value", field.get(people).toString());
                element.appendChild(element1);
            }
            rootElement.appendChild(element);
        }
        doc.appendChild(rootElement);


        StreamResult result = new StreamResult(new File("test.xml"));
        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
    }



    public static People deserialize(String path) throws Exception{
        People people = null;
        return people;
    }


}



