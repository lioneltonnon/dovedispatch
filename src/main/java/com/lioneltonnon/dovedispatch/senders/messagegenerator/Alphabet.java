package com.lioneltonnon.dovedispatch.senders.messagegenerator;

public record Alphabet(String letters) {
    public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
}
