import java.util.ArrayList;
import java.util.Scanner;

public class NStrikeAcademy {
	
	public static Projeto NovoProjeto(ArrayList <Colaborador> Colaboradores){
		
		Projeto novo = new Projeto();
		Scanner scan = new Scanner(System.in);
		
		int erro = 0, id, data = 0;
		
		while(erro == 0){
			
			try{
				System.out.println("T�tulo Do Projeto:");
				novo.Titulo = scan.nextLine();
				
				System.out.println("Data De In�cio Do Projeto:"); 
				while(data == 0){
					System.out.println("Dia:");
					novo.CDia = scan.nextInt();
					scan.nextLine();
					System.out.println("M�s:");
					novo.CMes = scan.nextInt();
					scan.nextLine();
					System.out.println("Ano:");
					novo.CAno = scan.nextInt();
					scan.nextLine();
					
					if(novo.CDia > 30 || novo.CMes > 12){
						System.out.println("Insira Uma Data V�lida!"); 
					}
					else{
						data = 1;
					}
				}
				data = 0;
				
				System.out.println("Data De Previs�o De T�rmino Do Projeto:");				
				while(data == 0){
					System.out.println("Dia:");
					novo.FDia = scan.nextInt();
					scan.nextLine();				
					System.out.println("M�s:");
					novo.FMes = scan.nextInt();
					scan.nextLine();
					System.out.println("Ano:");
					novo.FAno = scan.nextInt();
					scan.nextLine();
					if(novo.FDia > 30 || novo.FMes > 12){
						System.out.println("Insira Uma Data V�lida!"); 
					}
					else{
						data = 1;
					}
				}
				
				
				System.out.println("Ag�ncia Financiadora Do Projeto:");
				novo.Agencia = scan.nextLine();
				
				System.out.println("Valor Financiado:");
				novo.Valor = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Objetivo Do Projeto:");                                                                                    
				novo.Objetivo = scan.nextLine();
				
				System.out.println("Descri��o Do Projeto:");                                                                                    
				novo.Descricao = scan.nextLine();
				
				novo.Status = 0;
				
				System.out.println("Professores Cadastrados:");                                                                            
				for(Colaborador x : Colaboradores){
					
					if(x instanceof Professor){
						
						System.out.printf("---\nID: %d\nNome: %s\n---\n", Colaboradores.indexOf(x), x.Nome);
					}
				}
				
				System.out.println("Entre Com O ID De Um Professor Dispon�vel:");                                                      
				id = scan.nextInt();
				scan.nextLine();
				
				Colaboradores.get(id).Projetos.add(novo);
				novo.Colaboradores.add(Colaboradores.get(id));
				
				erro = 1;
			}
			
			catch(java.util.InputMismatchException test){
				
				System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
				scan.nextLine();
			}
			catch(java.lang.IndexOutOfBoundsException test1){
				
				System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
			}			
		}
		
		return novo;
	}
	
	public static Colaborador NovoColaborador(){
		
		Scanner scan = new Scanner(System.in);
		
		Colaborador novosuper = new Colaborador();
		System.out.println("Nome:");
		novosuper.Nome = scan.nextLine();
		System.out.println("Email:");
		novosuper.Email = scan.nextLine();
		
		int classe, i = 0;
		while(i == 0){
			
			try{
				System.out.println("Qual A Classe Do Novo Colaborador:\n"
						+ "1 - Professor\n"
						+ "2 - Pesquisador\n"
						+ "3 - Graduando\n"
						+ "4 - Mestrando\n"
						+ "5 - Doutorando\n");
				classe = scan.nextInt();
				scan.nextLine();
				
				if(classe == 1){				
					Professor novo = new Professor();
						
					novo.Nome = novosuper.Nome;
					novo.Email = novosuper.Email;
						
					return novo;
				}
				
				else if(classe == 2){
					Pesquisador novo = new Pesquisador();
					
					novo.Nome = novosuper.Nome;
					novo.Email = novosuper.Email;
					
					return novo;
				}
				
				else if(classe == 3){
					Graduando novo = new Graduando();
					
					novo.Nome = novosuper.Nome;
					novo.Email = novosuper.Email;
					
					return novo;
				}
				
				else if (classe == 4){
					Mestrando novo = new Mestrando();
					
					novo.Nome = novosuper.Nome;
					novo.Email = novosuper.Email;
					
					return novo;
				}
				
				else if (classe == 5){
					Doutorando novo = new Doutorando();
					
					novo.Nome = novosuper.Nome;
					novo.Email = novosuper.Email;
					
					return novo;
				}
				
				else{
					System.out.println("Op��o Inv�lida\n");
				}
			}
			
			catch(java.util.InputMismatchException test){
				System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
				System.out.println("Vamos Tentar Outra Vez!\n");
				scan.nextLine();
			}
			
		}		
		
		return null;		
	}
	
