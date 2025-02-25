package org.example.Kouza09;

public class FamilyMember {

  private String name;

  public String getName() {
    return name;
  }

  public FamilyMember(String name) {
    this.name = name;
  }

  public FirstAidKit dispose(FirstAidKit item) {
    switch (item) {
      case InternalMedicine internalMedicine -> {
        System.out.println(
            getName() + "は、" + internalMedicine.getName() + "を捨てた");
        return internalMedicine.setStock(0);
      }
      case TopicalMedicine topicalMedicine -> {
        System.out.println(
            getName() + "は、" + topicalMedicine.getName() + "を捨てた");
        return topicalMedicine.setStock(0);
      }
      case BandAid bandAid -> {
        System.out.println(
            getName() + "は、" + bandAid.getName() + "を捨てた");
        return bandAid.setStock(0);
      }
      default -> {
        System.out.println(
            getName() + "は、" + item.getName() + "を捨てた");
        return item.setStock(0);
      }
    }
  }

  FirstAidKit reduceStockByUsingItem(
      FirstAidKit item) { //mainから使用期限の確認なしで呼び出されないように、アクセス制御はパッケージプライベート

    switch (item) {

      case InternalMedicine internalMedicine -> {
        try {
          InternalMedicine medi = (InternalMedicine) internalMedicine.setStock(
              internalMedicine.getStock() - internalMedicine.getSingleDose()); //TODO:なぜキャスト必要？
          System.out.println(getName() + "は、" + internalMedicine.getName() + "を"
              + internalMedicine.getSingleDose() + internalMedicine.getUnit() + "飲んだ");
          return medi;
        } catch (IllegalArgumentException e) {
          System.out.println("薬の在庫が必要量より少ない。");
          return internalMedicine;
        }
      }

      case TopicalMedicine topicalMedicine -> {
        System.out.println(getName() + "は、" + topicalMedicine.getName() + "を使った");
        return topicalMedicine;
      }

      case BandAid bandAid -> {
        try {
          BandAid band = (BandAid) bandAid.setStock(bandAid.getStock() - 1); //TODO:なぜキャスト必要？
          System.out.println(getName() + "は、" + bandAid.getName() + "を1枚使った");
          return band;
        } catch (IllegalArgumentException e) {
          System.out.println("ばんそうこうがもうない。");
          return bandAid;
        }
      }

      default -> {
        System.out.println(getName() + "は、" + item.getName() + "を使った");
        return item;
      }
    }

  }

  public FirstAidKit useWithCheckingExpiration(FirstAidKit item) {

    if (!item.isNotExpired()) {
      System.out.println("使用期限が切れている。");
      return dispose(item);
    } else {
      return reduceStockByUsingItem(item);
    }
  }


}
