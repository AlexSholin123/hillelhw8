package ua.ithillel.service;


import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RandomHttpService {
    @SneakyThrows
    public int getNumber(int min, int max) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "http://www.randomnumberapi.com/api/v1.0/random?min=" + min + "&max=" + max + "&count=1";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String rBody = response.body();

        return Integer.parseInt(rBody.substring(1, rBody.length() - 1));


    }
}
