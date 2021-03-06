import java.util.Arrays;

import java.util.Random;

import java.util.Scanner;

    public class MastermindTeste {



        public static String[] inputArray(int input){
            String inputString = Integer.toString(input);
            String[] inputSplitted  = inputString.split("(?!^)");
            return inputSplitted;
        }

        public static String[] pwGenerator(){
            Random random = new Random();
            String[] pwGenerated = new String[4];
            int aux;
            String auxS;
            for (int i = 0; i < 4; i++) {
                aux = random.nextInt(6) + 1;
                auxS = Integer.toString(aux);
                pwGenerated[i] = auxS;
            }
            return pwGenerated;
        }

        public static int verificarDigitosCorretos(String[] senhaGerada, String[] inputUsuario){
            int digitosCorretos = 0;

            for (int i = 0; i < senhaGerada.length; i++) {
                for (int j = 0; j < senhaGerada.length; j++) {
                    if(i == j){
                        if(inputUsuario[j].equals(senhaGerada[i])){
                            digitosCorretos++;
                        }
                    }
                }
            }

            return digitosCorretos;
        }

        public static int verificarDigitosDeslocados(String[] senhaGerada, String[] inputUsuario){

            int digitosDeslocados = 0;

            for (int i = 0; i < senhaGerada.length; i++) {
                for (int j = 0; j < senhaGerada.length; j++) {
                    if(i != j){
                        if(inputUsuario[j].equals(senhaGerada[i])){
                            digitosDeslocados++;
                        }
                    }
                }
            }
            return digitosDeslocados;

        }

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int input;
            int tentativas = 1;

            String[] pwGame = pwGenerator();

            System.out.println("===--===--===--===--===--===--===--===--===--===");
            System.out.println("                 MASTERMIND                     ");
            System.out.println("===--===--===--===--===--===--===--===--===--===");




            while(tentativas<=10) {

                System.out.println("Try: " + tentativas);

                input = sc.nextInt();
                String[] senhaUser = inputArray(input);

                System.out.println("Correct digits " + verificarDigitosCorretos(pwGame, senhaUser));
                System.out.println("Out of place digits " + verificarDigitosDeslocados(pwGame, senhaUser));
                System.out.println("\n");

                if(verificarDigitosCorretos(pwGame, senhaUser)==4){
                    System.out.println("Gtz, you made it!");
                    break;
                }
                tentativas++;
            }

            System.out.println("---===Correct Password===---");
            System.out.println(Arrays.toString(pwGame));

        }
}
