package br.com.digivice.service;

import br.com.digivice.DTO.DigimonDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DigimonService {

    private RestTemplate restTemplate;
    String urlExternalApi = "https://digimon-api.vercel.app/api/digimon";
    String auxUrlApi = this.urlExternalApi;

    public DigimonService(){
        this.restTemplate = new RestTemplate();
    }
    public List<DigimonDTO> getAllDigimons(){
        return this.requestToExternalApi(this.urlExternalApi);
    }

    public List<DigimonDTO> getDigimonsByName(String name){

        String concatString = "/name/";

        this.urlExternalApi = this.urlExternalApi + concatString + name;

        return this.requestToExternalApi(this.urlExternalApi);
    }

    public List<DigimonDTO> getDigimonsByLevel(String level){

        String concatString = "/level/";

        this.urlExternalApi = this.urlExternalApi + concatString + level;

        return this.requestToExternalApi(this.urlExternalApi);
    }

    public List<DigimonDTO> requestToExternalApi(String url){
            ResponseEntity<List<DigimonDTO>> response = this.restTemplate.exchange(
                    this.urlExternalApi,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DigimonDTO>>() {
                    }
            );

            this.urlExternalApi = auxUrlApi;

            return response.getBody();

    }

}
