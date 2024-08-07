package com.lioneltonnon.dovedispatch.senders.messagegenerator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class RandomMessageService implements IMessageGenerator {

    private final Random random = new Random();

    @Override
    public Message generateMessage(int length, Alphabet alphabet) {
        String content = IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(alphabet.letters().charAt(random.nextInt(alphabet.letters().length()))))
                .collect(Collectors.joining());
        return new Message(content);
    }

    @Override
    public MessageList generateMessageList(int count, int length, Alphabet alphabet) {
        List<Message> messages = IntStream.range(0, count)
                .mapToObj(i -> generateMessage(length, alphabet))
                .collect(Collectors.toList());
        return new MessageList(messages);
    }
}