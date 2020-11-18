package classes;

public class FabricaConsumo implements FabricaDeGastos{

	@Override
	public Gastos criarGasto(String gasto) {
		
		if(gasto.equals("Cerveja")){
			return new Cerveja();
		}else
			return new Agua();
		
	}

}
