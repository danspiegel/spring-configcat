package br.com.configcat.example.demo.controller;

import br.com.configcat.example.demo.service.ConfigCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {

    @Autowired
    private ConfigCatService configCatService;


    @GetMapping("/teste")
    public Boolean getFlagTeste() {
        return configCatService.findFlag(Boolean.class, ConfigCatService.FT_TESTE, false);
    }

}
