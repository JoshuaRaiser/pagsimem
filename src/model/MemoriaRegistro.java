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
public class MemoriaRegistro {
    
    private final String endereco;
    private String valor;

    public MemoriaRegistro(String endereco, String valor) {
        this.endereco = endereco;
        this.valor = valor;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
