package Pegasus.Main;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    String[] Cards = {
        "Two-Hearts", "Two-Tiles", "Two-Clovers", "Two-Pikes",
        "Three-Hearts", "Three-Tiles", "Three-Clovers", "Three-Pikes",
        "Four-Hearts", "Four-Tiles", "Four-Clovers", "Four-Pikes",
        "Five-Hearts", "Five-Tiles", "Five-Clovers", "Five-Pikes",
        "Six-Hearts", "Six-Tiles", "Six-Clovers", "Six-Pikes",
        "Seven-Hearts", "Seven-Tiles", "Seven-Clovers", "Seven-Pikes",
        "Eight-Hearts", "Eight-Tiles", "Eight-Clovers", "Eight-Pikes",
        "Nine-Hearts", "Nine-Tiles", "Nine-Clovers", "Nine-Pikes",
        "Ten-Hearts", "Ten-Tiles", "Ten-Clovers", "Ten-Pikes",
        "Jack-Hearts", "Jack-Tiles", "Jack-Clovers", "Jack-Pikes",
        "Queen-Hearts", "Queen-Tiles", "Queen-Clovers", "Queen-Pikes",
        "King-Hearts", "King-Tiles", "King-Clovers", "King-Pikes",
        "Ace-Hearts", "Ace-Tiles", "Ace-Clovers", "Ace-Pikes"
    };
    int[] Value = {2, 2, 2, 2,
        3, 3, 3, 3,
        4, 4, 4, 4,
        5, 5, 5, 5,
        6, 6, 6, 6,
        7, 7, 7, 7,
        8, 8, 8, 8,
        9, 9, 9, 9,
        10, 10, 10, 10,
        2, 2, 2, 2,
        3, 3, 3, 3,
        4, 4, 4, 4,
        11, 11, 11, 11};
    List<Integer> fill = new ArrayList<Integer>();
    for (int i = 0; i < 52; i++) {
      fill.add(i);
    }
    Collections.shuffle(fill);
    int Pscore = 0;
    int Bscore = 0;
    int Pchoise;
    int Bchoise;
    int random;
    int k = 0;
    Scanner str = new Scanner(System.in);
    int question;
    while (k <= 35) {

      Pchoise = fill.get(2 * k);
      Bchoise = fill.get(2 * k + 1);
      //System.out.println("TestK = "+k);
      //System.out.println("TestB = "+Bchoise);
      //System.out.println("TestP = "+Pchoise);
      Pscore = Pscore + Value[Pchoise];
      Bscore = Bscore + Value[Bchoise];
      System.out.println(Cards[Pchoise] + " = " + Value[Pchoise]);
      System.out.println("Score = " + Pscore);
      if (Pscore > 21) {
        System.out.println("You loose");
        break;

      }
      if (Bscore > 21) {
        System.out.println("You Win");
        System.out.println("Dealer`s score is " + Bscore);
        break;

      }

      System.out.println("One more card? (0 is No)");
      question = str.nextInt();

      if (question == 0) {
        random = (int) (Math.random() * 2);
        if (random == 1) {
          Bchoise = fill.get(2 * k + 2);
          Bscore = Bscore + Value[Bchoise];
        }

        if (Pscore > 21) {
          System.out.println("You loose");
          break;

        }
        if (Bscore > 21) {
          System.out.println("You Win");
          System.out.println("Dealer`s score is " + Bscore);
          break;

        }

        if (Pscore > Bscore) {
          System.out.println("You win");
          System.out.println("Dealer`s score is " + Bscore);
        } else if (Pscore < Bscore && Bscore <= 21) {
          System.out.println("Dealer`s score is " + Bscore);
          System.out.println("Dealer win");
        } else if (Pscore == Bscore) {
          System.out.println("Draw");
          System.out.println("Dealer`s score is " + Bscore);
        }

        break;
      }
      k++;
    }
  }
}
