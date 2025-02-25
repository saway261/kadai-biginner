package org.example.Kouza09;

import java.time.LocalDate;
import java.time.YearMonth;

public abstract class Medicine implements FirstAidKit {

  private String name;
  private int stock;//在庫
  private LocalDate expiration;//使用期限
  private String unit;// 在庫の数え方の単位

  public Medicine(String name, int stock, int expirationYear, int expirationMonth, String unit) {
    if (stock < 0) {
      throw new IllegalArgumentException("在庫 (stock) は0以上である必要があります。: " + stock);
    }
    if (expirationYear < 2000 || expirationYear > 2100) {
      throw new IllegalArgumentException("使用期限の年 (expirationYear) は 2000 以上 2100 以下である必要があります。: "
          + expirationYear);
    }
    if (expirationMonth < 1 || expirationMonth > 12) {
      throw new IllegalArgumentException("使用期限の月 (expirationMonth) は 1 以上 12 以下である必要があります。: "
          + expirationMonth);
    }
    this.name = name;
    this.stock = stock;
    this.expiration = YearMonth.of(expirationYear, expirationMonth).atEndOfMonth();
    this.unit = unit;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getStock() {
    return stock;
  }

  @Override
  public LocalDate getExpiration() {
    return expiration;
  }

  @Override
  public String getUnit() {
    return unit;
  }

  @Override
  public abstract FirstAidKit setStock(int stock);


  @Override
  public void showStock() {
    System.out.println(getName() + "の残りの在庫数は" + getStock() + getUnit() + "です。");
  }

  @Override
  public boolean isNotExpired() {
    if (LocalDate.now().isAfter(getExpiration())) {
      return false;//期限切れ
    } else {
      return true;//期限内
    }
  }

  @Override
  public void showExpiration() {
    System.out.println(
        getName() + "の使用期限は " + getExpiration().getYear() + "."
            + getExpiration().getMonthValue()
            + " です。");
  }

}
