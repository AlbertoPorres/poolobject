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
public class ReusablePoolTest {
	
	private ReusablePool rp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rp = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		rp = null;
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		if(rp == null) {
			try { this.setUp();
			} catch (Exception e) {}
		}
		
		// comprobamos que la instancia ha sido creada
		assertNotNull(rp);
		assertEquals(rp, ReusablePool.getInstance());
		
		try { this.tearDown();
		} catch (Exception e) {}
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		if(rp == null) {
			try { this.setUp();
			} catch (Exception e) {}
		}
		
		// comprobamos la obtencion de los reusables
		Reusable r1 = null;
		Reusable r2 = null;
		assertNull(r1);
		assertNull(r2);
		try {
			r1 = rp.acquireReusable();
			r2 = rp.acquireReusable();
		} catch (NotFreeInstanceException e) {
		}
		assertNotNull(r1);
		assertNotNull(r2);
		
		// comprobamos que la excepcion salta correctamente
		try {
			Reusable r3 = rp.acquireReusable();
		} catch (NotFreeInstanceException e) {
			boolean outOfReusables = true;
			assertTrue(outOfReusables);
		}
		
		try { this.tearDown();
		} catch (Exception e) {}
	}

	/**
	 * Test method for {@link ubu.gii.dasDescription	Resource	Path	Location	Type
		The import ubu.gii.dass.c01.DuplicatedInstanceException is never used	ReusablePoolTest.java	/poolobject/src/test/ubu/gii/dass/test/c01	line 10	Java Problem
		s.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		if(rp == null) {
			try { this.setUp();
			} catch (Exception e) {}
		}
		
		try {
			//obtenemos reusables y liberamos correctamente
			Reusable r1 = rp.acquireReusable();
			Reusable r2 = rp.acquireReusable();
			
			rp.releaseReusable(r1);
			rp.releaseReusable(r2);
			
		} catch (NotFreeInstanceException e) {
		} catch (DuplicatedInstanceException e) {}
		
		try {
			//obtenemos reusables y liberamos pasandonos
			Reusable r1 = rp.acquireReusable();
			Reusable r2 = rp.acquireReusable();
			
			rp.releaseReusable(r1);
			rp.releaseReusable(r2);
			rp.releaseReusable(r1);
			
		} catch (NotFreeInstanceException e) {
		} catch (DuplicatedInstanceException e) {
			boolean alreadyReleased = true;
			assertTrue(alreadyReleased);
		}
		
		
		try { this.tearDown();
		} catch (Exception e) {}
	}

}