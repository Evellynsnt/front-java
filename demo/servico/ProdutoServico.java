package br.com.example.demo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.example.demo.modelo.ProdutoModelo;
import br.com.example.demo.modelo.RespostaModelo;
import br.com.example.demo.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired
    private RespostaModelo rm;
    @Autowired
    private ProdutoRepositorio pr;

        //Metodo listar
        public Iterable<ProdutoModelo> listar(){
            return pr.findAll();
        }

        //Metodo cadastrar
        public ResponseEntity<?> cadastrar(ProdutoModelo pm){
            if(pm.getNome().equals("")){
                rm.setMensagem("Nome obrigatorio");
                return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if (pm.getMarca().equals("")){
            rm.setMensagem("marca obrigatorio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            pr.save(pm);
            rm.setMensagem("Cadastrado com sucesso");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
        }
    }

    //Metodo remover
    public ResponseEntity<RespostaModelo> remover(long codigo){
        pr.deleteById(codigo);

        rm.setMensagem("Removido com sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String string) {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrarAlterar'");
    }

}

