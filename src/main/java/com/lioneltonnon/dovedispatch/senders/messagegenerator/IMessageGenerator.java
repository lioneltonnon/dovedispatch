package com.lioneltonnon.dovedispatch.senders.messagegenerator;

// Defines the methods required for message creation.
public interface IMessageGenerator {
    Message generateMessage(int length, Alphabet alphabet);

    MessageList generateMessageList(int count, int length, Alphabet alphabet);
}
