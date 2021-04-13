package com.discord.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class ModelApiResponse   {
  @JsonProperty("code")
  private Integer code;

  @JsonProperty("message")
  private String message;
}

