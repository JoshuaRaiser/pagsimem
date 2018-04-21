/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joshua Raiser
 */
public class MemoriaFisica extends Memoria{
    
    public MemoriaFisica(int tamanho, int tamanhoPagina) {
        super(tamanho, tamanhoPagina);
    }
    
    public boolean cabe(Processo processo)
    {
        int espacoDisponivel = 0;
        for(int i = 0; i < tamanho; i+=tamanhoPagina)
        {
            if(registros.get(i).getValor().equalsIgnoreCase(""))
            {
                espacoDisponivel += tamanhoPagina;
            }
        }
        return processo.getBytes() <= espacoDisponivel;
    }
    
    public List<String> alocar(Processo processo)
    {
        int bytesAlocados = 0;
        List<String> enderecos = new ArrayList<>();
        for(int i = 0; i < tamanho; i+=tamanhoPagina)
        {
            if(registros.get(i).getValor().equalsIgnoreCase(""))
            {
                for(int j = i; j < (tamanhoPagina + i) && bytesAlocados < processo.getBytes(); j++)
                {
                    bytesAlocados += 1;
                    registros.get(j).setValor(processo.getID());
                    enderecos.add(registros.get(j).getEndereco());
                }
            }
        }
        notificarListeners();
        return enderecos;
    }
    
}
