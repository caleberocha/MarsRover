package pucrs.gcs.cdl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import pucrs.gcs.cdl.Area;
import pucrs.gcs.cdl.Direcao;
import pucrs.gcs.cdl.FallingRoverException;
import pucrs.gcs.cdl.Orientacao;

public class AreaTest {

	private Area area;
	
	@Before
	public void setUp() throws Exception 
	{
		this.area = new Area(5, 5);
		area.deployRover(0, 0, Orientacao.N);
	}

	@Test
	public void testGetTamanhoX() 
	{
		assertEquals(5, area.getTamanhoX());
	}

	@Test
	public void testGetTamanhoY() 
	{
		assertEquals(5, area.getTamanhoY());
	}
	
	@Test
	public void testGetRovers()
	{
		assertNotNull(area.getRovers());
	}

	@Test(expected = FallingRoverException.class)
	public void testMoveRover() throws FallingRoverException 
	{
		area.getRovers().get(0).setX(-1);	
		area.moveRover(Direcao.L);
	}
}
