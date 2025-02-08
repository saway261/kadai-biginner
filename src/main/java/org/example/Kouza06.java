package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    System.out.println(Arrays.toString(studentNames));
    System.out.println(Arrays.toString(studentNames2));
    System.out.println(studentNameList);

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

}
