import java.io.*;

public class App {
    public static void main(String[] args){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);

        int n = 0;
        String nome = "null";
        String nomemax = "null";
        String nomemin = "null";
        float m = 0;
        int min = 1000002000;
        int max = 0;
        int n1 = 0;
        boolean parsed = false;

        while(!parsed){
            try{
                System.out.println("Inserisci su quante persone deve essere fatta l'analisi");
                String a = bf.readLine();
                checkLine(a);
                n = Integer.parseInt(a);
                parsed = true;
            }
            catch(IOException | NegativeNumberException | NumberFormatException e){
                String ex = e.toString();
                if(ex.contains("IOException"))
                    System.out.println("Errore nella sequenza di input, prego riprovare");
                else if(ex.contains("NegativeNumberException"))
                    System.out.println("Non e' possibile utilizzare un numero negativo");
                else
                    System.out.println("Non e' possibile utilizzare una lettera come numero");
                parsed = false;
            }
        }
        parsed = false;
        for(int i = 0; i < n; i++){
            while(!parsed){
                try{
                    System.out.println("Inserisci il nome della persona " + (i+1));
                    nome = bf.readLine();
                    System.out.println("Inserisci l'eta' di " + nome);
                    String a1 = bf.readLine();
                    checkLine(a1);
                    n1 = Integer.parseInt(a1);
                    parsed = true;
                }
            catch(IOException | NegativeNumberException | NumberFormatException e){
                    parsed = false;
                    String ex = e.toString();
                    if(ex.contains("IOException"))
                        System.out.println("Errore nella sequenza di input, prego riprovare");
                    else if(ex.contains("NegativeNumberException"))
                        System.out.println("Non e' possibile utilizzare un'eta' negativa");
                    else
                        System.out.println("Non e' possibile utilizzare una lettera come eta'");
                }
            }
            parsed = false;
            m = m + n1;
            if(n1 > max){
                max = n1;
                nomemax = nome;
            }
            if(n1 < min){
                min = n1;
                nomemin = nome;
            }
        }
        System.out.println("L'eta' media e' di " + (m / n) + " anni, l'eta' piu' alta e' di " + nomemax + " con " + max + " anni e l'eta' minima e' di: " + nomemin + " con " + min +" anni");
    }

    public static void checkLine(String s) throws NegativeNumberException{
        if(s.contains("-")){
            throw new NegativeNumberException();
        }
    }
}
