package polimorfismo.Proyecto_NewDawnBank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CuentaBancaria {
    private String iban;
    private String titular;
    private Double  saldo  = 0.0;
    private String[] movimientos = new String[100];
    private Integer cont = 0;
    
    // Constructor
    CuentaBancaria(String iban, String titular){
        this.iban = iban; 
        this.titular = titular;
    }

    // Getters y Setters 
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String[] movimientos) {
        this.movimientos = movimientos;
    }

    // METODOS

    // Ingresar 
    public void ingreso(Double dinero){
        if (0 < dinero){
            this.saldo += dinero;
            this.movimientos[this.cont] = "+"+dinero;
            cont++;
        }
        if (dinero > 3000){
            System.out.println("AVISO: Notificar a hacienda");
        }
    }

    // Retirar
    public void retirada(Double dinero){
        if ((saldo - dinero) <= -50){
            this.movimientos[this.cont] = "-"+ dinero;
            saldo = -50.0;
        }
        if (0 < dinero && saldo != -50){
            this.saldo -= dinero;
            this.movimientos[this.cont] = "-"+dinero;
            cont++;
        }
        if (saldo < 0){
            System.out.println("AVISO: Saldo negativo");
            System.out.println();
        }
    }

    // Validar que el iban sea correcto
    public boolean validarIban(){
        String regex = "^[A-Z]{2}\\d{22}$";
        Pattern patron = Pattern.compile(regex);
        Matcher matcher = patron.matcher(iban);
        return matcher.find();
    }

    // Mostrar movimientos
    public void mostrarMovimientos(){
        for (int i = 0; i < cont; i++){
            System.out.print(getMovimientos()[i]+ ", ");
        }
        System.out.println();
    }

    // MOSTRAR DATOS CUENTA
    public void datosCuenta(){
        
    }   
}