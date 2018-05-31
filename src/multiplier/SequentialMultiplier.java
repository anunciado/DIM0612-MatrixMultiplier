package multiplier;

import java.util.ArrayList;

public class SequentialMultiplier extends Multiplier
{
    public SequentialMultiplier( ArrayList< ArrayList< Long > > matrixA
                      , ArrayList< ArrayList< Long > > matrixB)
    {
        super(matrixA, matrixB);
    }

    @Override
    public void multiply() 
    {
       int size = matrixA.size();
       long sum;
       ArrayList <Long> list = new ArrayList <Long>();
       for(int i = 0; i < size; i++ )
       {
    	   list = new ArrayList <Long>();
           for( int j = 0; j < size; j++ )
           {
        	   sum = 0;
               for( int k = 0; k < size; k++)
               {
            	   sum += matrixA.get(i).get(k)*matrixB.get(k).get(j);
               }
               list.add(sum);
           }
           matrixC.add(list);
       }
    }  
}
