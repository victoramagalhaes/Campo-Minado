package br.com.divweb.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	
	private final int linha;
	private final int coluna;
	
	private boolean aberto;
	private boolean minado;
	private boolean marcado;
	
	private List<Campo> vizinhos = new ArrayList<>();
	
	Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int distanciaLinha = Math.abs(linha - vizinho.linha);
		int distanciaColuna = Math.abs(coluna - vizinho.coluna);
		
		int distanciaGeral = distanciaColuna + distanciaLinha;
		
		if(distanciaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}
		else if(distanciaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}
		else {
			return false;
		}
	}
}