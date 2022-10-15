package com.example.exception.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class User {
    @NotEmpty
    @Size(min = 1, max = 100)
    private String name;

    @Min(1)
    @NotNull
    private int age;
}
