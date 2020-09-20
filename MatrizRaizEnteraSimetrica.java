import java.util.ArrayList;
import java.util.Scanner;

public class MatrizRaizEnteraSimetrica {

	public static void main(String[] args) {

		
		int orden;
		int matriz[][];
		int contadorFilas;
		int mCuadrada[][];
		int mTraspuesta[][];
		boolean iguales;
			
		contadorFilas = 0;
		
		matriz = lectura();
		
		orden = matriz.length;
		
		
		mCuadrada = new int[orden][orden];
		
		mCuadrada = recorrerMatriz(matriz, contadorFilas, orden); 
		
			
		mTraspuesta = new int[orden][orden]; 
		
		mTraspuesta = calcularTraspuestaFil(contadorFilas, mCuadrada, orden, mTraspuesta);
		
		
		iguales = true; 
		
		iguales = compararMatricesFil(contadorFilas, orden, mCuadrada, mTraspuesta, iguales); 
		
		
		if(iguales == true) {
			
			System.out.println("La matriz de tamaño "+orden+" es de raíz entera simétrica.");
		
		}
		else
		{
			
			System.out.println("La matriz de tamaño "+orden+" es de raíz entera no simétrica.");
		
		}
		
		
		
	}
	
	private static int[][] lectura() {

		String cadena;
		int matriz[][];
		int orden;
		int contadorFilas;
		
		orden = 0;
		cadena= "";
		contadorFilas = 0;
		
		Scanner leerTeclado = new Scanner(System.in);
		
		cadena = leerTeclado.nextLine();
		
			try {
			
				orden = Integer.parseInt(cadena); 
			
			}catch(Exception errorTeclado) {
			
				System.out.println("Entrada Inválida.");
				System.exit(0);
		
			}
		
		
			if (orden <= 0) {
				
				System.out.println("Entrada Inválida.");
				System.exit(0);
			
			}
		
		matriz = new int [orden][orden];
	
		matriz = recorrerFilas(contadorFilas, matriz, leerTeclado);
			
			
			
		return matriz;
			
	}

	private static boolean compararMatricesFil(int contadorFilas, int orden, int[][] mCuadrada, int[][] mTraspuesta, boolean iguales) {
		
		int contadorCol;
		contadorCol = 0;
	
		
		
		if(contadorFilas == orden) {
			
			return iguales;
			
		}
		else
		{
			
			iguales = compararMatricesCol(mCuadrada, mTraspuesta, iguales, orden, contadorFilas, contadorCol);
			return compararMatricesFil(contadorFilas+1, orden, mCuadrada, mTraspuesta, iguales);
			
		}
		
	}

	private static boolean compararMatricesCol(int[][] mCuadrada, int[][] mTraspuesta, boolean iguales, int orden, int contadorFilas, int contadorCol) {
		
			if(contadorCol == orden) {
				
				return iguales;
				
			}
			else
			{
				if(mCuadrada[contadorFilas][contadorCol] != mTraspuesta[contadorFilas][contadorCol]) {
					
					iguales = false;
				}
				
				return compararMatricesCol(mCuadrada, mTraspuesta, iguales, orden, contadorFilas, contadorCol+1);
			}
	
	
	}

	private static int[][] calcularTraspuestaFil(int contadorFilas, int[][] mCuadrada, int orden, int[][] mTraspuesta) {
			
			int contadorColumnas;
			contadorColumnas = 0;
		
			if(contadorFilas == orden) {
				return mTraspuesta;
				
			}
			else
			{
				mTraspuesta = calcularTraspuestaCol(contadorFilas, contadorColumnas, orden, mCuadrada, mTraspuesta);
				return calcularTraspuestaFil(contadorFilas+1, mCuadrada, orden, mTraspuesta);
				
			}
		
		
	}

	private static int[][] calcularTraspuestaCol(int contadorFilas, int contadorColumnas, int orden, int[][] mCuadrada, int[][] mTraspuesta) {

			if(contadorColumnas == orden) {
				return mTraspuesta;
				
			}
			else
			{
				mTraspuesta[contadorFilas][contadorColumnas] = mCuadrada[contadorColumnas][contadorFilas];
				return calcularTraspuestaCol(contadorFilas, contadorColumnas+1, orden, mCuadrada, mTraspuesta);
			}
		
		
		
	}

