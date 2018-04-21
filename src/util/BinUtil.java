/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Joshua Raiser
 */
public class BinUtil {
    
    public static String formatarBinario(String binarioAtual, int comprimento)
    {
        String zeros = "";
        for (int i = 0; i < comprimento - binarioAtual.length()-1; ++i) {
            zeros += "0";
        }
        return zeros + binarioAtual;
    }
    
}
