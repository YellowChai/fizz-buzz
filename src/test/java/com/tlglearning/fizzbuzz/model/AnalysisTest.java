package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnalysisTest {
  static final Set<State> fizzExpected = EnumSet.of(State.FIZZ);
  static final Set<State> buzzExpected = EnumSet.of(State.BUZZ);


  final Analysis analysis = new Analysis();
//  private Analysis analysis;

  //everytime instance will be created anyways, so don't need to do below
//  @BeforeEach
//  void setUp() {
//    analysis = new Analysis();
//  }


  @ParameterizedTest
  @ValueSource(ints = {3, 21 ,999_999})
  void analyze_fizz(int value) {
    assertEquals(fizzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 100, 100_000})
  void analyze_buzz(int value) {
    assertEquals(buzzExpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {0,15,999_999_990})
  void analyze_fizzBuzz() {
    Set<State> expected = EnumSet.of(State.FIZZ, State.BUZZ);
    assertEquals(expected, analysis.analyze(15));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "neither.csv", numLinesToSkip = 1)
  void analyze_neither(int value) {
    Set<State> expected = EnumSet.noneOf(State.class);
    assertEquals(expected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -3, -5, -1})
  void analyze_negative(int value) {
    assertThrows(IllegalArgumentException.class, () -> analysis.analyze(value));
  }
}