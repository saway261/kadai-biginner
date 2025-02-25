package org.example.Kouza12;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private List<Book> collectionOfLibrary = new ArrayList<>();
  BookNormalizer bookNormalizer = new BookNormalizer();

  public List<Book> getCollectionOfLibrary() {
    return collectionOfLibrary;
  }

  public void setCollectionOfLibrary(Book book) {
    this.collectionOfLibrary.add(book);
  }

  public void setCollectionOfLibrary(List<Book> bookList) {
    for (Book book : bookList) {
      this.collectionOfLibrary.add(book);
    }
  }

  public List<Integer> searchByTitle(String searchWord) {
    List<Book> normalizedbooks = bookNormalizer.normalizeBooks(getCollectionOfLibrary());
    String normalizedWord = bookNormalizer.normalizeText(searchWord);

    List<Integer> searchedNumbers = new ArrayList<>();
    for (Book book : normalizedbooks) {
      if (book.getTitle().contains(normalizedWord)) {
        searchedNumbers.add(book.getNumber());
      }
    }
    return searchedNumbers;
  }

  public List<Integer> searchByAuthor(String searchWord) {
    List<Book> normalizedbooks = bookNormalizer.normalizeBooks(getCollectionOfLibrary());
    String normalizedWord = bookNormalizer.normalizeText(searchWord);

    List<Integer> searchedNumbers = new ArrayList<>();
    for (Book book : normalizedbooks) {
      if (book.getAuthor().contains(normalizedWord)) {
        searchedNumbers.add(book.getNumber());
      }
    }
    return searchedNumbers;
  }

  public List<Integer> searchByNumber(int searchNumber) {
    List<Integer> searchedNumbers = new ArrayList<>();
    for (Book book : getCollectionOfLibrary()) {
      if (book.getNumber() == searchNumber) {
        searchedNumbers.add(book.getNumber());
      }
    }
    return searchedNumbers;
  }

  public void findByNumber(int number) {
    for (Book book : getCollectionOfLibrary()) {
      if (book.getNumber() == number) {
        System.out.println(
            "■タイトル：" + book.getTitle() + "\n■タイトル：" + book.getAuthor() + "\n■蔵書番号："
                + book.getNumber());
      }
    }
  }

  public void showResult(List<Integer> searchedNumbers) {
    if (searchedNumbers.isEmpty()) {
      System.out.println("条件に一致する書籍はヒットしませんでした。");
    } else {
      System.out.println(searchedNumbers.size() + "件ヒットしました。");
      for (int number : searchedNumbers) {
        findByNumber(number);
      }
    }
  }
}