package com.example.lab.client.errorDecoder;

import com.example.lab.client.exception.BadRequestException;
import com.example.lab.client.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new BadRequestException("Bad request to library.");
            case 404:
                return new NotFoundException("Srry no such entity");
            default:
                return new Exception("Some error");
        }
    }
}
