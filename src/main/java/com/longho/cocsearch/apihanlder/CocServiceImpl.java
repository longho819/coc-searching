package com.longho.cocsearch.apihanlder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by leho on 2/26/17.
 */
@Component
public class CocServiceImpl implements CocService{

    private final String url = "https://api.clashofclans.com/v1";
    private final String token = "";

    public List<Object> GetMembersByClanName(String name) {
        return null;
    }


    public Object getClanByName(String name, int limit, String before, String after) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjZlNDdlNmQ4LTQwNTQtNGI4MS04YjNmLTg2NWJmYmVlYjY0YyIsImlhdCI6MTQ4ODIxMzk2Mywic3ViIjoiZGV2ZWxvcGVyLzQzYTViODgzLTdjOGEtNzA0ZC1lMDAzLTk4ZDM4YzgxNWU1MyIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjI3Ljc1LjE0Mi4xMDYiXSwidHlwZSI6ImNsaWVudCJ9XX0.nmSJ-VpcdIYaQxpjfKxzdHDcgRUvuHSlY9XuS5q7f0vIPhueasCMjSXlBEavFVCIJxJJpkqCQdPqSMmNcK-m3w");
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<Object> responseEntity = restTemplate
                    .exchange(buildUrl(name,limit,before,after),
                            HttpMethod.GET,
                            entity,
                            Object.class);
            return responseEntity.getBody();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return null;

    }

    private String buildUrl(String name, int limit, String before, String after)
    {
        String fullUrl = url + "/clans?limit=" + limit + "&";
        if(!StringUtils.isEmpty(name)){
            fullUrl += "name=" + name;
        }
        if(!StringUtils.isEmpty(before)){
            if(fullUrl.contains("name=")){
                fullUrl += "&";
            }
            fullUrl += "before=" + before;
        }
        if(!StringUtils.isEmpty(after)){
            if(fullUrl.contains("name=") || fullUrl.contains("before=")){
                fullUrl += "&";
            }
            fullUrl += "after=" + after;
        }
        return fullUrl;
    }

}
