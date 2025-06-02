package com.mailer.daily.handler.exceptionHandler;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mailer.daily.PojaGenerated;
import com.mailer.daily.handler.LambdaHandler;
import com.mailer.daily.handler.model.ErrorModel;
import com.mailer.daily.handler.model.ResponseEvent.LambdaUrlResponseEvent;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

@PojaGenerated
public class ExceptionHandlerImpl implements ExceptionHandler<LambdaUrlResponseEvent> {
  private final Logger log = LoggerFactory.getLogger(ExceptionHandlerImpl.class);

  private static final String INTERNAL_SERVER_ERROR_MESSAGE = INTERNAL_SERVER_ERROR.toString();

  protected static final HttpHeaders HEADERS = new HttpHeaders();

  static {
    HEADERS.put(CONTENT_TYPE, List.of(APPLICATION_JSON_VALUE));
  }

  @Override
  public LambdaUrlResponseEvent handle(Throwable throwable) {
    log.error("Called exception handler for :", throwable);
    // adding print stack in case we have no appender or we are running inside SAM local,
    // where need the output to go the stderr.
    throwable.printStackTrace();
    return new LambdaUrlResponseEvent(
        500, HEADERS.toSingleValueMap(), getErrorJson(INTERNAL_SERVER_ERROR_MESSAGE));
  }

  protected String getErrorJson(String message) {
    try {
      return LambdaHandler.getObjectMapper().writeValueAsString(new ErrorModel(message));
    } catch (JsonProcessingException e) {
      log.error("Could not produce error JSON", e);
      return "{\"message\": \"" + message + "\" }";
    }
  }
}
