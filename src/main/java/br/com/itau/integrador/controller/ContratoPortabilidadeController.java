package br.com.itau.consignado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.consignado.model.ContratoPortabilidade;
import br.com.itau.consignado.service.LiquidacaoContratoService;

@RestController
public class ContratoPortabilidadeController {

	@Autowired
	private LiquidacaoContratoService liquidacaoContratoService;

    @PostMapping("/saveContrato")
    public void salvarContratoPortabilidade(@RequestBody String contratoPortabilidade){
    	
    	this.liquidacaoContratoService.salvarContratoPortabilidade(contratoPortabilidade);
    	
    }


	

}

