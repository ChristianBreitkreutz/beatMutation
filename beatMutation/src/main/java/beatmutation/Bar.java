package beatmutation;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    public String create(List<List<String>> bar) throws BeatmutationException {
        List<String> huhu = migrate(bar);
        BarSize barSize = new BarSize(4);
        List<String> sizes = barSize.calculate(huhu);
        
        return "skdlf";
    }
    private List<String> migrate(List<List<String>> bar) {
        List<String> abc = new ArrayList<>();
        for (int i = 0; i < bar.size(); i++) {
            abc.add(bar.get(0).get(i) +", "+ bar.get(1).get(i) +", "+ bar.get(2).get(i));
        }
        return abc;
    }
}
