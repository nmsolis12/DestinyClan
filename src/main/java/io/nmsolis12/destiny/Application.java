package io.nmsolis12.destiny;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.KatharsisConfigV2;

@SpringBootApplication
@RestController
@Import(KatharsisConfigV2.class)
public class Application {

	@Autowired
    private ResourceRegistry resourceRegistry;

    @RequestMapping("/api/resourcesInfo")
    public Map<?, ?> getResources() {
        Map<String, String> result = new HashMap<>();

        for (Class<?> clazz : resourceRegistry.getResources().keySet()) {
           result.put(resourceRegistry.getResourceType(clazz), resourceRegistry.getResourceUrl(clazz));
        }
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
