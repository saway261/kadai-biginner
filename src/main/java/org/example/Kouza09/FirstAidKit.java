package org.example.Kouza09;

import java.time.LocalDate;

public interface FirstAidKit {

  String getName();

  int getStock();

  LocalDate getExpiration();

  String getUnit();

  FirstAidKit setStock(int stock);

  void showStock();

  boolean isNotExpired();

  void showExpiration();

  void dispose();

  void use();

}
