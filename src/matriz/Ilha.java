package matriz;

/*
 * @Author Lucas Lacerda
 * @Author Lucas Guasselli
 * @Author Amanda Silva Vieira
 * 
 * @since 15/04/2017
 * @version 2.0
 * 
 */

import java.util.ArrayList;

public class Ilha {
    private ArrayList<String> pontos;

    public Ilha() {
        this.pontos = new ArrayList<String>();
    }

    public ArrayList<String> getPontos() {
        return pontos;
    }
    
    public String toString(){
    	return ""+getPontos();
    }
    
}