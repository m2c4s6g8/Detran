package br.edu.ifms.detran.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.detran.dto.InfracaoDto;
import br.edu.ifms.detran.model.Infracao;
import br.edu.ifms.detran.repository.RepositoryInfracao;

@Service
public class InfracaoService {
	@Autowired
	private RepositoryInfracao repositoryInfracao;
	
	public List buscarTodos(){
		return repositoryInfracao.findAll();
	}
	
	public Infracao buscarId(Long id) {
		Optional <Infracao> infracao = repositoryInfracao.findById(id);
		return infracao.orElseThrow();
	}
	
	public Infracao inserir(Infracao infracao) {
		infracao.setId(null);
		return repositoryInfracao.save(null);
		}

		public void remover(Long id) {
		buscarId(id);
		repositoryInfracao.deleteById(id);
		}
		
		public Infracao atualizar(Infracao infracao) {
			Infracao infracaoNovo = buscarId(infracao.getId());
			infracaoNovo.setDescricao(infracao.getDescricao());
			infracaoNovo.setPontos(infracao.getPontos());
			infracaoNovo.setValor(infracao.getValor());
			return repositoryInfracao.save(infracaoNovo);
		}
		
		public Infracao formDto(InfracaoDto infracaoDto) {
			return new Infracao(infracaoDto.getId(),infracaoDto.getDescricao(),infracaoDto.getPontos(),infracaoDto.getValor());
		}
	
		
}
