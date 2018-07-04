import com.dave.model.Employee;
import com.dave.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by David on 19/03/2017.
 */
public class PersonClassTest {

    @Test
    public void testFirstName() throws  Exception {

        Person p = new Employee();
        Given:
        p.setFirstName("David");

        When:
        p.setFirstName("John");

        Then:
        Assert.assertEquals("John", p.getFirstName());

    }

    @Test
    public void testFullNameIsReturnedCorrectly() throws  Exception {

        Person p = new Employee();

        GIVEN:
        p.setFirstName("David");

        WHEN:
        p.setLastName("Crhonek");

        THEN:
        Assert.assertEquals("David Crhonek", p.getFullName());
    }
}
