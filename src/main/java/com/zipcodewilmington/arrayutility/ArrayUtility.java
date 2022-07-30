package com.zipcodewilmington.arrayutility;


import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<GenericType> {
    List<GenericType> array;

    public ArrayUtility(GenericType[] inputArray) {
        array = new ArrayList<>(Arrays.asList(inputArray));
    }

    public Integer getNumberOfOccurrences(GenericType valuesToEvaluate) {
//        Integer count = 0;
//        for (GenericType genericType : array)
//            if (genericType.equals(valuesToEvaluate))
//                count++;
//        return count;
        return Collections.frequency(array, valuesToEvaluate);
    }

    public Integer countDuplicatesInMerge(GenericType[] arrayToMerge, GenericType valuesToEvaluate) {
        array.addAll(new ArrayList<>(Arrays.asList(arrayToMerge)));
        return getNumberOfOccurrences(valuesToEvaluate);
    }

        public GenericType[] removeValue(GenericType valueToRemove) {
        array.remove(valueToRemove);
        array.removeIf( i -> Objects.equals(i, valueToRemove));
        if (valueToRemove instanceof Integer)
            return (GenericType[]) array.toArray(new Integer[0]);
        else if (valueToRemove instanceof Long)
            return (GenericType[]) array.toArray(new Long[0]);
        else
            return (GenericType[]) array.toArray(new String[0]);

    }
//    public GenericType[] removeValue(GenericType valueToRemove) {
//        for (int i = 0; i < array.size(); i++) {
//            array.remove(valueToRemove);
//        }
//        GenericType[] genericTypes = (GenericType[]) array.toArray();
//        return genericTypes;
//    }

    public GenericType getMostCommonFromMerge(GenericType[] arrayToMerge) {
        return array.stream().reduce(BinaryOperator.maxBy((o1, o2)
                -> Collections.frequency(array, o1) - Collections.frequency(array, o2))).orElse(null);

    }
}

