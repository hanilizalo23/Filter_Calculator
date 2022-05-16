package Filter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.iteso.math.exception.NegativeNumberFoundException;


public class AnalogicFilterLv1LP extends AnalagoFilter  {
	public double R1;
	public double Rf;
	public double R;
	public AnalogicFilterLv1LP() throws NegativeNumberFoundException {
		super.putGain();
		super.putFc();;
		super.putCap();
		
	}
	
	@Override
	public  void calculusResistances(double Fc, double G, double Cap) {
		this.Rf(Fc);
		this.R( G);
		this.R1();
	}

	public void Rf(double Fc) {
		double fc= Fc;
		this.Rf=1/(2*Math.PI*fc*C);
	}
	
	public void R(double gain) {
		this.R=this.Rf/getGain();
	}

	public void R1() {
		this.R1=this.Rf/this.R;
	}
	
	public void resulstFile() throws IOException {
	FileWriter fw=new FileWriter("D:\\MPO\\ITESO\\6_semestre\\POO\\programas\\ProyectoPOO\\FilterValuesDesignLv1.txt");
	BufferedWriter br=new BufferedWriter(fw);
	br.write(toString());
	br.close();
	fw.close();
	}
	
	public String toString() {
		return String.format("Valores introducidos:\n"
				+ "Frecuencia de corte: %.2fhz\nCapacitor C1: %f\nGanancia: %.2f\n"
				+ "Valores calculados:\nResistencia Rf= %fOhms\nResistencia R= %fOhms\nResistencia R1= %fOhms",getFc(),getCap(),getGain(),this.Rf, this.R,this.R1);

	}
	
	public static void main(String[] args) throws NegativeNumberFoundException, IOException {
		AnalagoFilter LP= new AnalogicFilterLv1LP();
		LP.calculusResistances(LP.getFc(),LP.getGain(),LP.getCap());
		System.out.println(LP);
		LP.resulstFile();
	}
	
}

