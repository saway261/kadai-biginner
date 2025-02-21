package org.example.Kouza09;

import java.time.LocalDate;
import java.time.YearMonth;

public abstract class Medicine implements FirstAidKit {

  protected String name;
  protected int stock;//在庫
  protected LocalDate expiration;//使用期限
  protected String unit;// 在庫の数え方の単位

  public Medicine(String name, int stock, int expirationYear, int expirationMonth, String unit) {
    this.name = name;
    this.stock = stock;
    this.expiration = YearMonth.of(expirationYear, expirationMonth).atEndOfMonth();
    this.unit = unit;
  }

  @Override
  public void showStock() {
    System.out.println(this.name + "の残りの在庫数は" + this.stock + this.unit + "です。");
  }

  @Override
  public boolean isNotExpired() {
    if (LocalDate.now().isAfter(this.expiration)) {
      return false;//期限切れ
    } else {
      return true;//期限内
    }
  }

  @Override
  public void showExpiration() {
    System.out.println(
        this.name + "の使用期限は " + this.expiration.getYear() + "."
            + this.expiration.getMonthValue()
            + " です。");
  }

  @Override
  public void dispose() {
    this.stock = 0;
    System.out.println(this.name + "を廃棄しました。");
  }

  @Override
  public abstract void use();

}
