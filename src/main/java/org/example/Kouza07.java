package org.example;

import java.util.List;

public class Kouza07 {

  List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  List<String> studentList = List.of("enami", "inoue", "tanaka");

  //forループを回す場合
  public void showNumbersByLoop() {
    for (int number : numberList) {
      if (number <= 5) {
        System.out.println(number);
      }
    }
  }

  public void showElementByStream() {
    numberList.stream()
        .mapToInt(number -> number).filter(number -> number <= 5)
        .forEach(System.out::println);

    studentList.stream()
        .map(v -> v.toUpperCase())//マッピングをする。大文字に変換
        .forEach(System.out::println);

    studentList.stream()
        .sorted()
        .forEach(System.out::println);
  }

  /*課題１
  10個の要素を持つ文字列のリストを作る。そのリストの中から文字列が２以上のものを抽出して、カンマ区切りの文字列に変換したものをコンソールに出力する
   */
  public void kadai1() {
    List<String> japaneseFlowers = List.of("桜", "梅", "藤", "紫陽花", "片栗", "山百合", "竜胆",
        "桔梗", "撫子", "菫");

    japaneseFlowers.stream()
        .filter(e -> e.length() >= 2)
        .forEach(System.out::println);

  }

  /*課題２
  １０個の要素を持つ数値のリストを作る。その数値の中から奇数のものだけを抽出して平均値を出力する。
   */
  public void kadai2() {
    List<Integer> numList = List.of(169, 170, 176, 150, 164, 191, 196, 173, 158, 168);
    System.out.println(numList.stream()
        .filter(num -> num % 2 == 1)
        .mapToInt(num -> num)
        .average()
        .orElse(0)
    );
  }

}
