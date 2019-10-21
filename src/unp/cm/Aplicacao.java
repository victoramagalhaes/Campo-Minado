package unp.cm;

import unp.cm.modelo.Tabuleiro;
import unp.cm.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
		
		
		new TabuleiroConsole(tabuleiro);
	}
}