	private static int[][] recorrerMatriz(int[][] mCuadrada, int contadorFilas, int orden) {
	
		int contadorColumnas;
		contadorColumnas = 0;
		
		if(contadorFilas == orden) {
			
			return mCuadrada;
			
		}
		else
		{
			
			mCuadrada = recorrerColumnas(mCuadrada, orden, contadorFilas, contadorColumnas);
			
			return recorrerMatriz(mCuadrada, contadorFilas+1, orden);
						
		}
		
		
	}

	private static int[][] recorrerColumnas(int[][] mCuadrada, int orden, int contadorFilas, int contadorColumnas) {
		
		int contador;
		int raizCuadrada;
		contador = 0;
		raizCuadrada = 0;
		
		if(contadorColumnas == orden) {
			return mCuadrada;		
			
		}
		else
		{
			raizCuadrada = hallarRaizCuadrada(mCuadrada, contadorFilas, contadorColumnas, contador); 
			
			
			
			mCuadrada[contadorFilas][contadorColumnas] = raizCuadrada;
			
			
			return recorrerColumnas(mCuadrada, orden, contadorFilas, contadorColumnas+1);
			
		}
	}

	private static int hallarRaizCuadrada(int[][] mCuadrada, int contadorFilas, int contadorColumnas, int contador) {

		if((contador*contador) == mCuadrada[contadorFilas][contadorColumnas]) { 
			
			return (contador);
			
		}
		else if((contador*contador) > mCuadrada[contadorFilas][contadorColumnas]) {
			
			return (contador-1);
		}
		else 
		{
			
			return hallarRaizCuadrada(mCuadrada, contadorFilas, contadorColumnas, contador+1);
			
		}
		
	
	}

	private static int[][] recorrerFilas(int contadorFilas, int[][] matriz, Scanner leerTeclado) {
		int contadorColumnas;
		int contadorVector;
		contadorColumnas = 0;
		contadorVector = 0;
		
		if(contadorFilas == matriz.length) {
		
			return matriz;
			
		}
		else
		{
			
			String cadena;
			String fila[];
			
			
			cadena = leerTeclado.nextLine();
			
			fila = cadena.split(" ");
			
			ArrayList<String> vectorLineaSinEspacio;
			vectorLineaSinEspacio = new ArrayList<String>();
			
			vectorLineaSinEspacio = quitaEspacios(vectorLineaSinEspacio, fila, contadorVector);
			
			
			if(vectorLineaSinEspacio.size() != matriz.length) { 
				
				System.out.println("Entrada Inválida."); 
				System.exit(0);
				
			}
			
			
			matriz = recorrerColumnas(contadorColumnas, contadorFilas, matriz, vectorLineaSinEspacio);
			return recorrerFilas(contadorFilas+1, matriz, leerTeclado);
		}
				
	}

	private static ArrayList<String> quitaEspacios(ArrayList<String> vectorLineaSinEspacio, String[] fila, int contadorVector) {
		
		if(contadorVector == fila.length) {
			return vectorLineaSinEspacio;
		}
		else 
		{
		
			if(fila[contadorVector].equals("")) {
				return quitaEspacios(vectorLineaSinEspacio,fila,contadorVector+1);
				
			}
			else
			{
				vectorLineaSinEspacio.add(fila[contadorVector]);
				return quitaEspacios(vectorLineaSinEspacio,fila,contadorVector+1);

			}
			
		}
		
	}

	private static int[][] recorrerColumnas(int contadorColumnas, int contadorFilas, int[][] matriz, ArrayList<String> vectorLineaSinEspacio) {

		if (contadorColumnas == matriz.length) {
			return matriz;
		}
		else
		{
			matriz = leerPosicion(matriz, contadorFilas, contadorColumnas, vectorLineaSinEspacio);
			
			return recorrerColumnas(contadorColumnas+1, contadorFilas, matriz, vectorLineaSinEspacio);
		}
		
		
	}

	private static int[][] leerPosicion(int[][] matriz, int contadorFilas, int contadorColumnas, ArrayList<String> vectorLineaSinEspacio) {
			
		
		try {
			
			matriz[contadorFilas][contadorColumnas] = Integer.parseInt(vectorLineaSinEspacio.get(contadorColumnas));
			
		}catch(Exception errorTeclado) {
			
			System.out.println("Entrada Inválida.");
			System.exit(0);
			
		}
		
		if(matriz[contadorFilas][contadorColumnas] < 0) {
			
			System.out.println("Entrada Inválida.");
			System.exit(0);
			
		}
		
		
		return matriz;
	}

}



