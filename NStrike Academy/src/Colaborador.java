import java.util.ArrayList;

public class Colaborador {
	
	public String Nome;
	public String Email;
	
	protected ArrayList <Producao> Producoes;
	protected ArrayList <Projeto> Projetos;	
	
	public Colaborador()
	{
		Projetos = new ArrayList <Projeto>();
		Producoes = new ArrayList <Producao>();
	}
}
