package com.lioneltonnon.dovedispatch.senders.messagegenerator;

import java.util.List;
//todo refactor to be in model package
public record MessageList(List<Message> messages) {
}
