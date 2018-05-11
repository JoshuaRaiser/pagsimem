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
import java.util.stream.Collectors;

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

    public Alocador(int tempo, List<Processo> processos, MemoriaFisica memoriaFisica)
    {
        this.tempo = tempo;
        this.processos = processos;
        this.memoriaFisica = memoriaFisica;
        this.memoriaLogica = new MemoriaLogica(this.memoriaFisica.getTamanhoPagina());
        this.filaEspera = new ArrayList<>();
    }
        
    @Override
    public void run() 
    {
        while (true) {
            if (filaEspera.isEmpty() && processos.isEmpty() && memoriaFisica.isEmpty()) {
                System.out.println("Saiu do while da thread do Joshua");
                break;
            } else {
                System.out.println("Fila de espera: " + filaEspera.size());
                System.out.println("Processos: " + processos.size());
            }
            
            List<Processo> processosRemover = new ArrayList<>();
            memoriaFisica.getProcessos().stream().filter((processo) -> (memoriaFisica.desalocar(processo))).forEachOrdered((processo) -> {
                processosRemover.add(processo);
            });
            memoriaFisica.getProcessos().removeAll(processosRemover);
            
            List<MemoriaRegistro> registrosRemover = new ArrayList<>();            
            memoriaLogica.getRegistros().forEach(registro -> {
                processosRemover.forEach(processo -> {
                    if (processo.getID().equalsIgnoreCase(registro.getValor())) {
                        registrosRemover.add(registro);
                    }
                });
            });
            memoriaLogica.getRegistros().removeAll(registrosRemover);
            
            processosRemover.clear();
            registrosRemover.clear();
            
            List<Processo> filaEsperaRemover = filaEspera.stream().filter((processo) -> (alocar(processo))).collect(Collectors.toList());
            filaEspera.removeAll(filaEsperaRemover);
            
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
