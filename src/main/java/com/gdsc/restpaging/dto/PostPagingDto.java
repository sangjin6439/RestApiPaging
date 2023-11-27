package com.gdsc.restpaging.dto;

import lombok.Data;

@Data
public class PostPagingDto {

    private int page;
    private int size;
    private String sort;

}
