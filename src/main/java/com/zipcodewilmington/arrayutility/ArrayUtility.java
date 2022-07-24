package com.zipcodewilmington.arrayutility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <GenericType> {

    List<GenericType> array = new ArrayList<>();

    public ArrayUtility(GenericType[] inputArray) {
        array = new ArrayList<>(Arrays.asList(inputArray));
    }

    public Integer getNumberOfOccurrences(GenericType valuesToEvaluate) {
        Integer count = 0;
        for (GenericType genericType : array)
            if (genericType.equals(valuesToEvaluate))
                count++;
        return count;
    }
    public Integer countDuplicatesInMerge(GenericType[] arrayToMerge, GenericType valuesToEvaluate) {
        array.addAll(new ArrayList<>(Arrays.asList(arrayToMerge)));
        return getNumberOfOccurrences(valuesToEvaluate);
    }
}

