//Adı Soyadı: Yusuf Tuğra Deveci
//Öğrenci No:250541095
//Tarih:24.11.2025
//Açıklama:Bu Java programı, sinema bileti fiyatını çeşitli koşullara göre hesaplayan bir bilet hesaplama uygulamasıdır.
//Kullanıcıdan gün, saat, yaş, meslek ve film formatı bilgileri alınarak bilet fiyatı dinamik şekilde belirlenir.
//Program önce seçilen güne ve seans saatine göre temel bilet fiyatını calculateBasePrice metodu ile hesaplar.
// Daha sonra yaş, meslek ve gün bilgilerine göre indirim oranı calculateDiscound metodu ile belirlenir
//. Film formatına bağlı ek ücret ise getFormatExtra metodu ile eklenir.
//Tüm bu değerler calculatefinalPrice fonksiyonunda birleştirilerek nihai ödenecek tutar hesaplanır.
//Son olarak program, seçilen günün hafta içi mi hafta sonu mu olduğunu, seansın matine olup olmadığını ve tüm fiyat detaylarını kullanıcıya gösterir.
//Böylece her duruma göre doğru bileti hesaplayan kapsamlı bir sistem oluşturulmuştur.


import java.util.Scanner;
public class Bilethesaplama {
    public static boolean isWeekend(int gun) {
        return (gun == 6 || gun == 7);
    }

    public static boolean isMatinee(int saat) {
        return (saat < 12);
    }

    public static int calculateBasePrice(int gun, int saat) {
        if (isWeekend(gun)) {
            if (isMatinee(saat)) {
                return 55;
            } else {
                return 85;
            }
        } else {
            if (isMatinee(saat)) {
                return 45;
            } else {
                return 65;
            }
        }
    }

    public static double calculateDiscound(int yas, int meslek, int gun) {
        double discount = 0;
        //65+ yaş indirimi
        if (yas >= 65) {
            discount = 30;
       //12 yaş altı
        }else if(yas<12){
        discount=25;
        //Öğretmen ve çarşamba
        }else if(meslek==2&&gun==3){
            discount=35;
        }//öğrenci indirimleri
        else if(meslek==1){
          if(gun>=1&&gun<=4){
              discount=20;
          }
          else{
              discount=15;
          }
        }
        else{
            discount=0;
        }
     return discount;
    }
    public static int getFormatExtra(int filmTuru){
        int extra = 0;
     switch(filmTuru){
         case 1:
             extra = 0;
             break;
          case 2:
             extra = 25;
             break;
         case 3:
             extra = 35;
             break;
         case 4:
             extra = 50;
             break;
         default:
              extra= 0;
     }
     return extra;
    }
    public static double calculatefinalPrice(int temelFiyat,double discount,int extra){
        double fiyat = temelFiyat-(temelFiyat*discount/100)+extra;
        return fiyat;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Günü girin(1-7):");
        int gun=input.nextInt();
        System.out.print("Saati girin(0-23):");
        int saat=input.nextInt();
        System.out.print("Yaşınızı giriniz:");
        int yas=input.nextInt();
        System.out.print("Meslek girin:1-Öğrenci 2-Öğretmen 3-Diğer");
        int meslek=input.nextInt();
        System.out.println("Film Türünü Seçiniz:1-Normal 2-3D 3-IMAX 4-IMAX 3D");
        int filmTuru=input.nextInt();


        int temelFiyat=calculateBasePrice(gun,saat);
        double indirim=calculateDiscound(yas,meslek,gun);
        int extra=getFormatExtra(filmTuru);
        double finalPrice=calculatefinalPrice(temelFiyat,indirim,extra);


        String weekendText=isWeekend(gun)?"Hafta Sonu":"Hafta İçi";
        String matineText=isMatinee(saat)?"Matine":"Normal saat";

        System.out.println(".................");
        System.out.println("Gün:"+weekendText);
        System.out.println("Seans:"+matineText);
        System.out.println("Temel Fiyat:"+temelFiyat+"TL");
        System.out.println("İndirim:"+indirim+"%");
        System.out.println("Format Ücreti:"+extra+"TL");
        System.out.println(".................");
        System.out.println("Ödenecek Son Tutar:"+finalPrice+"TL");

    }
}


//Çıktısı:Günü girin(1-7):2
//Saati girin(0-23):10
//Yaşınızı giriniz:18
//Meslek girin:1-Öğrenci 2-Öğretmen 3-Diğer1
//Film Türünü Seçiniz:1-Normal 2-3D 3-IMAX 4-IMAX 3D
//1
//.................
//Gün:Hafta İçi
//Seans:Matine
//Temel Fiyat:45TL
//İndirim:20.0%
//Format Ücreti:0TL
//.................
//Ödenecek Son Tutar:36.0TL

//Process finished with exit code 0
