package com.juliaosystem.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoDTO {

    @JsonProperty("count")
    private int  count;

    @JsonProperty("pages")
    private  int  pages;

    @JsonProperty("next")
    private String next;

    @JsonProperty("prev")
    private String prev ;
}
