package exceptionsRefactorCalculadora;

import exceptionsRefactorCalculadora.exceptions.DivisionByZeroException;
import exceptionsRefactorCalculadora.exceptions.InvalidNegativeValueException;

import java.util.InputMismatchException;

public class CalcController {
    private CalcModel model;
    private CalcView view;

    CalcController (CalcModel model, CalcView view){
        this.model = model;
        this.view = view;
    }

    //Inicia (Reinicia) a calculadora
    public void start(){
        view.ShowMenu(); //exibe o menu de operações
        this.ChooseAction(view.AskOperation());
    }

    //Determina a ação a ser feita dependendo da escolha do usuário
    protected void ChooseAction(String op){
        try {
            //Operações básicas
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                if (!view.isSaveResult()) {
                    model.BasicOp(op, view.BasicOpView("o primeiro valor"), view.BasicOpView("o segundo valor"));
                }
                else {
                    model.BasicOp(op, model.getInternalValue(), view.BasicOpView("o segundo valor"));
                }
            }
            //Potenciação
            else if (op.equals("^")) {
                if (!view.isSaveResult()) {
                    model.pow(view.BasicOpView("a base"), view.BasicOpView("o expoente"));
                }
                else {
                    model.pow(model.getInternalValue(), view.BasicOpView("o expoente"));
                }
            }
            //Radiciação
            else if (op.equals("~")) {
                if (!view.isSaveResult()) {
                    model.rad(view.BasicOpView("o radicando"), view.BasicOpView("o índice"));
                }
                else {
                    model.rad(model.getInternalValue(), view.BasicOpView("o índice"));
                }
            }
            //Fatorial
            else if (op.equals("!")) {
                if (!view.isSaveResult()) {
                    int n = (int) view.BasicOpView("""
                            o valor inteiro positivo
                            (valores decimais serão convertidos para inteiros
                            e perderão os valores após a vígula)"""); //converte o double para int
                    model.fatorial(n);
                }
                else {
                    int n = (int) model.getInternalValue(); //converte o double para int
                    model.fatorial(n);
                }
            }
            //Reexibição do menu incial
            else if (op.equals("M") || op.equals("m")) {
                this.start();
            }
            //Encerramento do programa
            else if (op.equals("S") || op.equals("s")) {
                this.end();
            } else {
                view.showErrorMesage("*OPERAÇÃO INVÁLIDA*\n" +
                        "------------------------");
                this.start();
            }
            view.ShowResult(model.getResult()); //exibe o resultado
            view.SaveResult(); //verifica se o resultado será usado novamente
            if (view.isSaveResult()) {
                model.setInternalValue(model.getResult()); //transfere o resultado atual para a variável interna
            }
        }catch (InputMismatchException | InvalidNegativeValueException | DivisionByZeroException e){ //Tratamento de exceções
            switch (e.getClass().toString()) {
                case "class java.util.InputMismatchException" -> view.showErrorMesage("*Entrada de teclado inválida*");
                case "class exceptionsRefactorCalculadora.exceptions.InvalidNegativeValueException" -> view.showErrorMesage("Valor inválido");
                case "class exceptionsRefactorCalculadora.exceptions.DivisionByZeroException" -> view.showErrorMesage("*Indefinido*");
            }

        }
        /*Código Original do catch acima:
        * catch (InputMismatchException|IllegalArgumentException|ArithmeticException e){ //Tratamento de exceções
            switch (e.getClass().toString()) {
                case "class java.util.InputMismatchException" -> System.out.println("*Entrada de teclado inválida*");
                case "class java.lang.IllegalArgumentException" -> System.out.println("Valor inválido");
                case "class java.lang.ArithmeticException" -> System.out.println("*Indefinido*");
            }
            view.setSaveResult(false);
            view.clearBuffer();
        }
        * */
        this.ChooseAction(view.AskOperation()); //looping de funcionamento
    }

    //Encerra o programa
    public void end(){
        System.out.println("Encerrando programa....");
        System.exit(0);
    }

}
