
import java.util.Random;
import java.util.Scanner;


public class Exemplo1 {
    public static void main(String[] args) {
        int notas[]={100,87,32,8,56,76,2,26,67,92};
        //obter o vetor: int array[] = { 2, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 };
        
        //35 participantes (notas: 0 a 5)
        //qde de notas 0:
        //qde de  notas 1:
        //qde de notas 2:
        //..
        //qde de  otas 5:
        
        int qn[] = new int[6]; //qn[0]=0;
        Random ale = new Random();
        for (int i = 0; i < 35; i++) {
            int n = ale.nextInt(6);//0 a 5
            qn[n]++;
        }
        for (int i = 0; i < qn.length; i++) {
            System.out.println("Quantidades de notas "+i+": "+qn[i]);
        } 
        
    }
}
