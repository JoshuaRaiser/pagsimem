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
    
    private final List<Processo> processos;
    
    public MemoriaFisica(int tamanho, int tamanhoPagina) {
        super(tamanho, tamanhoPagina);
        processos = new ArrayList<>();
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
        
        processos.add(processo);
        
        notificarListeners();
        return enderecos;
    }

    public List<Processo> getProcessos() {
        return processos;
    }

    public boolean desalocar(Processo processo) {
        if (processo.getTempoRemocao() == 1)
        {
            //processos.remove(processo);
            for (MemoriaRegistro registro : registros) 
            {
                if (processo.getID().equalsIgnoreCase(registro.getValor()))
                {
                    registro.setValor("");
                }
            }
            
            notificarListeners();
            
            return true;
        }
        
        processo.setTempoRemocao(processo.getTempoRemocao() - 1);
        return false;
    }
    
    public boolean isEmpty()
    {
        return registros.stream().filter(memoriaRegistro -> memoriaRegistro.getValor().equalsIgnoreCase("")).count() == 0;
    }   
    
}
