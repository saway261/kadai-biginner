package org.example;

import java.time.LocalDateTime;

public class Kouza04 {

  public void calc() {
    double number1 = 5;
    double number2 = 10;

    System.out.println(number1 + number2);
    System.out.println(number1 - number2);
    System.out.println(number1 * number2);
    System.out.println(Math.round(number1
        / number2));//小数点のある値になるため、int型では正しく計算できない。Mathクラスには計算の様々なメソッドがあり、roundは四捨五入を行う。ceil-メソッドは切り上げを行う。
    System.out.println(number1 % number2);
  }

  public void textConcat() {
    String number1 = "5";
    String number2 = "10";

    System.out.println(number1 + number2);//String型の場合は結合する
  }

  public void selfIntroduction() {
    int thisYear = LocalDateTime.now().getYear();
    int birthYear;
    String familyName;
    String firstName;

    birthYear = 1999;
    familyName = "田中";
    firstName = "太郎";

    String fullName = familyName + firstName;
    int age = thisYear - birthYear;

    System.out.println("私は" + fullName + "です。年齢は" + age + "です。");
  }

}
