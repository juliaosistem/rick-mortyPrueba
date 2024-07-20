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
public class PersonajesDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("species")
    private String species;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("imagen")
    private String imagen;

    @JsonProperty("created")
    private String created;
}
