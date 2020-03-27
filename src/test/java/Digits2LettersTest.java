import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class Digits2LettersTest {

    private Digits2Letters digits2Letters;

    @Before
    public void setUp() throws Exception {
        digits2Letters = new Digits2Letters();
    }

    @Test
    public void stageFirst() {
        Integer[] integers = {2, 3}; // can be overwritten by your need

        HashMap<Integer, String> map = digits2Letters.stageFirst(integers);

        // Print final results
        for (Integer key: map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
