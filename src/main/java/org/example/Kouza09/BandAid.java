package org.example.Kouza09;

import java.time.LocalDate;
import java.time.YearMonth;

public class BandAid implements FirstAidKit {

  private String name;
  private String size;
  private int stock;//残りの枚数
  private LocalDate expiration;
  private final String unit = "枚";

  public BandAid(String name, String size, int stock, int expirationYear, int expirationMonth) {
    this.name = name;
    this.size = size;
    this.stock = stock;
    this.expiration = YearMonth.of(expirationYear, expirationMonth).atEndOfMonth();
  }

  @Override
  public String getName() {
    return name;
  }

  public String getSize() {
    return size;
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
  public FirstAidKit setStock(int stock) {
    BandAid bandAid = new BandAid(getName(), getSize(), stock, getExpiration().getYear(),
        getExpiration().getMonthValue());
    return bandAid;
  }

  @Override
  public void showStock() {
    System.out.println(
        getName() + "(" + getSize() + ")の残りの在庫数は" + getStock() + getUnit() + "です。");
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
        getName() + "(" + getSize() + ")の使用期限は " + getExpiration().getYear() + "."
            + getExpiration().getMonthValue() + " です。");
  }

  @Override
  public void dispose() {
    setStock(0);
  }


  @Override
  public void use() {
    if (!isNotExpired()) {
      System.out.println("使用期限が切れています。");
      dispose();
    } else if (getStock() > 0) {
      setStock(getStock() - 1);
      System.out.println(getName() + "を1枚使用しました。");
    } else {
      System.out.println(getName() + "はありません。");
    }
  }

}



