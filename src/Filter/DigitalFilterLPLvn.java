package Filter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.iteso.math.exception.NegativeNumberFoundException;

public class DigitalFilterLPLvn extends DigitalFilter {
	private double Fc;
	private double Wc;
	private int Samples;
	private ArrayList<Double> hn= new ArrayList<>();

	public  DigitalFilterLPLvn() throws NegativeNumberFoundException{
		super.setFs();
		setFc();
		setWc();
		setSamples();
	}
	
	@Override
	public void filterImpulseResponse(double wc, int samples) {
		int k=-1*(samples/2);
		for (int n=0;n<samples+1 ;n++) {
				   if(k==0) {
				       this.hn.add(n, wc/Math.PI);
				       k++;
				   }
				   else{
				       this.hn.add(n, (Math.sin((wc)*k)/(k*Math.PI)));
				       k++;
				   }
		}
	}

	public void setFc() throws NegativeNumberFoundException {
		double x=Double.parseDouble(JOptionPane.showInputDialog("cut Frecuency:"));
		if(x<0) throw new NegativeNumberFoundException(x);
		this.Fc=x;
	}
	
	public void setWc() {
		this.Wc =super.cutFreqNormalized(this.Fc, super.Fs);;
	}
	
	public void setSamples() throws NegativeNumberFoundException {
		int x=Integer.parseInt(JOptionPane.showInputDialog("Level Filter Samples:"));
		if(x<0) throw new NegativeNumberFoundException(x);
		this.Samples=x;
	}

	public double getFc() {
		return Fc;
	}

	public double getWc() {
		return Wc;
	}

	public int getSamples() {
		return Samples;
	}

	public ArrayList<Double> getHn() {
		return hn;
	}

	@Override
	public void resulstFile() throws IOException {
		FileWriter fw=new FileWriter("C:\\Users\\nelid\\workspace\\java\\Proyecto_Final\\DigitalFilterLP.txt");
		BufferedWriter br=new BufferedWriter(fw);
		br.write(toString());
		br.close();
		fw.close();
	}
	public String toString() {
		return String.format("Valores introducidos:\n"
				+ "Orden del filtro: %d\nFrecuencia de corte: %.2fhz\nFrecuencia de muestreo: %.2fhz\nFrecuencia de corte normalizada: %.2f rad/m\n"
				+ "Valores calculados:\nRespuesta al impulso del filtro:\nh(n)=%s ",this.getSamples(),this.getFc(),super.getFs(),this.getWc(),this.getHn());

	}
	
	
	public static void main(String[] args) throws NegativeNumberFoundException, IOException {
		// TODO Auto-generated method stub
		DigitalFilterLPLvn lp= new DigitalFilterLPLvn();
		lp.filterImpulseResponse(lp.getWc(), lp.getSamples());
		System.out.println(lp.toString());
		lp.resulstFile();
	}


}
