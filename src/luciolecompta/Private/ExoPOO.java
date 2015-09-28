/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luciolecompta.Private;

/**
 * Exo TD1 POO
 * @author Karakayn
 */
public class ExoPOO {
    public ExoPOO(){}
    
    /**
     * Factorielle non récursive
     * @param n
     * @return 
     */
    public int fact(int n){
        int i;
        int r = 1;
        for(i = 2; i<=n; i++){
            r = r*i; // i <=> r *= i
        }
        return r;
    }
    
    /**
     * Factorielle récursive
     * @param n
     * @return 
     */
    public int factRecur(int n){
        if(n <= 1)
            return 1;
        else
            return fact(n-1)*n;
    }
    
    /**
     * Fibonacci récursif
     * @param n
     * @return 
     */
    public int fib(int n){

        if(n < 2)
            return n;
        else{
            return fib(n-1) + fib(n-2);
        }
    }
    
    /**
     * Fibonacci itératif
     * @param n
     * @return 
     */
    public int fibIteratif(int n){
        int u = 0;
        int v = 1;
        int r = 0;
        if(n == 1)
            return 1;
        else{
            for(int i = 2; i < n; i++){
                r = u + v;
                u = v;
                v = r;
            }
            return r;
        }
    }
    
    /**
     * Problème des tours de Hanoï
     * @param n : nombre de rondelle à déplacer 
     * @param piquetDeDepart = 1 au start de l'appli
     * @param piquetArrive = 3 au start de l'appli
     * 
     */
    public void HanoiRecursif(int n, int piquetDeDepart, int piquetArrive){
        piquetDeDepart = 1;
        piquetArrive = 3;
        if(n > 0){
            HanoiRecursif(n-1, piquetDeDepart, 6-piquetArrive-piquetDeDepart);
            System.out.println("Deplacer le dernier anneau de "+piquetDeDepart+" a "+piquetArrive);
            //deplacement entre le piquetDepart et le piquet arrive
            HanoiRecursif(n-1, 6-piquetDeDepart-piquetArrive, piquetArrive);
        }
    }
}
