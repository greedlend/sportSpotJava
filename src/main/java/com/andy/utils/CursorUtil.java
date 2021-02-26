package com.andy.utils;

import graphql.relay.ConnectionCursor;
import graphql.relay.DefaultConnectionCursor;
import graphql.relay.Edge;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/17
 * @Proposal:
 */
@Component
public class CursorUtil {

    public ConnectionCursor from(String uuid) {
        return new DefaultConnectionCursor(
        Base64.getEncoder().encodeToString(uuid.getBytes(StandardCharsets.UTF_8)));
    }

    public String decode(String cursor) {
        try {
            return new String(Base64.getDecoder().decode(cursor),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        }
    }

    public <T> ConnectionCursor getFirstCursor(List<Edge<T>> edgeList) {
        return edgeList.isEmpty()? null : edgeList.get(0).getCursor();
    }

    public <T> ConnectionCursor getLastCursor(List<Edge<T>> edgeList) {
        return edgeList.isEmpty()? null : edgeList.get(edgeList.size() - 1).getCursor();
    }
}
