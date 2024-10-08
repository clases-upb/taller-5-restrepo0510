/*
 * This source file was generated by the Gradle 'init' task
 */
package taller5;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class App {
    
    public static void main(String[] args) {
        
        try {
            
        } 
        
        catch (Exception e) {
            // TODO: handle exception
        }
    }


    /*
    
        1.	Desarrolle un algoritmo e impleméntelo en Java que: le pida al usuario un número entero positivo 
        entre 1000 y 9999. En un ciclo genere números de manera aleatoria y cuente los intentos que hizo antes 
        de hallar el número exactamente.
        
    
    */ 
 public static int try_numbers(int nro) {
        try {
            int tries = 0;
            int aleatory_n;
            int nro_min = 1000;
            int nro_max = 9999;

            if (nro < nro_min || nro > nro_max) {
                return -1;
            }

            Random random = new Random();

            do {
                aleatory_n = nro_min + random.nextInt(nro_max - nro_min + 1);
                tries++;
            } while (aleatory_n != nro);

            System.out.println("El número de intentos fue: " + tries);
            return tries;

        } catch (Exception e) {
            return -1;
        }
    }



    /* 
     
        2.	Se requiere una función en java que simule las ventas de tres años para un almacén. Para cada año, deberá generar 
        un aleatorio para cada mes hasta completar los 12 meses. La función se llamará Simular_ventas, y debe retornar un String 
        al final que muestre las ventas de cada año, así:
        
            Año 1
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###
            Total ventas Año 1:  $##.###.###
            
            Año 2
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###
            Total ventas Año 2: $##.###.###
            
            Año 3
            Ventas Mes 1: $##.###.###
            :
            Ventas Mes 12: $##.###.###

            Total ventas Año 3: $##.###.###
            
            Investigue sobre la clase DecimalFormat para mostrar bien la salida. 
            import java.text.DecimalFormat;
            DecimalFormat form_pesos = new DecimalFormat("$#,###.00");

        
      
    */

    public static String Simular_ventas() {
        try {
            DecimalFormat form_pesos = new DecimalFormat("$##,###,###");
            Random random = new Random();
            String resultado = "";
            int month_min = 1;
            int month_max = 12;

            for (int year = 1; year <= 3; year++) {
                double total_ventas_year = 0;
                resultado += "Año " + year + "\n";

                for (int month = month_min; month <= month_max; month++) {
                    double v_month = 1000000 + random.nextDouble() * 9000000;
                    total_ventas_year += v_month;
                    resultado += "Ventas Mes " + month + ": " + form_pesos.format(v_month) + "\n";
                }

                resultado += "Total ventas Año " + year + ": " + form_pesos.format(total_ventas_year) + "\n\n";
            }
            return resultado;

        } catch (Exception e) {
            return "error";
        }
    }




    /*  
     
        3.	En una fábrica se tiene el siguiente patrón de empaque: En una estiba(o pallet) caben 16  cajas y en cada caja, 
        caben 30 bombillas. Desarrolle una función que se llame: Calcular_empaque que: reciba como argumento la cantidad de 
        bombillas que se deben empacar y a partir de allí: calcule cuántas cajas necesita, cuántas estibas o pallets necesita. 
        Luego escriba lo siguiente: 

        Para ### bombillas, se necesitan ## cajas y ## pallets. Se quedan ### bombillas sin empacar. Se empacará así:

        Pallet 1 --> Caja1, Caja2……,Caja16
        Pallet2 -->  Caja17, Caja18…..Caja 32
        .
        Pallet n -- > Caja m, caja m+1…..
        
        La función retornará un texto, con la información anterior. Pruebe la función llamándola desde el programa principal: solicite al usuario el número de bombillas e invoque la función para imprimir en el main, los resultados.



    */
public static String Calcular_empaque(int c_bombillos) {
        try {
            int bombillas_caja = 30;
            int cajas_pallet = 16;

            int boxes_necesarias = c_bombillos / bombillas_caja;
            int restantes = c_bombillos % bombillas_caja;
            int pallets_necesarios = boxes_necesarias / cajas_pallet;
            int cajasRestantes = boxes_necesarias % cajas_pallet;

            if (cajasRestantes > 0) {
                pallets_necesarios++;
            }

            String resultado = "Para " + c_bombillos + " bombillos, se necesitan " + boxes_necesarias + " cajas y "
                    + pallets_necesarios + " pallets.\n";
            resultado += restantes + " bombillos restantes.\n";
            resultado += "orden:\n";

            int contadorCajas = 1;
            for (int box = 1; box <= pallets_necesarios; box++) {
                resultado += "Pallet " + box + " --> ";
                for (int j = 1; j <= cajas_pallet && contadorCajas <= boxes_necesarias; j++) {
                    resultado += "Caja" + contadorCajas;
                    if (j < cajas_pallet && contadorCajas < boxes_necesarias) {
                        resultado += ", ";
                    }
                    contadorCajas++;
                }
                resultado += "\n";
            }

            return resultado;

        } catch (Exception e) {
            return "error";
        }
    }


    

    /* 
    

        4.	En un juego, cada jugador tiene 3 intentos para sacar cartas de una baraja. Las cartas van numeradas entre 1 y 10. 
        Una función Jugar_21, deberá simular el juego para una cantidad de usuarios que enviará el usuario desde el main entre 1 y 6.

        Para cada uno de los jugadores, el programa le calculará 3 cartas al azar y al final imprimirá el juego para cada jugador basado en las siguientes reglas: 
        
        Si saca 21 exactos: juego perfecto
        Si saca más de 21: se pasó
        Si saca menos de 21: faltaron puntos

        La función deberá imprimir los puntos de cada jugador junto con la regla anterior, como muestra el ejemplo:

        Jugador X, puntos 21 -- > juego perfecto
        Jugador Y, puntos 26 -- > se pasó
        .
        .


    */
public static String Jugar_21(int players) {
        try {
            StringBuilder resultado = new StringBuilder();

            int carta_min = 1;
            int carta_max = 10;
            if (players < 1 || players > 6) {
                return "error";
            }

            Random random = new Random();

            for (int cart = 1; cart <= players; cart++) {
                int carta1 = random.nextInt(carta_max - carta_min + 1) + carta_min;
                int carta2 = random.nextInt(carta_max - carta_min + 1) + carta_min;
                int carta3 = random.nextInt(carta_max - carta_min + 1) + carta_min;

                int puntos = carta1 + carta2 + carta3;
                resultado.append("Jugador ").append(cart).append(", puntos ").append(puntos).append(" --> ");

                if (puntos == 21) {
                    resultado.append("juego perfecto\n");
                } else if (puntos > 21) {
                    resultado.append("se pasó\n");
                } else {
                    resultado.append("faltaron puntos\n");
                }
            }

            return resultado.toString();

        } catch (Exception e) {
            return "error";
        }
    }


}
