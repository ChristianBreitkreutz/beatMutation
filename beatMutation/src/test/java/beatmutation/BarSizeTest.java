package beatmutation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class BarSizeTest {

    @Test
    public void testQuarterNotes() throws BeatmutationException {
        BarSize bar = new BarSize(4);
        assertEquals(Arrays.asList("4", "4", "4", "4"), bar.calculate(Arrays.asList("c", "c", "c", "c")));
        assertEquals(Arrays.asList("2", "2"), bar.calculate(Arrays.asList("c", "", "c", "")));
        assertEquals(Arrays.asList("2", "4", "4"), bar.calculate(Arrays.asList("c", "", "c", "c")));
        assertEquals(Arrays.asList("1"), bar.calculate(Arrays.asList("c", "", "", "")));
        assertEquals(Arrays.asList("2.", "4"), bar.calculate(Arrays.asList("c", "", "", "c")));
        assertEquals(Arrays.asList("4", "2."), bar.calculate(Arrays.asList("c", "c", "", "")));
    }

    @Test
    public void testEighthNotes() throws BeatmutationException {
        BarSize bar = new BarSize(8);
        assertEquals(Arrays.asList("8","8","8", "4.", "4"), bar.calculate(Arrays.asList("c", "d", "e","f", "", "","g", "")));
    }

    @Test(expected = BeatmutationException.class)
    public void errorCase() throws BeatmutationException {
        BarSize bar = new BarSize(4);
        bar.calculate(Arrays.asList("1", "2", "3", "4", "5"));
    }

}
