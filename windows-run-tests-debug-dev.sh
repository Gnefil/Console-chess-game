javac -d ./chess/bin -cp .;junit-platform-console-standalone.jar ./chess/*.java ./chess/tests/DevQueenTest.java ./chess/tests/DevKingTest.java ./chess/tests/DevBishopTest.java ./chess/tests/DevPawnTest.java ./chess/tests/DevRookTest.java ./chess/tests/DevKnightTest.java ./chess/tests/DevCheckInputTest.java
java -jar junit-platform-console-standalone.jar --class-path ./chess/bin --scan-class-path --fail-if-no-tests