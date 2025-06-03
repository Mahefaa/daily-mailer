package com.mailer.daily.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mailer.daily.PojaGenerated;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@PojaGenerated
@Slf4j
public class LambdaHandler implements RequestStreamHandler {
  private final ApiEventHandler apiEventHandler;

  @Getter
  private static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

  public LambdaHandler() {
    this.apiEventHandler = new ApiEventHandler();
  }

  @Override
  public void handleRequest(InputStream input, OutputStream outputStream, Context context)
      throws IOException {
    apiEventHandler.handleRequest(input, outputStream, context);
  }
}
