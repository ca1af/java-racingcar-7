package racingcar.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent)); // System.out 리다이렉트
        outputView = new OutputView();
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut); // System.out 복원
    }

    @Test
    @DisplayName("실행 결과를 출력한다.")
    void printRunStarted() {
        // when
        outputView.printRunStarted();

        // then
        String expectedOutput = "실행 결과\n";
        assertThat(outContent).hasToString(expectedOutput);
    }

    @Test
    @DisplayName("주어진 문자열을 출력한다.")
    void printCurrentPositions() {
        // given
        String input = "Test Output";

        // when
        outputView.printCurrentPositions(input);

        // then
        String expectedOutput = "Test Output\n";
        assertThat(outContent).hasToString(expectedOutput);
    }

    @Test
    @DisplayName("우승자를 출력한다.")
    void printWinner() {
        // given
        String winner = "pobi";

        // when
        outputView.printWinner(winner);

        // then
        String expectedOutput = "pobi\n";
        assertThat(outContent).hasToString(expectedOutput);
    }
}