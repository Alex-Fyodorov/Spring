package app.homeWork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "HWSevlet", urlPatterns = "/hw")
public class HWServlet extends HttpServlet {
    List<Product> list = new ArrayList<>();
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    private static Logger logger = LoggerFactory.getLogger(HWServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New GET request");
        toFillList();
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        resp.getWriter().printf("<h1>Products:</h1>");
        for (Product product : list) {
            resp.getWriter().printf("<h1>" + product.toString() + "</h1>");
        }
        resp.getWriter().printf("</body></html>");
        resp.getWriter().close();
    }

    private List<Product> toFillList() {
        for (Titles title : Titles.values()) {
            int id = 1 + random.nextInt(10000);
            int cost  = 1 + random.nextInt(1000);
            Product product = new Product(id, title.getTitle(), cost);
            list.add(product);
        }
        return list;
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

