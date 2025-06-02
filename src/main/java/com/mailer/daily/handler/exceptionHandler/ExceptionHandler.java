package com.mailer.daily.handler.exceptionHandler;

import com.mailer.daily.PojaGenerated;

@PojaGenerated
public interface ExceptionHandler<R> {
  R handle(Throwable throwable);
}
