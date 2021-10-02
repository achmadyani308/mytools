package com.achmad.yani;

import java.io.File;
import java.nio.file.Files;
import java.text.ParseException;
import org.apache.commons.cli.*;

public class mytools {
    public static void main(String[] args) throws Exception {
        String filePath = args[0];

        Options options = new Options();

        // help arguments -h
        Option help = new Option("h", "help", false, "help");
        help.setRequired(false);
        options.addOption(help);

        // file type arguments -t
        Option type = new Option("t", "type", true, "type");
        type.setRequired(false);
        options.addOption(type);

        // copy arguments -o
        Option copy = new Option("o", "copy", true, "copy");
        copy.setRequired(false);
        options.addOption(copy);

        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        cmd = parser.parse(options, args);

        String fileType = "text";
        if (cmd.hasOption("t")) {
            if (cmd.getOptionValue("type").equals("json")) {
                fileType = "json";
            }

            if (fileType.equals("json")) {
                // convert to jsons

            }
        }

        // argunments -h
        if (cmd.hasOption("h")) {
            System.out.println("Panduan Penggunaan :\n" + "Konversi file json : $mytools <path>/<log file> -t json \n"
                    + "Konversi file text : $mytools <path>/<log file> -t text \n"
                    + "Copy File : $mytools <path>/<log file> -o <path tujuan>/<log file name.(json/text)>");
        }

        // argunments -o
        if (cmd.hasOption("o")) {
            if (cmd.getOptionValue("copy") != null && cmd.getOptionValue("copy") != "") {
                String copyFileTo = cmd.getOptionValue("copy");
                File source = new File(filePath);
                File dest = new File(copyFileTo);
                Files.copy(source.toPath(), dest.toPath());

            }
        }
    }
}
