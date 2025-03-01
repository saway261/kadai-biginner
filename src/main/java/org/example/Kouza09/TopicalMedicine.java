package org.example.Kouza09;

public class TopicalMedicine extends Medicine {//外用薬

  public TopicalMedicine(String name, int stock, int expirationYear, int expirationMonth,
      String unit) {
    super(name, stock, expirationYear, expirationMonth, unit);
  }

  @Override
  public TopicalMedicine setStock(int stock) {
    TopicalMedicine topicalMedicine = new TopicalMedicine(getName(), stock,
        getExpiration().getYear(),
        getExpiration().getMonthValue(), getUnit());
    return topicalMedicine;
  }

}
