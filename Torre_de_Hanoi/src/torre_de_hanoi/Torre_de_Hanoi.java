package torre_de_hanoi;

import java.io.IOException;
import java.util.Scanner;

public class Torre_de_Hanoi{
    
    public static void main(String[] args) throws IOException, InterruptedException {
        int fileira = 3, coluna=0, disc=1, ultNum;
        int[] tabuleiro;
       
        Scanner inputData = new Scanner(System.in);
        while(coluna<1){
            try{
                System.out.print("Indique o numero de discos:");
                coluna = inputData.nextInt();
                if(coluna == 0 || coluna < 0){
                    throw new Exception();
                }
            }
            catch(Exception excep){
                System.out.println("Informe apenas números maiores que 0");
                inputData.nextLine();
            }
        }
        
        tabuleiro = new int[fileira * coluna];
        
        for(int i = 0; i < fileira; i++) {
            for(int c = coluna - 1; c >= 0; c--) {
		if(i == 0) {
                    tabuleiro[coluna*i+c] = disc;
                    disc += 2;
                } 
                else {
                    tabuleiro[coluna*i+c] = 0;
		}
            }
	}
	ultNum = disc;
        for (int i = 0; i < coluna*3; ++i) System.out.println ();
	imprime(tabuleiro, fileira, coluna, ultNum);
	Thread.sleep(1000);
        hanoi(tabuleiro, fileira, coluna, coluna, ultNum, 0, 1, 2);
    }
   
    static int cont = 0;
    
    public static void contador(){
        System.out.println("Movimentos:" + cont + "\n");
        cont+=1;
        
    }
    
    public static void imprime (int[] tabuleiro, int fileira, int coluna, int ultNum) {
        int esp;
            contador();
            for(int c = coluna - 1; c >= 0; c--) {
                for(int f = 0; f < fileira; f++) {
                    esp = (ultNum - tabuleiro[coluna * f + c]) / 2;
                    for(int i = 0; i < esp; i++) {
                        System.out.print(" ");
                    }
                    for(int i = 0; i < tabuleiro[coluna * f + c]; i++) {
                        System.out.print("*");
                    }
                    for(int i = 0; i < esp; i++) {
                        System.out.print(" ");
                    }
                    System.out.print("\t");
                }
                System.out.print("\n");
            }
            for(int i=0; i <= ultNum; i++){
                System.out.print("----");
            }
            System.out.print("\n");
            for(int i=0; i <= ultNum/2; i++){
                System.out.print(" ");
            }
            System.out.print("A");
            for(int i=0; i <= ultNum/2; i++){
                System.out.print(" ");
            }
            System.out.print("|");
            for(int i=0; i <= ultNum/2; i++){
                System.out.print(" ");
            }
            System.out.print("B");
            for(int i=0; i <= ultNum/2; i++){
                System.out.print(" ");
            }
            System.out.print("|");
            for(int i=0; i <= ultNum/2; i++){
                System.out.print(" ");
            }
            System.out.print("C");
            for(int i=0; i <= ultNum/2; i++){
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    
    public static void moveDisco(int[] tabueiro, int fileira, int coluna, int ultNum, int A, int C){
        int O = coluna -1, D = coluna -1;

	while(O >= 0  &&  tabueiro[coluna*A+O] == 0){
            O--;
	}
        
	if(O < 0){
            O = 0;
        }

	while(D >= 0  &&  tabueiro[coluna*C+D] == 0){
            D--;
	}

	tabueiro[coluna*C+D+1] = tabueiro[coluna*A+O];
	tabueiro[coluna*A+O] = 0;
        imprime(tabueiro, fileira, coluna, ultNum);
    }
    
    public static void hanoi (int[] tabuleiro, int fileira, int coluna, int disc, int ultNum, int A, int B, int C) throws IOException, InterruptedException{
        if(disc==1){
            for (int i = 0; i < 50; ++i) System.out.println ();
            moveDisco(tabuleiro, fileira, coluna, ultNum, A, C);
            if(coluna<=5){
                Thread.sleep(800);
            }
            else if(coluna<=10){
                Thread.sleep(600);
            }
            else if(coluna<=15){
                Thread.sleep(200);
            }
            else if(coluna>15){
                Thread.sleep(100);
            }
        }
        else{
            hanoi(tabuleiro, fileira, coluna, disc-1, ultNum, A, C, B);
            for (int i = 0; i < 50; ++i) System.out.println ();
            moveDisco(tabuleiro, fileira, coluna, ultNum, A, C);
            if(coluna<=5){
                Thread.sleep(800);
            }
            else if(coluna<=10){
                Thread.sleep(600);
            }
            else if(coluna<=15){
                Thread.sleep(60);
            }
            else if(coluna>15){
                Thread.sleep(20);
            }
            hanoi(tabuleiro, fileira, coluna, disc-1, ultNum, B, A, C);
        }
    }
}