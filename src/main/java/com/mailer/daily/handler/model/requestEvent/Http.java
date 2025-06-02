package com.mailer.daily.handler.model.requestEvent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mailer.daily.PojaGenerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@PojaGenerated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Http {
  @JsonProperty("method")
  private String method;

  @JsonProperty("path")
  private String path;

  @JsonProperty("protocol")
  private String protocol;

  @JsonProperty("sourceIp")
  private String sourceIp;

  @JsonProperty("userAgent")
  private String userAgent;
}
