/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Joshua Raiser
 */
public class MemoriaLogica extends Memoria{
    
    private MemoriaLogica(int tamanho, int tamanhoPagina) {
        super(tamanho, tamanhoPagina);
    }
    
    public MemoriaLogica(int tamanhoPagina)
    {
        this(0, tamanhoPagina);
    }
    
    public void alocar(Processo processo, List<String> enderecos)
    {
        for(String endereco : enderecos)
        {
            registros.add(new MemoriaRegistro(endereco, processo.getID()));
        }
    }
    
}
