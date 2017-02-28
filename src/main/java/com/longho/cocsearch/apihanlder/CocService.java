package com.longho.cocsearch.apihanlder;


import java.util.List;

/**
 * Created by leho on 2/26/17.
 */
public interface CocService {

    public List<Object> GetMembersByClanName(String name);

    public Object getClanByName(String name, int limit, String before, String after);

}
