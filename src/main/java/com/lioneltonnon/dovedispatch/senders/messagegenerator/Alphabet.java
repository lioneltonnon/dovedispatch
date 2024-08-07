package com.lioneltonnon.dovedispatch.senders.messagegenerator;

//todo refactor to be in model package
public record Alphabet(String letters) {
    public static final Alphabet DEFAULT = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
}
