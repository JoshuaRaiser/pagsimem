/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joshua Raiser
 */
public class Alocador extends Thread {

    private final int tempo;
    private final List<Processo> processos;
    private final MemoriaFisica memoriaFisica;
    private final MemoriaLogica memoriaLogica;
    private final List<Processo> filaEspera;
    private final TabelaPagina tabelaPagina;

    public Alocador(int tempo, List<Processo> processos, MemoriaFisica memoriaFisica)
    {
        this.tempo = tempo;
        this.processos = processos;
        this.memoriaFisica = memoriaFisica;
        this.memoriaLogica = new MemoriaLogica(this.memoriaFisica.getTamanhoPagina());
        this.filaEspera = new ArrayList<>();
        this.tabelaPagina = new TabelaPagina(this.memoriaFisica, this.memoriaLogica);
    }
        
    @Override
    public void run() 
    {
        while (true) {
            if (filaEspera.isEmpty() && processos.isEmpty()) {
                break;
            }
            
            filaEspera.stream().filter((processo) -> (alocar(processo))).forEachOrdered((processo) -> {
                filaEspera.remove(processo);
            });

            List<Processo> processosRemover = new ArrayList<>();

            processos.forEach((processo) -> {
                if(processo.getTempoCriacao() == 1)
                {
                    if(!alocar(processo))
                    {
                        filaEspera.add(processo);
                    }

                    processosRemover.add(processo);
                }
                else
                {
                    processo.setTempoCriacao(processo.getTempoCriacao()-1);
                    processo.setTempoRemocao(processo.getTempoRemocao()-1);
                }
            });

            processos.removeAll(processosRemover);
            
            try {
                sleep(tempo);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alocador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private boolean alocar(Processo processo)
    {
        if(memoriaFisica.cabe(processo))
        {
            List<String> enderecos = memoriaFisica.alocar(processo);
            memoriaLogica.alocar(processo, enderecos);
            return true;
        }
        
        return false;
    }
    
}
