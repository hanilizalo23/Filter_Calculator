package Filter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.iteso.math.exception.NegativeNumberFoundException;

public class AnalogicFilterLv2LP extends Filter {
	private double R1;
	private double R2;
	private double R3;
	private double R4;
	private double C2;
	
	private double Q;
	private double K;
	public TypeFilter type=TypeFilter.Chevychev_Cres0_1db;
	public String resFiltName;
	
	public AnalogicFilterLv2LP() throws NegativeNumberFoundException {
		super.putGain();
		super.putFc();;
		super.putCap();
		System.out.println("Select the filter respont:");
		System.out.println("1)Chevychev_Crest 1.00db\r\n"
							+ "2)Chevychev_Crest 0.50db\r\n"
							+ "3)Chevychev_Crest 0.25db\r\n"
							+ "4)Chevychev_Crest 0.10db\r\n"
							+ "5)Butterworth\r\n"
							+ "6)Bessel");
		int select=Integer.parseInt(JOptionPane.showInputDialog("Filter Response:"));
		setType(select);
		setQ(type);
		setK(type);
		
		
	}
	
	@Override
	public void calculusResistances(double Fc, double G, double Cap) {
		R3(Fc,G,Cap);
		R1();
		R2();
		C2();
		R4();
	}
	
	public void R3(double Fc,double G,double Cap) {
		setR3((getQ()*(G+1))/(Math.PI*getK()*Fc*Cap));
	}
	
	public void R1() {
		setR1(getR3()/getGain());
	}
	
	public void C2() {
		setC2(1/(Math.PI*4*getFc()*getQ()*getR3()));
	}
	public void R2() {
		setR2(getR3()/(getGain()+1));
	}
	public void R4() {
		setR4(getR2()*2);
	}
	
	public double getR1() {
		
		return R1;
	}

	public void setR1(double r1) {
		if(r1>0) R1 = r1;
	}

	public double getR2() {
		return R2;
	}

	public void setR2(double r2) {
		if(r2>0) R2 = r2;
	}

	public double getR3() {
		return R3;
	}

	public void setR3(double r3) {
		if(r3>0) R3 = r3;
	}

	public double getR4() {
		return R4;
	}

	public void setR4(double r4) {
		if(r4>0) R4 = r4;
	}

	public double getC2() {
		return C2;
	}

	public void setC2(double c2) {
		if(c2>0) C2 = c2;
	}

	public double getQ() {
		return Q;
	}

	public void setQ(TypeFilter t) {
		Q = t.getQuality();
	}

	public double getK() {
		return K;
	}

	public void setK(TypeFilter t) {
		K = t.getConstant();
	}

	public TypeFilter getType() {
		return type;
	}

	public void setType(int select){
		switch(select) {
		case 1: this.type=TypeFilter.Chevychev_Cres1db;
				this.resFiltName="Chevychev_Crest 1.00db";
				break;
		case 2: this.type= TypeFilter.Chevychev_Cres0_5db;
				this.resFiltName="Chevychev_Crest 0.50db";
			    break;
		case 3: this.type= TypeFilter.Chevychev_Cres0_25db;
				this.resFiltName="Chevychev_Crest 0.25db";
	    		break;
		case 4: this.type= TypeFilter.Chevychev_Cres0_1db;
				this.resFiltName="Chevychev_Crest 0.10db";
	    		break;
		case 5: this.type= TypeFilter.Butterworth;
				this.resFiltName="Butterworth";
	    		break;
		case 6: this.type= TypeFilter.Bessel;
				this.resFiltName="Bessel";
	    		break;
		default: this.type=TypeFilter.Chevychev_Cres1db;
				this.resFiltName="Chevychev_Crest 1.00db";
				break; 
		}
	}
	
	@Override
	public void resulstFile() throws IOException {
		FileWriter fw=new FileWriter("D:\\MPO\\ITESO\\6_semestre\\POO\\programas\\ProyectoPOO\\FilterValuesDesignLv2.txt");
		BufferedWriter br=new BufferedWriter(fw);
		br.write(toString());
		br.close();
		fw.close();
	}
	
	@Override
	public String toString() {
		return String.format("Valores introducidos:\n"
				+ "Tipo de respuesta del filtro : %s\nFrecuencia de corte: %.2f\nCapacitor C1%f:\nGanancia: %.2f\n"
				+ "Valores caluclados:\nResistencia R1=%f\nResistencia R2=%f\nResistencia R3=%f"
				+ "\nResistencia R4=%f\nCapacitor C2=%.10f",this.resFiltName,getFc(),getCap(),getGain(),this.R1, this.R2,this.R3,this.R4,this.C2);

	}
	
	

	public static void main(String[] args) throws NegativeNumberFoundException, IOException {
		TypeFilter type= TypeFilter.Butterworth;
		System.out.println(type.getQuality());
		Filter LP= new AnalogicFilterLv2LP();
		LP.calculusResistances(LP.getFc(),LP.getGain(),LP.getCap());
		System.out.println(LP);
		LP.resulstFile();
	}
}
