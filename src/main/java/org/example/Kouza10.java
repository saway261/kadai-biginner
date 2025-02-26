package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Kouza10 extends Object {
// 正規表現
  /*
  `リストにランダムな文字列を30個ほど入れる。
  その文字列のリストに対して、正規表現を使って以下の条件の文字を抜き出す
  ・数字だけ　　　　　　
  ・英数字の大文字だけ　・日本語だけ
  ・英数字以外の文字
   */

  String regex;

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }

  public List<String> setRandomStringList() {
    List<String> randomStringList = new ArrayList<>();

    randomStringList.add("k馬5Vレ四oc/f&[ヘとoZvよ9千6u/モ:");
    randomStringList.add("水ちみ虎雨火ヌもEルきBコXLクモxvrBあA5j");
    randomStringList.add("龍2fち1イY金シU馬<ちやいHWのoいX山五rへ");
    randomStringList.add("Cワ_京zDえc雷nひ金*hろ千6アrウD水xはく");
    randomStringList.add("n!i七たRト千s.万0フ0とやyK馬+馬メオgR");
    randomStringList.add("34ノF四シまNWいW3十pBgつkヨxせい+月え");
    randomStringList.add("{雷す1V6をTレひksTハbヒ千兆nf_@z田ぬ");
    randomStringList.add("こLk牛8オとFMTテ}月も27O3九レqノす;c");
    randomStringList.add("e]雪-ネ6qめg3u<け!木Qシ4IP5ニO九]");
    randomStringList.add("Cシ92ヤ9む海H5りHきわ日3サニ猫jn(Iヒ9");
    randomStringList.add("8千レELルおエ8Lきqk雷[XijもHウヲ六花ナ");
    randomStringList.add(",(をZ)acTZな_Fエ海Nア草308日{火ミK");
    randomStringList.add("ら3クい兆京5メNS3O4IコCむFB{lにソロ日");
    randomStringList.add("0い虎zむ{guヒ一iネ万Psお0草:.ヒカ雨KJ");
    randomStringList.add("テD木ヲ馬き1S5兆rsを5TUてDサ/2]^^h");
    randomStringList.add("[馬jね月ハ3$sム六d,Vか雷i鳥$jヒidとm");
    randomStringList.add("P1lヤふ7Y0/ア千九,九gIコ^^tをてcvq");
    randomStringList.add("わb9%$HX九かV木もセ@[風Jp風六かkGhオ");
    randomStringList.add("ヘnMかイ雪ウ雨q=Ddフc1#6b四yX木ちう*");
    randomStringList.add("2わちO牛GGち九7!七6rぬlxeオdりつ)Qを");
    randomStringList.add("W2にbトて億YFc魚zそセユxQ木cヨ牛ねTヤ_");
    randomStringList.add("tg70Aj田へたカカ,t猫/lL)^!Cミ雪千A");
    randomStringList.add("F虎ソ6C|R-よDおサ4雪う<三コY猫0ロD一K");
    randomStringList.add("zOW6テ田M7NぬをキzタhWろ1Jセの8魚てち");
    randomStringList.add("TYO;iV魚0o八セいjとテテウQ>たや5W三馬");
    randomStringList.add("WH&き(9リ5をLヌ]BFメ草二#猫x魚360キ");
    randomStringList.add("ヨ61雪ンリ京sBをT日レBowdコあc3あ^鳥モ");
    randomStringList.add("つよの馬一bGケ十U木ニieル猫ネ2dんりdv|g");
    randomStringList.add("ハつ龍xIトエaワせN]4魚VnKX4DみG7いい");
    randomStringList.add("#4百$魚Pフ龍風rタ{_Bwk5QlヘぬニめG土");

    return randomStringList;

  }

  public void pickUpOnlyNumber(List<String> randomStringList) {
    System.out.println("【正規表現を使って数字のみを抜き出す】");
    setRegex("\\d+");

    List<Integer> numbers = randomStringList.stream()
        .flatMap(str -> {
          Matcher matcher = Pattern.compile(getRegex()).matcher(str);
          List<String> matches = new ArrayList<>();
          while (matcher.find()) {
            matches.add(matcher.group());
          }
          return matches.stream();
        })
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    System.out.println(numbers);
  }

  public void pickUpOnlyUpperCaseAlphabetAndNumber(List<String> randomStringList) {
    System.out.println("【正規表現を使って英数字の大文字のみを抜き出す】");
    setRegex("[A-Z0-9]+");

    List<String> upperCases = randomStringList.stream()
        .flatMap(str -> {
          Matcher matcher = Pattern.compile(getRegex()).matcher(str);
          List<String> matches = new ArrayList<>();
          while (matcher.find()) {
            matches.add(matcher.group());
          }
          return matches.stream();
        })
        .collect(Collectors.toList());

    System.out.println(upperCases);
  }

  public void pickUpOnlyJapanese(List<String> randomStringList) {
    System.out.println("【正規表現を使って日本語のみを抜き出す】");
    setRegex(
        "[\\p{Script=Hiragana}\\p{Script=Katakana}\\p{Script=Han}]+");//あるいは”[\u3040-\u309F\u30A0-\u30FF\u4E00-\u9FFF]+”

    List<String> upperCases = randomStringList.stream()
        .flatMap(str -> {
          Matcher matcher = Pattern.compile(getRegex()).matcher(str);
          List<String> matches = new ArrayList<>();
          while (matcher.find()) {
            matches.add(matcher.group());
          }
          return matches.stream();
        })
        .collect(Collectors.toList());

    System.out.println(upperCases);
  }

  public void pickUpNotNumberAndAlphabet(List<String> randomStringList) {
    System.out.println("【正規表現を使って英数字以外を抜き出す】");
    setRegex("[^0-9a-zA-Z]+");

    List<String> upperCases = randomStringList.stream()
        .flatMap(str -> {
          Matcher matcher = Pattern.compile(getRegex()).matcher(str);
          List<String> matches = new ArrayList<>();
          while (matcher.find()) {
            matches.add(matcher.group());
          }
          return matches.stream();
        })
        .collect(Collectors.toList());

    System.out.println(upperCases);
  }


}
