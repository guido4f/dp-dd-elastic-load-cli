package com.github.onsdigital.cli.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.github.onsdigital.cli.builder.IndividualDataSetBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by James Fawke on 09/01/2017.
 */

@Parameters(commandNames = CsvToIndividualCommand.ACTION,
            commandDescription = "Convert CSV File to Json")
public class CsvToIndividualCommand extends AbstractCommand implements Command {
    public static final String ACTION = "convertCSVtoIndividualJson";
    public static final String UTF_8 = "UTF-8";
    private static final Logger LOGGER = LoggerFactory.getLogger(CsvToIndividualCommand.class);
    @Parameter(names = "--help",
               help = true)
    boolean help = false;

    @Parameter(names = {"--csvDataDirectory", "-c"},
               required = true,
               description = "The CSV File to be converted into a Json Structure")
    private String csvDataDir;
    @Parameter(names = {"-f", "--outputFile"},
               required = false,
               description = "File to write the Json out to")

    private String outputFile;

    @Override
    public String getOutputFile() {
        return outputFile;
    }

    public void execute() throws IOException {
        File file = new File(getCsvDataDir());
        buildFile(new IndividualDataSetBuilder(file).build());
    }

    public String getCsvDataDir() {
        return csvDataDir;
    }

    public void setCsvDataDir(String csvDataDir) {
        this.csvDataDir = csvDataDir;
    }

    public String getAction() {
        return ACTION;
    }


}
