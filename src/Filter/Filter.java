package Filter;

import javax.swing.JOptionPane;

public abstract class Filter {
	protected  double  Lv;
	protected  double  Fc;
	protected  double  G;
	protected  double  C;
	public void putLv() {
		this.Lv =Double.parseDouble(JOptionPane.showInputDialog("Filter level:"));
	}
	public void putCap() {
		this.C =Double.parseDouble(JOptionPane.showInputDialog("Capacitance:"));
	}
	
	public void putFc() {
		this.Fc =Double.parseDouble(JOptionPane.showInputDialog("Cut Frecuency:"));
	}
	public void putGain() {
		this.G =Double.parseDouble(JOptionPane.showInputDialog("Gain:"));
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

	
}
