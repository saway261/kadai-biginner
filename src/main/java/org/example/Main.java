package org.example;

import java.util.List;
import org.example.Kouza12.Book;
import org.example.Kouza12.Library;

public class Main {

  public static void main(String[] args) {

    Library library = new Library();

    Book book1 = new Book("スッキリわかるJava入門　第4版", "中山清喬／国本大悟", 1);
    Book book2 = new Book("わかばちゃんと学ぶ　Gitの使い方入門", "湊川あい", 2);
    Book book3 = new Book("楽々ERDレッスン", "羽生章洋", 3);
    Book book4 = new Book("名前が語るお菓子の歴史", "ニナ・バルビエ, エマニュエル・ペレ", 4);
    Book book5 = new Book("すっきり暮らすために持たないもの、やめたこと", "主婦の友社", 5);

    library.addBooks(List.of(book1, book2, book3, book4, book5));

    library.addBooks(new Book("覚えておきたい！お菓子の基本　110", "関岡弘美", 6));

    System.out.println("【タイトル検索】");
    List<Integer> searchResult1 = library.searchByTitle("の");
    library.showSearchResult(searchResult1);

    System.out.println("\n【著者検索】");
    List<Integer> searchResult2 = library.searchByAuthor("湊川");
    library.showSearchResult(searchResult2);

    System.out.println("\n【蔵書番号検索】");
    List<Integer> searchResult3 = library.searchByNumber(6);
    library.showSearchResult(searchResult3);
  }
}

