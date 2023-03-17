package br.edu.ifms.detran.service;


import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.model.Apolice;
import br.edu.ifms.detran.model.Carro;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.model.Multa;
import br.edu.ifms.detran.repository.RepositoryApolice;
import br.edu.ifms.detran.repository.RepositoryCarro;
import br.edu.ifms.detran.repository.RepositoryInfracao;
import br.edu.ifms.detran.repository.RepositoryMulta;

@Service
public class DBService {

	@Autowired
	RepositoryCarro repositoryCarro;
	@Autowired
	RepositoryApolice repositoryApolice;
	@Autowired
	RepositoryInfracao repositoryInfracao;
	@Autowired
	RepositoryMulta repositoryMulta;
	
	public void instantiateTestDatabase() throws ParseException{
		// TODO Auto-generated method stub
		
		Carro car1 = new Carro(null,"Onix","Chevrolet",2019,"OOL 1410","Vermelho",null);
		Carro car2 = new Carro(null,"Onix","Chevrolet",2022,"OOL 3020","Azul",null);
		Carro car3 = new Carro(null,"Voiage","Chevrolet",2023,"OOL 0405","Vinho",null);
		
		Apolice apo1 = new Apolice(null,3000,"Total","12/2030",car1);
		
		Infracao i1 = new Infracao(null,"Estacionamento proibido",7,150);
		Infracao i2 = new Infracao(null,"Cinto de seguranca",5,99);
		Infracao i3 = new Infracao(null,"Velocidade acima da permitida",10,299);
		
		Multa m1 = new Multa(null, "Corumba", 2020, car1, i3);
		Multa m2 = new Multa(null, "Ladario", 2023, car2, i2);
		Multa m3 = new Multa(null, "Campo Grande", 2021, car3, i1);
		
		
		repositoryApolice.saveAll(Arrays.asList(apo1));
		repositoryCarro.saveAll(Arrays.asList(car1,car2,car3));
		repositoryInfracao.saveAll(Arrays.asList(i1,i2,i3));
		repositoryMulta.saveAll(Arrays.asList(m1,m2,m3));
	}
	
}
