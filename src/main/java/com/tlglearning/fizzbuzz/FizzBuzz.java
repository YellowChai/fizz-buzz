package com.tlglearning.fizzbuzz;

import com.tlglearning.fizzbuzz.model.Analysis;
import com.tlglearning.fizzbuzz.model.State;
import java.util.Set;
import org.apache.commons.cli.Options;

public class FizzBuzz {

  private static final int DEFAULT_UPPER_BOUND = 100;

  public static void main(String[] args) {
    try {
      int upperBound =  (args.length > 0 ) ? Integer.parseInt(args[0]) : DEFAULT_UPPER_BOUND;
      System.out.println(args[0]);
      if (upperBound < 1 ) {
        throw new IllegalArgumentException();
      }
      Analysis analysis = new Analysis();
      for (int counter = 1; counter <= upperBound; counter++ ) {
        Set<State> result = analysis.analyze(counter);
        System.out.println(result.isEmpty() ? counter : result);
      }
    } catch (IllegalArgumentException e) {
      System.out.printf("Usage: java %1$s [upperBound]%n", FizzBuzz.class.getName());
      System.out.println("Where: upperBound is a positive integer, with a default of 100");
      throw new RuntimeException("FizzBuzz halted!", e);
    } finally {
      System.out.println("Thanks for play FizzBuzz!");
    }
  }
}
