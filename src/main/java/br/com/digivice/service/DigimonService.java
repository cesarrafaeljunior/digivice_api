package service;

import DTO.DigimonDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DigimonService {
    String urlExternApi = "https://digimon-api.vercel.app/api/digimon";

    @GetMapping("/digimons")
    public List<DigimonDTO> getDigimon(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<DigimonDTO>> response =  restTemplate.exchange(this.urlExternApi, HttpMethod.GET, null, new ParameterizedTypeReference<List<DigimonDTO>>() {});
        return response.getBody();
    }

}
