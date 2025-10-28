package com.sistemadescontos.listadedesconto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sistemadescontos.listadedesconto.Model.Produto;
import com.sistemadescontos.listadedesconto.Repository.ProdutoRepository;
import org.springframework.ui.Model;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String listarProdutos(Model model, @RequestParam(defaultValue = "0") int page) {
        int tamanhoPagina = 5;
        Pageable configuracaoPagina = PageRequest.of(page, tamanhoPagina);
        Page<Produto> paginaProdutos = produtoRepository.findAll(configuracaoPagina);

        model.addAttribute("paginaProdutos", paginaProdutos);
        model.addAttribute("novoProduto", new Produto());
        return "index";
    }

    @GetMapping("/PaginaAdicionarProduto")
    public String exibirPaginaAdicionarProduto(Model model) {
        model.addAttribute("novoProduto", new Produto());
        return "adicionar";
    }

    @PostMapping("/ProdutoSalvo")
    public String adicionarProduto(Produto produto, RedirectAttributes redirectAttributes) {
        produtoRepository.save(produto);
        return "redirect:/";
    }
}
