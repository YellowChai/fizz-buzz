package com.tlglearning.fizzbuzz.model;

import java.util.EnumSet;
import java.util.Set;

public class Analysis {

    public static final String ILLEGAL_VALUE_FORMAT = "Value was $,d; must be non-negative.";

    /**
     *
     * @param value
     * @return
     * @throws IllegalArgumentException if {@code value < 0}.
     */
    public Set<State> analyze(int value) throws IllegalArgumentException {

        if (value < 0) {
            throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_FORMAT, value));
        }

        Set<State> result = EnumSet.noneOf(State.class);

        if (value % 3 == 0) {
            result.add(State.FIZZ);
        }

        if (value % 5 == 0) {
            result.add(State.BUZZ);
        }

        return result;
    }

}
