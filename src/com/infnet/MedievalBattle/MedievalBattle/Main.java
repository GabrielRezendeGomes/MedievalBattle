package com.infnet.MedievalBattle.MedievalBattle;
import com.infnet.MedievalBattle.Herois.Guerreiro;
import com.infnet.MedievalBattle.Herois.Barbaro;
import com.infnet.MedievalBattle.Herois.Paladino;
import com.infnet.MedievalBattle.Monstros.Orc;
import com.infnet.MedievalBattle.Monstros.MortoVivo;
import com.infnet.MedievalBattle.Monstros.Kobold;
import com.infnet.MedievalBattle.Personagem.Personagem;
import com.infnet.MedievalBattle.Imetodos.MetodosBatalha;
import com.infnet.MedievalBattle.Batalha.Batalha;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

    public static void main(String[] args) {


        System.out.println("▒█▀▄▀█ █▀▀ █▀▀▄ ░▀░ █▀▀ ▀█░█▀ █▀▀█ █░░ 　 ▒█▀▀█ █▀▀█ ▀▀█▀▀ ▀▀█▀▀ █░░ █▀▀ \n" +
                "▒█▒█▒█ █▀▀ █░░█ ▀█▀ █▀▀ ░█▄█░ █▄▄█ █░░ 　 ▒█▀▀▄ █▄▄█ ░░█░░ ░░█░░ █░░ █▀▀ \n" +
                "▒█░░▒█ ▀▀▀ ▀▀▀░ ▀▀▀ ▀▀▀ ░░▀░░ ▀░░▀ ▀▀▀ 　 ▒█▄▄█ ▀░░▀ ░░▀░░ ░░▀░░ ▀▀▀ ▀▀▀ \n");

        System.out.println("Insira o nome do seu herói:");
        Scanner in = new Scanner(System.in);

        String nome = in.nextLine();


        System.out.println("Bem vindo! " + nome);

        System.out.println("▒█▀▄▀█ █▀▀ █▀▀▄ █░░█ \n" +
                "▒█▒█▒█ █▀▀ █░░█ █░░█ \n" +
                "▒█░░▒█ ▀▀▀ ▀░░▀ ░▀▀▀ \n");

        System.out.println("Escolha uma classe para o seu herói \n " +
                "1- Guerreiro \n" +
                "2- Paladino \n" +
                "3- Barbaro \n" +
                "4- Sair"
        );

        int escolha = in.nextInt();

        Personagem heroi;

        switch (escolha) {
            case 1:
                heroi = new Guerreiro(nome);
                break;
            case 2:
                heroi = new Paladino(nome);
                break;
            case 3:
                heroi = new Barbaro(nome);
                break;
            case 4:
                System.exit(0);
            default:
                heroi = new Guerreiro(nome);
                System.out.println("Escolha invalida, guerreiro escolhido como padrão");
                break;
        }

        Personagem monstro = criarMonstroAleatorio();

        System.out.println("Voce lutará contra um " + monstro.getNome());

        Batalha batalha = new Batalha();
        batalha.simulaBatalha(heroi, monstro);

        String resultado = heroi.estaVivo() ? "GANHOU" : "PERDEU";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataDaPartida = new Date();

        // Caminho para a pasta "temp" no mesmo diretório
        String caminhoDoArquivo = "temp/";

        // Escreva os resultados da batalha no arquivo CSV
        escreverDadosCSV(caminhoDoArquivo, dateFormat.format(dataDaPartida), nome, resultado, monstro.getNome(), batalha.getQuantidadeDeRodadas());





    }



    public static Personagem criarMonstroAleatorio() {
        Random random = new Random();
        int escolhaMonstro = random.nextInt(3) + 1;

        return switch (escolhaMonstro) {
            case 1 -> new MortoVivo("Morto-Vivo");
            case 2 -> new Orc("Orc");
            case 3 -> new Kobold("Kobold");
            default -> null;
        };


    }
    public static void escreverDadosCSV(String caminhoDoArquivo, String data, String jogador, String resultado, String monstro, int quantidadeDeRodadas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoDoArquivo, true))) {
            writer.println(data + " || " + jogador + " || " + resultado + " || " + monstro + " || " + quantidadeDeRodadas);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o arquivo CSV.");
            e.printStackTrace();


        }
    }
}














