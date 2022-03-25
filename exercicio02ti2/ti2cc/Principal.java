package com.ti2cc;
import java.util.Scanner;

public class Principal {
	
	public static int enterCase(Scanner entrada) {
        int opcao;
		System.out.println("Escolha a opção: \n 1) Listar \n 2)Inserir \n 3) Excluir \n 4) Atualizar \n 5) Sair\n");
        opcao = entrada.nextInt();
        return opcao;
    }
	
	public static void main(String[] args) {
		
		Aluno alunos[] = new Aluno[30];
		DAO dao = new DAO();
		
		dao.conectar();
		Scanner entrada = new Scanner(System.in);
		boolean fim = false;
		int i=0;
		while(fim == false)
		{
			switch(enterCase(entrada))
			{
			case 1:
				try {
					dao.getAlunos();
					System.out.println("Escolha a opção: \n 1) Listar \n 2)Inserir \n 3) Excluir \n 4) Atualizar \n 5) Sair\n");
				} catch (Exception e)
				{
					System.out.println("Erro");
				}
				break;
			case 2:
				dao.inserirAluno(alunos[i++]);
				System.out.println("Escolha a opção: \n 1) Listar \n 2)Inserir \n 3) Excluir \n 4) Atualizar \n 5) Sair\n");
				break;
			case 3:
				int matricula;
				System.out.println("Digite a matrícula do aluno: ");
				matricula = entrada.nextInt();
				
				dao.excluirAluno(matricula);
				break;
			case 4:
				dao.atualizarAluno(alunos[i]);
				break;
			case 5:
				fim = true;
				break;
				
			}
		}
		

		
		System.out.println("Escolha a opção: \n 1) Listar \n 2)Inserir \n 3) Excluir \n 4) Atualizar \n 5) Sair\n");
		
		
		
		dao.close();
	}
}