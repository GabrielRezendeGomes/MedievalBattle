package com.infnet.MedievalBattle.Batalha;
import com.infnet.MedievalBattle.Herois.Guerreiro;
import com.infnet.MedievalBattle.Herois.Barbaro;
import com.infnet.MedievalBattle.Herois.Paladino;
import com.infnet.MedievalBattle.Monstros.Orc;
import com.infnet.MedievalBattle.Monstros.MortoVivo;
import com.infnet.MedievalBattle.Monstros.Kobold;
import com.infnet.MedievalBattle.Personagem.Personagem;
import com.infnet.MedievalBattle.Imetodos.MetodosBatalha;
import java.util.Scanner;
import java.util.Random;

public class Batalha {
    int quantidadeDeRodadas = 0;
    public void simulaBatalha(Personagem heroi, Personagem monstro) {
        int iniciativaHeroi;
        int iniciativaMonstro;


        while (heroi.estaVivo() && monstro.estaVivo()) {
            iniciativaHeroi = heroi.iniciativa();
            iniciativaMonstro = monstro.iniciativa();

            int danoHeroi = heroi.darDano(heroi.fatorDeAtaque(), monstro.FatordDedefesa());
            int danoMonstro = danoMonstro = monstro.darDano(monstro.fatorDeAtaque(), heroi.FatordDedefesa());

            if (iniciativaHeroi > iniciativaMonstro) {


                monstro.receberDano(danoHeroi);

                // Verifica se o monstro foi derrotado
                if (!monstro.estaVivo()) {
                    monstro.setpontosDeVida(0);
                    System.out.println("VOCÊ GANHOU em: " + quantidadeDeRodadas + "Rodadas");
                    break;
                }
            } else {

                heroi.receberDano(danoMonstro);

                // Verifica se o herói foi derrotado
                if (!heroi.estaVivo()) {
                    heroi.setpontosDeVida(0);
                    System.out.println("VOCÊ PERDEU em: " + quantidadeDeRodadas + "Rodadas");
                    break;
                }
            }

            // Exibe informações da rodada
            System.out.println("Você deu: " + danoHeroi + " de dano no " + monstro.getNome());
            System.out.println("O " + monstro.getNome() + " está com: " + monstro.getpontosDeVida() + " de vida");
            System.out.println("O monstro te deu: " + danoMonstro + " de dano");
            System.out.println("Você está com: " + heroi.getpontosDeVida() + " de vida");

            quantidadeDeRodadas++;
        }


    }
    public int getQuantidadeDeRodadas(){
        return quantidadeDeRodadas;
    }
}
