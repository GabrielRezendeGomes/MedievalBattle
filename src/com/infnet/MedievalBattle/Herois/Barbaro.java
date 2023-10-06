package com.infnet.MedievalBattle.Herois;
import java.util.Random;
import com.infnet.MedievalBattle.Imetodos.MetodosBatalha;
import com.infnet.MedievalBattle.Personagem.Personagem;

public class Barbaro extends Personagem{

    public int getFatorDano(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(6) +1;
        int numeroAleatorio2 = random.nextInt(6)+1;

        return numeroAleatorio2 + numeroAleatorio;
    }

    public Barbaro(String nome) {
        super(nome, 13, 6, 1, 3,0);
        this.setFatorDano(getFatorDano());
    }




}