package weekend.examples;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserSpec {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    MySysOut mySysOut;
    MySysIn mySysIn;

    @Before
    public void setup() {
        mySysOut = new MySysOut();
        mySysIn = new MySysIn();
        SelectionNamedQueryFromConsole.OUT = mySysOut;
        SelectionNamedQueryFromConsole.IN = mySysIn;
    }

    @Test
    public void whenTwoThenUserTwo() {
        // Given Setup
        String expected = "";
        expected = "Podaj id:\n";
        mySysIn.addStringToRead("2");
        expected += "User{id=2, login='kk', password='aa', town=null}";

        // When Act
        SelectionNamedQueryFromConsole.main(null);

        // Then Verify
        assertThat(mySysOut.getPrintedString()).isEqualTo(expected);
    }
}