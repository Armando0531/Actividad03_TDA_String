import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
1.Mostrar la cadena invertida por letra y por palabras.
2.Agregar/eliminar caracteres y/o subcadenas en posiciones especificas.
3.Mostrar cadena en formato CaMeL CaSe especial.
4.Mostar la cadena con la primer letra de cada palabra en mayúscula.
*/


class CadenaEspecial{
	Scanner entrada=new Scanner(System.in);
	private String cadena;

	public CadenaEspecial(String cadena) {
		this.cadena = cadena;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	public void mostrarCadenaInvertidaLetrasYPalabras() {
		System.out.println("Cadena invertida");
		for (int i=getCadena().length()-1; i >=0; i--) {
			System.out.print(getCadena().charAt(i));
		}
		System.out.println();
		String[] sep=getCadena().split(" ");
		System.out.println("Cadena invertida por palabra");
		for(int i=sep.length-1;i>=0;i--) {
			System.out.println(sep[i]);
		}
	}
	public void agregarEliminarCaracteresYSubcadenasPociEspecificas(String opcion){
		if(opcion.equalsIgnoreCase("A")) {
			System.out.println("Ingresa el caracter: ");
			String caracter=entrada.nextLine();
			setCadena(getCadena().replace(caracter,""));
			System.out.println(getCadena());
			
		}else if(opcion.equalsIgnoreCase("B")) {
			System.out.println("Ingresa la posicion: ");
			int po=0;
			boolean x=false;
			try {
			po=entrada.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("No ingresaste un valor numerico");
				x=true;
			}
			entrada.nextLine();
			System.out.println("Ingresa el caracter: ");
			String carac=entrada.nextLine();
			if(x==false) {
				String copi="";
				for(int i=0;i<getCadena().length();i++) {
					if(po-1==i) {
						copi=copi+carac;
					}else {
						copi=copi+getCadena().substring(i, i+1);
					}
					
				}
				setCadena(copi);
			}
			
		}else if(opcion.equalsIgnoreCase("C")) {
			System.out.println("Ingresa la posicion de la subcadena ejemplo (1-2):");
			String subcadEliminar=entrada.nextLine();
			String cadRes="";
			int poci=Integer.parseInt(subcadEliminar.split("-")[0]),poci2=Integer.parseInt(subcadEliminar.split("-")[1]);
			poci=poci-1;
			poci2=poci2-1;
			if((poci<getCadena().length() || poci2<getCadena().length())) {
				for(int i=0;i<getCadena().length();i++) {
					if(!(i>=poci && i<=poci2)) {
						cadRes=cadRes+getCadena().substring(i,i+1);
					}
				}
			}else {
				System.out.println("La subcadena no existe");
			}
			setCadena(cadRes);
			System.out.println("Subcadena eliminada");
			System.out.println(getCadena());
		}
	}
	
	public void mostrarCadenaCaMeLcAsE() {
		for(int i=0;i<cadena.length();i++) {
			if(i%2==0) {
				System.out.print(cadena.substring(i, i+1).toUpperCase());
			}else {
				System.out.print(cadena.substring(i, i+1).toLowerCase());
			}
		}
		System.out.println();
	}
	
	public void mostrarMayusculaCadaPalabra() {
		int num=0;
		for(int i=0;i<getCadena().length();i++) {
			if(getCadena().substring(i, i+1).equalsIgnoreCase(" ")) {
				num++;
			}
		}
		if(num>0) {
			String palabras[]=getCadena().split(" ");
			String cadNueva="";
			for(int i=0;i<palabras.length;i++) {
				for(int x=0;x<palabras[i].length();x++) {
					if(x==0) {
						cadNueva=cadNueva+palabras[i].substring(x, x+1).toUpperCase();
					}else {
						cadNueva=cadNueva+palabras[i].substring(x, x+1);
					}
				}
				cadNueva=cadNueva+" ";
			}
			setCadena(cadNueva);
		}else {
			String cad="";
			for(int i=0;i<getCadena().length();i++) {
				if(i==0) {
					cad=cad+getCadena().substring(i, i+1).toUpperCase();
				}else {
					cad=cad+getCadena().substring(i, i+1);
				}
			}
			setCadena(cad);
		}
		System.out.println(getCadena());
	}
	
}


public class PruebaCadenaEspecial {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingresa una cadena: ");
		byte opcion=0;
		String cad=entrada.nextLine();
		CadenaEspecial cade = new CadenaEspecial(cad);
		do {
			System.out.println("Selecciona una opcion");
			System.out.println("1-Mostrar la cadena invertida por letra y por palabras");
			System.out.println("2-Agregar/eliminar caracteres y/o subcadenas en posiciones especificas");
			System.out.println("3-Mostrar cadena en formato CaMeL CaSe especial");
			System.out.println("4-Mostar la cadena con la primer letra de cada palabra en mayúscula");
			System.out.println("5-Salir");
				try {
					opcion=entrada.nextByte();
				} catch (InputMismatchException e) {
					System.out.println("Debes de ingresar un numero");
					opcion=0;
				}
				entrada.nextLine();
			switch (opcion) {
			case 1:
				cade.mostrarCadenaInvertidaLetrasYPalabras();
				break;
			case 2:
				boolean x=true;
				String op1="";
				do {
					System.out.println("Elige una opcion: ");
					System.out.println("A) Eliminar caracter");
					System.out.println("B) Agregar caracter");
					System.out.println("C) Eliminar Subcadena");
					op1=entrada.nextLine().toUpperCase();
					switch (op1) {
					case "A":
						cade.agregarEliminarCaracteresYSubcadenasPociEspecificas(op1);
						break;
					case "B":
						cade.agregarEliminarCaracteresYSubcadenasPociEspecificas(op1);
						System.out.println(cade.getCadena());
						break;
					case "C":
						cade.agregarEliminarCaracteresYSubcadenasPociEspecificas(op1);
						break;
					default:
						System.out.println("Elige una opcion correcta");
						break;
					}	
					if(op1.equalsIgnoreCase("A") || op1.equalsIgnoreCase("B") || op1.equalsIgnoreCase("C")) {
						x=false;
						}
					}while(x==true);
				break;
			case 3:
				cade.mostrarCadenaCaMeLcAsE();
				break;
			case 4:
				cade.mostrarMayusculaCadaPalabra();
				break;
			case 5:
				System.out.println("Fin del programa");
				break;
			default:
				System.out.println("opcion no disponible");
				break;
			}
		}while(opcion!=5);

	}

}
