package beatmutation;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class LilipondElementsTest {

    @Test
    public void simpleElements() {
        assertEquals("\\version \"2.18.2\"", LilypondElements.version());
        assertEquals("\\include \"baseFiles/DrumSheet_base.ly\"", LilypondElements.headerInclude());
        assertEquals("\\include \"baseFiles/DrumStaff_base.ly\"", LilypondElements.footerInclude());

        assertEquals("\\break", LilypondElements.lineBreak());
        assertEquals("\\sb", LilypondElements.smallBarLine());
        assertEquals("\\rb", LilypondElements.repeatBarLine());
    }

    @Test
    public void title() {
        assertEquals("title = \"Test Title\"", LilypondElements.titel("Test Title"));
    }

    @Test
    public void note() {
        assertEquals("hh8.", LilypondElements.note("hh", "8."));
    }

    @Test
    public void chordmode() {
        assertEquals("<hh sn bd>4.", LilypondElements.chordmode(Arrays.asList("hh", "sn", "bd"), "4."));
    }

    @Test
    public void addComment() {
        assertEquals("element^\"comment\"", LilypondElements.addComment("element", "comment"));
    }

    @Test
    public void all() {
        String startGroup = LilypondElements.chordmode(Arrays.asList("a", "b"), "4");
        String startGroupWithComment = LilypondElements.addComment(startGroup, "testComment");
        String noteC = LilypondElements.note("c", "4");
        String noteD = LilypondElements.note("d", "4");
        String bar = LilypondElements.bindGroup(startGroupWithComment, Arrays.asList(noteC, noteD));
        String fullBar = bar + LilypondElements.smallBarLine() + bar + LilypondElements.repeatBarLine() + LilypondElements.lineBreak();
        assertEquals("<a b>4^\"testComment\"[c4 d4]\\sb<a b>4^\"testComment\"[c4 d4]\\rb\\break", fullBar);
    }
}
