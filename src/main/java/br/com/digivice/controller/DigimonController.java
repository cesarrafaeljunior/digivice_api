package br.com.digivice.controller;

import br.com.digivice.DTO.DigimonDTO;
import br.com.digivice.service.DigimonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class DigimonController {

    private final DigimonService digimonService;

    @Autowired
    public DigimonController(DigimonService digimonService){
        this.digimonService = digimonService;
    }

    @GetMapping("/digimons")
    public List<DigimonDTO> getDigimons(@RequestParam(required = false) String name,@RequestParam(required = false) String level){
        if(name != null){
            return digimonService.getDigimonsByName(name);
        }

        if(level != null){
            return digimonService.getDigimonsByLevel(level);
        }

        return digimonService.getAllDigimons();

    }
}
