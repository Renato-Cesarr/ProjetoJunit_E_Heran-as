import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Random;

class ArrayTest {

    @Test
    void testOneDimensionalArrayWithNumbers() {
        Random random = new Random();
        int size = 10;
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(100);
        }

        assertEquals(size, numbers.length);
        for (int i = 0; i < size; i++) {
            assertTrue(numbers[i] >= 0 && numbers[i] < 100);
        }

        numbers[5] = 999;
        assertEquals(999, numbers[5]);
    }

    @Test
    void testOneDimensionalArrayWithLetters() {
        Random random = new Random();
        int size = 10;
        char[] letters = new char[size];

        for (int i = 0; i < size; i++) {
            letters[i] = (char) ('A' + random.nextInt(26));
        }

        assertEquals(size, letters.length);
        for (char letter : letters) {
            assertTrue(letter >= 'A' && letter <= 'Z');
        }

        letters[3] = 'Z';
        assertEquals('Z', letters[3]);
    }

    @Test
    void testTwoDimensionalArray() {
        Random random = new Random();
        int rows = 5;
        int cols = 5;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        assertEquals(rows, matrix.length);
        for (int i = 0; i < rows; i++) {
            assertEquals(cols, matrix[i].length);
            for (int j = 0; j < cols; j++) {
                assertTrue(matrix[i][j] >= 0 && matrix[i][j] < 100);
            }
        }

        matrix[2][3] = 999;
        assertEquals(999, matrix[2][3]);
    }
}
