package org.fbi.linking.connector;

import org.fbi.linking.processor.standprotocol10.Stdp10ProcessorResponse;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * User: zhanrui
 * Date: 13-11-26
 * Time: 下午8:14
 */
public class Response implements Stdp10ProcessorResponse {
    private String encoding = "GBK";
    private Map<String, String> headerMap = new HashMap<>();
    private byte[] body;


    @Override
    public void setHeader(String key, String value) {
        //TODO 判断异常情况
        headerMap.put(key, value);
    }

    @Override
    public void addHeader(String key, String value) {
        headerMap.put(key, value);
    }

    @Override
    public void setIntHeader(String s, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void addIntHeader(String s, int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getHeader(String key) {
        return headerMap.get(key);
    }

    @Override
    public Collection<String> getHeaders(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<String> getHeaderNames() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setResponseBody(byte[] body) {
        this.body = body;
    }

    @Override
    public byte[] getResponseBody() {
        return body;
    }

    @Override
    public String getCharacterEncoding() {
        return this.encoding;
    }

    @Override
    public void setCharacterEncoding(String s) {
        this.encoding = s;
    }
}
