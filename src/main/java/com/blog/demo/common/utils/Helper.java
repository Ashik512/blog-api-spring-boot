package com.blog.demo.common.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.blog.demo.common.constants.ApplicationConstant.MESSAGE_SEPARATOR;

@Component
public class Helper {

    public static String createDynamicCode(String errorCode, String... placeHolders) {
        StringBuilder builder = new StringBuilder(errorCode);
        if(Objects.isNull(placeHolders)) {
            return errorCode;
        }
        Arrays.stream(placeHolders).forEach(placeHolder -> builder.append(MESSAGE_SEPARATOR).append(placeHolder));
        return builder.toString();
    }

}
