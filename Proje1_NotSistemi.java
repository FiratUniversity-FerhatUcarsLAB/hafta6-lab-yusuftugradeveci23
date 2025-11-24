//Adı Soyadı: Yusuf Tuğra Deveci
//Öğrenci No:250541095
//Tarih:24.11.2025
//Açıklama:Bu Java programı, öğrencinin vize, final ve ödev notlarını kullanarak dönem sonu ortalamasını hesaplayan bir not hesaplama uygulamasıdır.
//Program, ilk olarak kullanıcıdan üç farklı not bilgisi alır ve calculateAverage metodu ile bu notların ağırlıklı ortalamasını hesaplar.
//Ardından, öğrencinin aldığı ortalamaya göre harf notu getLetterGrade metodu ile belirlenir.
//Program ayrıca öğrencinin dersi geçip geçmediğini, onur listesine girip girmediğini ve bütünleme sınavına girme hakkı olup olmadığını ilgili kontrol metotları (isPassingGrade, isHonorList, hasRetakeRight) aracılığıyla değerlendirir.
//Sonuç olarak tüm bilgiler ekrana yazdırılarak kullanıcıya detaylı bir not değerlendirme çıktısı sunulur.


import java.util.Scanner;

public class ortalamaHesaplama {

    public static double calculateAverage(double vize, double finalNotu, double odev) {
        return vize * 0.3 + finalNotu * 0.4 + odev * 0.3;
    }

    public static boolean isPassingGrade(double ortalama) {
        return ortalama >= 50;
    }
    public static boolean isHonorList(double ortalama,double vize, double finalNotu, double odev) {
        return ortalama>=85 && vize>=70 && finalNotu>=70 && odev>=70;
    }
    public static boolean hasRetakeRight(double ortalama) {
        return ortalama >= 40 && ortalama < 50;
    }


    public static char getLetterGrade(double ortalama) {
        if (ortalama >= 90) {
            return 'A';
        } else if (ortalama >= 80) {
            return 'B';
        } else if (ortalama >= 70) {
            return 'C';
        } else if (ortalama >= 60) {
            return 'D';
        } else {
            return 'E';
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        // Ortalama


        System.out.print("Vize notunuzu giriniz: ");
        double vize = input.nextDouble();

        System.out.print("Final notunuzu giriniz: ");
        double finalNotu = input.nextDouble();

        System.out.print("Ödev notunuzu giriniz: ");
        double odev = input.nextDouble();

        double ortalama = calculateAverage(vize, finalNotu, odev);
        System.out.printf("Ortalama: %.2f%n", ortalama);
        //Harf Notu
        char harfNotu = getLetterGrade(ortalama);
        System.out.println("Harf Notunuz: " + harfNotu);
        //Geçme-Kalma
        System.out.println("Durum: " + (isPassingGrade(ortalama) ? "Geçtiniz" : "Kaldınız"));
        System.out.println("Onur Listesi: " + (isHonorList(ortalama, vize, finalNotu, odev) ? "EVET" : "HAYIR"));
        System.out.println("Bütünleme Hakkı: " + (hasRetakeRight(ortalama) ? "VAR" : "YOK"));
    }
}



//Çıktısı:Vize notunuzu giriniz: 80
//Final notunuzu giriniz: 90
//Ödev notunuzu giriniz: 95
//Ortalama: 88,50
//Harf Notunuz: B
//Durum: Geçtiniz
//Onur Listesi: EVET
//Bütünleme Hakkı: YOK

//Process finished with exit code 0
