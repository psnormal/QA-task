import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static void test (String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    void test_diag1Sym_1() {
        test("AaA\nAaA\nAaA", Solution.diag1Sym("AAA\naaa\nAAA"));
    }

    @Test
    void test_diag1Sym_2() {
        test("AaA\nBbb\nCcC", Solution.diag1Sym("ABC\nabc\nAbC"));
    }

    @Test
    void test_rot90Clock_1() {
        test("2151\n4362\n6573\n8784", Solution.rot90Clock("1234\n5678\n1357\n2468"));
    }

    @Test
    void test_rot90Clock_2() {
        test("A", Solution.rot90Clock("A"));
    }

    @Test
    void test_selfieAndDiag1_1() {
        test("A8b|A7.\n71c|811\n.1_|bc_", Solution.selfieAndDiag1("A8b\n71c\n.1_"));
    }

    @Test
    void test_returnArray_1() {
        char[][] array1 = {{'A', 'B', 'C'}, {'a', 'b', 'c'}, {'A', 'b', 'C'}};
        Arrays.equals(array1, Solution.returnArray("ABC\nabc\nAbC"));
    }

    @Test
    void test_oper_1() {
        test("aMOR\nrnpQ\nQmlW\nWMqs", Solution.oper(Solution::diag1Sym, "arQW\nMnmM\nOplq\nRQWs"));
    }

    @Test
    void test_oper_2() {
        test("311\n222\n103", Solution.oper(Solution::rot90Clock, "123\n120\n321"));
    }

    @Test
    void test_oper_3() {
        test("?$*|?+(\n+-=|$-0\n(0)|*=)", Solution.oper(Solution::selfieAndDiag1, "?$*\n+-=\n(0)"));
    }
}