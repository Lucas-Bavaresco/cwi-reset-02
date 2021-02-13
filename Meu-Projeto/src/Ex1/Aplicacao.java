package Ex1;

public class Aplicacao {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double resultado = calculadora.somar(10,20);
        System.out.println("O resultado da soma é: "+resultado);

        resultado = calculadora.subtrair(100,100);
        System.out.println("O resultado da subtração é: "+resultado);

        resultado = calculadora.multiplicar(10d,10d);
        System.out.println("O resultado da multiplicacao é: "+resultado);

        resultado = calculadora.dividir(7,2);
        System.out.println("O resultado da divisao é: "+resultado);

    }
}
