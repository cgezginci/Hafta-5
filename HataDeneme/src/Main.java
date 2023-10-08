import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] liste = {1,2,3,4,5,6,7,8,9,10};
        int deger;

        System.out.print("İndis değeri girin: ");
        
        try {
            deger = input.nextInt();
            System.out.println(liste[deger]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Belirtilen indiste bir eleman bulunmamaktadır.");
            System.out.println(e.toString());

        }

    }
}
