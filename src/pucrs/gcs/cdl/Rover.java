package pucrs.gcs.cdl;

public class Rover {
	
    private int x;
    private int y;
    private Orientacao orientacao;
    private int id;

    public Rover(int id, int x, int y, Orientacao orientacao){
        this.id = id;
        this.x = x;
        this.y = y;
        this.orientacao = orientacao;
    }

    public int getX(){
      return this.x;
    }

    public void setX(int x){
      this.x = x;
    }

    public int getY(){
      return this.y;
    }

    public void setY(int y){
      this.y = y;
    }

    public Orientacao getOrientacao(){
      return this.orientacao;
    }

    public int getId(){
    	return id;
    }
    
    public void move(Direcao direcao){
    	if(direcao == Direcao.L) {
    	    this.orientacao = orientacao.esquerda();
        } else if(direcao == Direcao.R) {
            this.orientacao = orientacao.direita();
        } else if(direcao == Direcao.M) {
            switch (this.orientacao) {
                case N:
                    this.x++;
                    break;
                case E:
                    this.y++;
                    break;
                case S:
                    this.x--;
                    break;
                case W:
                    this.y--;
                    break;
            }
        }
    }
    
    @Override
    public String toString(){
        return String.format("Rover %d: %d %d %s%s", this.id, this.x, this.y, this.orientacao, System.lineSeparator());
    }

}
