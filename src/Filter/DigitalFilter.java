package Filter;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.iteso.math.exception.NegativeNumberFoundException;

public abstract class DigitalFilter {
	protected double Fs;

    public double getFs() {
		return Fs;
	}

	public void setFs() throws NegativeNumberFoundException {
		double x=Double.parseDouble(JOptionPane.showInputDialog("Sampler Frecuency:"));;
		if(x<0) throw new NegativeNumberFoundException(x);
		this.Fs = x;
	}


	public static double cutFreqNormalized(double F, double Fs){
        return (F/Fs)*Math.PI*2;
    }

	
	public abstract void filterImpulseResponse(double wc, int samples);
	public abstract void resulstFile() throws IOException;

}
