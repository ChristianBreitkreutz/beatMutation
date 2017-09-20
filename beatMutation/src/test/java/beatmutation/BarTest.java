package beatmutation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BarTest {

    @Test
    public void test() throws BeatmutationException {
        Bar staff = new Bar();
        List<List<String>> bar = Arrays.asList(
                Arrays.asList("hh","hh","hh","hh"),
                Arrays.asList(""  ,""  ,"sn",""),
                Arrays.asList("bd",""  ,"","")
        );
        assertEquals("<hh, bd>4[hh4,<hh, sn>4 hh4]", staff.create(bar));
    }

}
