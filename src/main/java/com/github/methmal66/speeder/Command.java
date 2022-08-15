package com.github.methmal66.speeder;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class Command {
    private CommandLine cmd;

    /**
     * Create the options for argument parser. Then parse the args throgh the
     * parser. Throws ParseException when required parameters are not given
     * 
     * @param args String[] command line arguments of java
     */
    public Command(String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption("f", "file", true, "File which containing the text to be displayed");
        options.addOption("w", "wpm", true, "Words Per Minute rate");
        options.addOption("h", "help", false, "Display help");

        final CommandLineParser parser = new DefaultParser();
        this.cmd = parser.parse(options, args);
        displayHelpMenu(options);
    }

    /**
     * Display the help menu when user enter --help or -h as a command line
     * argument. Then program is terminated successfully without going to execute
     * the rest.
     * 
     * @param ops Options specified by commons cli for itself
     */
    private void displayHelpMenu(Options ops) {
        if (cmd.hasOption("h")) {
            final HelpFormatter formatter = new HelpFormatter();
            final String header = "Improve your speed reading skill with a simple CLI program";
            final String footer = "Please report issues at https://github.com/methmal66/speeder";
            formatter.printHelp("speeder", header, ops, footer);
            System.exit(0);// exit program successfully
        }
    }

    /**
     * Get the file name which was taken from the argemnet parser as --file or -f
     * 
     * @return String relative file name of which the text contains
     */
    public String parseFile() {
        return cmd.getOptionValue("f");
    }

    /**
     * Get the Word Per Minute rate which was taken from the arguement parser as
     * --wpm or -w
     * 
     * @return int wpm rate
     */
    public int parseWPM() {
        return Integer.parseInt(cmd.getOptionValue("w"));
    }
}
