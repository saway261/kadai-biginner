package org.example;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class Kouza05 {

  //データ型
  char c = 'a';//シングルクォーテーションで囲む
  String name = "aiu";

  byte num1 = 123; //-128から127
  short num2 = 1234;
  int num3 = 12345;
  long num4 = 123456;
  float num5 = 1.234F;//末尾のFはfloat型のリテラル。float型である（double型ではない）ことを明示するために必要
  double num6 = 123.456;

  BigDecimal num7 = BigDecimal.valueOf(10);
  BigDecimal num8 = BigDecimal.valueOf(100);//精密な計算が求められるものに使用する

  //int sum = num7 + num8;
  //はできない

  boolean bool = true;//or false

  Integer num9 = 10;
  Double num10 = 100.2;
  Boolean bool2 = false;
  //ラッパー型（参照型）。基本型と違いは、nullが扱えるか。また、メソッドを持っているので便利。

  //標準API　java.langパッケージに入っている機能
  LocalDateTime date1 = LocalDateTime.now();//ここのタイムゾーンに従う
  ZonedDateTime date2 = ZonedDateTime.now();//地域を指定して、そこのタイムゾーンに準ずる


  public void calc() {
    System.out.println(num7.add(num8));

  }

//  課題
//  文字列型を使って、変数を２つ用意する。その変数には苗字と名前を入れてください。
//  条件は苗字の文字数が２文字以上の場合　かつ　名前の文字数が２文字以上の場合はtrue
// 条件がtrueのときはその名前を表示する。
//条件がfalseの場合は条件に一致しませんでしたという文言を表示する

  public void showFullName(String familyName, String firstName) {
    String fullName = familyName + firstName;

    if (familyName.length() >= 2 && firstName.length() >= 2) {
      System.out.println(fullName);
    } else {
      System.out.println("条件に一致しませんでした。");
    }
  }


}
