package com.discord.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {

  @JsonProperty("channelName")
  private String channelName;
  
  @JsonProperty("message")
  private String message;
}
