package pucrs.gcs.cdl;

import java.util.ArrayList;
import java.util.List;

public class Area{
	private int tamanhoX;
	private int tamanhoY;
	private List<Rover> rovers;
	
	public Area(int tamanhoX, int tamanhoY){
		this.tamanhoX = tamanhoX;
		this.tamanhoY = tamanhoY;
		this.rovers = new ArrayList<>();
	}

	public int getTamanhoX() {
		return tamanhoX;
	}

	public int getTamanhoY() {
		return tamanhoY;
	}

    public List<Rover> getRovers() {
        return rovers;
    }

    public void deployRover(int x, int y, Orientacao orientacao) {
        Rover rover = new Rover(rovers.size() + 1, x, y, orientacao);
        rovers.add(rover);
    }

    public void moveRover(Direcao direcao) throws FallingRoverException {
	    Rover r = rovers.get(rovers.size()-1);
	    r.move(direcao);
	    if(r.getX() < 0 || r.getY() < 0 || r.getX() > this.tamanhoX || r.getY() > this.tamanhoY) {
	        throw new FallingRoverException();
        }
    }
    
    public String printOutput() {
    	StringBuilder sb = new StringBuilder();
    	for(Rover r : rovers) {
    		sb.append(r.toString()).append(System.lineSeparator());
    	}
    	
    	return sb.toString();
    }
}
