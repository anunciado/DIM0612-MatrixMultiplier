package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import io.Reader;
import io.Writer;
import multiplier.ConcurrentMultiplier;
import multiplier.Multiplier;
import multiplier.SequentialMultiplier;

public class Main {
	
	private static final int NUMBER_OF_TESTS = 20;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		long lStartTime = 0, lEndTime = 0, output = 0;
		//int size = Long.parseInt(args[0]);
		int size = 2048;
		//String type = args[1];
		String type = "C";
		for(;size <= 2048; size *= 2) {
			Reader reader = new Reader(size);
			reader.readFile();
			ArrayList<ArrayList<Long>> matrixA = reader.getMatrixA();
			ArrayList<ArrayList<Long>> matrixB = reader.getMatrixB();
			ArrayList<ArrayList<Long>> matrixC = new ArrayList<ArrayList<Long>>();
			Multiplier multiplier = null;
			if(type.equals("S")) {
				multiplier = new SequentialMultiplier(matrixA, matrixB);
			}
			else if(type.equals("C")) {
				multiplier = new ConcurrentMultiplier(matrixA, matrixB);
				((ConcurrentMultiplier) multiplier).initialize();
			}
			else {
				System.out.println("Execution type not expected!");
			}	
			Calculator calculator = new Calculator();
			for(int i = 0; i < NUMBER_OF_TESTS; i++) {
				lStartTime = new Date().getTime();
				multiplier.multiply();
		        lEndTime = new Date().getTime();
		        output = lEndTime - lStartTime;     
		        calculator.add(output);
		        System.out.println(output);
		        matrixC = multiplier.getMatrixC();
			}
		    Writer writer = new Writer(size, matrixC);
		    writer.write();
		    calculator.compute();
		    System.out.println("For size " + size + " in a " + type + " type of execution.");
		    System.out.println("Maximum elapsed time in milliseconds: " + calculator.getMaximum());
		    System.out.println("Minimum elapsed time in milliseconds: " + calculator.getMinimum());
		    System.out.println("Mean of elapsed time in milliseconds: " + calculator.getMean());
		    System.out.println("Standard Deviation of elapsed time in milliseconds: " + calculator.getStandardDeviation());
		}	
	}
}
