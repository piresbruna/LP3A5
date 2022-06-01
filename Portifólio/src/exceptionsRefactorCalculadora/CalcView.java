package exceptionsRefactorCalculadora;

import java.util.Scanner;

public class CalcView {
    String operation;
    boolean saveResult = false;
    Scanner scanner = new Scanner(System.in);

    public void ShowMenu(){
        System.out.print("""
                --CALCULADORA MVC JAVA--
                ------------------------
                >>Use os seguintes símbolos para indicar a operação:
                [+] Adição
                [-] Subtração
                [*] Multiplicação
                [/] Divisão
                [^] Exponenciação
                [~] Radiciação
                [!] Fatorial
                [M] Reapresenta este menu
                [S] Encerra o programa
                """);
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setSaveResult(boolean saveResult) {
        this.saveResult = saveResult;
    }

    public boolean isSaveResult() {
        return saveResult;
    }

    public String AskOperation(){ //requisição da operação
        System.out.print("""
                ------------------------
                >>Informe a operação:
                >>\s""");
        this.setOperation(scanner.next());
        return this.getOperation();
    }

    public double BasicOpView(String valor){ //requisição básica para todas as operações
        System.out.print(">>Informe " + valor + ":\n" +
                ">> ");
        return (scanner.nextDouble());
    }

    public void ShowResult(double r){ //exibição do resultado
        System.out.println(">>Resultado:\n" +
                ">>" + r + "<<");
    }

    public void SaveResult (){ //verificação de reaproveitamento de resultado
        System.out.print("""
                ------------------------
                >>Deseja realizar nova operação com o resultado ou descartá-lo?
                >>[R] Reaproveitar\t|\t[D] Descartar
                >>\s""");
        String disposal = scanner.next();
        if(disposal.equalsIgnoreCase("R")){
            this.setSaveResult(true);
        }
        else if(disposal.equalsIgnoreCase("D")){
            this.setSaveResult(false);
        }
        else{
            showErrorMesage("*Entrada de teclado inválida*");
        }
    }

    public void showErrorMesage(String msg){
        System.out.println(msg);
        this.setSaveResult(false);
        this.clearBuffer();
    }

    public void clearBuffer(){ //limpeza do buffer do scanner
        if (this.scanner.hasNextLine()) {
            this.scanner.nextLine();
        }
    }
}
