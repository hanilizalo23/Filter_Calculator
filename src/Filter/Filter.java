package Filter;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.iteso.math.exception.NegativeNumberFoundException;

public abstract class Filter {
	protected  double  Lv;
	protected  double  Fc;
	protected  double  G;
	protected  double  C;
	public void putLv() throws NegativeNumberFoundException{
		double x=Double.parseDouble(JOptionPane.showInputDialog("Filter level:"));
		if(x<0) throw new NegativeNumberFoundException(x);
		this.Lv =x;
	}
	public void putCap() throws NegativeNumberFoundException {
		double x=Double.parseDouble(JOptionPane.showInputDialog("Capacitance:"));;
		if(x<0) throw new NegativeNumberFoundException(x);
		this.C =x;
	}
	
	public void putFc() throws NegativeNumberFoundException {
		double x=Double.parseDouble(JOptionPane.showInputDialog("Cut Frecuency:"));
		if(x<0) throw new NegativeNumberFoundException(x);
		this.Fc =x;
	}
	public void putGain() throws NegativeNumberFoundException {
		double x=Double.parseDouble(JOptionPane.showInputDialog("Gain:"));
		if(x<0) throw new NegativeNumberFoundException(x);
		this.G =x;
	}

	public double getLv() {
		return Lv;
	}
	public double getFc() {
		return Fc;
	}
	public double getGain() {
		return G;
	}
	public double getCap() {
		return C;
	}
		
	public abstract void calculusResistances(double Fc, double G, double Cap);
	public abstract void resulstFile() throws IOException;
	
}
