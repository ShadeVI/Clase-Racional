package clases;


import java.security.InvalidParameterException;

public class Racional {
    private int Numerador, Denominador;

    public Racional(int numerador, int denominador) throws InvalidParameterException {
        if(denominador == 0) throw new InvalidParameterException("Denominador no puede ser 0");
        if(numerador == 0) {
            Numerador = 0;
            Denominador = 0;
        } else {
            Numerador = numerador;
            Denominador = denominador;
        }
    }

    public int getNumerador() {
        return Numerador;
    }

    public void setNumerador(int numerador) {
        Numerador = numerador;
    }

    public int getDenominador() {
        return Denominador;
    }

    public void setDenominador(int denominador) {
        Denominador = denominador;
    }

    public static String Mostrar_Racional(Racional r){
        return r.toString();
    }

    @Override
    public String toString(){
        if(Numerador == 0){
            return "0";
        }
        if (Denominador == 1) {
            return String.valueOf(Numerador);
        }
        return Numerador + "/" + Denominador;
    }
}
