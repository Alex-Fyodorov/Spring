package fyodorov.controller;

import fyodorov.model.Product;
import fyodorov.repository.ProductRepositoryDB;
import fyodorov.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepositoryDB productRepository;
    private final CartService cartService;

    @GetMapping
    public String productPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {
        cartService.addToCartByProductId(id);
        return "redirect:/product";
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "redirect:/product";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        model.addAttribute("products", cartService.getCurrentCart());
        model.addAttribute("sum", cartService.sum());
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCartPage(@PathVariable Long id) {
        cartService.addToCartByProductId(id);
        return "redirect:/product/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCartPage(@PathVariable Long id) {
        cartService.removeFromCart(id);
        return "redirect:/product/cart";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "add_product";
    }

    @PostMapping("/insert")
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add_product";
        }
        productRepository.addProduct(product.getTitle(), product.getPrice());
        return "redirect:/product";
    }

//    @GetMapping("/end")
//    public String shutdown() {
//        productRepository.shutdown();
//        return "redirect:/product/cart";
//    }
}
