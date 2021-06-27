package dev.victorugons.santanderdevweek.exception;

import dev.victorugons.santanderdevweek.util.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
