package com.rr27.front.service;

import com.rr27.dto.service.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/front")
public class FrontController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/showAll")
    public String showAll(Model model){
        //запрос через Эврику - указываем имя сервиса, как он зареган в самой Эврике (а не название модуля)
        //у Бина RestTemplate не забывем проставить LoadBalanced!!!
        List<ProductDTO> list = (List<ProductDTO>) restTemplate.exchange("http://product-client/products/showAll", HttpMethod.GET, null, List.class).getBody();
        //прямой запрос от одного сервиса к другому (без эврики)
//        List<ProductDTO> list = (List<ProductDTO>) restTemplate.exchange("http://localhost:6569/products/showAll", HttpMethod.GET, null, List.class).getBody();
        model.addAttribute("products", list);
        return "index";
    }

}
