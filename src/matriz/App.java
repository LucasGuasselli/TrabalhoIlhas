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

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
 
public class App {
	
	private static ArrayList<String> visitados = new ArrayList<String>();
	private static ArrayList<Ilha> ilhas = new ArrayList<Ilha>();
    
	public static void main(String[] args){
		Leitor leitor = new Leitor();
		
		int[][] matriz; 
		
				
		
		
		matriz = leitor.lerArquivo();
		int x = matriz[1].length;
		int y = matriz.length;
			        
		percorreMatriz(matriz, x, y);
		System.out.println("Posição da(s) ilha(s): "+ilhas);
		System.out.println("Numero de ilhas encontradas: "+ilhas.size());

	}//MAIN

	private static void percorreMatriz(int[][] matriz, int x, int y) {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
					identificaIlha(null, matriz, i, j);
			}
		}
	}// PERCORRE MATRIZ

	private static void identificaIlha(Ilha ilha, int[][] matriz, int x, int y) {
		String ponto = ""+x+y;
		if(visitados.contains(ponto)){
			return;
		}
		if(x >= 0 && x < matriz.length && y >= 0 && y < matriz[x].length){
			System.out.println("["+y+", "+x+"]"+ " = "+matriz[x][y]);
			visitados.add(ponto);

			if(matriz[x][y] == 1){
				if(ilha == null){
					ilha = new Ilha();
					ilhas.add(ilha);
				}
				ilha.getPontos().add(ponto);
				
			identificaIlha(ilha, matriz, x+1, y); //Direita
			identificaIlha(ilha, matriz, x-1, y); //Esquerda
			identificaIlha(ilha, matriz, x, y+1); //Em baixo
			identificaIlha(ilha, matriz, x, y-1); //Em cima

			}     

		}
		 
	}// IDENTIFICA ILHAS
	
} 