package entities;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class PaginaDeInscricao {
	
	
		
		//Inscrição dos candidatos

		protected Candidato candidatos[] = new Candidato[100];
		protected int candidatosRegistered = 0;

		public void inscricao(Scanner scanner) {
			
			NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
			
			System.out.println("Digite seu nome completo: ");
			String name = scanner.nextLine();
			
			System.out.println("\nDigite seu ano de nascimento: ");
			int bDayYear = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer do scanner

			System.out.println("Digite o nome da sua mãe: ");
			String nameMother = scanner.nextLine();
			
			System.out.println("Digite o nome do seu pai: ");
			String nameFather = scanner.nextLine();
			
			System.out.println("Informe seu número de telefone: ");
			long cellPhone = scanner.nextLong();
			
			System.out.println("Informe seu email: ");
			String email = scanner.next();
			scanner.nextLine(); // Limpar o buffer do scanner
			
			System.out.println("Qual sua altura em metros? (Ex: 1,78 ou 1.78): ");
			double height = lerAltura(scanner, numberFormat);
			
			System.out.println("Qual seu peso: ");
			double weight = lerPeso(scanner, numberFormat);
			
			Candidato candidato = new Candidato(name, bDayYear, nameMother, nameFather, cellPhone, email, height, weight);
			candidatos[candidatosRegistered] = candidato;
			candidatosRegistered++;

			//Exibição do número de candidatos já cadastrados
			System.out.println("Candidatos já cadastrados: " + candidatosRegistered);
		}
		
		
		//Formatação da altura para que aceite , ou . e faça o tratamento desse dado contendo também uma exceção para caso seja passado o dado de maneira incorreta e assim formamos um loop infinito até que retorne verdade
		protected double lerAltura(Scanner scanner, NumberFormat numberFormat) {
			numberFormat = NumberFormat.getInstance(Locale.US);
		    while (true) {
		        try {
		            String input = scanner.nextLine().replace(',', '.');
		            return numberFormat.parse(input).doubleValue();
		        } catch (ParseException e) {
		            System.out.println("Formato inválido. Digite sua altura novamente (Ex: 1,78 ou 1.78):");
		        }
		    }
		}
		//Formatação do peso para que aceite ',' ou '.' e faça o tratamento desse dado contendo também uma exceção para caso seja passado o dado de maneira incorreta (EX: ,. ou ,, etc...) e assim formamos um loop infinito até que retorne verdade
		protected double lerPeso(Scanner scanner, NumberFormat numberFormat) {
	    	numberFormat = NumberFormat.getInstance(Locale.US);
			while(true) {
				try {
					String input = scanner.nextLine().replace(',', '.');
					return numberFormat.parse(input).doubleValue();
				}catch(ParseException e) {
					System.out.println("Formato inválido. Digite seu peso novamente (Ex: 86,5 ou 86.5):");
				}
			}
		}
		
		//Metodo de exibição dos candidatos
		public void Exibicao() {
			System.out.println("\nLista de Candidatos 2025: ");
			for(int i = 0; i < candidatosRegistered; i++ ) {
				Candidato candidato = candidatos[i];
				System.out.println("Candidato " + (i + 1) + ":");
				candidato.ExibicaoDadosCandidatos();
				candidato.Verificacao();
				System.out.println("----------------------");
			}
		}

		public int getCandidatosRegistered() {
			return candidatosRegistered;
		}
		
		
		//Metodo para solicitar a pergunta de novo alistamentos gerando o loop com while
		public boolean continuarCadastrando(Scanner scanner) {
			 
			 System.out.println("\nDeseja realizar o Alistamento? (S/N): ");
			 String resposta = scanner.next();
			 scanner.nextLine();
			 return resposta.equalsIgnoreCase("S");
			 }

}
