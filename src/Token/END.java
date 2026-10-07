package Token;

public class END extends Token {

	public END() {
		super();
		this.setValeur("END");
	}

	@Override
	public END copie() {
		END end = new END();
		end.setValeur(this.getValeur());
		end.setNumLigne(this.getNumLigne());
		return end;
	}
	
}
