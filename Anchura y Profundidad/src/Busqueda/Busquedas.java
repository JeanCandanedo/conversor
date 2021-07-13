package Busqueda;
import java.util.ArrayList;
import java.util.Scanner;

public class Busquedas {
	
	public Busquedas() {}
	public static void main (String[] args) {
		Scanner Scan = new Scanner(System.in);
		
		int nodoi=0;
		int matriz[][] ={
					  {0, 1, 1, 0, 0, 0, 0},
					  {1, 0, 0, 1, 1, 0, 0},
					  {1, 0, 0, 0, 0, 1, 1},
					  {0, 1, 0, 0, 0, 0, 0},
					  {0, 1, 0, 0, 0, 0, 0},
					  {0, 0, 1, 0, 0, 0, 0},
					  {0, 0, 1, 0, 0, 0, 0},
					 
				  }; 
		
		
		boolean[] visitadoAnchura = new boolean[matriz.length];
		boolean[] visitadoProfundidad = new boolean[matriz.length];
		
		
		//Recorrido En Anchura
		ArrayList<Integer> recorridosA= new ArrayList<Integer>();
		visitadoAnchura[nodoi]=true;
		ArrayList<Integer> cola= new ArrayList<Integer>();
		recorridosA.add(nodoi);
		cola.add(nodoi);
		while(!cola.isEmpty()) {
			int j=cola.remove(0);
			for( int i=0; i < matriz.length; i++){
				if(matriz[j][i]== 1 && !visitadoAnchura[i]) {
					cola.add(i);
					recorridosA.add(i);
					visitadoAnchura[i]=true;
				}
			}
		}
		
		//Recorrido en Profundidad
		ArrayList<Integer> recorridosP= new ArrayList<Integer>();
		recorridosP=recorridoProfundo(nodoi, visitadoProfundidad, matriz );
		
		System.out.print("El Recorrido en Anchura es: ");
		for(int u=0;u<recorridosA.size();u++) {
			System.out.print(recorridosA.get(u).toString());
		}
		System.out.println("\n");
		System.out.print("El Recorrido en Profundidad es: ");
		for(int u=0;u<recorridosP.size();u++) {
			System.out.print(recorridosP.get(u).toString());
		}
		
		
	}
	
	public static ArrayList<Integer> recorridoProfundo(int nodo, boolean[] visitadoProfundidad, int matriz[][] ){
		ArrayList<Integer> recorridos= new ArrayList<Integer>();
		visitadoProfundidad[nodo]=true;
		ArrayList<Integer> cola2= new ArrayList<Integer>();
		recorridos.add(nodo);
		cola2.add(nodo);
		while(!cola2.isEmpty()) {
			int j=cola2.remove(0);
			for( int i=0; i < matriz.length; i++) {
				if(matriz[j][i]== 1 && !visitadoProfundidad[i]) {
					cola2.add(i);
					recorridos.addAll(recorridoProfundo(i, visitadoProfundidad, matriz)) ;
				}
			}
		}
		return recorridos;
	}
}


