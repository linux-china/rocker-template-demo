package org.mvnsearch;


import com.fizzed.rocker.RockerModel;
import com.fizzed.rocker.runtime.OutputStreamOutput;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * rocker message converter to render RockerModel
 *
 * @author linux_china
 */
public class RockerMessageConverter extends AbstractHttpMessageConverter<RockerModel> {

    public RockerMessageConverter() {
        super(Charset.forName("utf-8"), MediaType.TEXT_HTML);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return RockerModel.class.isAssignableFrom(clazz);
    }

    @Override
    protected void writeInternal(RockerModel rockerModel, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream body = outputMessage.getBody();
        rockerModel.render((contentType, charset) -> new OutputStreamOutput(contentType, body, charset));
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    protected RockerModel readInternal(Class<? extends RockerModel> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        throw new HttpMessageNotReadableException("Input not supported by Rocker", inputMessage);
    }

}