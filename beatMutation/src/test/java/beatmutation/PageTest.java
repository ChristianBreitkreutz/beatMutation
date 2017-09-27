package beatmutation;

import org.junit.Test;

public class PageTest {

    @Test
    public void test() {
        Page page = new Page("/home/christian/git/Beat-Atomes/autoTest.ly");
        page.title("Permute from Hell");
        System.out.println(page);
    }

}
