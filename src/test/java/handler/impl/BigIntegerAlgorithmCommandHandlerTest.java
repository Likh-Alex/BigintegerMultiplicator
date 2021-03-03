package handler.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;

class BigIntegerAlgorithmCommandHandlerTest {
    private static final String FIRST_NUMBER = "12345678987654323456743567897654345676543456786543";
    private static final String SECOND_NUMBER = "1234567865432456789765432456789087654324567345644";
    private static final String THIRD_NUMBER = "12324546564322324565335465443235433543344234334234";
    private static final String INVALID_INPUT = "1212aaa";
    public static final String BAD_PARAMETERS_MESSAGE = "Bad parameters. Please try again";
    private BigIntegerAlgorithmCommandHandler bigIntAlgorithm;
    private CustomAlgorithmCommandHandlerImpl customAlgorithm;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        bigIntAlgorithm = new BigIntegerAlgorithmCommandHandler();
        customAlgorithm = new CustomAlgorithmCommandHandlerImpl();
        outputStream = new ByteArrayOutputStream();
    }

    @Test
    public void getEqualResultDifferentAlgorithms_oK() {
        BigInteger bigIntegerAlgorithmResult = bigIntAlgorithm.calculate(FIRST_NUMBER, SECOND_NUMBER);
        BigInteger customAlgorithmResult = customAlgorithm.calculate(FIRST_NUMBER, SECOND_NUMBER);
        Assertions.assertEquals(bigIntegerAlgorithmResult, customAlgorithmResult);
    }

    @Test
    public void getDifferentResultDifferentAlgorithms_Ok() {
        BigInteger bigIntegerAlgorithmResult = bigIntAlgorithm.calculate(FIRST_NUMBER, SECOND_NUMBER);
        BigInteger customAlgorithmResult = customAlgorithm.calculate(FIRST_NUMBER, THIRD_NUMBER);
        Assertions.assertNotEquals(bigIntegerAlgorithmResult, customAlgorithmResult);
    }

    @Test
    public void getErrorMessageBigIntegerAlgorithm_Ok() {
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        bigIntAlgorithm.processInput(INVALID_INPUT);
        Assertions.assertEquals(outputStream.toString().trim(), BAD_PARAMETERS_MESSAGE);
    }

    @AfterEach
    public void tearDown() {
        bigIntAlgorithm = null;
        customAlgorithm = null;
    }
}