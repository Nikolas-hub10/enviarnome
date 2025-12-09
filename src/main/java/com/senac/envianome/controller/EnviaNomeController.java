package com.senac.envianome.controller;

import com.senac.envianome.dto.NomeDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/mensagem")
public class EnviaNomeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/enviarnome")
    public void enviarNome(NomeDTO nomeDTO){
        rabbitTemplate.convertAndSend("provaNikolasPeixoto", nomeDTO);
    }
}
