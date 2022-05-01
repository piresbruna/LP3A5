package br.edu.ifsp.lp3a5.aula1;

public class Disciplina {
	final public static int QTDAULAS = 20;
	private int qtdPresencas;
	private double notaProva;
	private double notaTrabalho;
	private double notaExercicios;
	
	public static int getQtdaulas() {
		return QTDAULAS;
	}
	public int getQtdPresencas() {
		return qtdPresencas;
	}
	public void setQtdPresencas(int qtdPresencas) {
		this.qtdPresencas = qtdPresencas;
	}
	public double getNotaProva() {
		return notaProva;
	}
	public void setNotaProva(double notaProva) {
		this.notaProva = notaProva;
	}
	public double getNotaTrabalho() {
		return notaTrabalho;
	}
	public void setNotaTrabalho(double notaTrabalho) {
		this.notaTrabalho = notaTrabalho;
	}
	public double getNotaExercicios() {
		return notaExercicios;
	}
	public void setNotaExercicios(double notaExercicios) {
		this.notaExercicios = notaExercicios;
	}
	
	public double calculaMediaFinal() {
		double mf = (this.notaProva * 0.4) + (this.notaExercicios * 0.2) + (this.notaTrabalho * 0.4);
		return mf; 
	}
	
	public double frequencia() {
		double f = (this.qtdPresencas/(double)Disciplina.QTDAULAS)*100;
		return f;
	}
	
	public String resultadoFinal() {
		double mf = (this.notaProva * 0.4) + (this.notaExercicios * 0.2) + (this.notaTrabalho * 0.4);
		double f = ((this.qtdPresencas/(double)Disciplina.QTDAULAS)*100);
		if (f >= 75.0) {
			if (mf >= 6.0) {
				return "APROVADO";
			}
			else if(mf >= 4.0) {
				return "IFA";
			}
		}
		return "REPROVADO";
	}
	
	
}
