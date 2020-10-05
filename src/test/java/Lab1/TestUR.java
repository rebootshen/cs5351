package Lab1;

import static org.junit.jupiter.api.Assertions.*;

import Lab1.UR;
import org.junit.jupiter.api.Test;

public class TestUR {

  @Test
  public void test() {
    UR r = new UR(6);

    r.dividingCake(6);

    r.dividingCake(3);
  }

  @Test
  public void piecesLTsize() {
    UR r = new UR(6);

    boolean result6 = r.dividingCake(6);

    assertTrue(result6);

    boolean result5 = r.dividingCake(5);

    assertFalse(result5);

    boolean result4 = r.dividingCake(4);

    assertFalse(result4);

    boolean result3 = r.dividingCake(3);

    assertTrue(result3);

    boolean result2 = r.dividingCake(2);

    assertTrue(result2);

    boolean result1 = r.dividingCake(1);

    assertTrue(result1);
  }

  @Test
  public void zeroPieces() {
    UR r = new UR(6);

    boolean result = r.dividingCake(0);

    assertFalse(result);
  }

  @Test
  public void zeroSize() {
    UR r = new UR(0);

    boolean result = r.dividingCake(0);

    assertFalse(result);
  }

  @Test
  public void piecesGTsize() {
    UR r = new UR(6);

    boolean result = r.dividingCake(10);

    assertFalse(result);
  }
}