	public static void ListarProjetos(ArrayList <Projeto> Projetos){
		
		try{
			
			int i;
			if(Projetos.size() != 0){
				for (i = 0 ; i < Projetos.size() ; i++){
					
					System.out.printf("---\nID: %d\nT�tulo: %s\n---\n", i, Projetos.get(i).Titulo);
				}
			}
			
			else{
				System.out.println("N�o Existem Projetos Adicionados\n");
			}
		}
		
		catch (java.lang.NullPointerException test){
			
			System.out.println("\t   Ops!!!\n");
		}
		
		catch(java.lang.IndexOutOfBoundsException test1){
			
			System.out.println("\t   Ops!!!\n");
		}
	}
	
	public static void ListarColaboradores(ArrayList <Colaborador> Colaboradores){
		
		try{
			
			if(Colaboradores.size() != 0){
				
				int i;
				for (i = 0; i < Colaboradores.size() ; i++){
					
					System.out.printf("---\nID: %d\nNome: %s\n---\n", i, Colaboradores.get(i).Nome);
				}
			}
			
			else{
				
				System.out.printf("N�o Existem Colaboradores Adicionados\n");
			}
		}
		
		catch (java.lang.NullPointerException test){
			
			System.out.println("\t   Ops!!!\n");
		}
		
		catch(java.lang.IndexOutOfBoundsException test1){
			
			System.out.println("\t   Ops!!!\n");
		}
	}
	
	public static Producao AdicionarProducaoAcademica(ArrayList <Colaborador> Colaboradores, ArrayList <Projeto> Projetos, int Tipo)
	{
		Scanner scan = new Scanner(System.in);
		Producao nova = new Producao();
		int Confirmar, id, erro = 0, data = 0;
		
		while(erro == 0){
			try{
				
				if(Tipo == 1){
					
					System.out.println("T�tulo Da Orienta��o:");
					nova.Tipo = 1;
					nova.Titulo = scan.nextLine();
					nova.ConferenciaNome = null;
					
					System.out.println("Data Da Orienta��o:");
					while(data == 0){
						System.out.println("Dia:");
						nova.Dia = scan.nextInt();
						scan.nextLine();
						System.out.println("M�s:");
						nova.Mes = scan.nextInt();
						scan.nextLine();
						System.out.println("Ano:");
						nova.Ano = scan.nextInt();
						scan.nextLine();
						if(nova.Dia > 30 || nova.Mes > 12){
							System.out.println("Insira Uma Data V�lida!"); 
						}
						else{
							data = 1;
						}
					}
					
				}
				
				else if (Tipo == 2){
					
					System.out.println("T�tulo Da Publica��o:");
					nova.Tipo = 2;
					nova.Titulo = scan.nextLine();
					System.out.println("Nome Da Confer�ncia Onde Foi Publicada:");
					nova.ConferenciaNome = scan.nextLine();
					System.out.println("Data Da Publica��o:");
					while(data == 0){
						System.out.println("Dia:");
						nova.Dia = scan.nextInt();
						scan.nextLine();
						System.out.println("M�s:");
						nova.Mes = scan.nextInt();
						scan.nextLine();
						System.out.println("Ano:");
						nova.Ano = scan.nextInt();
						scan.nextLine();
						if(nova.Dia > 30 || nova.Mes > 12){
							System.out.println("Insira Uma Data V�lida!"); 
						}
						else{
							data = 1;
						}
					}
					
					System.out.println("Adicionar Mais Colaboradores A Publica��o?\n"
							+ "1 - Sim\n"
							+ "2 - N�o");
					Confirmar = scan.nextInt();
					scan.nextLine();
					
					while(Confirmar == 1){
						
						ListarColaboradores(Colaboradores);
						System.out.println("Entre Com O ID De Um Colaborador Dispon�vel");
						id = scan.nextInt();
						scan.nextLine();
						Colaboradores.get(id).Producoes.add(nova);	
						System.out.println("Colaborador Adicionado Com Sucesso\n");
						
						System.out.println("Adicionar Mais Colaboradores A Publica��o?\n"
								+ "1 - Sim\n"
								+ "2 - N�o");
						Confirmar = scan.nextInt();
						scan.nextLine();
					}
					
				}
				
				erro = 1;
			}
			
			catch(java.util.InputMismatchException test){
				
				System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
				scan.nextLine();
			}
			catch(java.lang.IndexOutOfBoundsException test1){
				
				System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
			}
		}
		
		return nova;
	}
	
