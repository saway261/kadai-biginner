package org.example;

import org.example.Kouza09.BandAid;
import org.example.Kouza09.FirstAidKit;
import org.example.Kouza09.InternalMedicine;
import org.example.Kouza09.Medicine;
import org.example.Kouza09.TopicalMedicine;

public class Main {

  public static void main(String[] args) {

    FirstAidKit bufferin = new InternalMedicine("バファリン", 24, 2027, 2, "錠",
        2);
    FirstAidKit muhi = new TopicalMedicine("ムヒアルファ", 1, 2027, 8, "本");
    FirstAidKit careleaves = new BandAid("ケアリーヴ", "M", 20, 2028, 4);

    System.out.println("【インターフェースが宣言した抽象メソッドのみ】");
    System.out.println("\n ①各アイテムの在庫を表示");
    bufferin.showStock();
    muhi.showStock();
    careleaves.showStock();

    System.out.println("\n ②各アイテムを使用");
    bufferin.use();
    muhi.use();
    careleaves.use();

    System.out.println("\n ③各アイテムの在庫を表示");
    bufferin.showStock();
    muhi.showStock();
    careleaves.showStock();

    System.out.println("\n ④各アイテムの使用期限を表示");
    bufferin.showExpiration();
    muhi.showExpiration();
    careleaves.showExpiration();

    System.out.println("\n ⑤ムヒを廃棄し、在庫を確認");
    muhi.dispose();
    muhi.showStock();

    System.out.println(
        "\n \n 【InternalMedicineのみが持っているメソッドを親クラス・インターフェースなどから呼び出してみる】");

    FirstAidKit biofermin1 = new InternalMedicine("ビオフェルミン", 2, 2026, 5, "錠", 3);
    Medicine biofermin2 = new InternalMedicine("ビオフェルミン", 2, 2026, 5, "錠", 3);
    InternalMedicine biofermin3 = new InternalMedicine("ビオフェルミン", 2, 2026, 5, "錠", 3);

    biofermin1.use();

    InternalMedicine biofermin4 = new InternalMedicine("ビオフェルミン", 550, 2026, 5, "錠", 3);

    System.out.println(
        "addUpFromLastMedicineメソッドで、先に生成したインスタンスの在庫の残りを、後に生成したインスタンスに合算する。");
    //biofermin4.addUpFromLastMedicine(biofermin1.getStock());//FirstAidKit型のbiofermin1はgetStockを呼び出せない。
    //biofermin4.addUpFromLastMedicine(biofermin2.getStock());//Medicine型のbiofermin2はgetStockを呼び出せない。
    biofermin4.addUpFromLastMedicine(
        biofermin3.getStock());//InternalMedicine型のbiofermin3はgetStockを呼び出すことができる。

    biofermin4.showStock();


  }


}

