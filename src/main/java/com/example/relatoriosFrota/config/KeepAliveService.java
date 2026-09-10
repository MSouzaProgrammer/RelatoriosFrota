package com.example.relatoriosFrota.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

@Component
public class KeepAliveService {

    // 600000 milissegundos = 10 minutos
    @Scheduled(fixedRate = 600000)
    public void pingMe() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/")) // uma rota sua
                    .GET()
                    .build();
            
            // Faz a requisição para si mesmo na nuvem
            client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Ping enviado para manter o Render acordado!");
        } catch (Exception e) {
            System.err.println("Erro no auto-ping: " + e.getMessage());
        }
    }
}