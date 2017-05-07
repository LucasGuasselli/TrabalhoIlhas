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

public class Matriz {
	
	private int matriz[][];
	private int eixoX;
	private int eixoY;
	
	public Matriz(int eixoX, int eixoY){
		this.eixoX = eixoX;
		this.eixoY = eixoY;
		this.matriz = new int[eixoX][eixoY];
	}
	
	public int getElement(int x, int y){
		return this.matriz[x][y];
	}
	
	public int getEixoX(){
		return this.eixoX;
	}
	public void setEixoX(int x){
		this.eixoX = x;
	}
	public int getEixoY(){
		return this.eixoY;
	}
	public void setEixoY(int y) {
		this.eixoY = y;
	}
	
	public void setElement(int x, int y, int element){
		 this.matriz[x][y] = element;
	}
	
	public int getUmNumero(){
			int n = 0;
			for(int i = 0; i < this.getEixoX(); i++){
				for(int j = 0; j < this.getEixoY(); j++){
					System.out.println(j);
					if(this.getElement(i, j) == 1){
						n++;
					}
				}
			}
			return n;
		}
		
	
	/*
	 * 
[o,1; 1,1; 2,0]
0,0, 0,2, 1,1
2,1, ,3,0
ilha1 = [0,0, 1,1]
ilha2 = [2,0]
vetoDeUm = [0,1; 1,1; 2,0]
0,2, 1,1 - esses caras estao mapeados no array?
se sim, em qual lugar?
ilha1 = int [2]
ilha1[0] = vetorDeUm[0]
ilha1[1] = vetorDeUm[?]
vetorDeum = [null, null, 2,0]
for(int i = 0; i < vetorDeUm.length; i++){
	
}
 
	 */
	

} 