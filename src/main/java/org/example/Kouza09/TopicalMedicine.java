package org.example.Kouza09;

public class TopicalMedicine extends Medicine {//外用薬

  public TopicalMedicine(String name, int stock, int expirationYear, int expirationMonth,
      String unit) {
    super(name, stock, expirationYear, expirationMonth, unit);
  }

  @Override
  public void use() {
    if (!isNotExpired()) {
      System.out.println("使用期限が切れています。");
      dispose();
    } else {
      System.out.println(getName() + "を使用しました。");
    }
  }

}
