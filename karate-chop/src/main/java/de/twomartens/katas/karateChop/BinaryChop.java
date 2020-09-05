package de.twomartens.katas.karateChop;

import java.util.List;

public interface BinaryChop {
    int chop(int searchedValue, List<Integer> list);
    default boolean isOdd(int value) {
        return (value % 2) != 0;
    }

    default int getLowerBoundOfUpperHalf(int listSize) {
        return isOdd(listSize) ? (listSize + 1) / 2 : listSize / 2;
    }
}
