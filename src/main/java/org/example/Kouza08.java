package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Kouza08 {

  public void inputAndOutput1() {

    try {
      Path path = Path.of("JavaCourse.txt");
      Files.writeString(path, "Javaコース楽しい！");//writeStringメソッド：ファイル名を指定して、ファイル名を作成して書き込む。
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("例外が発生した");
    }
  }

  public void inputAndOutput2() {//try-with-resource文

    try {
      Path path = Path.of("JavaCourse.txt");
      Files.writeString(path, "Javaコース楽しすぎる！！", StandardOpenOption.APPEND);//書き加える
      System.out.println(Files.readString(path));
    } catch (IOException e) {
      System.out.println("例外が発生した");
      e.printStackTrace();
    }
  }

  public void tryCatchFinally() {
    FileWriter fw = null;
    try {
      fw = new FileWriter("data.txt");
      fw.write("hello!");
    } catch (Exception e) {
      System.out.println("何らかの例外が発生しました。");
    } finally {
      if (fw != null) { //fwがnullのときはファイルを開けていないので、閉じる操作をしなくてよい
        try {
          fw.close();
        } catch (IOException e) {
          ; // ファイルを閉じられなかったときにできる対処はないため、空文にする
        }
      }
    }
  }

  /*課題
  入出力を実際に実装して、作ったファイルに文章を追加する。
  その作ったファイルを削除してもう一度実行すると例外になるので、その例外をキャッチして例外処理を行う。
  また、キャッチした中でさらにファイルに書き込もうとして例外になった場合、どうなるのかを確認する。
   */

  public void kadai1() {
    Path path = Path.of("JavaHappy.txt");
    try {
      Files.writeString(path, "Java大好き！！", StandardOpenOption.APPEND);//書き加える
      System.out.println(Files.readString(path));
    } catch (IOException e) {
      System.out.println("例外が発生した");
      e.printStackTrace();

      try {
        Files.writeString(path, "Java大好き！！",
            StandardOpenOption.APPEND);//catchブロックの中でもういちど例外が発生しうる実装をするとコンパイルエラーになる
      } catch (IOException f) {
        f.getMessage();
      }
    }
  }

}
