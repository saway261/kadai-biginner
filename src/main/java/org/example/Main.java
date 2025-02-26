package org.example;

import org.example.Kouza09.BandAid;
import org.example.Kouza09.FamilyMember;
import org.example.Kouza09.FirstAidKit;
import org.example.Kouza09.InternalMedicine;
import org.example.Kouza09.TopicalMedicine;

public class Main {

  public static void main(String[] args) {

    FirstAidKit bufferin = new InternalMedicine("バファリン", 1, 2027, 2, "錠",
        2);
    FirstAidKit muhi = new TopicalMedicine("ムヒアルファ", 1, 2027, 8, "本");
    FirstAidKit careleaves = new BandAid("ケアリーヴ", "M", 20, 2028, 4);

    FamilyMember hanako = new FamilyMember("花子");

    System.out.println("\n ①各アイテムの在庫を表示");
    bufferin.showStock();
    muhi.showStock();
    careleaves.showStock();

    System.out.println("\n ②各アイテムを使用");
    bufferin = hanako.useWithCheckingExpiration(bufferin);
    muhi = hanako.useWithCheckingExpiration(muhi);
    careleaves = hanako.useWithCheckingExpiration(careleaves);

    System.out.println("\n ③各アイテムの在庫を表示");
    bufferin.showStock();
    muhi.showStock();
    careleaves.showStock();

    System.out.println("\n ④各アイテムの使用期限を表示");
    bufferin.showExpiration();
    muhi.showExpiration();
    careleaves.showExpiration();

    System.out.println("\n ⑤ムヒを廃棄し、在庫を確認");
    muhi = hanako.dispose(muhi);
    muhi.showStock();


  }
}

