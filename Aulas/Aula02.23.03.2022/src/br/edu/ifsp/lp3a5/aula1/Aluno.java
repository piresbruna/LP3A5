package br.edu.ifsp.lp3a5.aula1;

public class Aluno {
	private String matricula;
	private String nome;
	final private Disciplina d1;

	public Aluno(String matricula, String nome) {
		this.matricula = matricula;
		this.nome = nome;
		this.d1 = new Disciplina();
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public Disciplina getD1() {
		return d1;
	}

	public static void main(String[] args) {
		
		Aluno aluno1 = new Aluno("SP1111111","Aluno1");
		aluno1.getD1().setQtdPresencas(7);
		aluno1.getD1().setNotaProva(8.0);
		aluno1.getD1().setNotaTrabalho(5);
		aluno1.getD1().setNotaExercicios(10);
		
		System.out.println("Aluno: " +aluno1.getMatricula() + " - " + aluno1.getNome());
		System.out.println("Aulas: " + Disciplina.QTDAULAS);
		System.out.println("Média Final:" + aluno1.getD1().calculaMediaFinal());
		System.out.println("Frequência: " + aluno1.getD1().frequencia() + "%");
		System.out.println("Situação: " + aluno1.getD1().resultadoFinal());
	}

}
