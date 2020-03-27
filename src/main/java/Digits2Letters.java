import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * convert the digits from 0 to 9 into letters
 */

@CustomMappingTable(table = {
        @CustomMappingPojo(letter = "A", digit = 2),
        @CustomMappingPojo(letter = "B", digit = 2),
        @CustomMappingPojo(letter = "C", digit = 2),

        @CustomMappingPojo(letter = "D", digit = 3),
        @CustomMappingPojo(letter = "E", digit = 3),
        @CustomMappingPojo(letter = "F", digit = 3),

        @CustomMappingPojo(letter = "G", digit = 4),
        @CustomMappingPojo(letter = "H", digit = 4),
        @CustomMappingPojo(letter = "I", digit = 4),

        @CustomMappingPojo(letter = "J", digit = 5),
        @CustomMappingPojo(letter = "K", digit = 5),
        @CustomMappingPojo(letter = "L", digit = 5),

        @CustomMappingPojo(letter = "M", digit = 6),
        @CustomMappingPojo(letter = "N", digit = 6),
        @CustomMappingPojo(letter = "O", digit = 6),

        @CustomMappingPojo(letter = "P", digit = 7),
        @CustomMappingPojo(letter = "Q", digit = 7),
        @CustomMappingPojo(letter = "R", digit = 7),
        @CustomMappingPojo(letter = "S", digit = 7),

        @CustomMappingPojo(letter = "T", digit = 8),
        @CustomMappingPojo(letter = "U", digit = 8),
        @CustomMappingPojo(letter = "V", digit = 8),

        @CustomMappingPojo(letter = "W", digit = 9),
        @CustomMappingPojo(letter = "X", digit = 9),
        @CustomMappingPojo(letter = "Y", digit = 9),
        @CustomMappingPojo(letter = "Z", digit = 9)
})
public class Digits2Letters {

    public HashMap<Integer, String> stageFirst(Integer[] integers) {

        if (integers.length == 0) {
            System.out.println("please input something.");
            return null;
        }

        HashMap<String, Integer> hashMap = getDataFormAnnotation();

        List<List<String>> filteredList = filterByInputParamters(integers, hashMap);

        HashMap<Integer, String> result = outPutByCustomRule(filteredList);

        return result;
    }

    /**
     * Get data from the Annotation
     *
     * @return
     */
    private HashMap<String, Integer> getDataFormAnnotation() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        Class<Digits2Letters> digits2LettersClass = Digits2Letters.class;

        CustomMappingTable customMappingTable = digits2LettersClass.getAnnotation(CustomMappingTable.class);

        CustomMappingPojo[] customMappingPojos = customMappingTable.table();

        for (CustomMappingPojo customMappingPojo : customMappingPojos) {
            hashMap.put(customMappingPojo.letter(), customMappingPojo.digit());
        }

        return hashMap;
    }

    /**
     * Filter out the required list by InputParamters
     *
     * @param integers
     * @param hashMap
     * @return
     */
    private List<List<String>> filterByInputParamters(Integer[] integers, HashMap<String, Integer> hashMap) {
        List<List<String>> filteredList = new ArrayList<>();

        for (Integer integer : integers) {
            List<String> temp = new ArrayList<>();
            for (String key : hashMap.keySet()) {
                Integer value = hashMap.get(key);
                if (value == integer) {
                    temp.add(key);
                }
            }
            filteredList.add(temp);
        }

        return filteredList;
    }

    /**
     * Filter out the required HashMap by rule
     *
     * @param filteredList
     * @return
     */
    private HashMap<Integer, String> outPutByCustomRule(List<List<String>> filteredList) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        Integer indexFoot = 0;
        for (int i = filteredList.size(); i > 0; i--) {
            HashMap<Integer, String> mapTemp = new HashMap<>();

            List<String> list = filteredList.get(i - 1);
            for (int j = 0; j < list.size(); j++) {

                if (hashMap.size() == 0) {
                    mapTemp.put(j, list.get(j));
                    continue;
                }

                for (Integer key : hashMap.keySet()) {
                    mapTemp.put(indexFoot, list.get(j) + hashMap.get(key));
                    indexFoot++;
                }

            }

            hashMap.putAll(mapTemp);
            indexFoot = 0;
        }

        return hashMap;
    }
}
