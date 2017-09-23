package beatmutation;

import java.util.ArrayList;
import java.util.List;

public class Bar {
    private String comment = "";

    public void addComment(String comment) {
        this.comment = comment;
    }

    public String create(List<List<String>> drumPattern) throws BeatmutationException {
        List<List<String>> flipedDrumPattern = flipArray(drumPattern);
        List<String> noteEvents = mergeNoteEvents(flipedDrumPattern);
        BarSize barSize = new BarSize(noteEvents.size());
        List<String> noteLenghts = barSize.calculate(noteEvents);

        return toString(cleanArray(flipedDrumPattern), noteLenghts);
    }

    private List<String> mergeNoteEvents(List<List<String>> bar) {
        List<String> abc = new ArrayList<>();
        for (int i = 0; i < bar.size(); i++) {
            boolean isDefined = false;
            for (int j = 0; j < bar.get(i).size(); j++) {
                if(!bar.get(i).get(j).equals("") ){
                    isDefined = true;
                    continue;
                }
            }
            if(isDefined){
                abc.add(bar.get(i).toString());
            }else{
                abc.add("empty");
            }
        }
        return abc;
    }

    private List<List<String>> flipArray(List<List<String>> bar) {
        List<List<String>> abc = new ArrayList<>();
        int innerSize = bar.get(0).size();
        for (int i = 0; i < innerSize; i++) {
            List<String> wurst = new ArrayList<>();
            for (int j = 0; j < bar.size(); j++) {
                wurst.add(bar.get(j).get(i));
            }
            abc.add(wurst);
        }
        return abc;
    }

    private List<List<String>> cleanArray(List<List<String>> bar) {
        List<List<String>> abc = new ArrayList<>();
        for (int i = 0; i < bar.size(); i++) {
            List<String> wurst = new ArrayList<>();
            for (int j = 0; j < bar.get(i).size(); j++) {
                if (!bar.get(i).get(j).isEmpty()) {
                    wurst.add(bar.get(i).get(j));
                }
            }
            if (!wurst.isEmpty() && !wurst.get(0).isEmpty()) {
                abc.add(wurst);
            }
        }
        return abc;
    }

    private String toString(List<List<String>> bar, List<String> size) {
        String firstElement = "";
        List<String> notesWithTimeSecond = new ArrayList<>();
        for (int i = 0; i < bar.size(); i++) {
            if (i == 0) {
                if (bar.get(i).size() > 1) {
                    firstElement = LilypondElements.chordmode(bar.get(i), size.get(i));
                } else {
                    firstElement = LilypondElements.note(bar.get(i).get(0), size.get(i));
                }
                if (!comment.isEmpty()) {
                    firstElement = LilypondElements.addComment(firstElement, comment);
                }
            } else {
                if (bar.get(i).size() > 1) {
                    notesWithTimeSecond.add(LilypondElements.chordmode(bar.get(i), size.get(i)));
                } else {
                    notesWithTimeSecond.add(LilypondElements.note(bar.get(i).get(0), size.get(i)));
                }
            }
        }
        if (notesWithTimeSecond.size() > 0) {
            return LilypondElements.bindGroup(firstElement, notesWithTimeSecond);
        } else {
            return firstElement;
        }
    }

}
