package com.infnet.MedievalBattle.Personagem;
import java.util.Random;
public class Personagem {

    protected String nome;
    protected int pontosDeVida;
    protected int forca;
    protected int defesa;
    protected int agilidade;

    protected int fatorDano;


    public Personagem(String nome, int pontosDeVida, int forca, int defesa, int agilidade, int fatorDano){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.fatorDano = fatorDano;

    }
    Random random = new Random();
    public int darDano(int fatorAtaque, int fatorDefesa){
        if(fatorAtaque > fatorDefesa ){

            return getForca() + fatorDano;
        }
        else{
            return 0;
        }




    }

    public int iniciativa(){
        int dadoIniciativa = random.nextInt(10)+1;
        return dadoIniciativa + getAgilidade();
    }

    public int receberDano(int quantidadeDeDano){

        return pontosDeVida -= quantidadeDeDano;
    }


    public int fatorDeAtaque(){
        int danoBase = random.nextInt(10)+1;
        return danoBase + getAgilidade() + getForca();
    }

    public int FatordDedefesa(){
        int defesaBase = random.nextInt(10)+1;
        return defesaBase + getDefesa() + getAgilidade();
    }


    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    public int getpontosDeVida(){
        return pontosDeVida;
    }

    public String getNome() {
        return nome;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getDefesa() {
        return defesa;
    }


    public int getForca() {
        return forca;
    }


    protected void setFatorDano(int fator){
        this.fatorDano = fator;
    }


    public void setpontosDeVida(int fatorVida) {
        int pontosDeVida = fatorVida;
    }
}



