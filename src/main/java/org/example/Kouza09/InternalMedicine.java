package org.example.Kouza09;

public class InternalMedicine extends Medicine {//内服薬

  private int singleDose;// １回服用量(錠)

  public InternalMedicine(String name, int stock, int expirationYear, int expirationMonth,
      String unit,
      int singleDose) {
    super(name, stock, expirationYear, expirationMonth, unit);
    this.singleDose = singleDose;
  }

  public int getSingleDose() {
    return singleDose;
  }

  @Override
  public FirstAidKit setStock(int stock) {
    FirstAidKit internalMedicine = new InternalMedicine(getName(), stock, getExpiration().getYear(),
        getExpiration().getMonthValue(), getUnit(), getSingleDose());
    return internalMedicine;
  }

  @Override
  public void use() {
    if (!isNotExpired()) {
      System.out.println("使用期限が切れています。");
      dispose();
    } else if (getStock() >= getSingleDose()) {
      setStock(getStock() - getSingleDose());
      System.out.println(getName() + "を" + getSingleDose() + getUnit() + "服用しました。");
    } else {
      System.out.println("薬が足りません。");
    }
  }

  //以前に購入したもので、使い切れず余っていた同じ種類の薬を、（優先的に使用する前提で）このインスタンスのstockに合算する
  public void addUpFromLastMedicine(int lastMedicineStock) {
    setStock(getStock() + lastMedicineStock);
  }


}
