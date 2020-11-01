package cityu;

import org.testng.annotations.Test;

public class Test11Test{

   @Test
   public void test1()
      {
      System.out.println("Priority 0 (Default in Class 1)t1");
      }

   @Test(priority = 1)
   public void test2()
      {
      System.out.println("Priority 1 (Class 1)t2");
      }

   @Test(priority = 0)
   public void test3()
      {
      System.out.println("Priority 0 (Class 1)t3");
      }

   @Test(priority = 1)
   public void test4()
      {
      System.out.println("Priority 1 (Class 1)t4");
      }

}