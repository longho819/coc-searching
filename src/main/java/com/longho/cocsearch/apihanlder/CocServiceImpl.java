package com.longho.cocsearch.apihanlder;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leho on 2/26/17.
 */
@Component
public class CocServiceImpl implements CocService{

    private final String url = "https://api.clashofclans.com/v1";
    private final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImZjYzI1YmNmLTRlYmEtNDkwYS1iZjBlLWQwNGZhNmM0ZTEzOCIsImlhdCI6MTQ4ODY5NzIwOCwic3ViIjoiZGV2ZWxvcGVyLzQzYTViODgzLTdjOGEtNzA0ZC1lMDAzLTk4ZDM4YzgxNWU1MyIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjI3Ljc1LjE0MS4yNDMiXSwidHlwZSI6ImNsaWVudCJ9XX0.EhqVri8D7sw_aYyJ93DfcxeT5giqjGXeli0YsfEvgv5sTj_BInHoRD35fIEl5AQcvncJioeZJ27Vfg2oCOB6JQ";

    public List<Object> GetMembersByClanName(String name) {
        return null;
    }


    public Object getClansByName(String name, int limit, String before, String after) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<Object> responseEntity = restTemplate
                    .exchange(buildUrl(name,limit,before,after).toUri(),
                            HttpMethod.GET,
                            entity,
                            Object.class);
            return responseEntity.getBody();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;

    }

    private UriComponents buildUrl(String name, int limit, String before, String after)
    {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "/clans");
        builder.queryParam("limit",limit);
        if(!StringUtils.isEmpty(name)){
            builder.queryParam("name",name);
        }
        if(!StringUtils.isEmpty(before)){
            builder.queryParam("before",before);
        }
        if(!StringUtils.isEmpty(after)){
            builder.queryParam("after",after);
        }
        return builder.build();
    }

    public Object getClanByTag(String tag) {
        try{
            String urlGetClan = "https://api.clashofclans.com/v1/clans/{tag}";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<Object> responseEntity = restTemplate
                    .exchange(urlGetClan,
                            HttpMethod.GET,
                            entity,
                            Object.class,tag);
            return responseEntity.getBody();

        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;
    }
}