	public static void PrintarProjetosOrdenados(ArrayList <Projeto> Projetos){
		
		try{
			
			Ordem Ordenar[] = new Ordem[Projetos.size()];
			Ordem Troca = new Ordem();
			int i, j;
			
			for(i = 0 ; i < Projetos.size() ; i++){
				
				Ordenar[i] = new Ordem();
			}
			
			for(i = 0 ; i < Projetos.size() ; i++){
				
				Projeto aux = Projetos.get(i);
				Ordenar[i].Peso = aux.FDia + (aux.FMes*30) + (aux.FAno*365);
				Ordenar[i].Dia = aux.FDia;
				Ordenar[i].Mes = aux.FMes;
				Ordenar[i].Ano = aux.FAno;
				Ordenar[i].Titulo = aux.Titulo;
				Ordenar[i].Condicao = aux.Status;
			}
			
			for(i = 0 ; i < (Projetos.size())-1 ; i++){
				
				for(j = 1 ; j < Projetos.size() ; j++){		
					
					if(Ordenar[i].Peso < Ordenar[j].Peso){
						
						Troca.Peso = Ordenar[i].Peso;
						Ordenar[i].Peso = Ordenar[j].Peso;
						Ordenar[j].Peso = Troca.Peso;
						
						Troca.Titulo = Ordenar[i].Titulo;
						Ordenar[i].Titulo = Ordenar[j].Titulo;
						Ordenar[j].Titulo = Troca.Titulo;
						
						Troca.Dia = Ordenar[i].Dia;
						Ordenar[i].Dia = Ordenar[j].Dia;
						Ordenar[j].Dia = Troca.Dia;
						
						Troca.Mes = Ordenar[i].Mes;
						Ordenar[i].Mes = Ordenar[j].Mes;
						Ordenar[j].Mes = Troca.Mes;
						
						Troca.Ano = Ordenar[i].Ano;
						Ordenar[i].Ano = Ordenar[j].Ano;
						Ordenar[j].Ano = Troca.Ano;
						
						Troca.Condicao = Ordenar[i].Condicao;						
						Ordenar[i].Condicao = Ordenar[j].Condicao;
						Ordenar[j].Condicao = Troca.Condicao;
					}		
				}
			}
			
			for(i = 0 ; i < Projetos.size() ; i++){
				
				switch(Ordenar[i].Condicao){
				case 0:
					System.out.printf("-----\nT�tulo: %s\n"
							+ "Status: Em Andamento\n"
							+ "Data De Conclus�o Prevista: %d/%d/%d\n-----\n", Ordenar[i].Titulo, Ordenar[i].Dia, Ordenar[i].Mes, Ordenar[i].Ano);
					break;
				case 1:
					System.out.printf("-----\nT�tulo: %s\n"
							+ "Status: Em Elabora��o\n"
							+ "Data De Conclus�o Prevista: %d/%d/%d\n-----\n", Ordenar[i].Titulo, Ordenar[i].Dia, Ordenar[i].Mes, Ordenar[i].Ano);
					break;
				case 2:
					System.out.printf("-----\nT�tulo: %s\n"
							+ "Status: Concluido\n"
							+ "Data: %d/%d/%d\n-----\n", Ordenar[i].Titulo, Ordenar[i].Dia, Ordenar[i].Mes, Ordenar[i].Ano);
					break;	
				}	
			}
		}
		
		catch (java.lang.NullPointerException test){
			
			System.out.println("\t   Ops!!!\n"
					+ "N�o Possui Projetos Adicionados\n");
		}
		
		catch(java.lang.IndexOutOfBoundsException test1){
			
			System.out.println("\t   Ops!!!\n");
		}
	}
	
