package com.springboot.ex4.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder(toBuilder = true) // 빌더 기반생성 객체를 사용하여 객체들의 값을 일부 변경해서 객체를 복사할 수 있다.
@Data
public class SampleDTO {
    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;
}
