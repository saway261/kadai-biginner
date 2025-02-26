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

    library.setCollectionOfLibrary(List.of(book1, book2, book3));

    library.setCollectionOfLibrary(new Book("覚えておきたい！お菓子の基本　110", "関岡弘美", 4));

    System.out.println("【タイトル検索】");
    List<Integer> searchResult1 = library.searchByTitle("JAVA");
    library.showResult(searchResult1);

    System.out.println("\n【著者検索】");
    List<Integer> searchResult2 = library.searchByAuthor("湊川");
    library.showResult(searchResult2);

    System.out.println("\n【蔵書番号検索】");
    List<Integer> searchResult3 = library.searchByNumber(2);
    library.showResult(searchResult3);


  }
}

