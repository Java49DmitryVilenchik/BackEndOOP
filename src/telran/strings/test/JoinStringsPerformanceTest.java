package telran.strings.test;

import telran.strings.JoinStrings;

public class JoinStringsPerformanceTest extends PerformanceTest {
    private JoinStrings joinStrings;
    private String[] strings;

    public JoinStringsPerformanceTest(int nRuns, String testName, JoinStrings joinStrings, String[] strings) {
        super(nRuns, testName);
        this.joinStrings = joinStrings;
        this.strings = strings;
    }

    @Override
    public void runTest() {
        joinStrings.join(strings, "#");
    }
}
