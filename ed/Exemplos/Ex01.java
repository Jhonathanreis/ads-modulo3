
import java.util.Scanner;


public class Ex01 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Aluno alunos[];
        
        alunos = new Aluno[20]; //
        System.out.println(alunos);
        for (int i = 0; i < alunos.length; i++) {
            System.out.println("Informe a nome do "+(i+1)+"o. aluno: ");
            String nome = entrada.next();
            System.out.println("Informe a matricula do "+(i+1)+"o. aluno: ");
            int matricula = entrada.nextInt();
            System.out.println("Informe a Nota do "+(i+1)+"o. aluno: ");
            double nota = entrada.nextDouble();
            alunos[i]=new Aluno(matricula,nome,nota);
        }      
        //mostrar
        for (int i = 0; i < alunos.length; i++) {
            System.out.println(alunos[i]);
        }
    }
}
