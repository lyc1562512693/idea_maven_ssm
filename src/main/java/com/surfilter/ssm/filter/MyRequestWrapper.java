package com.surfilter.ssm.filter;

import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

public class MyRequestWrapper extends HttpServletRequestWrapper {

    private byte[] data;
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public MyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        data = IOUtils.toByteArray(request.getInputStream());
    }
    public ServletInputStream getInputStream(){
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }
    public BufferedReader getReader() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        return new BufferedReader(new InputStreamReader(new InputStream() {
            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        }));
    }
}
