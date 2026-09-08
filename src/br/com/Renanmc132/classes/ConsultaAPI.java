package br.com.Renanmc132.classes;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {


    public CEP ConsultaCEP(String cep) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        URI url = URI.create("https://viacep.com.br/ws/"+cep+"/json/");
        HttpRequest request = HttpRequest.newBuilder().uri(url).build();

        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body() ,CEP.class);
    }



}
