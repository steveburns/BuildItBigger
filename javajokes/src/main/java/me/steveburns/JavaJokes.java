package me.steveburns;

import java.util.ArrayList;

public class JavaJokes {

    private static ArrayList<String> jokesList = new ArrayList<>();

    static {
        jokesList.add("It’s hard to explain puns to kleptomaniacs because they always take things literally");
        jokesList.add("I used to think the brain was the most important organ. Then I thought, look what’s telling me that.");
        jokesList.add("The midget fortune teller who kills his customers is a small medium at large.");
        jokesList.add("A farmer in the field with his cows counted 196 of them, but when he rounded them up he had 200.");
        jokesList.add("What does a nosey pepper do? Get jalapeño business.");
        jokesList.add("What is Bruce Lee’s favorite drink? Wataaaaah!");
        jokesList.add("The dyslexic devil worshipper sold his soul to Santa.");
        jokesList.add("You kill vegetarian vampires with a steak to the heart.");
        jokesList.add("There was a prison break and I saw a midget climb up the fence. As he jumped down her sneered at me and I thought, well that’s a little condescending.");
        jokesList.add("If you want to catch a squirrel just climb a tree and act like a nut.");
        jokesList.add("A magician was walking down the street and turned into a grocery store.");
        jokesList.add("A blind man walks into a bar. And a table. And a chair.");
        jokesList.add("Why don’t you ever see hippopotamus hiding in trees? Because they’re really good at it.");
        jokesList.add("Did you hear about the Mexican train killer? He had locomotives.");
        jokesList.add("How does NASA organize their company parties? They planet.");
        jokesList.add("Why can’t you hear a pterodactyl go to the bathroom? Because the “P” is silent.");
        jokesList.add("What kind of shoes do ninjas wear? Sneakers.");
        jokesList.add("Why does Snoop Dogg carry an umbrella? Fo’ drizzle.");
        jokesList.add("Did you hear about the new corduroy pillows? They’re making headlines everywhere!");
        jokesList.add("My friend recently got crushed by a pile of books, but he’s only got his shelf to blame.");
    }
    public static String returnAJoke() {
        int index = (int)(Math.random() * jokesList.size());
        return jokesList.get(index >= jokesList.size() ? 0 : index);
    }
}
