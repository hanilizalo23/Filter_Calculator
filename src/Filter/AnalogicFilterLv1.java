package Filter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.iteso.math.exception.NegativeNumberFoundException;


public class AnalogicFilterLv1 extends Filter  {
	public double R1;
	public double Rf;
	public double R;
	public AnalogicFilterLv1() throws NegativeNumberFoundException {
		super.putLv();
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
	FileWriter fw=new FileWriter("Descargas\\Hola.txt");
	BufferedWriter br=new BufferedWriter(fw);
	br.write(toString());
	br.close();
	fw.close();
	}
	
	public String toString() {
		return String.format("Resistencia Rf=%f\nResistencia R1=%f\nResistencia R=%f",this.Rf, this.R1,this.R);

	}
	
	public static void main(String[] args) throws NegativeNumberFoundException {
		Filter LP= new AnalogicFilterLv1();
		LP.calculusResistances(LP.getFc(),LP.getGain(),LP.getCap());
		System.out.println(LP);
		
	}
	
}

