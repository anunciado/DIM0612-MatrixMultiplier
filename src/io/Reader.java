package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader 
{    
    private ArrayList< ArrayList< Long > > matrixA;
    private ArrayList< ArrayList< Long > > matrixB;
    private long size;
    private String filenameA;
    private String filenameB;

    public Reader(long size)
    {
        this.setSize(size);
        this.filenameA = "A"+size+"x"+size+".txt";
        this.filenameB = "B"+size+"x"+size+".txt";
        this.matrixA = new ArrayList<ArrayList<Long>>();
        this.matrixB = new ArrayList<ArrayList<Long>>();
    }
    
    public ArrayList< ArrayList< Long > > getMatrixA() 
	{
		return matrixA;
	}

	public void setMatrixA(ArrayList< ArrayList< Long > > matrixA) 
	{
		this.matrixA = matrixA;
	}

	public ArrayList< ArrayList< Long > > getMatrixB() 
	{
		return matrixB;
	}

	public void setMatrixB(ArrayList< ArrayList< Long > > matrixB) 
	{
		this.matrixB = matrixB;
	}

	public long getSize() 
	{
		return size;
	}

	public void setSize(long size) 
	{
		this.size = size;
	}
	
    public String getFilenameA() 
    {
        return filenameA;
    }

    public void setFilenameA( String filenameA ) 
    {
        this.filenameA = filenameA;
    }

    public String getFilenameB() 
    {
        return filenameB;
    }

    public void setFilenameB(String filenameB) 
    {
        this.filenameB = filenameB;
    }  
    
    public void readFile() throws FileNotFoundException, IOException 
    {  
        setMatrixA(createMatrix("./input/"+filenameA));
        setMatrixB(createMatrix("./input/"+filenameB));
    }
    
    private ArrayList< ArrayList< Long > > createMatrix(String path) throws FileNotFoundException, IOException
    {
       ArrayList< ArrayList< Long > > matrixC = new ArrayList< ArrayList<Long> >();
       try
       {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            ArrayList< Long > linelong;
            String readLine = bufferedReader.readLine();
            String[] line;
            while( (readLine = bufferedReader.readLine() ) != null )
            {
                linelong =  new ArrayList< Long >();
                line = readLine.split(" ");
                for(String numero : line)
                {
                    linelong.add(Long.parseLong(numero));
                }
                matrixC.add(linelong);   
            }
            
       } catch ( FileNotFoundException e )
       {
            e.printStackTrace();
       } catch ( IOException e )
       {
           e.printStackTrace();
       }
       return matrixC;
    } 
}
