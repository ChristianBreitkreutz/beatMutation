package beatmutation;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PatternTest {

	@Test
	public void test() {
		Pattern pattern = new Pattern();
		Combinatoric combinatoric = new Combinatoric(Arrays.asList("BD"," "), 2);
		List<List<String>> bla = combinatoric.permutation();
		for (int i = 0; i < bla.size(); i++) {
			System.out.println(bla.get(i).toString());
		}
		System.out.println(combinatoric.permutation().toString());
	}

	@Test
	public void blabla(){
		List<String> hh = Arrays.asList("hh","hh","hh","hh");
		List<String> sn = Arrays.asList("","","sn","");
		List<String> bd = Arrays.asList("bd","","","");

//		<hh>4^"A1"[bd hh8 ]  \sb <hh sn>8[ hh8] \rb
//\break
	}
}
