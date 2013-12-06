package org.fbi.linking.connector;

import org.fbi.linking.processor.ProcessorContext;
import org.fbi.linking.processor.standprotocol10.Stdp10ProcessorRequest;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * User: zhanrui
 * Date: 13-11-26
 * Time: 下午8:06
 */
public class Request implements Stdp10ProcessorRequest {
    private String encoding = "GBK";
    private Map<String, String> headerMap = new HashMap<>();
    private byte[] body;

    public Request(String buf){
        if (buf == null || buf.length() < 111) {
            throw new RuntimeException("报文头字节长度错误！");
        }
        int index = 0 + 6;
        int step = 3;
        headerMap.put("version", buf.substring(index, index + step).trim());
        index += step;
        step = 18;
        headerMap.put("serialNo", buf.substring(index, index + step).trim());
        index += step;
        step = 4;
        headerMap.put("rtnCode", buf.substring(index, index + step).trim());
        index += step;
        step = 7;
        headerMap.put("txnCode", buf.substring(index, index + step).trim());
        index += step;
        step = 9;
        headerMap.put("branchID", buf.substring(index, index + step).trim());
        index += step;
        step = 12;
        headerMap.put("tellerID", buf.substring(index, index + step).trim());
        index += step;
        step = 6;
        headerMap.put("ueserID", buf.substring(index, index + step).trim());
        index += step;
        step = 6;
        headerMap.put("appID", buf.substring(index, index + step).trim());
        index += step;
        step = 14;
        headerMap.put("txnTime", buf.substring(index, index + step).trim());
        index += step;
        step = 32;
        headerMap.put("mac", buf.substring(index, index + step));

        index += step;
        try {
            this.body = buf.substring(index).getBytes(this.encoding);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("编码类型错误：" + this.encoding);
        }
    }

    @Override
    public String getHeader(String s) {
        return headerMap.get(s);
    }

    @Override
    public Enumeration<String> getHeaders(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getIntHeader(String s) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public byte[] getRequestBody() {
        return body;
    }

    @Override
    public String getParameter(String s) {
        return null;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String[] getParameterValues(String s) {
        return new String[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getAttribute(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAttribute(String s, Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeAttribute(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getCharacterEncoding() {
        return this.encoding;
    }

    @Override
    public void setCharacterEncoding(String s) throws UnsupportedEncodingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ProcessorContext getProcessorContext() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
