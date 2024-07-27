package entities;

public class Candidato {
	
	private String name;
	private int bDayYear;
	private String nameMother;
	private String nameFather;
	private long cellPhone;
	private String email;
	private double height;
	private double weight;

	//Exibição do número de cadidatos, Ex: candidato 1, candidato 2, etc...
	 
	
	public Candidato(String name, int bDayYear, String nameMother, String nameFather, long cellPhone, String email,
			double height, double weight) {
		
		this.name = name;
		this.bDayYear = bDayYear;
		this.nameMother = nameMother;
		this.nameFather = nameFather;
		this.cellPhone = cellPhone;
		this.email = email;
		this.height = height;
		this.weight = weight;
	}

	public void ExibicaoDadosCandidatos() {
		
		System.out.println("Nome do candidato: " + name);
		System.out.println("idade: " + calcularIdade());
		System.out.println("Nome da Mãe: " + nameMother);
		System.out.println("Nome do pai: " + nameFather);
		System.out.println("Telefone: " + cellPhone);
		System.out.println("E-mail: " + email);
		System.out.println("Altura: " + String.format("%.2f", height));
		System.out.println("Peso: " + String.format("%.2f", weight));
	}
	
	private int calcularIdade() {
		int currentYear = 2024;
		return currentYear - bDayYear;
	}
	public void verificacao() {
		int age = calcularIdade();
		int valorMulta = (age - 20) * 5;
		if(age < 18) {
			System.out.println("Não possui idade suficiente para o alistamento militar.");
		}else if(age > 19 && age < 45) {
			System.out.println("ATENÇÃO: Multa de R$" + valorMulta + ", pois encontra-se acima da idade isenta");
		}
	}

}
