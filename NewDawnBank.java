package polimorfismo.Proyecto_NewDawnBank;

import java.util.Scanner;

public class NewDawnBank {
    public static void main(String[] args) {
        
        // CREAMOS UN OBJETO
        CuentaBancaria cuenta = new CuentaBancaria("ES6621000418401234567891","Juan Tur García");
        
        boolean condicion = true;
        while(condicion){

            // MENU VISUAL
            System.out.println("1. Datos de la cuenta");
            System.out.println("2. IBAN");
            System.out.println("3. Titular");
            System.out.println("4. Saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.println();

            // SCANNER
            Scanner s = new Scanner(System.in);
            System.out.print("Dime una opción: ");
            Integer opcion = s.nextInt();

            if (opcion == 1){
                System.out.println("IBAN: "+ cuenta.getIban());
                System.out.println("Titular: "+ cuenta.getTitular());
                System.out.println("Saldo: "+ cuenta.getSaldo());
                System.out.println();
            } 

            if (opcion == 2){
                System.out.println("IBAN: "+cuenta.getIban());
                System.out.println();
            }

            if (opcion == 3){
                System.out.println("Titular: "+ cuenta.getTitular());
                System.out.println();
            }

            if (opcion == 4){
                System.out.println("Saldo: "+ cuenta.getSaldo());
                System.out.println();
            }

            if (opcion == 5){
                System.out.print("Cuanto dinero quieres ingresar a la cuenta: ");
                Double dinero = s.nextDouble();
                cuenta.ingreso(dinero);
                System.out.println();
            }

            if (opcion == 6){
                System.out.print("Cuanto dinero quieres retirar de la cuenta: ");
                Double dinero = s.nextDouble();
                cuenta.retirada(dinero);
                System.out.println();
            }

            if (opcion == 7){
                System.out.print("Estos son los movimientos de la cuenta: ");
                cuenta.mostrarMovimientos();
                System.out.println();
            }

            if (opcion == 8){
                condicion = false;
                s.close();
            }
        }
    }
}