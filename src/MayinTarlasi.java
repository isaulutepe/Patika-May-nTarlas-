import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    public static void main(String[] args) {
        int[][] oyunAlani;
        Scanner scan=new Scanner(System.in);
        System.out.print("Lütfen satır sayısını giriniz : ");
        int satir=scan.nextInt();
        System.out.print("Lütfen sütün sayısını giriniz : ");
        int sutun=scan.nextInt();

        oyunAlani=new int[satir][sutun];  //2-2 ise 4 eleman olacaktır.
        //Eleman sayısınınn çeyreği kadar mayın eklenmeli
        int mayinSayisi= (satir*sutun)/4;
        Random rnd=new Random();

        for (int i = 0; i<mayinSayisi; i++) {
            int rndSatir = rnd.nextInt(satir);
            int rndSutun = rnd.nextInt(sutun);

            while (oyunAlani[rndSatir][rndSutun] == '*') { //Aynı konumda mayın varsa tekrar sayı üret.
                rndSatir = rnd.nextInt(satir);
                rndSutun = rnd.nextInt(sutun);
            }
            // Mayını oyun alanına ekle
            oyunAlani[rndSatir][rndSutun] = '*';
        }
        // Oyun alanını yazdır
        System.out.println("mayın konumları : ");
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print(oyunAlani[i][j] == '*' ? "* " : "- ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");

        int girilenSatir;
        int girilenSutun;
        do {
            System.out.print("Bir satır girin : ");
            girilenSatir =scan.nextInt();
            System.out.print("Bir sütün giriniz : ");
            girilenSutun=scan.nextInt();

            System.out.println("---------------------------");

            if (oyunAlani[girilenSatir][girilenSutun]=='*'){
                System.out.println("Game Over");
            }
            else {
                int rndSayi = rnd.nextInt(10);
                oyunAlani[girilenSatir][girilenSutun] = rndSayi;
            }
        }while(oyunAlani[girilenSatir][girilenSutun] !='*');

    }

}
