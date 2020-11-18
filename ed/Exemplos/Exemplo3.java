public class Exemplo3 {
    public static void main(String[] args) {
        int notas[]={8,87,32,34,56,76,2,26,67,92};
        //obter o vetor: int array[] = { 2, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 };
        int array[] = new int [11];
        for (int i = 0; i < notas.length; i++) {
            array[notas[i]/10]++;
        }
        for (int i = 0; i < array.length-1; i++) {
            System.out.printf("%02d-%02d: %d\n",10*i,(10*i+9),array[i]);
        }
        System.out.printf("  100: %d\n",array[10]);
        
        //maior nota???
        int maior = notas[0];
        int pos=0;
        for (int i = 1; i < notas.length; i++) {
            if(notas[i] > maior){
                pos = i;
                maior = notas[i];
            }
            
        }
        System.out.println("Maior: "+ maior+"\nposicao: "+pos);
    }
}
