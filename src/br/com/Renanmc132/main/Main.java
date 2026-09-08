package br.com.Renanmc132.main;

import br.com.Renanmc132.classes.Arquivo;
import br.com.Renanmc132.classes.CEP;
import br.com.Renanmc132.classes.ConsultaAPI;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Main {

    static void main() throws IOException, InterruptedException {
        Arquivo arquivo = new Arquivo();
        ConsultaAPI api = new ConsultaAPI();

        String busca = JOptionPane.showInputDialog("Qual seu CEP?");

        arquivo.CriarJson(busca,api.ConsultaCEP(busca));

        JOptionPane.showMessageDialog(null,"Arquivo Json criado com sucesso!");
    }


}
