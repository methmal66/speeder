package com.github.methmal66.speeder;

import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

public class Command {
    private CommandLine cmd;

    public Command(String[] args) throws ParseException {
        final Options options = new Options();
        options.addOption("f", "file", true, "File which containing the text to be displayed");
        options.addOption("w", "wpm", true, "Words Per Minute rate");
        final CommandLineParser parser = new DefaultParser();
        this.cmd = parser.parse(options, args);
    }

    public String parseFile() {
        return cmd.getOptionValue("f");
    }

    public int parseWPM() {
        return Integer.parseInt(cmd.getOptionValue("w"));
    }
}
