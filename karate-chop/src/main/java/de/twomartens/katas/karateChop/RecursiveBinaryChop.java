package de.twomartens.katas.karateChop;

import java.util.List;

public class RecursiveBinaryChop implements BinaryChop {
    @Override
    public int chop(int searchedValue, List<Integer> list) {
        if (list.isEmpty()) {
            return -1;
        }
        if (list.size() == 1) {
            if (list.get(0) == searchedValue) {
                return 0;
            } else {
                return -1;
            }
        }
        int lowerBoundOfUpperHalf = getLowerBoundOfUpperHalf(list.size());
        if (searchedValue < list.get(lowerBoundOfUpperHalf)) {
            return chop(searchedValue, list.subList(0, lowerBoundOfUpperHalf));
        } else if (searchedValue == list.get(lowerBoundOfUpperHalf)) {
            return lowerBoundOfUpperHalf;
        } else {
            int returnValue = chop(searchedValue, list.subList(lowerBoundOfUpperHalf, list.size()));
            return returnValue == -1 ? -1 : lowerBoundOfUpperHalf + returnValue;
        }
    }
}
