package exceptionsRefactorCalculadora;

import exceptionsRefactorCalculadora.exceptions.DivisionByZeroException;
import exceptionsRefactorCalculadora.exceptions.InvalidNegativeValueException;

public class CalcModel {
    double internalValue;
    double result;

    public void setInternalValue(double internalValue) {
        this.internalValue = internalValue;
    }

    public double getInternalValue() {
        return internalValue;
    }

    public void setResult(double result) { this.result = result; }

    public double getResult() {
        return result;
    }

    public void BasicOp(String op, double a, double b) throws DivisionByZeroException{
        switch (op) {
            case "+" -> this.plus(a, b);
            case "-" -> this.minus(a, b);
            case "*" -> this.multiply(a, b);
            case "/" -> this.division(a, b);
            //default -> this.result = 0.0;
        }
    }

    //Operações Básicas
    //Soma
    private void plus (double a, double b){
        this.setResult(a + b);
    }

    //Subtração
    private void minus (double a, double b){
        this.setResult(a - b);
    }

    //Multiplicação
    private void multiply (double a, double b){
        this.setResult(a * b);
    }

    //Divisão
    private void division (double a, double b) throws DivisionByZeroException{
        if(b==0){
            throw new DivisionByZeroException();//Caso de divisão por zero
        }
        else{
            this.setResult(a / b);
        }
    }

    //Operações extras
    //Exponenciação
    public void pow (double a, double b){
        this.setResult(Math.pow(a,b));
    }

    //Radiciação
    public void rad (double a, double b) throws InvalidNegativeValueException{
        if(a < 0 && (b%2)==0){ //radicando negativo e índice par
            throw new InvalidNegativeValueException();
        }
        else if (a < 0 && (b%2)!=0){ //radicando negativo e índice ímpar
            a = a*(-1);
            this.setResult(Math.pow(a,(1/b)) * (-1));
        }
        else{ //radicando e índice positivos
            this.setResult(Math.pow(a,(1/b)));
        }

    }
    //Fatorial - apenas números naturais (0,1,2,...,n,...)
    public void fatorial(int a) throws InvalidNegativeValueException{
        int fatorial = a;
        if(a == 0 || a==1){
            this.setResult(1);
        }
        else if(a == 2){
            this.setResult(2);
        }
        else{
            if(a < 0){
                throw new InvalidNegativeValueException();
            }
            else{
                while(a!=2){
                    fatorial = fatorial*(a-1);
                    a--;
                }
                this.setResult(fatorial);
            }
        }
    }
}
