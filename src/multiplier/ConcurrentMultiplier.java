package multiplier;

import java.util.ArrayList;

public class ConcurrentMultiplier extends Multiplier
{
    
    public ConcurrentMultiplier( ArrayList< ArrayList< Long > > matrixA
                      , ArrayList< ArrayList< Long > > matrixB)
    {
        super(matrixA, matrixB);
    }
    
    public void initialize()
	{
    	int size = matrixA.size();
    	ArrayList <Long> list = new ArrayList <Long>();
    	for(int i = 0; i < size; i++) {
    		list = new ArrayList <Long>(size);
    		for(int j = 0; j < size; j++) {
        		list.add((long) 0);
        	}
    		matrixC.add(list);
    	}
	}

    @Override
    public void multiply() 
    {
       int size = matrixA.size();
       ArrayList < ThreadElement > threadsList = new ArrayList<ThreadElement >();       // Calculo matriz produto
       for(int i = 0; i < size; i++ )
       {
    	   ThreadElement thread = new ThreadElement(i , matrixA.get(i), matrixB, matrixC);
           threadsList.add(thread);
           thread.start();
           try {
        	   threadsList.get(i).join();
           } catch ( InterruptedException ex ) 
           {
               ex.printStackTrace();
           }
       }
    }

    
}

