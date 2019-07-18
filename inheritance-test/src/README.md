In Java constructors are not class members and therefore are not inherited (exactly opposite to PHP5+):

  $ javac A.java B.java App.java
  
  B.java:1: error: constructor A in class A cannot be applied to given types;
  public class B extends  A {
         ^
    required: String
    found: no arguments
    reason: actual and formal argument lists differ in length
  App.java:3: error: constructor B in class B cannot be applied to given types;
          B obj = new B("adasd");
                  ^
    required: no arguments
    found: String
    reason: actual and formal argument lists differ in length
  2 errors
  
