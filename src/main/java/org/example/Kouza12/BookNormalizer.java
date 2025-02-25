package org.example.Kouza12;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class BookNormalizer {

  public String toHiragana(String str) {
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (c >= 'ァ' && c <= 'ン') {
        sb.append((char) (c - 'ァ' + 'ぁ')); // カタカナをひらがなに変換
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public List<Book> normalizeBooks(List<Book> bookList) {
    List<Book> normalizedList = new ArrayList<>();
    for (Book book : bookList) {
      Book normaluzedBook = new Book(normalizeText(book.getTitle()),
          normalizeText(book.getAuthor()), book.getNumber());
      normalizedList.add(normaluzedBook);
    }
    return normalizedList;
  }

  public String normalizeText(String text) {
    String normalized = Normalizer.normalize(text, Normalizer.Form.NFKC);
    normalized = toHiragana(normalized);
    normalized = normalized.toLowerCase();
    return normalized;
  }


}
