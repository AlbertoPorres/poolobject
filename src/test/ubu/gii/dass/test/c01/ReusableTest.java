package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Alberto Porres 
 * @author Alejandro Romero
 *
 */
public class ReusableTest {
	
	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testUtil() {
		Reusable reusable = new Reusable();
		assertEquals(reusable.util(), reusable.hashCode() + "  :Uso del objeto Reutilizable");

	}

	

}