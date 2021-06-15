/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

/**
 *
 * @author Sushil Kumar
 */
import java.util.*;
public class Matrix {

    /**
     * @param args the command line arguments
     */
    private int nrows; 
    private int ncols; 
    private int[][] data; 
    public Matrix(int[][] dat) 
    {
        this.data = dat; 
        this.nrows = dat.length; 
        this.ncols = dat[0].length; 
    }
    public Matrix(int nrow, int ncol) 
    { 
        this.nrows = nrow; 
        this.ncols = ncol; 
        data = new int[nrow][ncol]; 
    }
    public void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER THE ELEMENTS IN THE ARRAY");
        for(int i=0;i<nrows;i++)
        {
            for(int j=0;j<ncols;j++)
                data[i][j]=sc.nextInt();
        }
    }
    public void display()
    {
        for(int i=0;i<nrows;i++)
        {
            for(int j=0;j<ncols;j++)
                System.out.print(data[i][j]+"\t");
            System.out.println();
        }
    }
    public void addition(Matrix m1, Matrix m2)
    {
        for(int i=0;i<nrows;i++)
        {
            for(int j=0;j<ncols;j++)
                this.data[i][j]=m1.data[i][j]+m2.data[i][j];
        }
    }
    public void multiplication(Matrix m1, Matrix m2)
    {
        if(m1.ncols!=m2.nrows)
            System.out.println("MATRICES ARE NOT COMPATIBLE FOR MULTIPLICATION");
        else
        {
            for(int i=0;i<this.ncols;i++)
            {
                for(int j=0;j<this.nrows;j++)
                {
                    this.data[i][j]=0;
                    for(int k=0;k<m1.nrows;k++)
                        this.data[i][j]+=m1.data[i][k]*m2.data[k][j];
                }
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER NUMBER OF ROWS AND COLUMNS");
        int r=sc.nextInt();
        int c=sc.nextInt();
        Matrix obj1=new Matrix(r,c);
        System.out.println("ENTER ORDER OF SECOND MATRIX");
        r=sc.nextInt();
        c=sc.nextInt();
        Matrix obj2=new Matrix(r,c);
        obj1.input();
        obj2.input();
        System.out.println("ENTER YOUR CHOICE");
        System.out.println("1. ADDITION");
        System.out.println("2. MULTIPLICATION");
        int ch=sc.nextInt();
        /*System.out.println("ENTER THE ORDER OF RESULTANT MATRIX");
        r=sc.nextInt();
        c=sc.nextInt();*/
        Matrix result=new Matrix(r,c);
        switch(ch)
        {
            case 1:result.addition(obj1, obj2);
                    System.out.println("RESULTANT MATRIX*****************************");
                    result.display();
                    break;
            case 2:result.multiplication(obj1, obj2);
                    System.out.println("RESULTANT MATRIX*****************************");
                    result.display();
                    break;
            default:System.out.println("YOU ENTERED WRONG CHOICE!!");
        }
        System.out.println("FIRST MATRIX*********************************");
        obj1.display();
        System.out.println("SECOND MATRIX********************************");
        obj2.display();
        
    }
    
}
