package de.twomartens.katas.karateChop;

import java.util.List;

public class IterativeBinaryChop implements BinaryChop {
    @Override
    public int chop(int searchedValue, List<Integer> list) {
        int lowerBound = 0;
        int upperBound = list.size() - 1;
        while (lowerBound <= upperBound) {
            int middleIndex = (int) Math.floor((lowerBound + upperBound) / 2.0);
            int middleIndexValue = list.get(middleIndex);
            if (middleIndexValue < searchedValue) {
                lowerBound = middleIndex + 1;
            } else if (middleIndexValue > searchedValue) {
                upperBound = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
