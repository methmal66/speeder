package com.github.methmal66.speeder;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class Command {
    private CommandLine cmd;

    public Command(String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption("f", "file", true, "File which containing the text to be displayed");
        options.addOption("w", "wpm", true, "Words Per Minute rate");
        options.addOption("h", "help", false, "Display help");

        final CommandLineParser parser = new DefaultParser();
        this.cmd = parser.parse(options, args);
        displayHelpMenu(options);
    }

    private void displayHelpMenu(Options ops) {
        if (ops.hasOption("h")) {
            final HelpFormatter formatter = new HelpFormatter();
            final String header = "Improve your speed reading skill with a simple CLI program";
            final String footer = "Please report issues at https://github.com/methmal66/speeder";
            formatter.printHelp("speeder", header, ops, footer);
            System.exit(0);// exit program successfully
        }
    }

    public String parseFile() {
        return cmd.getOptionValue("f");
    }

    public int parseWPM() {
        return Integer.parseInt(cmd.getOptionValue("w"));
    }
}
