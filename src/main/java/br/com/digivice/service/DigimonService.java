package br.com.digivice.service;

import br.com.digivice.DTO.DigimonDTO;
import br.com.digivice.exceptions.EntityNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DigimonService {

    private final RestTemplate restTemplate;
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

    public List<DigimonDTO> requestToExternalApi(String url) {
        try {
            ResponseEntity<List<DigimonDTO>> response = this.restTemplate.exchange(
                    this.urlExternalApi,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<DigimonDTO>>() {
                    }
            );

            this.urlExternalApi = auxUrlApi;

            return response.getBody();
        } catch(HttpClientErrorException error){

            this.urlExternalApi = auxUrlApi;

            int startIndex = error.getMessage().indexOf("\"ErrorMsg\":\"") + 12;
            int endIndex = error.getMessage().indexOf("\"}", startIndex);
            String errorMessage = error.getMessage().substring(startIndex, endIndex);

            throw  new EntityNotFoundException(error.getStatusCode(),errorMessage);
        }
    }

}
