package br.com.example.demo.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.demo.modelo.ProdutoModelo;
import br.com.example.demo.modelo.RespostaModelo;
import br.com.example.demo.servico.ProdutoServico;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {
    @Autowired
    private ProdutoServico ps;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrar(pm);
    }
    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }

    // Metodo alterar
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrarAlterar(pm, "alterar");
    }

    @DeleteMapping("/remover/(codigo)")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }
    @GetMapping
    public String rota(){
        return "api de produtos funcionando!";
    }
}
