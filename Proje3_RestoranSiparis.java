//Adı Soyadı: Yusuf Tuğra Deveci
//Öğrenci No:250541095
//Tarih:24.11.2025
//Açıklama:Bu Java programı, bir restoranda müşterinin seçtiği yemeklere göre toplam hesap tutarını detaylı şekilde hesaplayan bir yemek menüsü uygulamasıdır.
//Program; ana yemek, başlangıç, içecek ve tatlı seçimlerine göre ilgili fiyatları belirleyen metotlar içerir. Kullanıcı seçim yaptıktan sonra toplam tutar oluşturulur.
//Ardından combo menü durumu, Happy Hour (14–17 arası), öğrenci indirimi ve 200 TL üzeri alışveriş indirimi gibi çeşitli indirimler calculateDiscound metodu ile hesaplanır.
//Ek olarak program, indirim uygulandıktan sonra hesap üzerinden %10 servis ücreti (bahşiş) hesaplar.
//Son olarak toplam ödenecek tutar, seçilen ürünlerin fiyatları, uygulanan indirim ve servis ücreti ile birlikte ayrıntılı şekilde kullanıcıya gösterilir.
//Bu sayede program, restoran sipariş fiyatlandırmasını gerçekçi kurallarla modelleyen kapsamlı bir hesaplama sistemi sunmaktadır.


import java.util.Scanner;
public class yemekMenüsü {
    // Ana Yemekler
    public static int getMainDishPrice(int secim) {
        int fiyat = 0;
        switch (secim) {
            case 1:
                fiyat = 85;
                break;
            case 2:
                fiyat = 120;
                break;
            case 3:
                fiyat = 110;
                break;
            case 4:
                fiyat = 65;
                break;
            default:
                fiyat = 0;
                break;
        }
        return fiyat;
    }

    //Başlangıçlar
    public static int getAppetizerPrice(int secim) {
        int fiyat = 0;
        switch (secim) {
            case 1:
                fiyat = 25;
                break;
            case 2:
                fiyat = 45;
                break;
            case 3:
                fiyat = 55;
                break;
            default:
                fiyat = 0;
        }
        return fiyat;
    }
    //İçecekler
    public static int getDrinkPrice(int secim) {
        int fiyat = 0;
        switch (secim) {
            case 1:
            fiyat=15;
            break;
            case 2:
             fiyat=12;
             break;
             case 3:
             fiyat=35;
             break;
             case 4:
              fiyat=25;
              break;
              default:
              fiyat = 0;
              break;
        }
        return fiyat;
    }
       // Tatlılar
    public static int getDessertPrice(int secim) {
        int fiyat = 0;
        switch (secim) {
            case 1:
                fiyat = 65;
                break;
                case 2:
                    fiyat = 55;
                    break;
                    case 3:
                        fiyat = 35;
                        break;
                        default:
                            fiyat = 0;
                            break;
        }
        return fiyat;
    }
    public static boolean isComboOrder(int ana,int icecek,int tatli) {
    boolean combo=false;
    if(ana>0&&icecek>0&&tatli>0) {
        combo=true;
    }
    return combo;
    }
    public static boolean happyHour(int saat){
        boolean happyHour=false;
        if(saat>=14&&saat<=17){
            happyHour=true;
        }
        return happyHour;
    }
    public static double calculateDiscound(double tutar,boolean combo, boolean ogrenci,boolean happyHour,int gun){
     double indirim=0;
        if(combo){
        indirim+=tutar*0.15;
     }
        if(tutar>200){
         indirim+=tutar*0.10;
        }
        if(happyHour){
          indirim+=tutar*0.20;
        }
        if(ogrenci&&gun>=1&&gun<=5){
            indirim+=tutar*0.10;
        }
        return indirim;
    }
    public static double calculateSercice(double tutar){
        return  tutar*0.10;
    }
    public static boolean isStudent(int meslek){
      int meslek1=0;
      switch(meslek){
          case 1:
              return true;
      }
      return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ana Yemekler:1=Izgara Tavuk,2=Adana Kebap,3=Levrek,4=Mantı");
        System.out.print("Seçiminiz:");
        int ana=input.nextInt();


        System.out.println("Başlangıçlar: 1=Çorba, 2=Humus, 3=Sigara Böreği");
        System.out.print("Seçiminiz: ");
        int baslangic = input.nextInt();


        System.out.println("İçecekler: 1=Kola, 2=Ayran, 3=Taze Meyve Suyu, 4=Limonata");
        System.out.print("Seçiminiz: ");
        int icecek = input.nextInt();



        System.out.println("Tatlılar: 1=Künefe, 2=Baklava, 3=Sütlaç");
        System.out.print("Seçiminiz: ");
        int tatli = input.nextInt();


        System.out.print("Saati Giriniz(0-23):");
        int saat = input.nextInt();
        System.out.print("Günü Giriniz(1-7):");
        int gun=input.nextInt();

        System.out.print("Meslek seçimi (1=Öğrenci, 2=Diğer): ");
        int meslek = input.nextInt();
        boolean ogrenci = isStudent(meslek);


        int anaFiyat = getMainDishPrice(ana);
        int baslangicFiyat = getAppetizerPrice(baslangic);
        int icecekFiyat = getDrinkPrice(icecek);
        int tatliFiyat = getDessertPrice(tatli);


        boolean combo = isComboOrder(ana, icecek, tatli);
        boolean hh = happyHour(saat);


        int Toplamtutar = anaFiyat + baslangicFiyat + icecekFiyat + tatliFiyat;

        double indirim = calculateDiscound(Toplamtutar, combo, ogrenci, hh, gun);

        double bahsis = calculateSercice(Toplamtutar - indirim);

        double odenecek = (Toplamtutar - indirim) + bahsis;


        System.out.printf("Ana Yemek Fiyatı: %d TL%n", anaFiyat);
        System.out.printf("Başlangıç Fiyatı: %d TL%n", baslangicFiyat);
        System.out.printf("İçecek Fiyatı: %d TL%n", icecekFiyat);
        System.out.printf("Tatlı Fiyatı: %d TL%n", tatliFiyat);
        System.out.printf("Uygulanacak İndirim: %.2f TL%n", indirim);
        System.out.printf("Verilecek Bahşiş: %.2f TL%n", bahsis);
        System.out.printf("Toplam Tutar: %.2f TL%n", odenecek);









    }
}

//Çıktısı:Ana Yemekler:1=Izgara Tavuk,2=Adana Kebap,3=Levrek,4=Mantı
//Seçiminiz:2
//Başlangıçlar: 1=Çorba, 2=Humus, 3=Sigara Böreği
//Seçiminiz: 1
//İçecekler: 1=Kola, 2=Ayran, 3=Taze Meyve Suyu, 4=Limonata
//Seçiminiz: 2
//Tatlılar: 1=Künefe, 2=Baklava, 3=Sütlaç
//Seçiminiz: 1
//Saati Giriniz(0-23):19
//Günü Giriniz(1-7):6
//Meslek seçimi (1=Öğrenci, 2=Diğer): 1
//Ana Yemek Fiyatı: 120 TL
//Başlangıç Fiyatı: 25 TL
//İçecek Fiyatı: 12 TL
//Tatlı Fiyatı: 65 TL
//Uygulanacak İndirim: 55,50 TL
// Bahşiş: 16,65 TL
//Toplam Tutar: 183,15 TL

//Process finished with exit code 0


