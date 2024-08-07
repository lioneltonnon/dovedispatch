package com.lioneltonnon.dovedispatch.senders.messagegenerator;


public interface IMessageGenerator {
    Message generateMessage(int length, Alphabet alphabet);

    MessageList generateMessageList(int count, int length, Alphabet alphabet);
}