	public static void PrintarProducoesOrdenadas(ArrayList <Producao> Producoes){
		try{
			
			Ordem Ordenar[] = new Ordem[Producoes.size()];
			Ordem Troca = new Ordem();
			
			int i, j;
			
			for(i = 0 ; i < Producoes.size() ; i++){
				
				Ordenar[i] = new Ordem();
			}
			
			for(i = 0 ; i < Producoes.size() ; i++){
				
				Producao aux = Producoes.get(i);
				Ordenar[i].Peso = aux.Dia + (aux.Mes*30) + (aux.Ano*365);
				Ordenar[i].Dia = aux.Dia;
				Ordenar[i].Mes = aux.Mes;
				Ordenar[i].Ano = aux.Ano;
				Ordenar[i].Titulo = aux.Titulo;
				Ordenar[i].Condicao = aux.Tipo;
			}
			
			for(i = 0 ; i < (Producoes.size())-1 ; i++){
				
				for(j = 1 ; j < Producoes.size() ; j++){	
					
					if(Ordenar[i].Peso < Ordenar[j].Peso){	
						
						Troca.Peso = Ordenar[i].Peso;
						Ordenar[i].Peso = Ordenar[j].Peso;
						Ordenar[j].Peso = Troca.Peso;
						
						Troca.Titulo = Ordenar[i].Titulo;
						Ordenar[i].Titulo = Ordenar[j].Titulo;
						Ordenar[j].Titulo = Troca.Titulo;
						
						Troca.Dia = Ordenar[i].Dia;
						Ordenar[i].Dia = Ordenar[j].Dia;
						Ordenar[j].Dia = Troca.Dia;
						
						Troca.Mes = Ordenar[i].Mes;
						Ordenar[i].Mes = Ordenar[j].Mes;
						Ordenar[j].Mes = Troca.Mes;
						
						Troca.Ano = Ordenar[i].Ano;
						Ordenar[i].Ano = Ordenar[j].Ano;
						Ordenar[j].Ano = Troca.Ano;
						
						Troca.Condicao = Ordenar[i].Condicao;
						Ordenar[i].Condicao = Ordenar[j].Condicao;
						Ordenar[j].Condicao = Troca.Condicao;
					}		
				}
			}
			
			for(i = 0 ; i < Producoes.size() ; i++){
				
				switch(Ordenar[i].Condicao){
					case 1:
						System.out.printf("-----\nOrienta��o\n"
								+ "T�tulo: %s"
								+ "Data: %d/%d/%d\n-----\n", Ordenar[i].Titulo, Ordenar[i].Dia, Ordenar[i].Mes, Ordenar[i].Ano);
						break;
					case 2:
						System.out.printf("-----\nPublica��o\n"
								+ "T�tulo: %s"
								+ "Data: %d/%d/%d\n-----\n", Ordenar[i].Titulo, Ordenar[i].Dia, Ordenar[i].Mes, Ordenar[i].Ano);
						break;
				}				
			}		
		}
		
		catch (java.lang.NullPointerException test){
			
			System.out.println("\t   Ops!!!\n"
					+ "N�o Possui Produ��es Acad�micas Adicionadas\n");
		}
		
		catch(java.lang.IndexOutOfBoundsException test1){
			
			System.out.println("\t   Ops!!!\n");
		}
	}
	
