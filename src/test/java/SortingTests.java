import com.patterns.bridge.DerivedAbstractionCustomImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by Michał Szewczyk on 2017-05-05.
 */
public class SortingTests {
    @Test
    public void shouldPerformTestingCorrectly() {
        DerivedAbstractionCustomImpl<Integer> derivedAbstractionCustom = new DerivedAbstractionCustomImpl<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.iterate(10, i -> --i).limit(10).forEach(arrayList::add);
        for (int i = 0; i < arrayList.size(); i++) {
            Assert.assertTrue(Arrays.deepEquals(derivedAbstractionCustom.sort(arrayList), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        }
    }
}
