package pucrs.gcs.cdl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pucrs.gcs.cdl.Direcao;
import pucrs.gcs.cdl.Orientacao;
import pucrs.gcs.cdl.Rover;

public class RoverTest {

	private Rover rover;
	
	@Before
	public void setUp() throws Exception 
	{
		this.rover = new Rover(2, 2, 3, Orientacao.N);
	}

	@Test
	public void testGetX() 
	{
		assertEquals(2, rover.getX());
	}

	@Test
	public void testGetY() 
	{
		assertEquals(3, rover.getY());
	}

	@Test
	public void testGetOrientacao() 
	{
		assertEquals(Orientacao.N, rover.getOrientacao());
	}

	@Test
	public void testGetId() 
	{
		assertEquals(2, rover.getId());
	}

	@Test
	public void testMove() 
	{
		rover.move(Direcao.M);
		assertEquals(4, rover.getY());
	}

}
