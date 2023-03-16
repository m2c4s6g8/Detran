package br.edu.ifms.detran.service;


import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Apolice;
import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.repository.RepositoryApolice;
import br.edu.ifms.detran.repository.RepositoryCarro;

@Service
public class DBService {

	@Autowired
	RepositoryCarro repositoryCarro;
	@Autowired
	RepositoryApolice repositoryApolice;
	
	public void instantiateTestDatabase() throws ParseException{
		// TODO Auto-generated method stub
		
		Carro car1 = new Carro(null,"Onix","Chevrolet",2019,"OOL 1410","Vermelho",null);
		Carro car2 = new Carro(null,"Onix","Chevrolet",2022,"OOL 3020","Azul",null);
		
		Apolice apo1 = new Apolice(null,3000,"Total","12/2030",car1);
		
		repositoryApolice.saveAll(Arrays.asList(apo1));
		repositoryCarro.saveAll(Arrays.asList(car1,car2));
	}
	
}
