package com.rajins.echo.constants;

public enum EventAction {
    SEND_KEYS(EventType.KEYBOARD),
    PRESS_KEY(EventType.KEYBOARD),
    RELEASE_KEY(EventType.KEYBOARD),

    CLICK(EventType.MOUSE),
    DOUBLE_CLICK(EventType.MOUSE),
    MOUSE_DOWN(EventType.MOUSE),
    MOUSE_UP(EventType.MOUSE),
    MOUSE_MOVE(EventType.MOUSE),
    CONTEXT_CLICK(EventType.MOUSE);

    private EventType eventType;

    EventAction(EventType eventType) {
        this.eventType = eventType;
    }
}
