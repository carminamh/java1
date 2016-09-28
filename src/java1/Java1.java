/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java1;

/**
 *
 * @author ainfo
 */


import java.util.Scanner;

public class Java1 {

    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        int [][] porra = new int [20][2];
        String [] nombre_apuesta = new String [20];
        int opcion, cont_apuestas = 0;
        String [] equipos = new String [2];
        
        do{
            opcion = Menu();
            
            switch(opcion)
            {
                case 1:
                    AltaEquipos(equipos);
                    break;
                case 2:
                    AltaApuesta(cont_apuestas,porra,nombre_apuesta,equipos);
                    cont_apuestas++;
                    break;
                case 3:
                    ListarTodasApuestas(cont_apuestas,porra,nombre_apuesta,equipos);
                    break;
                case 4:
                    BuscarApuestaUsuario(cont_apuestas,porra,nombre_apuesta,equipos);
                    break;
                case 5:
                    BuscarApuestaResultado(cont_apuestas,porra,nombre_apuesta,equipos);
                    break;
                case 6:
                    MostrarBote(cont_apuestas);
                    break;
                case 7:
                    ListarGanadores(cont_apuestas,porra,nombre_apuesta,equipos);
                    break;
                case 8:
                    cont_apuestas = ResetearPrograma(cont_apuestas);
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
            }
        }while(opcion != 0);
        
        
    }
    
    public static int Menu(){
        
        int op;
        
        System.out.println(" - - - M E N U - - - - ");
        System.out.println(" 1. Definir equipos");
        System.out.println(" 2. Anyadir porra");
        System.out.println(" 3. Listar todas las apuestas");
        System.out.println(" 4. Listar apuestas por usuario");
        System.out.println(" 5. Listar apustas por resultado");
        System.out.println(" 6. Mostrar bote total de la apuesta");
        System.out.println(" 7. Listar ganadores/es");
        System.out.println(" 8. Resetear. Empezar nueva porra");
        System.out.println(" 0. Salir");
        
        op = teclado.nextInt();
        
        return op;
        
    }
    
    public static void AltaEquipos(String [] equipos){
        
        teclado.nextLine();
        System.out.println("Dame el nombre del equipo local");
        equipos[0] = teclado.nextLine();
        System.out.println("Dame el nombre del equipo visitante");
        equipos[1] = teclado.nextLine();
    }
    
    public static void AltaApuesta(int cont_apuestas, int[][]porra, String[] nombre_apuesta, String[]equipos){
                
        System.out.println("¿Cuánto crees que van a quedar?");
        System.out.println(equipos[0]+" - "+equipos[1]);
        System.out.println("Marcador para "+equipos[0]);
        porra[cont_apuestas][0] = teclado.nextInt();
        System.out.println("Marcador para "+equipos[1]);
        porra[cont_apuestas][1] = teclado.nextInt();
        teclado.nextLine();
        System.out.println("A nombre de quién quieres poner la apuesta?");
        nombre_apuesta[cont_apuestas] = teclado.nextLine();
    }
    
    public static void ListarTodasApuestas(int cont_apuestas, int[][]porra, String[] nombre_apuesta, String[]equipos){
        
        int i;
        
        System.out.println("- - - Listado de apuestas - - -");
        System.out.println("Nombre - \t "+equipos[0]+" - "+equipos[1]);
        for(i=0;i<cont_apuestas;i++)
        {
            System.out.println(nombre_apuesta[i]+" - \t "+porra[i][0]+" - \t"+porra[i][1]);
        }
    }
    
    public static void BuscarApuestaUsuario(int cont_apuestas, int[][]porra, String[] nombre_apuesta, String[]equipos){
        
        boolean encontrado = false;
        int i;
        String busqueda;
        
        teclado.nextLine();
        System.out.println("Dime el nombre para buscar la apuesta");
        busqueda = teclado.nextLine();
        for(i=0;i<cont_apuestas;i++)
        {
            if(busqueda.compareTo(nombre_apuesta[i]) == 0)
            {
                System.out.println(" Nombre \t "+equipos[0]+" - "+equipos[1]);
                System.out.println(nombre_apuesta[i]+" - \t "+porra[i][0]+" - "+porra[i][1]);
                encontrado = true;
            }
        }
        if(!encontrado)
            System.out.println("El nombre introducido no tiene ninguna apuesta realizada");
    }
    
    public static void BuscarApuestaResultado(int cont_apuestas, int[][]porra, String[] nombre_apuesta, String[]equipos){
        
        int i, local, visitante;
        boolean encontrado = false;
        
        System.out.println("Dime el resultado por el que quieres hacer la búsqueda");
        System.out.print("Puntuación local: ");
        local = teclado.nextInt();
        System.out.print("Puntuación visitante: ");
        visitante = teclado.nextInt();
        for(i=0;i<cont_apuestas;i++)
        {
            if(porra[i][0] == local)
            {
                if(porra[i][1] == visitante)
                {
                    System.out.println(nombre_apuesta[i]+" ha apostado a "+equipos[0]+": "+porra[i][0]+" - "+equipos[1]+": "+porra[i][1]);
                    encontrado = true;
                }
            }
        }
        if(!encontrado)
            System.out.println("No se ha encontrado ningún resultado");
    }
    
    public static void MostrarBote(int cont_apuestas){
        
        int bote;
        
        bote = cont_apuestas*2;
        System.out.println("El bote total de la porra es de "+bote+" euros");
    }
    
    public static void ListarGanadores(int cont_apuestas, int[][]porra, String[] nombre_apuesta, String[]equipos){
        
        int i, local, visitante;
        boolean encontrado = false;
        
        System.out.println("Vamos a comprobar a los ganadores de la porra: ");
        System.out.println("Dime cuánto ha quedado el "+equipos[0]+": ");
        local = teclado.nextInt();
        System.out.println("Ahora el resultado del "+equipos[1]+":");
        visitante = teclado.nextInt();
        System.out.println(" - - - G A N A D O R E S - - - ");
        for(i=0;i<cont_apuestas;i++)
        {
            if(porra[i][0] == local)
            {
                if(porra[i][1] == visitante)
                {
                    System.out.println(i+". "+nombre_apuesta[i]);
                    encontrado = true;
                }
            }
        }
        if(!encontrado)
            System.out.println("No ha habido un ganador");
    }
    
    public static int ResetearPrograma(int cont_apuestas){
        
        System.out.println("Reseteando la porra...");
        cont_apuestas = 0;
        
        return cont_apuestas;
    }
}
