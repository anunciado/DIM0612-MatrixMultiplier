package multiplier;

import java.util.ArrayList;

public abstract class Multiplier 
{
    protected ArrayList< ArrayList< Long > > matrixA;
    protected ArrayList< ArrayList< Long > > matrixB; 
    protected ArrayList< ArrayList< Long > > matrixC; 
    
    public Multiplier( ArrayList< ArrayList< Long > > matrixA
            , ArrayList< ArrayList< Long > > matrixB)
    {
    	this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixC = new ArrayList<ArrayList<Long>>();
    }       

    public ArrayList<ArrayList<Long>> getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(ArrayList<ArrayList<Long>> matrixA) {
        this.matrixA = matrixA;
    }

    public ArrayList<ArrayList<Long>> getMatrixB() {
        return matrixB;
    }

    public void setMatrixB(ArrayList<ArrayList<Long>> matrixB) {
        this.matrixB = matrixB;
    }
    
    public ArrayList<ArrayList<Long>> getMatrixC() {
        return matrixC;
    }

    public void setMatrixC(ArrayList<ArrayList<Long>> matrixC) {
        this.matrixC = matrixC;
    }

    public abstract void multiply();
}
