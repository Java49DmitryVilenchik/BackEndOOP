package telran.strings.test;

public abstract class PerformanceTest {

    private int nRuns;
    private String testName;

    public PerformanceTest(int nRuns, String testName) {
        this.nRuns = nRuns;
        this.testName = testName;
    }

    public abstract void runTest();

    public void run() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < nRuns; i++) {
            runTest();
        }
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;

        System.out.println("Number of runs: " + nRuns);
        System.out.println("Test name: " + testName);
        System.out.println("Running time: " + runningTime + " ms");
    }
}
