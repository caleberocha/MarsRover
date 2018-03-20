package Rover;

public class Rover {
	
    private int x;
    private int y;
    private String orientacao;
    private String robonene;
    private static int id;

    public Rover(int x, int y, String orientacao, String robonene, int id){
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
        this.robonene = robonene;
        Rover.id = id;
    }

    public int getX(){
      return this.x;
    }

    public int setX(){
      return this.x;
    }

    public int getY(){
      return this.y;
    }

    public int setY(){
      return this.y;
    }

    public String getOrientacao(){
      return this.orientacao;
    }

    public String setOrientacao(String direcao){
      return this.orientacao;
    }
    
    public String getRobo(){
    	return robonene;
    }

    public static int getId(){
    	return id;
    }
    
    public static int setId(){
    	return id;
    }
    
    public void move(String orientacao){
    	
    }
    
    @Override
    public String toString(){
        return this.x + " " + this.y + " " + this.orientacao;
    }

}
