package fyodorov.hw;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ProductServlet", urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    Random random = new Random();
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        for (Titles title : Titles.values()) {
            int cost  = 1 + random.nextInt(1000);
            this.productRepository.insert(new Product(title.getTitle(), cost));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>Id</th>");
        writer.println("<th>Product</th>");
        writer.println("<th>Cost</th>");
        writer.println("</tr>");
        if(req.getPathInfo().equals("/")){
            for(Product product : productRepository.findAll()){
                writer.println("<tr>");
                writer.println("<td>" + product.getId() + "</td>");
                writer.println("<td><a href = '" + getServletContext().getContextPath()
                        + "/product/" + product.getId() + "'>"  + product.getTittle()
                        + "</td>");
                writer.println("<td>" + product.getCost() + "</td>");
                writer.println("</tr>");
            }
        } else {
            long thisId = Long.parseLong(req.getPathInfo().substring(1));
            writer.println("<tr>");
            writer.println("<td>" + thisId + "</td>");
            writer.println("<td>"  + productRepository.findById(thisId).getTittle()    + "</td>");
            writer.println("<td>"  + productRepository.findById(thisId).getCost()    + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
//        writer.println(req.getPathInfo());
//        writer.println(req.getContextPath());
    }

    private enum Titles {

        PRODUCT1 ("Computer"),
        PRODUCT2 ("Toaster"),
        PRODUCT3 ("Microwave"),
        PRODUCT4 ("Camera"),
        PRODUCT5 ("Hair dryer"),
        PRODUCT6 ("Blender"),
        PRODUCT7 ("Printer"),
        PRODUCT8 ("Dishwasher"),
        PRODUCT9 ("Monitor"),
        PRODUCT10 ("Vacuum cleaner");

        private String title;

        Titles(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }
}