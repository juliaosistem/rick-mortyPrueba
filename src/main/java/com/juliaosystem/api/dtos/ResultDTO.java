package com.juliaosystem.api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO {


@JsonProperty("id")
private Integer id;

@JsonProperty("name")
private String name;

@JsonProperty("status")
private String status;

@JsonProperty("species")
private String species;

@JsonProperty("type")
private String type;

@JsonProperty("gender")
private String gender;

@JsonProperty("origin")
private List<OrigenDTO> origin;

@JsonProperty("location")
private List<UbicacionDTO> location;

@JsonProperty("image")
private String image;

@JsonProperty("episode")
private List<String> episode;

@JsonProperty("url")
private String url;

@JsonProperty("created")
private String created;

}
