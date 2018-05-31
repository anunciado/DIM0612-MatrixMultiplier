package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer 
{
    private ArrayList< ArrayList< Long > > matrixC; 
    private int size;
    
    public Writer(int size, ArrayList< ArrayList< Long > > matrixC )
    {
         this.size = size;
         this.matrixC = matrixC;
    }
    
    
    public void write() throws IOException
    {
        BufferedWriter writtenFile = null;
        try
        {
            writtenFile = new BufferedWriter( new FileWriter("./output/"+"C"+size+"x"+size+".txt" ) );
            String linha = "";
            writtenFile.write(size + " " + size + "\n");
            for( int i=0; i<size; i++, linha = "" )
            {
                for( int j=0; j<size; j++ )
                {
                    linha += matrixC.get(i).get(j).toString() + " ";
                }
                writtenFile.write(linha + "\n");
            }
                
            
        } catch( IOException e )
        {
            e.printStackTrace();
        } finally
        {
            try 
            {
                if( writtenFile != null )
                {
                    writtenFile.close();
                }
            } catch ( IOException e )
            {
                e.printStackTrace();
            }
        }
        
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
