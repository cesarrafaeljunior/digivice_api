package RequestDigimons;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RequestDigimons {

    String urlExternApi = "https://digimon-api.vercel.app/api/digimon";

    @GetMapping("/digimons")
    public List<ResultDigimons> getDigimon(){
        RestTemplate  restTemplate = new RestTemplate();
        ResponseEntity<List<ResultDigimons>> response =  restTemplate.exchange(this.urlExternApi, HttpMethod.GET, null, new ParameterizedTypeReference<List<ResultDigimons>>() {});
        return response.getBody();
    }


}
