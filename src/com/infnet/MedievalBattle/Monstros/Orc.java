package com.infnet.MedievalBattle.Monstros;
import java.util.Random;
import com.infnet.MedievalBattle.Imetodos.MetodosBatalha;
import com.infnet.MedievalBattle.Personagem.Personagem;

public class Orc extends Personagem{

    public int getFatorDano(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(8) +1;


        return numeroAleatorio;
    }

    public Orc(String nome) {
        super(nome, 13, 6, 1, 3,0);
        this.setFatorDano(getFatorDano());
    }




}