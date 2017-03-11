package com.longho.cocsearch.apihanlder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by leho on 2/26/17.
 */
@Component
public class CocServiceImpl implements CocService{

    @Value("${api.url}")
    private String url;

    @Value("${api.token}")
    private String token;

    public List<Object> GetMembersByClanName(String name) {
        return null;
    }


    public Object getClansByName(String name, int limit, String before, String after) {
        try {
            System.out.println("Token: " + token);
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
        }catch (HttpStatusCodeException ex){
            System.out.println(ex.toString());
            System.out.println(ex.getResponseBodyAsString());

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
        System.out.println("URL: " + builder.toUriString());
        return builder.build();
    }

    public Object getClanByTag(String tag) {
        try{
            String urlGetClan = url + "/clans/{tag}";
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

        }catch (HttpStatusCodeException ex){
            System.out.println(ex.toString());
            System.out.println(ex.getResponseBodyAsString());

        }
        return null;
    }

    @Override
    public Object getPlayer(String tag) {
        try{
            String urlGetPlayer = url + "/players/{tag}";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
            HttpEntity<String> entity = new HttpEntity<>(null,headers);
            ResponseEntity<Object> responseEntity = restTemplate.exchange(
                    urlGetPlayer,
                    HttpMethod.GET,
                    entity,
                    Object.class,
                    tag
            );
            return responseEntity.getBody();
        }catch (HttpStatusCodeException ex){
            System.out.println(ex.toString());
            System.out.println(ex.getResponseBodyAsString());

        }
        return null;
    }
}
