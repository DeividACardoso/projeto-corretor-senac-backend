package br.sc.senac.tcs.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrantedAuthorityDeserializer extends JsonDeserializer<List<SimpleGrantedAuthority>> {

    @Override
    public List<SimpleGrantedAuthority> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (JsonNode authorityNode : node) {
            authorities.add(new SimpleGrantedAuthority(authorityNode.asText()));
        }

        return authorities;
    }
}

