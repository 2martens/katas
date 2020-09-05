package de.twomartens.katas.karateChop;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryChopTest {

    static Stream<Arguments> getTestClasses() {
        return Stream.of(
                Arguments.of(new IterativeBinaryChop()),
                Arguments.of(new RecursiveBinaryChop())
        );
    }

    @ParameterizedTest
    @MethodSource("getTestClasses")
    void shouldReturnNegativeOne_WhenListIsEmpty(BinaryChop binaryChop) {
        assertEquals(-1, binaryChop.chop(2, Collections.emptyList()));
    }

    @ParameterizedTest
    @MethodSource("getTestClasses")
    void shouldReturnNegativeOne_WhenSearchedValueNotInList(BinaryChop binaryChop) {
        assertEquals(-1, binaryChop.chop(7, List.of(1, 3, 5)));
        assertEquals(-1, binaryChop.chop(6, List.of(1, 3, 5)));
        assertEquals(-1, binaryChop.chop(2, List.of(1, 3, 5)));
        assertEquals(-1, binaryChop.chop(0, List.of(1, 3, 5)));
    }

    @ParameterizedTest
    @MethodSource("getTestClasses")
    void shouldReturnIndexOfSearchedValue_WhenSearchedValueIsInList(BinaryChop binaryChop) {
        assertEquals(0, binaryChop.chop(1, List.of(1, 3, 5)));
        assertEquals(1, binaryChop.chop(3, List.of(1, 3, 5)));
        assertEquals(2, binaryChop.chop(5, List.of(1, 3, 5)));
        assertEquals(1, binaryChop.chop(80, List.of(60, 80, 100)));
        assertEquals(1, binaryChop.chop(0, List.of(-50, 0, 50)));
        assertEquals(2, binaryChop.chop(47, List.of(-1000000, -686858, 47)));
    }

}