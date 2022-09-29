package br.ufrn.imd.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.ufrn.imd.domino.Veiculo;

public class Repositorio {

	private List<Veiculo> veiculos;
	
	/**
	 * Questão a
	 * @param v
	 */
	public void addVeiculo(Veiculo v) {
		if(veiculos == null)
			veiculos = new ArrayList<Veiculo>();
		veiculos.add(v);
	}
	
	/**
	 * Questão b (parte 1)
	 * @return
	 */
	public List<Veiculo> listarVeiculosCadastrados() {
		return veiculos;
	}

	/**
	 * Questão b (parte 2)
	 * @return
	 */
	public String maiorMarca() {
		
		HashMap<String, Integer> qtdMarcas = new HashMap<String, Integer>();
		for (Veiculo veiculo : veiculos) {
			if(qtdMarcas.get(veiculo.getMarca()) == null){
				qtdMarcas.put(veiculo.getMarca(), 1);
			} else {
				int qtdVeiculo = qtdMarcas.get(veiculo.getMarca()); 
				qtdMarcas.put(veiculo.getMarca(), qtdVeiculo+1);
			}
		}

		int maiorMarca = 0;
		String retorno ="";
		for (Map.Entry<String, Integer> set : qtdMarcas.entrySet()) {
			if(maiorMarca < set.getValue()) {
				maiorMarca = set.getValue();
				retorno = set.getKey();
			}
       }
		return retorno;
	}
	
	/**
	 * Questão c (parte 1)
	 * @return
	 */
	public List<Veiculo> veiculosAlugados() {
		return veiculos(true);
	}

	public List<Veiculo> veiculos(boolean alugado) {
		List<Veiculo> veiculosAlugados = new ArrayList<Veiculo>();
		for (Veiculo veiculo : veiculos) {
			if(veiculo.isAlugado() == alugado)
				veiculosAlugados.add(veiculo);
		}
		return veiculosAlugados;
	}
	
	/**
	 * Questão c (parte 2)
	 * @return
	 */
	public double valorAlugueis() {
		
		double total = 0;
		for (Veiculo veiculo : veiculosAlugados()) {
			total+= veiculo.getValorAluguel();
		}
		
		return total;
	}
	
	/**
	 * Questão d (parte 1)
	 * @return
	 */
	public List<Veiculo> veiculosDisponiveis() {
	
		return veiculos(false);
		
	}
	
	/**
	 * Questão d (parte 2)
	 * @return
	 */
	public Veiculo veiculoMaisCaroDisponivel() {
		double valorAluguel = 0;
		Veiculo maisCaro = new Veiculo();
		for (Veiculo veiculo : veiculos) {
			if(valorAluguel < veiculo.getValorAluguel()) {
				valorAluguel = veiculo.getValorAluguel();
				maisCaro = veiculo;
			}
		}
		return maisCaro;
	}
	
	/**
	 * Questão d (parte 3)
	 * @return
	 */
	public Veiculo veiculoMaisBaratoDisponivel() {
		
		double valorAluguel = 0;
		Veiculo maisBarato = new Veiculo();
		for (Veiculo veiculo : veiculos) {
			if(valorAluguel == 0 || valorAluguel > veiculo.getValorAluguel()) {
				valorAluguel = veiculo.getValorAluguel();
				maisBarato = veiculo;
			}				

		}
		return maisBarato;
	}
	
	
	
	
	
	
}
