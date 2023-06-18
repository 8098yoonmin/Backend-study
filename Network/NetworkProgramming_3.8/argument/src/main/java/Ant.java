import org.apache.commons.cli.*;

public class Ant {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h","help",false,"print this message");
        options.addOption(Option.builder("buildfile").hasArg().argName("file").build());
//        options.addOption(Option.builder("D")
//                .hasArgs()
//                .argName("property")
//                .valueSeparator('=')
//                .build());

        options.addOption("d","debug",false,"print debugging");
        options.addOption(Option.builder("listener").hasArg().argName("classname").valueSeparator('=').build());
        options.addOption(Option.builder("quiet").build());
        options.addOption(Option.builder("V").longOpt("verbose").desc("자세하게 알려줘").build());


        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if(cmd.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("ant", options);

            } else {
                for(Option option: cmd.getOptions()) {
                    System.out.println(option.getOpt()+": "+cmd.getOptionValue("classname"));
                }
            }
        } catch(ParseException ignore) {
            System.err.println(ignore.getMessage());
        }
    }
}
