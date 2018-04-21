/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joshua Raiser
 */
public class Alocador extends Thread {

    private int tempo;
    private List<Processo> processos;
    private Memoria memoriaFisica;
    private Memoria memoriaLogica;
    private List<Processo> filaEspera;
    
    public Alocador(int tempo, List<Processo> processos, Memoria memoriaFisica)
    {
        this.tempo = tempo;
        this.processos = processos;
        this.memoriaFisica = memoriaFisica;
        this.memoriaLogica = new Memoria(0, this.memoriaFisica.getTamanhoPagina());
        this.filaEspera = new ArrayList<>();
    }
        
    @Override
    public void run() 
    {
        for(Processo processo : filaEspera)
        {
            if (alocar(processo))
            {
                filaEspera.remove(processo);
            }
        }
        
        for(Processo processo : processos)
        {
            if(processo.getTempoCriacao() == 1)
            {
                if(!alocar(processo))
                {
                    filaEspera.add(processo);
                }
                processos.remove(processo);
            }
            else
            {
                processo.setTempoCriacao(processo.getTempoCriacao()-1);
                processo.setTempoRemocao(processo.getTempoRemocao()-1);
            }
        }
    }
    
    private boolean alocar(Processo processo)
    {
        if()
        {
            
            
            return true;
            
        }
        return false;
    }

    
    
}
