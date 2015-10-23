package dataanalysis;

public class InfraRed {
	private double [] sensorValues;
	
	public InfraRed() {
		sensorValues = new double[7];
		for (int i = 0; i < 7; i++) sensorValues[i] = Double.POSITIVE_INFINITY;
	}
	
	private double convertRawToMetric(double raw) {    
		return  2.7600986570989910263e+01 +
				raw*(-1.9849960190238043894e-02 +
			    raw*(1.5212102635134943293e-05 +
			    raw*(-8.6350493431215160015e-09 +
			    raw*(2.3215266840684188232e-12 +
			    raw*(-2.2505642504852145915e-16)))));
	}
	
	public void updateValue(int id, short raw) {
		if (raw == 0) {
			sensorValues[id] = Double.POSITIVE_INFINITY;
		}
		else {
			sensorValues[id] = convertRawToMetric(raw);
		}
	}
	
	public double getValue(int id) {
		return sensorValues[id];
	}
	
	public static void main(String [] args) {
		InfraRed ir = new InfraRed();
		
		for (double x = 300; x < 4700; x++) {
			System.out.println(x + "," + ir.convertRawToMetric(x));
		}
	}
}
