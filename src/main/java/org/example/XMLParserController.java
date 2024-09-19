//package org.example;
//
//public class XMLParserController {
//}

package org.example;

import org.example.XMLParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/xml")
public class XMLParserController {

    private final XMLParserService xmlParserService;

    @Autowired
    public XMLParserController(XMLParserService xmlParserService) {
        this.xmlParserService = xmlParserService;
    }

    @GetMapping("/parse")
    public ResponseEntity<Map<String, String>> parseXML() {
        // Specify the XML file path (you can change this as needed)
        String filePath = "C:/Users/91954/OneDrive/Desktop/springboot/newABC/src/main/java/org/example/data.xml";

        // Parse the XML file and get the key-value pairs
        Map<String, String> keyValueMap = xmlParserService.parseXML(filePath);

        // Return the key-value pairs as a response
        return ResponseEntity.ok(keyValueMap);
    }
}
