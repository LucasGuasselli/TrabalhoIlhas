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
import java.util.Scanner;

public class Leitor {


public int[][] lerArquivo() {
			int x = 0;
			int y = 0;
			int[][] matriz;

	        int a;
	        int b;    
	        String linha;
	            
	        try {
	                Scanner arquivo = new Scanner(new File("src/files/example_0.txt"));  
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
	                        }
	                    }
	                }
	            arquivo.close();
	        }catch(Exception e){
	            System.out.println("ERRO!");
	            return null;
	        }//fecha-try-catch
	        return matriz;
	}
}