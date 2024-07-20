package com.juliaosystem.api.dtos.responses;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.juliaosystem.api.dtos.InfoDTO;
import com.juliaosystem.api.dtos.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiRykiResponse {

    @JsonProperty("info")
    private InfoDTO info;

    @JsonProperty("results")
    private List<ResultDTO> results;
}
