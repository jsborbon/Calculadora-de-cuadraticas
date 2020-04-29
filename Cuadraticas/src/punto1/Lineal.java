package punto1;

public class Lineal {
	
	private double variableTemp;
	private double solucion;
	
	public void resolverIncognita(float a, float b) {
		variableTemp = -(b / a);
	}
	
	

	public double getSolucion() {
		solucion=variableTemp;
		return solucion;
	}



	public void setSolucion(double solucion) {
		this.solucion = solucion;
	}



	public Lineal() {
		this.variableTemp = 0;
		this.solucion = 0;
	}

	
}
