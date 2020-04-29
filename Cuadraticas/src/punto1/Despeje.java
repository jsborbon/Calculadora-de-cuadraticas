/**
 **DESCRIPCIÓN: Programa con interfaz que soluciona una ecuación de segundo grado con una variable.
 **NOMBRE:Javier Santiago Borbón
 **FECHA: 08 de Noviembre de 2019
 **VERSION:1.0
 */
package punto1;

public class Despeje {
	
	private double discriminante; 
	private boolean imaginario;
	private double variableTemp;
	private double variable1;
	private double variable2;
	private double numImaginario;
	

	public void resolverIncognita(float a, float b, float c) {
		this.variableTemp=(((-1*b)+Math.sqrt(discriminante))/(2*a));
		setVariable1(this.variableTemp); //x1
		this.variableTemp=(((-1*b)-Math.sqrt(discriminante))/(2*a));
		setVariable2(this.variableTemp); //x2
	}

	public double getVariable1() {
		return variable1;
	}

	public void setVariable1(double variable1) {
		this.variable1 = variable1;
	}

	
	
	public double getVariable2() {
		return variable2;
	}

	public void setVariable2(double variable2) {
		this.variable2 = variable2;
	}
	

	public boolean isImaginario() {
		return imaginario;
	}

	public void setImaginario(boolean imaginario) {
		this.imaginario = imaginario;
	}

	public void setDiscriminante(float a, float b, float c) {
		discriminante = Math.pow(b, 2)-(4*a*c);
		if(discriminante<0) {
			discriminante=discriminante*-1;
			numImaginario=Math.sqrt(discriminante)/(2*a);
			imaginario=true; //Discriminante negativo
		}else {
			imaginario=false; //Discriminante positivo
		}
	}

	public double getNumImaginario() {
		return numImaginario;
	}	
	
	
}
