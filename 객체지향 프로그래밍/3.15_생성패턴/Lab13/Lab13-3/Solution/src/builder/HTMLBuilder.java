package builder;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class HTMLBuilder implements Builder {
    private String albumTitle;
    private String teamName;

    private StringBuilder buffer = new StringBuilder();

    @Override
    public void albumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
        buffer.append("<html><body>\n");
        buffer.append("<H2>Title: " + albumTitle + "</h2>\n");
    }

    @Override
    public void teamName(String teamName) {
        this.teamName = teamName;
        buffer.append("<hr />\n");
        buffer.append("<h3>" + teamName + "</h3>\n");
    }

    @Override
    public void makeItems(ArrayList<String> items) {
        buffer.append("<ol>");
        for(String songName: items) {
            buffer.append("<li>" + songName + "</li>\n");
        }
        buffer.append("</ol>");
    }
    
    @Override
    public void close() {
        buffer.append("</body></html>\n");
    }

    @Override
    public void makeFile() {
        try {
            File file = new File(this.albumTitle + " - " + this.teamName + ".html");
            
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(buffer.toString());
            writer.close();
        }
        catch (IOException e) {}
    }
}
