package org.example.Kouza09;

import java.time.LocalDate;
import java.time.YearMonth;

public class BandAid implements FirstAidKit {

  protected String name;
  protected String size;
  protected int stock;//残りの枚数
  protected LocalDate expiration;
  protected final String unit = "枚";

  public BandAid(String name, String size, int stock, int expirationYear, int expirationMonth) {
    this.name = name;
    this.size = size;
    this.stock = stock;
    this.expiration = YearMonth.of(expirationYear, expirationMonth).atEndOfMonth();
  }

  @Override
  public void showStock() {
    System.out.println(
        this.name + "(" + this.size + ")の残りの在庫数は" + this.stock + this.unit + "です。");
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
        this.name + "(" + this.size + ")の使用期限は " + this.expiration.getYear() + "."
            + this.expiration.getMonthValue() + " です。");
  }

  @Override
  public void dispose() {
    this.stock = 0;
  }


  @Override
  public void use() {
    if (!this.isNotExpired()) {
      System.out.println("使用期限が切れています。");
      this.dispose();
    } else if (this.stock > 0) {
      this.stock -= 1;
      System.out.println(this.name + "を1枚使用しました。");
    } else {
      System.out.println(this.name + "はありません。");
    }
  }

}



