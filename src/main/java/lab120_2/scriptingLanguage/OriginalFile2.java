package lab120_2.scriptingLanguage;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class OriginalFile2 {
    private String originalFile = "";
    public void setOriginalFile(String originalFile) {
        this.originalFile = originalFile;
    }
    public String getOriginalFile() {
        return originalFile;
    }
    public LinkedList<String> file(String originalFile) {
        setOriginalFile(originalFile);
        File file = new File(originalFile);
        LinkedList<String> g = new LinkedList<>();
        if (file.exists() && file.canRead()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    g.add(scanner.nextLine());
                } scanner.close();
                g.removeIf(i -> i.contains("#") | i.isEmpty() | i.equals(" "));
                return g;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System. exit(0);
        return null;
    }
}
