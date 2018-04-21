/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.BinUtil;

/**
 *
 * @author Joshua Raiser
 */
public class Memoria {

    private final int tamanho;
    private final int tamanhoPagina;

    private final List<MemoriaRegistro> registros;
    
    public Memoria(int tamanho, int tamanhoPagina) {
        this.tamanho = tamanho;
        this.tamanhoPagina = tamanhoPagina;
        this.registros = new ArrayList<>();

        int quantidade = Integer.toString(this.tamanho, 2).length();
        for (int i = 0; i < this.tamanho; i++) {
            this.registros.add(new MemoriaRegistro(BinUtil.formatarBinario(Integer.toString(i, 2), quantidade), ""));
        }
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public List<MemoriaRegistro> getRegistros() {
        return this.registros;
    }

}
