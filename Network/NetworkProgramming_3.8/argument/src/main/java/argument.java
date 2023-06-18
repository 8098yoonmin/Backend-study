import org.apache.commons.cli.*;

public class argument {
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("h","help", false,"도움말");
        Option logfileOption = Option.builder("logfile")
                .argName("file")
                .valueSeparator('=')
                .hasArg()
                .desc("use given file for log")
                .build();
        options.addOption(logfileOption);

        CommandLineParser parser = new DefaultParser();


        try {
            CommandLine cmd = parser.parse(options, args);

            for(Option option : cmd.getOptions()) {

                if (option.getOpt().equals("h")) {
                    // 자동으로 도움말 문 생성
                    System.out.println("도움말을 요청 합니다.");
                    HelpFormatter formatter = new HelpFormatter();
                    formatter.printHelp("ex1", options);
                } else if (option.getOpt().equals("logfile")) {
                    System.out.println("Log file: " + cmd.getOptionValue("logfile"));
                }

            }
        } catch(ParseException ignore) {
            System.err.println("명령어 인수가 잘못되었습니다.");
            System.err.print(ignore.getMessage());

        }
        }
}
