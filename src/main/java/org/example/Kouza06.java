package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Kouza06 {

  public void loopSum() {
    int sum = 0;
    for (int i = 0; i <= 100; i++) {//i++,i--,++i,--i などがある
      sum += i;//sum = sum + i;と同じ意味
    }
    System.out.println(sum);
  }

  public void testNameListAndArray() {

    String[] studentNames = new String[]{"江並", "井上", "佐藤", "加藤", "田中"};//配列
    //配列の要素数はnewした段階で固定長。もし要素数を増やしたい場合は、また別のもっと大きな配列を作り、そこに元の配列の要素をひとつずつ格納していくしかない。↓
    String[] studentNames2 = new String[]{studentNames[0], studentNames[1], studentNames[2],
        studentNames[3], studentNames[4], "岡田"};

    System.out.println(studentNames2);//このままだと人間に読める形で出力されない
    System.out.println(Arrays.toString(studentNames2));//リストのような形で出力されるように変換

    //配列は要素を追加するときに面倒なので、要素数が変わる可能性があるものはListを使うと良い
    List<String> studentNameList = new ArrayList<>(Arrays.asList(
        studentNames));//Arrays.asList:配列変数studentNamesの中身をそのままリストに変換してstudentNameListに格納する
    studentNameList.add("岡田");

    System.out.println(studentNameList);

    studentNames[0] = "渡辺";//もとの配列studentNamesの要素を書き換えるとどうなるのか
    System.out.println(Arrays.toString(studentNames));//書き換わる
    System.out.println(Arrays.toString(studentNames2));//書き換わらない
    System.out.println(studentNameList);//書き換わらない

    Map<Integer, String> studentNameMap1 = Map.of(1, "江並", 2, "井上", 3, "佐藤", 4, "加藤");
    Map<Integer, List<String>> studentNameMap2 = Map.of(1, List.of("江並", "公史"), 2,
        List.of("井上", "太郎"));
    System.out.println(studentNameMap1);
    System.out.println(studentNameMap2);

    for (String name : studentNameList) {//拡張for文
      if (name.equals("江並")) {
        System.out.println(name);
      }
    }
    //ネストしないように、最初から条件に合ったものだけをリストに入れると読みやすいコードになる

    int number = 10;//switch文
    switch (number) {
      case 1 -> System.out.println(1);
      case 2 -> System.out.println(2);
      case 3 -> System.out.println(3);
      default -> System.out.println(10);
    }
  }

  public void studyArray() {
    int[] arrayA = {1, 2, 3};
    int[] arrayB;
    arrayB = arrayA;
    arrayB[0] = 100;
    System.out.println(arrayA[0]);

    /*『スッキリわかるJava入門 第4版』より
    45行目でarrayB[0]を100に置き換えても、もとのarrayA[0]には影響なく、46行目は「1」が出力されそうだが、実際には「100」が出力される。
    配列変数は参照型であるため、arrayAとarrayBは共に「arrayAのデータが格納されているメモリ上の最初の要素のアドレス」を持っている。
    このため、arrayB[0] = 100;はarrayAとarrayBが共に参照しているメモリの実際の中身を書き換えており、arrayAにとっての0番目の要素も書き換えられてしまう。
     */
  }

  //課題１：生徒名みたいな文字列のリストを作る。リストの数は10個以上。リストに入っている文字が３文字以上のものを表示する。このリストをループさせて繰り返し処理を実装し、その中で条件を満たすものだけを表示する
  //課題２：Mapを作る。生徒名と番号の組み合わせ。Mapの要素は１０個以上Mapの中の番号から偶数のものをMapから削除する。この処理を行う繰り返し処理を実装する。削除した状態のものを出力して表示

  public void showNames() {//課題１
    List<String> cityNameList = List.of("札幌", "仙台", "さいたま", "千葉", "川崎", "横浜",
        "相模原", "新潟", "静岡", "浜松", "名古屋", "京都", "大阪", "堺", "神戸", "岡山", "広島",
        "北九州", "福岡", "熊本");

    for (String cityName : cityNameList) {
      if (cityName.length() >= 3) {
        System.out.println(cityName);
      }
    }
  }

  public void removeMap() {
    Map<Integer, String> cityNameMap = new HashMap<>();//HashMapは可変長

    cityNameMap.put(1, "富山");
    cityNameMap.put(2, "金沢");
    cityNameMap.put(3, "福井");
    cityNameMap.put(4, "松本");
    cityNameMap.put(5, "岐阜");
    cityNameMap.put(6, "富士");
    cityNameMap.put(7, "沼津");
    cityNameMap.put(8, "豊橋");
    cityNameMap.put(9, "岡崎");
    cityNameMap.put(10, "一宮");
    cityNameMap.put(11, "津");
    cityNameMap.put(12, "大津");
    cityNameMap.put(13, "宇治");
    cityNameMap.put(14, "東大阪");
    cityNameMap.put(15, "豊中");
    cityNameMap.put(16, "高槻");
    cityNameMap.put(17, "枚方");
    cityNameMap.put(18, "吹田");
    cityNameMap.put(19, "八尾");
    cityNameMap.put(20, "姫路");
    cityNameMap.put(21, "尼崎");
    cityNameMap.put(22, "西宮");
    cityNameMap.put(23, "明石");
    cityNameMap.put(24, "奈良");
    cityNameMap.put(25, "和歌山");
    cityNameMap.put(26, "倉敷");
    cityNameMap.put(27, "福山");
    cityNameMap.put(28, "下関");
    cityNameMap.put(29, "徳島");
    cityNameMap.put(30, "高松");
    cityNameMap.put(31, "松山");
    cityNameMap.put(32, "高知");
    cityNameMap.put(33, "久留米");
    cityNameMap.put(34, "大牟田");
    cityNameMap.put(35, "長崎");
    cityNameMap.put(36, "熊本");
    cityNameMap.put(37, "大分");
    cityNameMap.put(38, "宮崎");
    cityNameMap.put(39, "鹿児島");

    Iterator<Entry<Integer, String>> it = cityNameMap.entrySet()
        .iterator();//Mapはコレクションインターフェースではないため直接イテレータを呼び出せない。

    while (it.hasNext()) {
      if (it.next().getKey() % 2 == 0) {
        it.remove();
      }
    }
    System.out.println(cityNameMap);

  }


}
