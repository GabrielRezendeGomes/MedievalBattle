package com.infnet.MedievalBattle.Monstros;
import java.util.Random;
import com.infnet.MedievalBattle.Imetodos.MetodosBatalha;
import com.infnet.MedievalBattle.Personagem.Personagem;

public class Kobold extends Personagem{

    public int getFatorDano(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(2) +1;
        int numeroAleatorio2 = random.nextInt(2) +1;
        int numeroAleatorio3 = random.nextInt(2) +1;
        return numeroAleatorio + numeroAleatorio2 + numeroAleatorio3;


    }

    public Kobold(String nome) {
        super(nome, 13, 6, 1, 3,0);
        this.setFatorDano(getFatorDano());
    }




}