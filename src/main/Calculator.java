package main;

import java.util.ArrayList;

public class Calculator {
	private long maximum;
	private long minimum;
	private double mean;
	private double standardDeviation;
	private ArrayList <Long> values;
	
	public Calculator() 
	{
		this.values = new ArrayList <Long>();
	}

	public long getMaximum() {
		return maximum;
	}

	public void setMaximum(long maximum) {
		this.maximum = maximum;
	}

	public long getMinimum() {
		return minimum;
	}

	public void setMinimum(long minimum) {
		this.minimum = minimum;
	}

	public double getMean() {
		return mean;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	
	public void add(long value) {
		this.values.add(value);
	}
	
	public double sum() {
		double sum = 0;
		for(int i = 0; i < values.size(); i++) {
			sum += values.get(i);
		}
		return sum;
	}
	
	public void compute() {
		double size = values.size();
		maximum = values.get(0);
		minimum = values.get(0);
		mean = this.sum()/size;
		for(int i = 0; i < values.size(); i++) {
            standardDeviation += Math.pow(values.get(i) - mean, 2);
			if(values.get(i) > maximum) {
				this.setMaximum(values.get(i));
			}
			if(values.get(i) < minimum) {
				this.setMinimum(values.get(i));
			}
		}
        standardDeviation = Math.sqrt(standardDeviation / size);
	}
}
