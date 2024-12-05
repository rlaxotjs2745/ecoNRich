package com.task.econrich.util;

public record CommonResponse<T>(
        String resultMsg,
        T data
) {
}
