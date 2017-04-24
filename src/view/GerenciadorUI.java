package view;


/*
 * @Author Lucas Lacerda
 * @Author Lucas Guasselli
 * @Author AmandaSilva Vieira
 * 
 * @since 15/04/2017
 * @version 2.0
 * 
 */

import java.io.File;
import java.util.Scanner;
 
public class GerenciadorUI {
 
    private static int x,y = 0;
    static int quantPosicoesArmazenadas = 0;
    static String [] arrayPosicoes = new String[30];
    static String posicao = "";
    static int[][] matriz;
    static int quantIlhas;
 
     
    public static void main(String[] args) {
        
                                    
                //metodo de importacao dos dados
        lerArquivo();                
        verMatriz(matriz);
                
        gerenciaIlhas(matriz);
                                
    }//fecha main
    
    static public int[][] lerArquivo() {
        
        int a;
        int b;    
        String linha;
            
        try {
                Scanner arquivo = new Scanner(new File("src/arquivos/example_1.txt"));  
                x = arquivo.nextInt();  
                y = arquivo.nextInt();
                matriz = new int[x][y];
                linha = arquivo.nextLine();
                while (arquivo.hasNext()) {
                    for (int i = 0; i < y; i++) {
                        linha = arquivo.nextLine();  
                        a = 0;
                        b = 1;
                        for (int k = 0; k < x; k++) {
                            int valor = Integer.parseInt(linha.substring(a, b));
                                matriz[i][k] = valor;
                                a++;
                                b++;
                        }//fecha for
                    }//fecha for
                }//fecha while
            arquivo.close();
        }catch(Exception e){
            System.out.println("ERRO!");
            return null;
        }//fecha-try-catch
        return matriz;
        
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
          
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {    
                        
                if(matriz[i][k] == 1){
                    posicao = ""+k+i;
                    k++;
                    if(validaPosicao(posicao)){
                       identificaIlhas(k, i);
                        
                    }
            
                }
                         
            }
            
        }
                          
     }// GERENCIA ILHAS
 
      
     /*método que valida se o método já passou pela posicao atual de x e y.
     Se não está gravada no arrayPosicoes, então o método identificaIlhas() pode ser executado*/
    
    static boolean validaPosicao(String posicao){         
         for (int i = 0; i < arrayPosicoes.length; i++) {
             if(arrayPosicoes[i].equals(posicao)){
                 return false;
             }
         }
         return true;
     } // VALIDAPOSICAO
 
    public static void identificaIlhas(int colunaX, int linhaY){
        int auxX = 0;
        int auxY = 0;
          
         salvaPosicaoMatriz(""+colunaX+linhaY);
         //verifica se a próxima coluna(x) à coluna atual é menor que o final da matriz
         if(colunaX+1 < x){
              
             //verifica se a primeira posicao da matriz é 1
             if((matriz[colunaX+1][linhaY] == 1)) {                 
                 auxX = colunaX+1;
                 auxY = linhaY;
                 identificaIlhas(auxX, auxY);
                  
             }
             if(matriz[colunaX-1][linhaY] ==1){
                 auxX = colunaX-1;
                 auxY = linhaY;
                 identificaIlhas(auxX, auxY);
             }
             if(matriz[colunaX][linhaY+1] == 1){
                 auxX = colunaX;
                 auxY = linhaY+1;
                 identificaIlhas(colunaX, auxY);
             }
             if(matriz[colunaX][linhaY-1] == 1){
                 auxX = colunaX;
                 auxY = linhaY-1;
                 identificaIlhas(auxX, auxY);
             }
         }
 
         else{
             colunaX = 0;
             linhaY++;
             identificaIlhas(colunaX, linhaY);
         }
 
 
 
     }//IDENTIFICA ILHAS
 
    public static void salvaPosicaoMatriz(String posicao){
          
         arrayPosicoes[quantPosicoesArmazenadas] = posicao;
         quantPosicoesArmazenadas++;
    }//fechar metodo
}//fecha classe

