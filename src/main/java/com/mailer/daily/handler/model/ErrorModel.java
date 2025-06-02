package com.mailer.daily.handler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mailer.daily.PojaGenerated;

@PojaGenerated
public record ErrorModel(@JsonProperty("message") String message) {}
