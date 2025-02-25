package org.example.Kouza12;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private List<Book> collectionOfLibrary = new ArrayList<>();

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
}
