import com.gs.collections.impl.factory.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by David on 07/10/2017.
 */
public class CollectionTest {

    @Test
    public void testStream() {
        List<String> list = Arrays.asList("A", "B", "C");

        boolean isBPresent = list.stream()
                .filter(s -> s.equals("B"))
                .findAny()
                .isPresent();

        boolean isCPresent = list.stream()
                .anyMatch(s -> "C".equals(s));

        boolean isFPresent = list.stream()
                .anyMatch(s -> "F".equals(s));

        Assert.assertEquals(true, isBPresent);
        Assert.assertEquals(true, isCPresent);
        Assert.assertNotEquals(true, isFPresent);


    }

}

