package com.ncinga.backend.exceptions;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
@Value
@EqualsAndHashCode
@ToString
public class ErrorMessage {
    String message;
    String requestUrl;
    String port;
    String method;
}
