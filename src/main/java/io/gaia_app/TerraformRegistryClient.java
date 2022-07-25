package io.gaia_app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

public class TerraformRegistryClient implements TerraformRegistry {

    private static final String TERRAFORM_REGISTRY_URL = "https://registry.terraform.io/v1";

    @Override
    public PaginableResponse listModules() {
        var httpClient = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .uri(URI.create(TERRAFORM_REGISTRY_URL+"/modules"))
                .GET()
                .build();

        var objectMapper = new ObjectMapper();
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("response.body() = " + response.body());
            return objectMapper.readValue(response.body(), TerraformRegistry.PaginableResponse.class);
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PaginableResponse listModules(String namespace) {
        return null;
    }

    @Override
    public PaginableResponse searchModules(String q) {
        return null;
    }
}
