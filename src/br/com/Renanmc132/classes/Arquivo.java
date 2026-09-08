package br.com.Renanmc132.classes;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class Arquivo {


    public void CriarJson(String name, CEP cep) throws IOException {

        FileWriter writer = new FileWriter(name);

        Gson gson = new Gson()
                .newBuilder()
                .setPrettyPrinting()
                .create();

        writer.write(gson.toJson(cep));
        writer.close();


    }



}
