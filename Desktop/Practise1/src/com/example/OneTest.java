package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OneTest {
	@Test
	  public void testFoo() throws Exception {
	    One one = new One();
	    assertEquals("foo", one.foo());
	  }

	  @Test
	  public void testBoth() throws Exception {
	    One one = new One();
	    assertEquals("toto", one.toto());
	    assertEquals("foo", one.foo());

}
}