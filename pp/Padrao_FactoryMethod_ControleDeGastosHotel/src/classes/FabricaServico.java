package classes;

public class FabricaServico implements FabricaDeGastos{

	@Override
	public Gastos criarGasto(String gasto) {
		
		if(gasto.equals("Arrumadeira")){
			return new Arrumadeira();
		}else
			return new Lavanderia();
		
	}

}
