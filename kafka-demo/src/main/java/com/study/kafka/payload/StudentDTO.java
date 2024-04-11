package com.study.kafka.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
}
