//package org.example;
//
//public class serviceCode {
//}
//

package org.example;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class XMLParserService {

    public Map<String, String> parseXML(String filePath) {
        Map<String, String> keyValueMap = new HashMap<>();

        try {
            // Create a DOM parser factory and builder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();

            // Get the list of all "entry" elements
            NodeList nodeList = document.getElementsByTagName("entry");

            // Iterate over each entry
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Extract the key and value from the entry
                    String key = element.getElementsByTagName("key").item(0).getTextContent();
                    String value = element.getElementsByTagName("value").item(0).getTextContent();

                    // Store the key-value pair in the HashMap
                    keyValueMap.put(key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error parsing XML file", e);
        }

        return keyValueMap;
    }
}
