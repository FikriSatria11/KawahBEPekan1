import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class Kalkulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("Selamat Datang di Kalkulator");
            System.out.println("Silahkan pilih operasi matematika yang Anda inginkan");
            System.out.println("1. Penjumlahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Sisa Bagi");
            System.out.print("Pilih : ");
            int select = scan.nextInt();
            System.out.print("Masukkan bilangan pertama : ");
            int firstNumber = scan.nextInt();
            System.out.print("Masukkan bilangan kedua : ");
            int secondNumber = scan.nextInt();
            switch(select){
                case 1:
                    penjumlahan(firstNumber, secondNumber);
                    break;
                case 2:
                    pengurangan(firstNumber, secondNumber);
                    break;
                case 3:
                    perkalian(firstNumber, secondNumber);
                    break;
                case 4:
                    if(secondNumber==0){
                        System.out.println("Tidak bisa membagi dengan nol");
                    }else{
                        pembagian(firstNumber, secondNumber);
                    }
                    break;
                case 5:
                    modulo(firstNumber, secondNumber);
                    break;
                default:
                    System.out.println("Pilih angka 1 s/d 5");
            }
            System.out.println("Apakah Anda ingin menggunakan kalkulator lagi ? (y/n) ");
            String repeat = scan.next();
            if(!(repeat.equalsIgnoreCase("y"))){
                System.out.println("Kalkulator Shutdown");
                scan.close();
                loop = false;
            }
        }
    }

    public static void penjumlahan(int firstNumber, int secondNumber){
        int result = firstNumber+secondNumber;
        saveFile("Hasil penjumlaha dari "+firstNumber+" dan "+secondNumber+" adalah "+result);
    }
    public static void pengurangan(int firstNumber, int secondNumber){
        int result = firstNumber-secondNumber;
        saveFile("Hasil pengurangan dari "+firstNumber+" dan "+secondNumber+" adalah "+result);
    }
    public static void perkalian(int firstNumber, int secondNumber){
        int result = firstNumber*secondNumber;
        saveFile("Hasil perkalian dari "+firstNumber+" dan "+secondNumber+" adalah "+result);
    }
    public static void pembagian(int firstNumber, int secondNumber){
        float result = (float)firstNumber/(float)secondNumber;
        saveFile("Hasil pembagian dari "+firstNumber+" dan "+secondNumber+" adalah "+result);
    }
    public static void modulo(int firstNumber, int secondNumber){
        int result = firstNumber%secondNumber;
        saveFile("Hasil sisa bagi dari "+firstNumber+" dan "+secondNumber+" adalah "+result);
    }

    public static void saveFile(String result){
        System.out.println(result);
        try {
            FileWriter myWriter = new FileWriter("result.txt");
            myWriter.write(result);
            myWriter.close();
            System.out.println("Sukses menyimpan hasil dalam file result.txt");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}