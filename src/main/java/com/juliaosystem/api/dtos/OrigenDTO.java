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
public class OrigenDTO {


    @JsonProperty("name")
    private  String name;

    @JsonProperty("url")
    private String url;
}
