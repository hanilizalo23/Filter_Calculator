package Filter;

public enum TypeFilter {
//	public static final, se crean durante el primer uso de Figura en el programa
	Chevychev_Cres1db   (0.9564,0.8623),
	Chevychev_Cres0_5db (0.8638,0.886),
	Chevychev_Cres0_25db(0.8093,0.9098),
	Chevychev_Cres0_1db (0.7673,0.9368),
	Bessel              (0.5771,1.2754),
	Butterworth         (0.7071,1.00);
	
	private double Quality;
	private double Constant;
	private TypeFilter(double q, double k) {
		this.Quality = q;
		this.Constant = k;
	}
	
	public String toString() {
		return "Quality:"+this.Quality + ","+"Constant:"+ this.Constant;
	}

	public double getQuality() {
		return Quality;
	}

	public double getConstant() {
		return Constant;
	}

}
