import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner okuyucu = new Scanner(System.in);

        // 1. Soru
        /* 「SORU」
            Aşağıdaki komutun ekran çıktısını yorumlayınız.
        */
        /* 「AÇIKLAMA」
            Normal koşullarda Math.abs() içine koyacağımız negatif bir sayının pozitif dönmesini bekleriz.
            ANCAK java'daki "int" tipi 32-bit'tir ve depolayabileceği maksimum değer 2147483647, minimum değer -2147483647'dir.
            Math.abs() içine koyduğumuz sayı int tipinin taşıyabileceği değerden büyük olduğu için taşma yaşanmıştır ve sonuç "-" işaretli çıkmıştır.
        */
        System.out.println(Math.abs(-2147483648));

        // 2. Soru
        /* 「SORU」
            API, Kütüphane, MAVEN kavramlarını yazılım geliştirirken sunduğu katkıları belirtiniz.
        */
        /* 「AÇIKLAMA」
            K
        */

        // 3. Soru
        /* 「SORU」
            Debug kavramını araştırınız. 10 kere Merhaba yazısını for döngüsü ile yazınız debug modda gözlemleyiniz.
        */
        /* 「AÇIKLAMA」
            K
        */

        // 4. Soru
        /* 「SORU」
            JOptionPane.showMessageDialog(), JOptionPane.showInputDialog() yapılarını kullanarak ekrandan girilen
            iki sayının kullanıcını secimine göre toplama, çarpma, bölme, çıkarma sonucu “JOptionPane.showMessageDialog()” gösteren programı yazınız.
        */
        /* 「AÇIKLAMA」
            Hesap makinesi 3 aşamadan oluşmaktadır. İlk aşamada 2 tane sayı istenecektir ve alınan sayılar .split metodu ile ayrılıp
            sonrasında "stringToNmbr" fonksiyonu ile
        */
        spaceForAll();
        int flag = 0;
        while (flag == 0) {
            float total = 0;
            String[] calculations = { "+ TOPLAMA", "- ÇIKARMA", "* ÇARPMA", "/ BÖLME"};
            String calculatorNmbrs = JOptionPane.showInputDialog(null, "İşlem yapmak istediğiniz 2 sayıyı aralarında boşluk olacak şekilde girin", "Hesap Makinesi",JOptionPane.WARNING_MESSAGE);
            String[] calculatorNmbrsArr = calculatorNmbrs.split(" ");
            float[] arrCalc = new float[calculatorNmbrsArr.length];
            stringToNmbr(calculatorNmbrsArr, arrCalc);

            int calculatorOption = JOptionPane.showOptionDialog(null, "Yapmak istediğiniz işlemi seçiniz", "Hesap Makinesi", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, calculations, calculations[0]);
            switch (calculatorOption) {
                case 0 -> total = arrCalc[0] + arrCalc[1];
                case 1 -> total = arrCalc[0] - arrCalc[1];
                case 2 -> total = arrCalc[0] * arrCalc[1];
                case 3 -> total = arrCalc[0] / arrCalc[1];
            }
            int calcResult = JOptionPane.showConfirmDialog(null, "İşlem Sonucu: " + total + ". İşlem yapmaya devam etmek istiyor musunuz?",
                    "Hesap Makinesi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            flag = calcResult == JOptionPane.YES_OPTION ? 0 : 1;
        }

        // 5. Soru
        /* 「SORU」
            Klavyeden alınan int türden üç sayı arasındaki büyüklük-küçüklük ilişkisini küçükten büyüğe doğru < ve = sembolleriyle gösteriniz.
        */
        /* 「AÇIKLAMA」
            Kullanıcıdan aralarına boşluklar koyarak sayılar girmesi istenecek, sayılar terminalden string olarak okunacak.
            String split yöntemi ile array'e ayrılacak, ardından array elemanları "stringToNmbr" fonsksiyonu ile sayıya dönüştürülecek.
            Sunulan sayılar "sortedArr" fonksiyonu ile küçükten büyüğe sıralanacak.
            En son sunulan sıralanmış sayılar "sortedResult" fonk ile değerlendirilip konsola yazılacak.
        */
        spaceForAll();
        System.out.print("Büyüklük-küçüklük ilişkisi ile sırlamak istediğiniz kadar sayıyı aralarında SADECE boşluk olacak şekilde giriniz:\n");
        String numbers = okuyucu.nextLine();
        String[] numbersArr = numbers.split(" ");

        float[] arr = new float[numbersArr.length];
        stringToNmbr(numbersArr, arr);
        System.out.println(sortedResult(arr));

        // 6. Soru
        /* 「SORU」
            Parametresi ile aldığı int türden 3 sayıdan ortancasına geri dönen mid isimli metodu yazınız ve test ediniz.
        */
        /* 「AÇIKLAMA」
            Kullanıcıdan aralarına boşluklar koyarak sayılar girmesi istenecek, sayılar terminalden string olarak okunacak.
            String split yöntemi ile array'e ayrılacak, ardından array elemanları "stringToNmbr" fonsksiyonu ile sayıya dönüştürülecek.
            Sunulan sayılar "sortedArr" fonksiyonu ile küçükten büyüğe sıralanacak.
            En son sunulan sayıların ortanca değeri "mid" fonk ile hesaplanıp konsola yazılacak.
        */
        spaceForAll();
        System.out.print("Ortanca sayılarının hesaplanması için istediğiniz kadar sayıyı aralarında SADECE boşluk olacak şekilde giriniz:\n");
        String midNmbrs = okuyucu.nextLine();
        String[] midArr = midNmbrs.split(" ");

        float[] arr2 = new float[midArr.length];
        stringToNmbr(midArr, arr2);
        System.out.println(mid(arr2));

        // 7. Soru
        /* 「SORU」
            Parametresi ile aldığı int türden bir sayının negatif mi, 0(sıfır) mı, pozitif mi olduğunu test eden signum isimli metodu yazınız
            ve test ediniz. Metot pozitif için 1(bir), negatif için -1(eksi bir) ve sıfır için 0(sıfır)döndürecektir.
        */
        /* 「AÇIKLAMA」
            Kullanıcıdan tek bir sayı istenecek, sayı terminalden string olarak okunacak.
            Sayıya göre 1,0,-1 döndürülebilmesi için "signum" fonk kullanılacak, fonksiyona verilecek parametre sayıya dönüştürülecek.
        */
        spaceForAll();
        System.out.print("İstediğiniz sayıyı giriniz. Sayı pozitifse 1, negatifse -1, sıfırsa 0 döndürülecek:\n");
        String signumNmr = okuyucu.nextLine();
        System.out.println(signum(Integer.parseInt(signumNmr)));

        // 8. Soru
        /* 「SORU」
            Klavyeden bir n sayısı okuyunuz ve aşağıdaki deseni oluşturan programı yazınız.
        */
        /* 「AÇIKLAMA」
            K
        */
        spaceForAll();
        baklavaMaker(3);

        // 9. Soru
        /* 「SORU」
            Parametresi ile aldığı long türden saniye cinsinden süreyi saat, dakika ve saniye olarak ayrıştırarak ekrana yazdıran
            displayDuratioon isimli metodu yazınız. Eğer saat, dakika ya da saniye değeri 0(sıķr) ise ekrana yazdırılmayacaktır.
        */
        /* 「AÇIKLAMA」
            K
        */
        spaceForAll();
        displayDuration(4000);

        // 10. Soru
        /* 「SORU」
            Bir sayının asal çarpanlarını yazdıran programı yazınız.
        */
        /* 「AÇIKLAMA」
            K
        */
        spaceForAll();
        int primeNmbr = 12;
        int[] primeArr = primeArrCreator(10);
        for (int primeNmbrs : primeArr) System.out.println(primeNmbrs);

        // 11. Soru
        /* 「SORU」
            Klavyeden bir height ve width değişkenleri için sayılar okuyunuz ve aşağıdaki deseni oluşturunuz:
        */
        /* 「AÇIKLAMA」
            K
        */
        spaceForAll();
        int width = 10, height = 15;
        int aimToWidth = 0;

        while (height > 0) {
            if (aimToWidth < width) {
                for (int k = width; k > 0; k--) {
                    if (height > 0) System.out.println("|" + " ".repeat(aimToWidth) + "*" + " ".repeat(width - aimToWidth) + "|");
                    else break;
                    aimToWidth++;
                    height--;
                }
            } else {
                for (int k = width; k > 0; k--) {
                    if (height > 0) System.out.println("|" + " ".repeat(aimToWidth) + "*" + " ".repeat(width - aimToWidth) + "|");
                    else break;
                    aimToWidth--;
                    height--;
                }
            }
        }
        // 12. Soru
        /* 「SORU」
            2’den büyük tüm çift sayılar iki asal sayının toplamı biçiminde yazılabilir (Goldbach teoremi).
            Klavyeden bir çift sayı alan ve bunu iki asal sayının toplamı biçiminde yazdıran programı yazınız.
        */
        /* 「AÇIKLAMA」
            K
        */
    }

    public static void spaceForAll() {
        /* 「AÇIKLAMA」
            Farklı sorular arasında boşluk bırakmak için kullanılıyor.
        */
        System.out.println("\n");
    }

    public static float[] stringToNmbr(String[] arrString, float[] arrNmbr) {
        /* 「AÇIKLAMA」
            Bu fonksiyon verilen array'in elemanlarını String'den int'e çevirir
        */
        for (int i = 0; i < arrString.length; i++) arrNmbr[i] = Float.parseFloat(arrString[i]);
        return arrNmbr;
    }

    public static float[] sortedArr(float[] arr) {
        /* 「AÇIKLAMA」
            Bu fonksiyon verilen array'i küçükten büyüğe sıralar
        */
        for (int i = 1; i < arr.length; i++) {
            for (int k = 0; k < i; k++) {
                if (arr[i] < arr[k]) {
                    float x = arr[i];
                    arr[i] = arr[k];
                    arr[k] = x;
                }
            }
        }
        return arr;
    }

    public static String sortedResult(float[] arr) {
        /* 「AÇIKLAMA」
            Bu fonksiyon verilmiş bir arrayin elemanları arasında gidip gelerek aralarındaki ilişkiyi bulur.
            Doğru çalışması için parametresine girilen arrayi "sortedArr" fonksiyonunu çağırarak küçükten büyüğe sıralatır.
        */
        arr = sortedArr(arr);
        String outputText = arr[0] + " ";
        for (int i = 0; i < arr.length - 1; i++) outputText += (arr[i + 1] != arr[i] ? "<" : "=") + " " + arr[i + 1] + " ";
        return outputText;
    }

    public static String mid(float[] arr) {
        /* 「AÇIKLAMA」
            Bu fonksiyon verilmiş bir arrayin ortanca sayılarını verir. Array uzunluğu tek ise tek bir ortanca sayı, çift ise iki ortanca sayı gönderir.
            Doğru çalışması için parametresine girilen arrayi "sortedArr" fonksiyonunu çağırarak küçükten büyüğe sıralatır.
        */
        arr = sortedArr(arr);
        return "Ortanca sayı" + (arr.length % 2 == 1 ? " " + arr[arr.length / 2] : "lar " + arr[arr.length / 2 - 1] + " ve " + arr[arr.length / 2]);
    }

    public static int signum(int number) {
        /* 「AÇIKLAMA」
            Bu fonksiyon verilmiş bir sayının değerine göre değer gönderir.
            Sayı sıfır ise 0, negatif ise -1, pozitif ise 1 gönderilir.
        */
        if (number == 0) return 0;
        else if (number < 0) return -1;
        else return 1;
    }

    public static void baklavaMaker(int number) {
        /* 「AÇIKLAMA」
            Bu fonksiyon parametreye verilen değere göre baklava şeklinde bir desen oluşturur.
            Desenin iki yanına değer-1-i (loop tarafından yönetilen değer) kadar boşluk, ortasında i*2-1 tane yıldız(*) işareti yazılır.
            Desenin ortasında gelindikten sonra alt tarafını yapmak için yeni bir loop'a geçilir ve aynı işlemler geriye sayan k ile tekrarlanır.
        */
        for (int i = 0; i < number; i++) {
            if (i == number - 1) {
                for (int k = number - 1; k >= 0 ; k--) System.out.println(" ".repeat(number-1-k) + "*".repeat(k * 2 + 1) + " ".repeat(number-1-k));
            } else System.out.println(" ".repeat(number-1-i) + "*".repeat(i * 2 + 1) + " ".repeat(number-1-i));
        }
    }

    public static void displayDuration(int duration) {
        /* 「AÇIKLAMA」
            Bu fonksiyon parametreye girilen SANİYE CİNSİNDEN değeri saat, dakika ve saniye gibi parçalarına ayırır.
            Eğer sayı 3600 saniyeden büyük eşit ise 1 saatten uzun bir süre olduğu için while döngümüz dengeye girer. Her döngü aat için atadığımız "hr" değerine 1 ekler.
            ve parametreye girilen değerin kopyasından 3600 çıkarır. Döngünün benzeri değiştirilmiş değerler ile dakika için de yapılır.
            Sonuç terminale yazılır. Eğer saat, dakika veya saniye değerleri 0 ise yazılmaz.
        */
        long hr = 0, mn = 0, copyDuration = duration;
        while (copyDuration >= 3600) {
            hr += 1;
            copyDuration -= 3600;
        }
        while (copyDuration >= 60) {
            mn += 1;
            copyDuration -= 60;
        }
        System.out.println((hr > 0 ? hr + "sa " : "") + (mn > 0 ? mn + "dk " : "") + (copyDuration > 0 ? copyDuration + "sn " : ""));
    }

    public static boolean primeChecker(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static int[] primeArrCreator(int count) {
        int[] arr = new int[count];
        for (int i = 0; i <= count; i++) {
            if (primeChecker(i)) arr[i] = i;
        }
        return arr;
    }
}