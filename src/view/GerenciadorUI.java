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
	
	public static void gerenciaIlhas(int[][] matriz){
	     int linha = 0;
	     int coluna = 0;
	            
	        if(matriz[x][y] == 1){
	            posicao = ""+x+y;
	            if(validaPosicao(matriz, posicao)){
	                identificaIlhas(matriz, x, y);
	            }
	        }         
	 }// GERENCIA ILHAS

	 
	 /*método que valida se o método já passou pela posicao atual de x e y.
	 Se não está gravada no arrayPosicoes, então o método identificaIlhas() pode ser executado*/
	static boolean validaPosicao(int[][] matriz, String posicao){        
	     for (int i = 0; i < arrayPosicoes.length; i++) {
	         if(arrayPosicoes[i].equals(posicao)){
	             return false;
	         }
	     }
	     return true;
	 } // VALIDAPOSICAO

	     public static void identificaIlhas(int[][] matriz, int colunaX, int linhaY){
	         int auxX = 0;
	         int auxY = 0;
	     
	     salvaPosicaoMatriz("X-"+colunaX + "Y-"+linhaY);
	     //verifica se a próxima coluna(x) à coluna atual é menor que o final da matriz
	     if(colunaX+1 < x){
	         
	         //verifica se a primeira posicao da matriz é 1
	         if((matriz[colunaX+1][linhaY] == 1)) {                
	             auxX = colunaX+1;
	             auxY = linhaY;
	             identificaIlhas(matriz, auxX, linhaY);
	             
	     }
	         if(matriz[colunaX][linhaY+1] == 1){
	             auxX = colunaX;
	             auxY = linhaY+1;
	             identificaIlhas(matriz, colunaX, auxY);
	         }    
	     }

	     else{
	         linhaY++;
	         colunaX = 0;
	         identificaIlhas(matriz, colunaX, linhaY);
	 }



	 }//IDENTIFICA ILHAS

	public static void salvaPosicaoMatriz(String posicao){
	     
	     arrayPosicoes[quantPosicoesArmazenadas] = posicao;
	     quantPosicoesArmazenadas++;
	}//fechar metodo

}//fecha classe