	public static void ProjetoConsulta(ArrayList <Projeto> Projetos, ArrayList <Colaborador> Colaboradores){
		Scanner scan = new Scanner(System.in);
		int erro = 0, id;
		while (erro == 0){
			
			try	{
				
				ListarProjetos(Projetos);
				System.out.println("ID Do Projeto.\n");				
				id = scan.nextInt();
				scan.nextLine();
				
				Projeto Consulta = Projetos.get(id);
	
				System.out.printf("T�tulo: %s\n", Consulta.Titulo);
				System.out.printf("ID: %d\n", id);
							                  
				if(Consulta.Status == 0)
				{
					System.out.printf("Status: Em Elabora��o");
				}
				else if(Consulta.Status == 1)
				{
					System.out.printf("Status: Em Andamento");
				}
				else if(Consulta.Status == 2)
				{
					System.out.printf("Status: Conclu�do");
				}
				
				System.out.printf("Data de in�nio: %d/%d/%d\n", Consulta.CDia, Consulta.CMes, Consulta.CAno);
				System.out.printf("Data de t�rmino: %d/%d/%d\n", Consulta.FDia, Consulta.FMes, Consulta.FAno);
				System.out.printf("Ag�ncia Patrocinadora: %s\n", Consulta.Agencia);
				System.out.printf("Valor Investido: %d\n", Consulta.Valor);
				System.out.printf("Objetivo: %s\n", Consulta.Objetivo);
				System.out.println("Colaboradores Associados:");
				ListarColaboradores(Consulta.Colaboradores);
				System.out.println("Publica��es Associadas:");
				PrintarProducoesOrdenadas(Consulta.Publicacoes);
				
				erro = 1;
			}
			
			catch(java.util.InputMismatchException test){
				
				System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
				System.out.println("Retornando Ao Menu!");
				scan.nextLine();
				erro = 1;
			}
			catch(java.lang.IndexOutOfBoundsException test1){
				
				System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
				System.out.println("Retornando Ao Menu!");
				erro = 1;
			}			
			catch (java.lang.NullPointerException test2){
				
				System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
				System.out.println("Retornando Ao Menu!");
				erro = 1;
			}
		}		
					
	}
	
	public static void ColaboradorConsulta(ArrayList <Projeto> Projetos, ArrayList <Colaborador> Colaboradores){
		
		Scanner scan = new Scanner(System.in);
		int erro = 0, id;
		
		while (erro == 0){
			
			try{
				
				ListarColaboradores(Colaboradores);
				System.out.println("ID Do Colaborador:\n");				
				id = scan.nextInt();
				scan.nextLine();				
				Colaborador Consulta = Colaboradores.get(id);

				System.out.printf("Nome: %s\n", Consulta.Nome);
				System.out.printf("ID: %d\n", id);
				System.out.printf("EMAIL: %s\n", Consulta.Email);
				System.out.printf("Projetos Associados:\n");
				PrintarProjetosOrdenados(Consulta.Projetos);
				System.out.printf("Produ��es:\n");
				PrintarProducoesOrdenadas(Consulta.Producoes);
				
				erro = 1;
			}
			
			catch(java.util.InputMismatchException test){
				
				System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
				System.out.println("Retornando Ao Menu!");
				scan.nextLine();
			}
			catch(java.lang.IndexOutOfBoundsException test1){
				
				System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
				System.out.println("Retornando Ao Menu!");
			}			
			catch (java.lang.NullPointerException test2){
				
				System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
				System.out.println("Retornando Ao Menu!");
			}
		}
					
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);		
		
		System.out.println("\t     Ol�!\nBem-Vindo A Academia NStrike!");
		System.out.println("\nInicializando Software De Produtividade Academica...");	
		System.out.println("\nSoftware Inicializado Com Sucesso!");
		
		ArrayList <Colaborador> Colaboradores = new ArrayList <Colaborador>();
		ArrayList <Projeto> Projetos = new ArrayList <Projeto>();
		ArrayList <Producao> Producoes = new ArrayList <Producao>();
		
		int Comando = 1;
		
