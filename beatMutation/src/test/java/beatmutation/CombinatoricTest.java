package beatmutation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import beatmutation.Combinatoric;

public class CombinatoricTest {

	@Test
	public void calculationBasics() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B", "C"), 1);
		assertEquals(3, per.permutaionLenght);
		List<Integer> expected = Arrays.asList(1);
		assertEquals(expected, per.columnIntervalls);

		per = new Combinatoric(Arrays.asList("A", "B", "C"), 4);
		assertEquals(81, per.permutaionLenght);
		expected = Arrays.asList(1, 3, 9, 27);
		assertEquals(expected, per.columnIntervalls);
	}

	@Test
	public void singleValue_Depth_one() {
		Combinatoric per = new Combinatoric(Arrays.asList("A"), 1);
		assertEquals(1, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void singleValue_Depth_two() {
		Combinatoric per = new Combinatoric(Arrays.asList("A"), 2);
		assertEquals(1, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1, 1);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A", "A"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void singleValue_Depth_three() {
		Combinatoric per = new Combinatoric(Arrays.asList("A"), 3);
		assertEquals(1, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1, 1, 1);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A", "A", "A"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void TwoValues_Depth_one() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B"), 1);
		assertEquals(2, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A"));
		expected.add(Arrays.asList("B"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void TwoValues_Depth_two() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B"), 2);
		assertEquals(4, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1, 2);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A", "A"));
		expected.add(Arrays.asList("B", "A"));
		expected.add(Arrays.asList("A", "B"));
		expected.add(Arrays.asList("B", "B"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void TwoValues_Depth_three() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B"), 3);
		assertEquals(8, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1, 2, 4);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A", "A", "A"));
		expected.add(Arrays.asList("B", "A", "A"));
		expected.add(Arrays.asList("A", "B", "A"));
		expected.add(Arrays.asList("B", "B", "A"));
		expected.add(Arrays.asList("A", "A", "B"));
		expected.add(Arrays.asList("B", "A", "B"));
		expected.add(Arrays.asList("A", "B", "B"));
		expected.add(Arrays.asList("B", "B", "B"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void ThreeValues_Depth_one() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B", "C"), 1);
		assertEquals(3, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A"));
		expected.add(Arrays.asList("B"));
		expected.add(Arrays.asList("C"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void ThreeValues_Depth_two() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B", "C"), 2);
		assertEquals(9, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1, 3);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A", "A"));
		expected.add(Arrays.asList("B", "A"));
		expected.add(Arrays.asList("C", "A"));
		expected.add(Arrays.asList("A", "B"));
		expected.add(Arrays.asList("B", "B"));
		expected.add(Arrays.asList("C", "B"));
		expected.add(Arrays.asList("A", "C"));
		expected.add(Arrays.asList("B", "C"));
		expected.add(Arrays.asList("C", "C"));
		assertEquals(expected, per.permutation());
	}

	@Test
	public void ThreeValues_Depth_three() {
		Combinatoric per = new Combinatoric(Arrays.asList("A", "B", "C"), 3);
		assertEquals(27, per.permutaionLenght);
		List<Integer> expectedIncrements = Arrays.asList(1, 3, 9);
		assertEquals(expectedIncrements, per.columnIntervalls);
		List<List<String>> expected = new ArrayList<List<String>>();
		expected.add(Arrays.asList("A", "A", "A"));
		expected.add(Arrays.asList("B", "A", "A"));
		expected.add(Arrays.asList("C", "A", "A"));
		expected.add(Arrays.asList("A", "B", "A"));
		expected.add(Arrays.asList("B", "B", "A"));
		expected.add(Arrays.asList("C", "B", "A"));
		expected.add(Arrays.asList("A", "C", "A"));
		expected.add(Arrays.asList("B", "C", "A"));
		expected.add(Arrays.asList("C", "C", "A"));
		// -------------------------------------
		expected.add(Arrays.asList("A", "A", "B"));
		expected.add(Arrays.asList("B", "A", "B"));
		expected.add(Arrays.asList("C", "A", "B"));
		expected.add(Arrays.asList("A", "B", "B"));
		expected.add(Arrays.asList("B", "B", "B"));
		expected.add(Arrays.asList("C", "B", "B"));
		expected.add(Arrays.asList("A", "C", "B"));
		expected.add(Arrays.asList("B", "C", "B"));
		expected.add(Arrays.asList("C", "C", "B"));
		// -------------------------------------
		// -------------------------------------
		expected.add(Arrays.asList("A", "A", "C"));
		expected.add(Arrays.asList("B", "A", "C"));
		expected.add(Arrays.asList("C", "A", "C"));
		expected.add(Arrays.asList("A", "B", "C"));
		expected.add(Arrays.asList("B", "B", "C"));
		expected.add(Arrays.asList("C", "B", "C"));
		expected.add(Arrays.asList("A", "C", "C"));
		expected.add(Arrays.asList("B", "C", "C"));
		expected.add(Arrays.asList("C", "C", "C"));
		// -------------------------------------
		assertEquals(expected, per.permutation());
	}

}
