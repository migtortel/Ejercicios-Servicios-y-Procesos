package ejercicio_2;

public class MainExam {

	public static void main(String[] args) {
		
		
		int numVeces = 5;
		EscribeExam exam = new EscribeExam(numVeces);
		EscribeE h1 = new EscribeE(exam);
		EscribeX h2 = new EscribeX(exam);
		EscribeA h3 = new EscribeA(exam);
		EscribeM h4 = new EscribeM(exam);
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		
		System.out.println("El número de intentos fallidos de escribir E es: " + EscribeExam.contE);
		System.out.println("El número de intentos fallidos de escribir X es: " + EscribeExam.contX);
		System.out.println("El número de intentos fallidos de escribir A es: " + EscribeExam.contA);
		System.out.println("El número de intentos fallidos de escribir M es: " + EscribeExam.contM);

	}

}
