package beatmutation;

import java.util.List;

public class LilypondElements {
    public static String lineBreak() {
        return "\\break";
    }

    public static String smallBarLine() {
        return "\\sb";
    }

    public static String repeatBarLine() {
        return "\\rb";
    }

    public static String version() {
        return "\\version \"2.18.2\"";
    }

    public static String headerInclude() {
        return "\\include \"baseFiles/DrumSheet_base.ly\"";
    }

    public static String footerInclude() {
        return "\\include \"baseFiles/DrumStaff_base.ly\"";
    }
    public static String notes(String notes) {
        return "notes = \\drummode { " + notes +" }";
    }

    public static String titel(String name) {
        return "title = \"" + name + "\"";
    }

    public static String note(String type, String lenght) {
        return type + lenght;
    }

    public static String chordmode(List<String> notes, String lenght) {
        return note("<" + spacedString(notes) + ">", lenght);
    }

    public static String addComment(String element, String comment) {
        return element + "^\"" + comment + "\"";
    }

    public static String bindGroup(String element, List<String> elements) {
        return element + "[" + spacedString(elements) + "]";
    }

    private static String spacedString(List<String> list) {
        String outPut = "";
        for (int i = 0; i < list.size(); i++) {
            outPut += list.get(i);
            if (i != list.size() - 1) {
                outPut += " ";
            }
        }
        return outPut;
    }
}
