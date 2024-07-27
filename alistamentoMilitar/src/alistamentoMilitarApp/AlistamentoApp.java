package alistamentoMilitarApp;

import java.util.Scanner;

import entities.PaginaDeInscricao;

public class AlistamentoApp {

	public static void main(String[] args) {
		


		
		Scanner scanner = new Scanner(System.in);
		PaginaDeInscricao inscricao = new PaginaDeInscricao();
		
		System.out.println("Sejam Bem-Vindos ao Alistamento Militar Obrigatório");
		
		inscricao.Exibicao();
		 while(inscricao.continuarCadastrando(scanner)) {
			 
			 inscricao.inscricao(scanner); 
			
		 }
		 inscricao.Exibicao();
		 scanner.close();
	
	}

}
