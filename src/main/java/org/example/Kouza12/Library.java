package org.example.Kouza12;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private List<Book> books = new ArrayList<>();
  BookNormalizer bookNormalizer = new BookNormalizer();

  public List<Book> getBooks() {
    return books;
  }

  public void addBooks(Book newBook) {
    for (Book existingBook : getBooks()) {
      if (existingBook.getNumber() == newBook.getNumber()) {
        throw new IllegalArgumentException(
            "同じ番号の書籍がすでに存在します: " + newBook.getNumber());
      }
    }
    this.books.add(newBook);
  }

  public void addBooks(List<Book> newBookList) {
    for (Book newBook : newBookList) {
      addBooks(newBook);
    }
  }

  public List<Integer> searchByTitle(String searchWord) {
    List<Book> normalizedBooks = bookNormalizer.normalizeBooks(getBooks());
    String normalizedWord = bookNormalizer.normalizeText(searchWord);

    List<Integer> searchedNumbers = new ArrayList<>();
    for (Book book : normalizedBooks) {
      if (book.getTitle().contains(normalizedWord)) {
        searchedNumbers.add(book.getNumber());
      }
    }
    return searchedNumbers;
  }

  public List<Integer> searchByAuthor(String searchWord) {
    List<Book> normalizedbooks = bookNormalizer.normalizeBooks(getBooks());
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
    for (Book book : getBooks()) {
      if (book.getNumber() == searchNumber) {
        searchedNumbers.add(book.getNumber());
      }
    }
    return searchedNumbers;
  }

  public Book findByNumber(int number) {
    for (Book book : getBooks()) {
      if (book.getNumber() == number) {
        return book;
      }
    }
    return null;
  }

  public void showSearchResult(List<Integer> searchedNumbers) {
    if (searchedNumbers.isEmpty()) {
      System.out.println("条件に一致する書籍はヒットしませんでした。");
    } else {
      System.out.println(searchedNumbers.size() + "件ヒットしました。");
      for (int number : searchedNumbers) {
        Book book = findByNumber(number);
        System.out.println(
            "■タイトル：" + book.getTitle() + "\n■著者名：" + book.getAuthor() + "\n■蔵書番号："
                + book.getNumber() + "\n");
      }
    }
  }
}