		while(Comando > 0){
			
			try{
				
				System.out.println("\nDigite No Console O N�mero Do Comando Que Deseja Executar:");
				System.out.println("\t0 - Encerrar Programa\n"
						+ "\t1 - Adicionar Projeto\n"
						+ "\t2 - Adicionar Colaborador\n"
						+ "\t3 - Editar ou Adicionar Informa��es De Um Projeto\n"
						+ "\t4 - Adicionar Uma Produ��o Academica\n"
						+ "\t5 - Relat�rio De Produ��o Academica\n"
						+ "\t6 - Consulta\n");
				
				System.out.println("Digite Aqui Comando Que Deseja Executar:");
				Comando = scan.nextInt();
				scan.nextLine();
				
				if(Comando == 0){
					System.out.println("\nSincronizando Altera��es Locais Com Os Servidores...");
					System.out.println("\nEncerrando Software De Produtividade Academica...");
					System.out.println("\n\tObrigado Pela Prefer�ncia!");
				}
				
				else if(Comando == 1){
					Projetos.add(NovoProjeto(Colaboradores));
					System.out.println("Novo Projeto Adicionado Com Sucesso!");
				}
				
				else if(Comando == 2){
					Colaboradores.add(NovoColaborador());
					System.out.println("Novo Colaborador Adicionado Com Sucesso!");
				}
				
				else if(Comando == 3){
					
					if(Projetos.size() > 0){					
						try{
							ListarProjetos(Projetos);
							System.out.println("ID Do Projeto:");
							int ID = scan.nextInt();
							scan.nextLine();
							
							System.out.println("Selecione a op��o que deseja editar:");
							System.out.println("1.Alocar novos colaboradores a projetos");
							System.out.println("2.Altera��o de status de projeto");
							int opcao = scan.nextInt();
							scan.nextLine();

							if(opcao == 1)
							{
								if(Projetos.get(ID).Status != 0)
								{
									System.out.println("Projeto N�o Est� Em Fase De Elabora��o");
								}
								else
								{
									ListarColaboradores(Colaboradores);
									System.out.println("ID Do Colaborador");
									int id = scan.nextInt();
									scan.nextLine();
									
									int add = 0, i;
									for(i = 0 ; i < Projetos.get(ID).Colaboradores.size() ; i++){
										if(Projetos.get(ID).Colaboradores.get(i).Nome == Projetos.get(ID).Colaboradores.get(id).Nome){
											System.out.println("Colaborador J� Associado Ao Projeto!");
											add = 1;
										}
									}
									
									if(add == 0){
										Colaboradores.get(id).Projetos.add(Projetos.get(ID));
										Projetos.get(ID).Colaboradores.add(Colaboradores.get(id));
										System.out.println("Colaborador Adicionado");
									}
							
								}				
							}
							else if(opcao == 2)
							{
								int Confirmar, i;
								if(Projetos.get(ID).Status == 2){
									
									System.out.println("Atual: Conclu�do");
									System.out.println("N�o Pode Ser Alterado");
								}
								
								else if(Projetos.get(ID).Status == 0)
								{										
									System.out.println("Atual: Em Elabora��o");
									
									System.out.println("Alterar Status Para Em Andamento\n"
											+ "1 - Sim\n"
											+ "2 - N�o");
									Confirmar = scan.nextInt();
									scan.nextLine();
									
									for(i = 0; i < Projetos.get(ID).Colaboradores.size() ; i++){
										if(Colaboradores.get(i) instanceof Graduando)
										{													
											if(((Graduando)Colaboradores.get(i)).NProjetos == 2){
												Confirmar = 3;
											}
											
										}
									}
									
									if(Confirmar == 1){
										Projetos.get(ID).Status = 1;
										for(i = 0; i < Projetos.get(ID).Colaboradores.size() ; i++){
											if(Colaboradores.get(i) instanceof Graduando)
											{													
												((Graduando)Colaboradores.get(i)).NProjetos++;
												
											}
										}
										System.out.println("Status Alterado!");
									}
									
									else if(Confirmar == 3){
										System.out.println("Projeto Possui Graduando Com Limite M�ximo De Projetos Em Andamento!");
									}
								}
								else if(Projetos.get(ID).Status == 1)
								{
									System.out.println("Atual: Em Andamento");
									
									if(Projetos.get(ID).Publicacoes.size() != 0)
									{
										System.out.println("Alterar Status Para Conclu�do\n"
												+ "1 - Sim\n"
												+ "2 - N�o");
										Confirmar = scan.nextInt();
										scan.nextLine();
										
										if(Confirmar == 1){
											Projetos.get(ID).Status = 2;
											for(i = 0; i < Projetos.get(ID).Colaboradores.size() ; i++){
												if(Colaboradores.get(i) instanceof Graduando)
												{													
													((Graduando)Colaboradores.get(i)).NProjetos--;
													
												}
											}
											System.out.println("Status Alterado!");
										}
									}
									
									else{
										System.out.println("Status N�o Pode Ser Alterado(Projeto N�o Possui Publica��es)");
									}
								}
											
							}
							else
							{
								System.out.println("Op��o selecionada inv�lida.\nRetornando ao menu principal.\n");
							}
						}
						
						catch(java.util.InputMismatchException test){
							
							System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
							System.out.println("Retornando Ao Menu!");
							scan.nextLine();
						}
						catch(java.lang.IndexOutOfBoundsException test1){
							
							System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
							System.out.println("Retornando Ao Menu!");
						}
						
						catch (java.lang.NullPointerException test2)
						{
							System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
							System.out.println("Retornando Ao Menu!");
						}
					}
					else
					{
						System.out.println("Lista de Projetos est� vazia.\nRetornando ao menu principal.\n");
					}
				}
				else if(Comando == 4){
					System.out.println("Tipo De Produ��o Acad�mica:\n"
							+ "	1 - Orienta��o\n"
							+ "	2 - Publica��es\n");
					int Tipo = scan.nextInt();
					scan.nextLine();
					
					int Confirmar, Teste;
					
					try{
						
						if(Tipo == 1){
							
							try{
								
								ListarColaboradores(Colaboradores);
								System.out.println("Digite A ID Do Orientador:");
								int orientador = scan.nextInt();
								scan.nextLine();
								
								Teste = 0;
								while(Teste == 0){
									if(Colaboradores.get(orientador) instanceof Professor){
										Teste = 1;
									}
									
									else{
										System.out.println("Selecione Um Professor");
										System.out.println("Digite A ID Do Orientador:");
										orientador = scan.nextInt();
										scan.nextLine();

									}
								}
								
								ListarColaboradores(Colaboradores);
								System.out.println("Digite A ID Do Orientado:");
								int orientado = scan.nextInt();
								scan.nextLine();
								
								Teste = 0;
								while(Teste == 0){
									if(Colaboradores.get(orientado) instanceof Graduando || Colaboradores.get(orientado) instanceof Mestrando || Colaboradores.get(orientado) instanceof Doutorando){
										Teste = 1;
									}
									
									else{
										System.out.println("Selecione Um Aluno");
										System.out.println("Digite A ID Do Orientado:");
										orientado = scan.nextInt();
										scan.nextLine();

									}
								}
								
								((Professor)Colaboradores.get(orientador)).Orientados.add(Colaboradores.get(orientado));
								Producao nova = AdicionarProducaoAcademica(Colaboradores,Projetos,1);
								Colaboradores.get(orientador).Producoes.add(nova);
								System.out.println(Colaboradores.get(orientador).Producoes.size());
								Producoes.add(nova);
								
								if(Colaboradores.get(orientado) instanceof Graduando){
									
									((Graduando)Colaboradores.get(orientado)).Orientando.add(Colaboradores.get(orientador));
								}
								else if(Colaboradores.get(orientado) instanceof Mestrando){
									
									((Mestrando)Colaboradores.get(orientado)).Orientando.add(Colaboradores.get(orientador));
								}
								else if(Colaboradores.get(orientado) instanceof Doutorando){
									
									((Doutorando)Colaboradores.get(orientado)).Orientando.add(Colaboradores.get(orientador));
								}
								
								System.out.println("Produ��o Academica Adicionada Com Sucesso\n");															
								
							}
							
							catch(java.util.InputMismatchException test){
								
								System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
								System.out.println("Retornando Ao Menu!");
								scan.nextLine();
							}
							catch(java.lang.IndexOutOfBoundsException test1){
								
								System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
								System.out.println("Retornando Ao Menu!");
							}
							catch(java.lang.NullPointerException test2){
								
								System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
								System.out.println("Retornando Ao Menu!");
							}
						}
						else if (Tipo == 2){
							
								try{
									ListarColaboradores(Colaboradores);
									System.out.println("ID Do Colaborador:");									
									int colaborador = scan.nextInt();
									scan.nextLine();
									Colaboradores.get(colaborador);
									Producao nova = AdicionarProducaoAcademica(Colaboradores,Projetos,2);
									Producoes.add(nova);
									Colaboradores.get(colaborador).Producoes.add(nova);
									
									ListarProjetos(Projetos);
									System.out.println("A Publica��o Est� Associada A Algum Dos Projetos Acima?\n"
											+ "1 - Sim\n"
											+ "2 - N�o");
									
									Confirmar = scan.nextInt();
									scan.nextLine();
									if(Confirmar == 1){
										System.out.println("Insira O ID Do projeto.");
										int projeto = scan.nextInt();
										scan.nextLine();
										
										while(Projetos.get(projeto).Status != 1){
											if(Projetos.get(projeto).Status != 1){
												System.out.println("Projeto Inv�lido(Selecione Um Projeto Em Andamento)");
												System.out.println("Insira O ID Do projeto.");
												projeto = scan.nextInt();
												scan.nextLine();
											}
										}
										
										Projetos.get(projeto).Publicacoes.add(nova);
										System.out.println("Produ��o Academica Adicionada Com Sucesso\n");
									}
									
								
								}
								catch(java.lang.IndexOutOfBoundsException test){
									
									System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
									System.out.println("Retornando Ao Menu!");
								}
						}
						else
						{
							System.out.println("Op��o Inv�lida\n");
						}
					}
					
					catch(java.util.InputMismatchException test1){
						
						System.out.println("\t  Ops!!!\nPor favor Insira As Informa��es De Forma Correta");
						System.out.println("Retornando Ao Menu!");
						scan.nextLine();
					}
					catch(java.lang.NullPointerException test2){
						
						System.out.println("\t   Ops!!!\nPor favor Insira ID's V�lidos");
						System.out.println("Retornando Ao Menu!");
					}	
					
				}
				
				else if(Comando == 5){
					System.out.printf("N�mero De Colaboradores: %d\n", Colaboradores.size());					
					
					int Elaboracao = 0, Andamento = 0, Concluido = 0;
					for(int i = 0; i < Projetos.size(); i++)
					{
						if(Projetos.get(i).Status == 0)
						{
							Elaboracao++;
						}
						else if(Projetos.get(i).Status == 1)
						{
							Andamento++;
						}
						else 
						{
							Concluido++;
						}
					}
					
					System.out.printf("N�mero De Projetos:\n"
							+ "	Em Elabora��o: %d\n"
							+ "	Em Andamento: %d\n"
							+ "	Conclu�dos:   %d\n", Elaboracao,Andamento,Concluido);
					System.out.printf("\nTotal De Projetos: %d\n", Projetos.size());
										
					int Orientacao = 0, Producao = 0;
					
					for(int i = 0; i < Producoes.size(); i++)
					{
						if(Producoes.get(i).Tipo == 1)
						{
							Orientacao++;
						}
						else
						{
							Producao++;
						}
					}
					System.out.printf("N�mero De Produ��o Acad�mica:\n"
							+ "	Orienta��es: %d\n"
							+ "	Publica��es: %d\n", Orientacao, Producao);
				}
				
				else if(Comando == 6){
					int Tipo = 0;
					while(Tipo != 1 && Tipo != 2)
					{
						System.out.println("Tipo De Consulta:\n"
								+ "1 - Colaborador\n"
								+ "2 - Projeto");
						Tipo = scan.nextInt();
						scan.nextLine();
						
						if(Tipo != 1 && Tipo != 2){
							System.out.println("\nTipo Inv�lido\n");
						}
					}
					if(Tipo == 1)
					{
						ColaboradorConsulta(Projetos, Colaboradores);
					}
					else if(Tipo == 2)
					{						
						ProjetoConsulta(Projetos, Colaboradores);
					}
				}
				
				else{
					System.out.println("\nComando Inv�lido\n");
				}
			}
			
			catch(java.util.InputMismatchException test){
				System.out.println("\nEntrada Inv�lida\n");
				scan.nextLine();
				Comando = 1;
			}
		}	
		

	}

}
