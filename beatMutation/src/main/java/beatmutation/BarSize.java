package beatmutation;

import java.util.ArrayList;
import java.util.List;

public class BarSize {
    private int beat;

    public BarSize(int beat) {
        this.beat = beat;
    }

    public List<String> calculate(List<String> elements) throws BeatmutationException {
        if (elements.size() > beat) {
            throw new BeatmutationException("test");
        }
        List<String> sizes = new ArrayList<>();
        int noteLenght = beat;
        int oddCounter = 0;
        for (int i = 0; i < elements.size(); i++) {
            oddCounter++;
            if (i + 1 < elements.size() && elements.get(i + 1) == "") {
                if (oddCounter % 2 > 0) {
                    noteLenght /= 2;
                }
            } else {
                if (oddCounter != 1 && oddCounter % 2 > 0) {
                    sizes.add(noteLenght + ".");
                } else {
                    sizes.add(noteLenght + "");
                }
                noteLenght = beat;
                oddCounter = 0;
            }
        }
        return sizes;
    }
}
