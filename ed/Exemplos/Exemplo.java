
import java.util.Random;
import java.util.Scanner;


public class Exemplo {
    public static void main(String[] args) {
        int notas[]={100,87,32,8,56,76,2,26,67,92};
        //obter o vetor: int array[] = { 2, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 };
        
        //35 participantes (notas: 0 a 5)
        //qde de notas 0:
        //qde de  notas 1:
        //qde de notas 2:
        //..
        //qde de  otas 5:
        int qn0=0;
        int qn1=0;
        int qn2=0;
        int qn3=0;
        int qn4=0;
        int qn5=0;
        Random ale = new Random();
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < 35; i++) {
//            System.out.println("Digite a nota do "+(i+1)+"o. participante:");
//            int n = entrada.nextInt();
            int n = ale.nextInt(6);//0 a 5
            if(n==0) qn0++;
            if(n==1) qn1++;
            if(n==2) qn2++;
            if(n==3) qn3++;
            if(n==4) qn4++;
            if(n==5) qn5++;
        }
        System.out.println("Quantidades de notas 0: "+qn0);
        System.out.println("Quantidades de notas 1: "+qn1);
        System.out.println("Quantidades de notas 2: "+qn2);
        System.out.println("Quantidades de notas 3: "+qn3);
        System.out.println("Quantidades de notas 4: "+qn4);
        System.out.println("Quantidades de notas 5: "+qn5);
        
    }
}
