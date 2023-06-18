import builder.HTMLBuilder;
import builder.TextBuilder;
import director.Album;

public class App {
    public static void main(String[] args) throws Exception {
        HTMLBuilder builder = new HTMLBuilder();

        Album album = new Album(builder);
        album.construct();
        builder.makeFile();
    }
}
