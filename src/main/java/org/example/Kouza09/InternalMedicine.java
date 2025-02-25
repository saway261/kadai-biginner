package org.example.Kouza09;

public class InternalMedicine extends Medicine {//内服薬

  private int singleDose;// １回服用量(錠)

  public InternalMedicine(String name, int stock, int expirationYear, int expirationMonth,
      String unit, int singleDose) {
    super(name, stock, expirationYear, expirationMonth, unit);
    if (singleDose < 1) {
      throw new IllegalArgumentException(
          "1回服用量 (singleDose) は1以上である必要があります。: " + singleDose);
    }
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

  //以前に購入したもので、使い切れず余っていた同じ種類の薬を、（優先的に使用する前提で）このインスタンスのstockに合算する
  public void addUpFromLastMedicine(int lastMedicineStock) {
    setStock(getStock() + lastMedicineStock);
  }


}
