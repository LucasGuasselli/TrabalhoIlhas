package view;

import java.io.File;
import java.util.Scanner;

public class GerenciadorUI {

	private static int x,y = 0;
	static String posicao = "";
	static String [] arrayPosicoes = new String[100];
    static int quantPosicoesArmazenadas = 0;
    
	public static void main(String[] args) {
		
					
				//matrizes que recebem dados dos arquivos txt
				int[][] matriz1 = new int[11][11];
				int[][] matriz2 = new int[11][11];
				int[][] matriz3 = new int[11][11];
				
				//metodo de importacao dos dados
				lerArquivo(matriz1, matriz2 , matriz3);				
				verMatriz(matriz1);
				
				
	}//fecha main

	
	private static void lerArquivo(int[][] matriz1,int[][] matriz2,int[][]matriz3 ) {
		
		int a = 0;
		int b = 0;	
		String linha;
			
		try {
			Scanner arquivo = new Scanner(new File("src/arquivos/example_2.txt")); 
				x = arquivo.nextInt(); 
				y = arquivo.nextInt();
				linha = arquivo.nextLine();
			while (arquivo.hasNext()) {
				for (int i = 0; i < y; i++) {
					linha = arquivo.nextLine(); 
					a = 0;
					b = 1;
					for (int k = 0; k < x; k++) {
						int valor = Integer.parseInt(linha.substring(a, b));
							matriz1[i][k] = valor;
						if (valor == 1) {
							matriz2[i][k] = 2; 
						}//fecha if
						if (valor == 0) {
							matriz3[i][k] = 2; 
						}//fecha if
						a++;
						b++;
					}//fecha for
				}//fecha for
			}//fecha while
			arquivo.close();
		}catch(Exception e){
			System.out.println("ERRO!");
		}//fecha-try-catch
		
	}//fecha metodo
	
	public static void verMatriz(int[][] vetor) {
		for (int i = 0; i < y; i++) {
			for (int k = 0; k < x; k++) {				
				System.out.print("|" + vetor[i][k] + "|");
			}//fecha for
			System.out.print("\n");
		}//fecha for
	}//fecha verMatriz
	
}//fecha classe
