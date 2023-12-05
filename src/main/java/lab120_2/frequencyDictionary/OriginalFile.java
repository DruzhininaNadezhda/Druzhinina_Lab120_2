package lab120_2.frequencyDictionary;
import java.io.*;

public class OriginalFile {
    private String originalFile = "";
    public void setOriginalFile(String originalFile) {
        this.originalFile = originalFile;
    }
    public String getOriginalFile() {
        return originalFile;
    }
    public StringBuilder file(String originalFile) {
        setOriginalFile(originalFile);
        File file = new File(originalFile);
        if (file.exists() && file.canRead()) {
            try {
                StringBuilder sb = new StringBuilder();
                FileReader reader = new FileReader(file);
                char[] buff = new char[1024];
                int size;
                while ((size = reader.read(buff)) > -1) {
                    sb.append(new String(buff, 0, size));
                } return sb;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Неправильный файл");
        System. exit(0);
        return null;
    }
}


