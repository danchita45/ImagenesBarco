/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

/**
 *
 * @author Danchita45
 */
public class Transformaciones2d {

    
    public static int Tx=5;
    public static int Ty=-8;
    double traslacion[][]=
    {
        {1,0,0},
        {0,1,0},
        {Tx,Ty,1}
    };
    
    
    public float[][] mTraslacion(double x0,double y0,
                             double x1, double y1,
                             double x2, double y2,
                             double x3, double y3){
       double moriginal[][]={
           {x0,y0,1},
           {x1,y1,1},
           {x2,y2,1},
           {x3,y3,1}
       } ;
       float mt[][] = new float[moriginal.length][traslacion.length];
       for(int i=0;i<4;i++){
           for(int j=0;j<3;j++){
               for(int k =0;k<3;k++){
                 mt[i][j]+=(moriginal[i][k]*traslacion[k][j]);
               }
           }
       }
       return mt;
    }
    
}
