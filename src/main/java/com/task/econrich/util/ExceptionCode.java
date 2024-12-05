package com.task.econrich.util;

import lombok.Getter;

public enum ExceptionCode {
    CANNOT_FIND_DATA(404, "데이터를 찾지 못했습니다."),
    CANNOT_INCREASE_SALLARY(400, "연봉 인상 시 직무 최대 연봉을 초과하는 직원이 있습니다."),
    NOT_EXIST_DEPARTMENT(400, "존재하지 않은 부서입니다."),
    URI_PARSE_ERROR(500, "uri에 잘못된 syntax가 존재합니다."),
    INTERNAL_SERVER_ERROR(500, "서버 문제로 인해 요청이 실패했습니다.");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
