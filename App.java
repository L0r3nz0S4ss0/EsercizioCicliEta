import java.io.*;

public class App {

    public static void clearConsole(){
        try{
            final String os = System.getProperty("os.name");
            
            if (os.contains("Windows")){
                Runtime.getRuntime().exec("cls");
            }
            else{
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e){

        }
    }
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
                n = Integer.parseInt(a);
                parsed = true;
                clearConsole();
            }
            catch(Exception e){
                parsed = false;
                System.out.println("ERRORE, VALORE NON VALIDO, RIPROVARE");
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
                    n1 = Integer.parseInt(a1);
                    parsed = true;
                    clearConsole();
                }
                catch(Exception e){
                    parsed = false;
                    System.out.println("ERRORE, VALORE NON VALIDO, RIPROVARE");
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
}
