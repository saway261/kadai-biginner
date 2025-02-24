package org.example;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    Kouza10 kouza10 = new Kouza10();
    List<String> randomStringList = kouza10.setRandomStringList();
    kouza10.pickUpOnlyNumber(randomStringList);
    kouza10.pickUpOnlyUpperCaseAlphabetAndNumber(randomStringList);
    kouza10.pickUpOnlyJapanese(randomStringList);
    kouza10.pickUpNotNumberAndAlphabet(randomStringList);


  }


}

