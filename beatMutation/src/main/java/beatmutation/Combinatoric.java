package beatmutation;

import java.util.ArrayList;
import java.util.List;

public class Combinatoric {
    public int permutaionLenght;
    public ArrayList<Integer> columnIntervalls;
    private List<String> elements;
    private int depth;
    private int innerIntervallCount;

    public Combinatoric(List<String> elements, int depth) {
        this.elements = elements;
        this.depth = depth;
        calculatePermutaionSize();
        calculateColumnIntervalls();
    }

    public void calculatePermutaionSize() {
        this.permutaionLenght = (int) Math.pow(this.elements.size(), this.depth);
    }

    public void calculateColumnIntervalls() {
        int amountElements = elements.size();
        ArrayList<Integer> columnIntervalls = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            if (columnIntervalls.isEmpty()) {
                columnIntervalls.add(1);
                continue;
            }
            if (columnIntervalls.size() == 1) {
                columnIntervalls.add(amountElements);
                continue;
            }
            columnIntervalls.add(columnIntervalls.get(i - 1) * amountElements);
        }
        this.columnIntervalls = columnIntervalls;

    }

    public List<List<String>> permutation() {
        innerIntervallCount = 0;
        List<List<String>> permutations = new ArrayList<>();
        for (int depthCount = 0; depthCount < this.depth; depthCount++) {
            int elementCounter = 0;
            for (int permutationCount = 0; permutationCount < this.permutaionLenght; permutationCount++) {
                if (permutations.size() < permutaionLenght) {
                    permutations.add(new ArrayList<>());
                }
                if (elementCounter >= elements.size()) {
                    elementCounter = 0;
                }
                permutations.get(permutationCount).add(elements.get(elementCounter));
                elementCounter = incrementColumnCounter(depthCount, elementCounter);
            }
        }
        return permutations;
    }

    private int incrementColumnCounter(int depthCount, int elementCounter) {
        int columnIntervall = columnIntervalls.get(depthCount);
        if (innerIntervallCount == columnIntervall - 1) {
            innerIntervallCount = 0;
            return ++elementCounter;
        }
        innerIntervallCount++;
        return elementCounter;
    }
}
