import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*2. Первое задание предыдущей лабораторной со следующими изменениями:
        Матрица читается с клавиатуры с помощью Scannera. Запись до файла
        сделать с помощью других потоков(не так, как вы делали в прошлый раз)
 */


public class Main {
    public void tab()  throws IOException { // метод, который записывает матрицу в текстовый файл
        Scanner scanner = new Scanner(System.in);
        System.out.println("Poczatkowa macierz: \n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("macierz"))) {
            int tab[][] = new int[4][5];
            writer.write("Macierz\n");
            writer.write("Liczba wierszy: " + tab.length + "\n");
            writer.write("Liczba kolumn: " + tab[0].length + "\n");

            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    tab[i][j] = scanner.nextInt();
                    writer.write(tab[i][j] + "  ");
                  //  System.out.printf("%2d", tab[i][j]);
                }
                scanner.close(); 
                writer.write("\r\n");
                System.out.println();

            }

            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                //    tab[i][j] = scanner.nextInt();
                //    writer.write(tab[i][j] + "  ");
                    System.out.printf("%2d", tab[i][j]);
                }
              //  writer.write("\r\n");
                System.out.println();

            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }
   public static void readTab() throws IOException{
       System.out.println("\n Macierz z pliku:  \n ");
       BufferedReader br = new BufferedReader(new FileReader("macierz"));


       String a = br.readLine();
       String b = br.readLine();
       String c = br.readLine();
       System.out.println(a + "\n" + b + "\n" + c);
       int tab[][] = new int[4][5];
       int sum = 0;

        for(int i = 0; i < 4; i++){
            String[] line = br.readLine().split("  ");
            int y = 0;
            for(String x: line){
                tab[i][y] = Integer.parseInt(x);
                sum += tab[i][y];
                y++;
            }
        }


       for (int i = 0; i < tab.length; i++) {
           for (int j = 0; j < tab[i].length; j++) {
               System.out.printf("%2d", tab[i][j]);
           }
           System.out.println();
       }
       System.out.println( "Liczba srednia:" + Float.toString(sum/(tab.length * tab[0].length)));

       br.close();


   }




        public static void main (String[]args)  throws IOException{
            Main main = new Main();//создаем объект
            main.tab();//вывод таблицы
            main.readTab();//вывод таблицы 2.0
        }
    }

