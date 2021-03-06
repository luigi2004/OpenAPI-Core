/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tech.opdev.json;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import jakarta.json.Json;
import jakarta.json.JsonValue;
import jakarta.json.stream.JsonLocation;
import jakarta.json.stream.JsonParser;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        // System.out.println(new App().getGreeting());
        try (InputStream in = App.class.getResourceAsStream("/api.json")) {
            JsonParser parser = Json.createParser(in);
            JsonLocation loc = parser.getLocation();
            log.info("Reading from line {}", loc.getLineNumber());
            parser.next();
            Document document = new Document();
            parser.getObjectStream().forEach(obj->{
                String header = obj.getKey();
                JsonValue val = obj.getValue();
                log.info("Key: {}", header);
                switch (header) {
                    case "openapi":
                        log.info("version: {}", val);
                        document.setVersion(val.toString());
                        break;
                    case "info":
                        Info info = new Info(val.asJsonObject());
                        document.setInfo(info);
                        log.info("info: {}", info);
                        break;
                    case "paths":
                        Map<String, PathItem> paths = new HashMap<>();
                        val.asJsonObject().entrySet().stream().forEach(p->paths.put(p.getKey(), PathItem.getFrom(p.getValue().asJsonObject())));
                        document.setPaths(Optional.of(paths));;
                        log.info("paths: {}", paths);
                        break;
                    case "externalDocs":
                        break;
                    default:
                        break;
                }
            });
            log.info("Done!!! {}", document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
