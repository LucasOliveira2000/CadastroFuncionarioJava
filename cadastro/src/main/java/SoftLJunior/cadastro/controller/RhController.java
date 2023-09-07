package SoftLJunior.cadastro.controller;


import SoftLJunior.cadastro.domain.funcionario.DadosAlteracaoFuncionario;
import SoftLJunior.cadastro.domain.funcionario.DadosCadastroFuncionario;
import SoftLJunior.cadastro.domain.funcionario.Funcionario;
import SoftLJunior.cadastro.domain.funcionario.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class RhController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping("/funcionario")
    public String carregaFuncionario(Long id, Model model){
        if(id != null){
            var funcionario = repository.getReferenceById(id);
            model.addAttribute("funcionario", funcionario);
        }
        return ("index/home");
    }

    @GetMapping
    public String carregaPaginaListagem(Model model){
        model.addAttribute("lista", repository.findAll()); // invia a informação para o HTML da lista que ele vai percorrer
        return ("index/listagem");
    }


    @PostMapping
    public String cadastraFuncionario(DadosCadastroFuncionario dados){
        Funcionario funcionario = new Funcionario(dados);
        repository.save(funcionario);
        return "redirect:/home";
    }

    @PutMapping
    @Transactional
    public String alteraFuncionario(DadosAlteracaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizaDados(dados);
        return "redirect:/home";
    }




    @DeleteMapping
    @Transactional
    public String removeFuncionario(Long id){
        repository.deleteById(id);
        return "redirect:/home";
    }



}
