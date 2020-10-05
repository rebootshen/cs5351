package Lab1;

public class UR {
  int sizeOfCake;

  UR(int size) {
    this.sizeOfCake = size;
  }

  boolean dividingCake(int pieces) {
    if (0 == this.sizeOfCake || 0 == pieces) return false;
    int i = this.sizeOfCake % pieces;
    if (0 != i) return false;

    int size = this.sizeOfCake / pieces;

    System.out.println("the size of each piece of cake: " + size);

    return true;
  }
}
