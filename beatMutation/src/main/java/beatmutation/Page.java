package beatmutation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Page {
    private String title = "Title not set";
    private String filepath = "";

    public Page(String filePath) {
        this.filepath = filePath;
    }

    public void title(String title) {
        this.title = title;
    }

    private String createNotes() {
        Combinatoric combinatoric = new Combinatoric(Arrays.asList("bd", ""), 4);
        List<List<String>> perm = combinatoric.permutation();
        int lineBreak = 4;
        String collector = "";
        collector += LilypondElements.repeatBarLine();
        collector += "\n";
        try {
            for (int i = 0; i < perm.size(); i++) {
                Bar staff = new Bar();
                List<List<String>> bar = Arrays.asList( //
                        Arrays.asList("hh", "hh", "hh", "hh"), //
                        Arrays.asList("", "", "sn", ""), //
                        perm.get(i) //
                );
                staff.addComment("" + (i + 1));
                collector += staff.create(bar);
                collector += LilypondElements.repeatBarLine();
                collector += "\n";
                if (i % lineBreak == 3) {
                    collector += LilypondElements.lineBreak();
                    collector += "\n\n";
                }
            }
            return collector;
        } catch (BeatmutationException e) {
            return "Error:" + e.getMessage();
        }
    }

    public String toString() {
        String page = "";
        page += LilypondElements.version();
        page += "\n";
        page += LilypondElements.titel(title);
        page += "\n";
        page += LilypondElements.headerInclude();
        page += "\n";
        page += LilypondElements.notes(createNotes());
        page += "\n";
        page += LilypondElements.footerInclude();
        page += "\n";
        writeFile(page);
        return page;
    }

    private void writeFile(String testTOPrint) {
        try {
            PrintWriter writer = new PrintWriter(filepath, "UTF-8");
            writer.println(testTOPrint);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
