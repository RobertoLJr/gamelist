package com.robertoljr.gamelist.exception.handler;

import java.time.Instant;

public record ExceptionResponse(Instant timestamp, Integer status, String error, String path) {
}
