import java.util.ArrayList;

public class Projeto {
	
	public String Titulo;
	
	public int CDia;
	public int CMes;
	public int CAno;
	public int FDia;
	public int FMes;
	public int FAno;
	
	public String Agencia;
	public int Valor;
	
	public String Objetivo;
	public String Descricao;
	
	public int Status = 0; // Elaboração Andamento Concluido
	
	ArrayList <Colaborador> Colaboradores = new ArrayList <Colaborador>();
	ArrayList <Producao> Publicacoes = new ArrayList <Producao>();
	
	public Projeto()
	{
		Colaboradores = new ArrayList <Colaborador>();
		Publicacoes = new ArrayList <Producao>();
	}

}
