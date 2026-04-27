import java.util.Arrays;
public class Experiment {
    private final Sorter sorter;
    private final Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }
    public long measureSortTime(int[] arr, String type) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        int[] copy = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(copy);
        } else {
            throw new IllegalArgumentException("Sort type must be 'basic' or 'advanced'.");
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        int[] copy = Arrays.copyOf(arr, arr.length);
        sorter.advancedSort(copy);

        long startTime = System.nanoTime();
        searcher.search(copy, target);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }
    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000, 5000};

        System.out.println("============================================");
        System.out.println("Sorting and Searching Algorithm Analysis");
        System.out.println("Basic Sort: Selection Sort");
        System.out.println("Advanced Sort: Merge Sort");
        System.out.println("Search: Binary Search");
        System.out.println("============================================");

        System.out.println("Size\tInput\tSelection(ns)\tMerge(ns)\tBinary Search(ns)");
        System.out.println("--------------------------------------------------------------------------------------------");

        for (int size : sizes) {
            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = generateSortedArray(size);

            runExperimentForArray(size, "Random", randomArray);
            runExperimentForArray(size, "Sorted", sortedArray);
        }

        System.out.println("--------------------------------------------------------------------------------------------");
    }

    private void runExperimentForArray(int size, String inputType, int[] array) {
        int target = array[array.length / 2];

        long basicTime = measureSortTime(array, "basic");
        long advancedTime = measureSortTime(array, "advanced");
        long searchTime = measureSearchTime(array, target);

        System.out.println(size + "\t" + inputType + "\t"
                + basicTime + "\t" + advancedTime + "\t" + searchTime);
    }

    private int[] generateSortedArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        return arr;
    }
}
