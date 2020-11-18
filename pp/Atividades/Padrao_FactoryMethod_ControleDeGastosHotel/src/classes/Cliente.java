package classes;

public class Cliente {
	
	public static void main(String[] args) {
		FabricaDeGastos fabrica = new FabricaConsumo();
		Gastos gasto = fabrica.criarGasto("Cerveja");
		gasto.exibirInfo();
		System.out.println();
		
		fabrica = new FabricaConsumo();
		gasto = fabrica.criarGasto("Agua");
		gasto.exibirInfo();
		System.out.println();
		
		fabrica = new FabricaServico();
		gasto = fabrica.criarGasto("Arrumadeira");
		gasto.exibirInfo();
		System.out.println();
		
		fabrica = new FabricaServico();
		gasto = fabrica.criarGasto("Lavanderia");
		gasto.exibirInfo();
		System.out.println();
	}

}
