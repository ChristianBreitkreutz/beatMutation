package beatmutation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BarTest {

    @Test
    public void testFull() throws BeatmutationException {
        Bar staff = new Bar();
        staff.addComment("Test");
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh","hh","hh","hh"),
                Arrays.asList("","","sn",""),
                Arrays.asList("bd","","","")
        );
        assertEquals("<hh bd>4^\"Test\"[hh4 <hh sn>4 hh4]", staff.create(bar));
    }
    @Test
    public void testFullWithTriolen() throws BeatmutationException {
        Bar staff = new Bar();
        staff.addComment("Test");
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh","","","hh"),
                Arrays.asList("sn","","",""),
                Arrays.asList("bd","","","")
                );
        assertEquals("<hh sn bd>2.^\"Test\"[hh4]", staff.create(bar));
    }
    @Test
    public void testSingleNote() throws BeatmutationException {
        Bar staff = new Bar();
        staff.addComment("Test");
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh")
                );
        assertEquals("hh1^\"Test\"", staff.create(bar));
    }
    @Test
    public void multipleNote() throws BeatmutationException {
        Bar staff = new Bar();
        staff.addComment("Test");
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh","hh","hh","hh")
                );
        assertEquals("hh4^\"Test\"[hh4 hh4 hh4]", staff.create(bar));
    }
    @Test
    public void testSingleNoteNoComment() throws BeatmutationException {
        Bar staff = new Bar();
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh")
                );
        assertEquals("hh1", staff.create(bar));
    }
    @Test
    public void testTriole() throws BeatmutationException {
        Bar staff = new Bar();
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh","","","hh")
                );
        assertEquals("hh2.[hh4]", staff.create(bar));
    }

}
