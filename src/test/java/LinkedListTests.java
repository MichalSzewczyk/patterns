import com.patterns.iterator.BasicList;
import com.patterns.iterator.Iterator;
import com.patterns.iterator.LinkedList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.ConcurrentModificationException;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */

public class LinkedListTests {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void prepareForTests() {
        thrown.expect(ConcurrentModificationException.class);
    }

    @Test
    public void testIfLinkedListThrowsExceptionWhenModifyingAfterGettingIterator() {
        BasicList<Integer> list = new LinkedList<>();
        Iterator<Integer> iterator = list.getIterator();
        list.add(0);
        iterator.next();
    }
}
