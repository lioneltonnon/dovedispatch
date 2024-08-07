package com.lioneltonnon.dovedispatch.senders.messagegenerator;

// Data encapsulation object for the set of characters used to generate random messages
public record Alphabet(String letters) {
    public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
}
