package org.example.Kouza09;

public class InternalMedicine extends Medicine {//内服薬

  private int singleDose;// １回服用量(錠)

  public InternalMedicine(String name, int stock, int expirationYear, int expirationMonth,
      String unit,
      int singleDose) {
    super(name, stock, expirationYear, expirationMonth, unit);
    this.singleDose = singleDose;
  }

  @Override
  public void use() {
    if (!this.isNotExpired()) {
      System.out.println("使用期限が切れています。");
      this.dispose();
    } else if (this.stock >= this.singleDose) {
      this.stock -= this.singleDose;
      System.out.println(this.name + "を" + this.singleDose + this.unit + "服用しました。");
    } else {
      System.out.println("薬が足りません。");
    }
  }


}
