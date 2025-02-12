import java.util.Scanner;
public class Conteggio_numeri{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            int N = scanner.nextInt();

            if(N==0){
                break;
            }

            Stampariga(N);
        }
    }
    public static void Stampariga(int N){
        if(N%2==0){
            System.out.print(N + ":");
            for(int i=0; i<N; i++){
                System.out.print("*");
            }

        }
        else{
            System.out.print(N + ":");
            for(int i=0; i<N; i++){
                System.out.print("#");
            }
        }
        System.out.println();
    }
}




