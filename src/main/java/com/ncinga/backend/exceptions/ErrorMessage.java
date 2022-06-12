package com.ncinga.backend.exceptions;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
public class ErrorMessage {
    String message;
    String requestUrl;
    String port;
    String method;
}
