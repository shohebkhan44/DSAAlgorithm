import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayDSATest {

    private String captureStdOut(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try {
            action.run();
        } finally {
            System.out.flush();
            System.setOut(originalOut);
        }
        return baos.toString();
    }

    @Test
    void unionArray_withSecondArrayEmpty_printsNothing() {
        int[] a = {1, 2, 3};
        int[] b = {};
        String out = captureStdOut(() -> ArrayDSA.UnionArray(a, b));
        assertEquals("", out);
    }

    @Test
    void unionArray_arr123_and_b4_prints13() {
        int[] a = {1, 2, 3};
        int[] b = {4};
        String out = captureStdOut(() -> ArrayDSA.UnionArray(a, b));
        assertEquals("13", out);
    }

    @Test
    void unionArray_arr5_and_b12_prints12() {
        int[] a = {5};
        int[] b = {1, 2};
        String out = captureStdOut(() -> ArrayDSA.UnionArray(a, b));
        assertEquals("12", out);
    }
}