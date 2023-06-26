package telran.strings;

import telran.strings.test.*;

public class JoinStringsPerformanceApplication {

	public static void main(String[] args) {
        final int N_RUNS = 10000;
        final int N_STRINGS = 1000;

        String[] strings = new String[N_STRINGS];
        for (int i = 0; i < N_STRINGS; i++) {
            strings[i] = "Hello";
        }
        String expected = "Hello#Hello#Hello";

        JoinStrings jsBuilder = new JoinStringsBuilderImpl();
        JoinStrings jsImpl = new JoinStringsImpl();

        JoinStringsPerformanceTest builderTest = new JoinStringsPerformanceTest(N_RUNS, "JoinStringsBuilderImpl", jsBuilder, strings);
        JoinStringsPerformanceTest implTest = new JoinStringsPerformanceTest(N_RUNS, "JoinStringsImpl", jsImpl, strings);

        builderTest.run();
        implTest.run();
	}

}
