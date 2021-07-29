package com.telerikacademy.oop.cosmetics.core.contracts;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandName, CosmeticsRepository repository);

}
