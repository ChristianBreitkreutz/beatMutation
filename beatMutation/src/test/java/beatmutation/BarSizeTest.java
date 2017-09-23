package beatmutation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class BarSizeTest {

    @Test
    public void testQuarterNotes() throws BeatmutationException {
        BarSize bar = new BarSize(4);
        assertEquals(Arrays.asList("4", "4", "4", "4"), bar.calculate(Arrays.asList("c", "c", "c", "c")));
        assertEquals(Arrays.asList("2", "2"), bar.calculate(Arrays.asList("c", "empty", "c", "empty")));
        assertEquals(Arrays.asList("2", "4", "4"), bar.calculate(Arrays.asList("c", "empty", "c", "c")));
        assertEquals(Arrays.asList("1"), bar.calculate(Arrays.asList("c", "empty", "empty", "empty")));
        assertEquals(Arrays.asList("2.", "4"), bar.calculate(Arrays.asList("c", "empty", "empty", "c")));
        assertEquals(Arrays.asList("4", "2."), bar.calculate(Arrays.asList("c", "c", "empty", "empty")));
    }
    @Test
    public void testEmpthyNotes() throws BeatmutationException {
        BarSize bar = new BarSize(4);
        assertEquals(Arrays.asList("2.", "4"), bar.calculate(Arrays.asList("c", "empty","empty", "c")));
    }

    @Test
    public void testEighthNotes() throws BeatmutationException {
        BarSize bar = new BarSize(8);
        assertEquals(Arrays.asList("8","8","8", "4.", "4"), bar.calculate(Arrays.asList("c", "d", "e","f", "empty", "empty","g", "empty")));
    }

    @Test(expected = BeatmutationException.class)
    public void errorCase() throws BeatmutationException {
        BarSize bar = new BarSize(4);
        bar.calculate(Arrays.asList("1", "2", "3", "4", "5"));
    }

}
