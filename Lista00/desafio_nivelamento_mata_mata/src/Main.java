import java.util.Scanner;

void main(){
    Scanner entrada = new Scanner(System.in);
    char[][] times = {{'A', 'B'}, {'C', 'D'}, {'E', 'F'}, {'G', 'H'}, {'I', 'J'}, {'K', 'L'}, {'M', 'N'}, {'O', 'P'}};
    char [] vencedores = new char[15];
    int M;
    int N;
    int indice;
    int partidas_quartas = 0;
    int partidas_semi = 0;
    for (int i = 0; i < 15; i++){
        M = entrada.nextInt();
        N = entrada.nextInt();
        if (M > N){
            indice = 0;
        } else {
            indice = 1;
        }

        if (i <= 7){
           vencedores[i] = times[i][indice];
        } else if (i <= 11){
            vencedores[i] = vencedores[i - 8 + indice + partidas_quartas];
            partidas_quartas += 1;
        } else if (i <= 13){
            vencedores[i] = vencedores[i - 4 + indice + partidas_semi];
            partidas_semi += 1;
        } else {
            vencedores[14] = vencedores[12 + indice];
        }
    }

    System.out.println(vencedores[14]);


}