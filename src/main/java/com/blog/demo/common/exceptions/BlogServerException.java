package com.blog.demo.common.exceptions;

import com.blog.demo.common.constants.ApplicationConstant;
import lombok.Data;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

@Data
public class BlogServerException extends RuntimeException {

    private static final long serialVersionUID = 1436995162658277359L;
    private final String errorId;
    private final String traceId;
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;


    public BlogServerException(String errorId, HttpStatus status, String traceId) {
        this.errorId = errorId;
        this.status = status;
        this.traceId = traceId;
    }

    public static BlogServerException dataSaveException(String errorId) {
        return new BlogServerException(errorId, HttpStatus.INTERNAL_SERVER_ERROR, MDC.get(ApplicationConstant.TRACE_ID));
    }

}