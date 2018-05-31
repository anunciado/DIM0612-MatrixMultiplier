package multiplier;

import java.util.ArrayList;

public class ThreadElement extends Thread
{
    private int row;
    private ArrayList< Long > listMatrixA;
    private ArrayList< ArrayList< Long > > matrixB; 
    private ArrayList< ArrayList< Long > > matrixC; 
    
    public ThreadElement(int row
                        , ArrayList<  Long > listMatrixA 
                        , ArrayList< ArrayList< Long > > matrixB 
                        , ArrayList< ArrayList< Long > > matrixC)
    {
        this.row = row;
        this.listMatrixA = listMatrixA;
        this.matrixB = matrixB;
        this.matrixC = matrixC;
    }
    
    @Override
    public void run()
    {
        long sum = 0;
        int size = listMatrixA.size();
        ArrayList< Long > listMatrix = null;
        for( int i = 0; i < size; i++ )
        {
        	listMatrix = new ArrayList< Long >();
        	for(int j = 0; j < size; j++) {
        		sum += listMatrixA.get(i) * matrixB.get(j).get(i);
        		listMatrix.add(sum);
        	}  
        	matrixC.add(row, listMatrix);
        }
    }
}
