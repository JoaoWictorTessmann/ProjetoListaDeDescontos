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
        int tamanhoPagina = 10;
        Pageable configuracaoPagina = PageRequest.of(page, tamanhoPagina);
        Page<Produto> paginaProdutos = produtoRepository.findAll(configuracaoPagina);

        model.addAttribute("paginaProdutos", paginaProdutos);
        model.addAttribute("novoProduto", new Produto());
        return "index";
    }

    @GetMapping("/adicionar")
    public String exibirPaginaAdicionarProduto(Model model) {
        model.addAttribute("novoProduto", new Produto());
        return "adicionar";
    }

    @PostMapping("/adicionar")
    public String adicionarProduto(Produto produto, RedirectAttributes redirectAttributes) {
        produtoRepository.save(produto);
        return "redirect:/";
    }

    @GetMapping("/editar")
    public String editarProduto(@RequestParam Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + id));
        model.addAttribute("produto", produto);
        return "editar";
    }

    @PostMapping("/editar")
    public String atualizarProduto(Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/";
    }

    @GetMapping("/excluir")
    public String excluirProduto(@RequestParam Long id) {
        produtoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/desconto")
    public String mostrarPaginaDesconto(@RequestParam Long id, Model model) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + id));
        model.addAttribute("produto", produto);
        return "desconto";
    }

    @PostMapping("/desconto")
    public String salvarDesconto(@RequestParam Long id, @RequestParam Double desconto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + id));

        produto.setDesconto(desconto);
        produtoRepository.save(produto);

        return "redirect:/";
    }
}