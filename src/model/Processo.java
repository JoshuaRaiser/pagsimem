/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joshua Raiser
 */
public class Processo {

    @Override
    public String toString() {
        return "Processo{" + "ID= " + ID + " tempoCriacao= " + tempoCriacao + ", tempoRemocao= " + tempoRemocao + ", bytes= " + bytes + '}';
    }

    public Processo(String ID, int tempoCriacao, int tempoRemocao, int bytes) {
        this.ID = ID;
        this.tempoCriacao = tempoCriacao;
        this.tempoRemocao = tempoRemocao;
        this.bytes = bytes;
    }
    
    // ID único do processo
    String ID;
    
    // tempo em que o processo deve ser criado
    int tempoCriacao;
    
    // tempo em que o processo deve ser removido
    int tempoRemocao;
    
    // quantidade de bytes que ele ocupa
    int bytes;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getTempoCriacao() {
        return tempoCriacao;
    }

    public void setTempoCriacao(int tempoCriacao) {
        this.tempoCriacao = tempoCriacao;
    }

    public int getTempoRemocao() {
        return tempoRemocao;
    }

    public void setTempoRemocao(int tempoRemocao) {
        this.tempoRemocao = tempoRemocao;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }  
    
}
