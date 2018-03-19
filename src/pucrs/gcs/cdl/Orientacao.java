package pucrs.gcs.cdl;

public enum Orientacao {

	N, E, S, W;

	public Orientacao esquerda() {
		if(ordinal() <= 0)
			return values()[values().length-1];
		return values()[ordinal()-1];
	}

	public Orientacao direita() {
		if(ordinal() >= values().length-1)
			return values()[0];
		return values()[ordinal()+1];
	}

}
