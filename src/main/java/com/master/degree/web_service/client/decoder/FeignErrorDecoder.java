package com.master.degree.web_service.client.decoder;

import com.master.degree.web_service.exception.ResourceNotAvailableException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()) {
            case 500: {
                return new ResourceNotAvailableException("Resource is not available.");
            }
        }
        return null;
    }
}
