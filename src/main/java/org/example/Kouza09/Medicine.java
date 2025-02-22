package org.example.Kouza09;

import java.time.LocalDate;
import java.time.YearMonth;

public abstract class Medicine implements FirstAidKit {

  private String name;
  private int stock;//在庫
  private LocalDate expiration;//使用期限
  private String unit;// 在庫の数え方の単位

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
  public void setStock(int stock) {
    this.stock = stock;
  }


  public Medicine(String name, int stock, int expirationYear, int expirationMonth, String unit) {
    this.name = name;
    this.stock = stock;
    this.expiration = YearMonth.of(expirationYear, expirationMonth).atEndOfMonth();
    this.unit = unit;
  }

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

  @Override
  public void dispose() {
    setStock(0);
    System.out.println(this.name + "を廃棄しました。");
  }

  @Override
  public abstract void use();

}
