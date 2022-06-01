package exceptionsRefactorCalculadora;

/**
 * As classes Calculadora.Main, Calculadora.CalcController,
 * Calculadora.CalcView e Calculadora.CalcModel implementam uma
 * calculadora simples que executa as operações de soma, subtração,
 * multiplicação, divisão, potenciação, radiciação e cálculo de fatorial
 * via console.
 *
 * Esta implementação é baseada no padrão de projeto MVC
 * produzido para a disciplina de Engenharia de Software 3 (ES3A3)
 * e modificado para a disciplina de Linguagem de Programação 3 (LP3A5)
 * do curso superior Tecnólogo em Análise e Desenvolvimento de Sistemas (TADS)
 * do Instituto Federal de Educação Ciência e Tecnologia de São Paulo,
 * Campus São Paulo (IFSP).
 *
 * @author Bruna Pires
 */

public class Main {
    /* Cria os objetos de visão (view), modelo (model),
     * controle (controller) e inicia o programa.
     */
    public static void main(String[] args){
        //Instâncias de View, Model e Controller
        CalcView view = new CalcView();
        CalcModel model = new CalcModel();
        CalcController controller = new CalcController(model, view);

        //Inicia o programa
        controller.start();

    }
}
