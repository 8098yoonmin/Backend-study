import org.apache.commons.cli.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class snc {
    public static void main(String[] args) {
        Options options = new Options();

        CommandLineParser parser = new DefaultParser();

        options.addOption(Option.builder("h").longOpt("help").build());
        options.addOption(Option.builder("l").
                hasArgs().
                argName("port").
                desc("서버 모드로 동작 , 입력 받은 포트로 listen").build());
        options.addOption(Option.builder("").
                optionalArg(true).
                argName("<host> <port>").
                numberOfArgs(2).
                hasArg(true).build());

        try {
            CommandLine cmd = parser.parse(options , args);

            if(cmd.hasOption("h")){
                System.out.println("도움말을 요청 합니다.");
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("snc", options);
            }else{
                if(cmd.hasOption("l")){
                    int port = Integer.parseInt(cmd.getOptionValue("l"));
                    server(port);
                }else{
                    String ip = args[0];
                    int port = Integer.valueOf(args[1]);
                    client(ip , port);
                }
            }
        } catch (ParseException e) {
            System.err.println("명령어 인수가 잘못되었습니다.");
            System.err.print(e.getMessage());
        }

    }



    public static void client(String ip , int port){
        try (Socket socket = new Socket(ip , port)){
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); // 터미널 입력
            BufferedWriter terminal = new BufferedWriter(new OutputStreamWriter(System.out)); // 터미널에 출력

            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Thread inputThread = new Thread(() -> {
                try {
                    while(!Thread.interrupted()) {
                        terminal.write(input.readLine()); //받은 걸 화면에 찍음
                        terminal.newLine();
                        terminal.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });

            inputThread.start();

            while(!Thread.interrupted()) {
                String line = console.readLine();
                output.write(line);
                output.newLine();
                output.flush();
            }

        } catch (IOException e) {
            System.err.println(e);
            System.err.println("연결에 실패했습니다.");
        }
    }

    public static void server(int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            Socket socket = serverSocket.accept();

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));

            while(!Thread.interrupted()){
                String line = input.readLine();

                if(line.equals("exit")) {
                    break;
                }
                output.write(line);
                output.newLine();
                output.flush();

                log.write(line);
                log.newLine();
                log.flush();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
