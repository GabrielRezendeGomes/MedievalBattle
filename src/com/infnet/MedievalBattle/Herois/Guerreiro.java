package com.infnet.MedievalBattle.Herois;

import com.infnet.MedievalBattle.Imetodos.MetodosBatalha;
import com.infnet.MedievalBattle.Personagem.Personagem;

import java.util.Random;

public class Guerreiro extends Personagem{

    public int getFatorDano(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(4) +1;
        int numeroAleatorio2 = random.nextInt(4)+1;

        return numeroAleatorio2 + numeroAleatorio;
    }
    public Guerreiro(String nome) {
        super(nome, 12, 4, 3, 3,0);
        this.setFatorDano(getFatorDano());
    }



}
