package com.mailer.daily.handler.model.requestEvent;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mailer.daily.PojaGenerated;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@PojaGenerated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LambdaUrlRequestEvent {
  @JsonProperty("version")
  private String version;

  @JsonProperty("rawPath")
  private String rawPath;

  @JsonProperty("rawQueryString")
  private String rawQueryString;

  @JsonProperty("cookies")
  private List<String> cookies;

  @JsonProperty("headers")
  private Map<String, String> headers;

  @JsonProperty("queryStringParameters")
  private Map<String, String> queryStringParameters;

  @JsonProperty("requestContext")
  private RequestContext requestContext;

  @JsonProperty("body")
  private String body;

  @JsonProperty("isBase64Encoded")
  private boolean isBase64Encoded;
}
