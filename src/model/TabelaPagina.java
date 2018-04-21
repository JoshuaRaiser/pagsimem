/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joshua Raiser
 */
public class TabelaPagina {
    
    Map<String, String> tabelaPaginas;
    private final Memoria memFisica;
    private final Memoria memLogica;
    

    public TabelaPagina(Memoria memFisica, Memoria memLogica) {
        this.tabelaPaginas = new HashMap<>();
        this.memFisica = memFisica;
        this.memLogica = memLogica;
    }
    
}
