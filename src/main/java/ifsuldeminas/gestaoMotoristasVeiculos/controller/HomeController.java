package ifsuldeminas.gestaoMotoristasVeiculos.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui/index.html");
    }

}
