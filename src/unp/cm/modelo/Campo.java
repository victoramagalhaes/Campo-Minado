package unp.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import unp.cm.excessao.ExplosaoExcessao;

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
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
		
	boolean abrir() {
		
		if(!aberto && !marcado) {
			aberto = true;
		
			if(minado) {
				throw new ExplosaoExcessao();
			}
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	void minar() {
		minado = true;
	}
	public boolean isMarcado() {
		return marcado;
	}
	
	public boolean isAberto() {
		return aberto;
	}
	
	
	
}
