import clases.Racional;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num, den;


        try{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Numerador: ");
            num = scanner.nextInt();
            System.out.print("Denominador: ");
            den = scanner.nextInt();

            Racional  r1 = Crear_Racional(num, den);
            System.out.println(r1);

            System.out.print("Numerador: ");
            num = scanner.nextInt();
            System.out.print("Denominador: ");
            den = scanner.nextInt();

            Racional  r2 = Crear_Racional(num, den);
            System.out.println(r2);
            System.out.println();

            /* MENU DE ACCIONES => OPERACIONES */

            Racional r1r2Suma = Sumar_Racional(r1, r2);
            System.out.format("%s + %s = %s\n", r1, r2, r1r2Suma);

            Racional r1r2Resta = Restar_Racional(r1, r2);
            System.out.format("%s - %s = %s\n", r1, r2, r1r2Resta);

            Racional r1r2Multiplica = Multiplicar_Racional(r1, r2);
            System.out.format("%s x %s = %s\n", r1, r2, r1r2Multiplica);

            Racional r1r2Dividir = Dividir_Racional(r1, r2);
            System.out.format("%s : %s = %s\n", r1, r2, r1r2Dividir);

        } catch (InvalidParameterException e){
            System.out.println(e.getMessage());
        }
    }

    public static Racional Crear_Racional(int num, int den) {
        return new Racional(num, den);
    }

    public static Racional Sumar_Racional(Racional r1, Racional r2){
        int numLocal = (r1.getNumerador()*r2.getDenominador() + r2.getNumerador()*r1.getDenominador());
        int denLocal = (r1.getDenominador() * r2.getDenominador());
        int mcd = mcd(numLocal, denLocal);
        return new Racional(numLocal/mcd, denLocal/mcd);
    }

    public static Racional Restar_Racional(Racional r1, Racional r2) {
        int numLocal = (r1.getNumerador()*r2.getDenominador() - r2.getNumerador()*r1.getDenominador());
        int denLocal = (r1.getDenominador() * r2.getDenominador());
        int mcd = mcd(numLocal, denLocal);
        return new Racional(numLocal/mcd, denLocal/mcd);
    }

    public static Racional Multiplicar_Racional(Racional r1, Racional r2) {
        int mcdNumR1DenR2 = mcd(r1.getNumerador(), r2.getDenominador());
        int mcdNumR2DenR1 = mcd(r2.getNumerador(), r1.getDenominador());
        int numLocal = (r1.getNumerador()/mcdNumR1DenR2) * (r2.getNumerador()/mcdNumR2DenR1);
        int denLocal = (r1.getDenominador()/mcdNumR2DenR1) * (r2.getDenominador()/mcdNumR1DenR2);
        int mcd = mcd(numLocal, denLocal);
        return new Racional(numLocal/mcd, denLocal/mcd);
    }

    public static Racional Dividir_Racional(Racional r1, Racional r2) {
        Racional invertidoR2 = new Racional(r2.getDenominador(), r2.getNumerador());
        return Multiplicar_Racional(r1, invertidoR2);
    }

    public static int mcd(int n, int m){
        if(n < m){
            int aux = n;
            n = m;
            m = aux;
        }
        int res = 1;
        for(int i=2; i <= n && i <= m; i++){
            if(n%i == 0 && m%i == 0){
                res = i;
            }
        }
        return res;
    }
}