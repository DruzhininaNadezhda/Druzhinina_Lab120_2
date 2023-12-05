package lab120_2.frequencyDictionary;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class DataOutput {
    private String originalFile = "";
    private String direct = "";

    public String getOriginalFile() {
        return originalFile;
    }

    public String getDirect() {
        return direct;
    }

    public void setOriginalFile(String originalFile) {
        this.originalFile = originalFile;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public void fileOutput (String originalFile, String direct) {
        setOriginalFile(originalFile);
        setDirect(direct);
        DataProcessing f = new DataProcessing();
        OriginalFile file1 = new OriginalFile();
        TreeMap<String, Integer> h = f.dictionary(file1.file(originalFile));
        int sumWords = 0;
        for (String key : h.keySet()) {
            sumWords += h.get(key);}
            File dir = new File(direct);
            File newFile = new File(dir, "report-by-alph.txt");
            if (dir.canWrite()) {
                try {
                    newFile.createNewFile();
                    FileWriter writer = new FileWriter(newFile);
                    for (String keys : h.keySet()) {
                        writer.write(keys + " "
                                + h.get(keys) + " "
                                + (double) h.get(keys) / sumWords
                                + "\n");
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            File newFile2 = new File(dir, "report-by-freq.txt");
            if (dir.canWrite()) {
                try {
                    newFile2.createNewFile();
                    FileWriter writer = new FileWriter(newFile2);
                    int m = sumWords;
                    while (m !=0) {
                    for (String keys : h.keySet()){
                        if (h.get(keys).equals(m) )  {
                            writer.write(keys + " "
                                    + h.get(keys) + " "
                                    + (double) h.get(keys) / sumWords
                                    + "\n");
                            writer.flush();
                        }; }m--;}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        File newFile3 = new File(dir, "report-by-alph-rev.txt");
        if (dir.canWrite()) {
            try {
                newFile2.createNewFile();
                FileWriter writer = new FileWriter(newFile3);
                DataProcessing u = new DataProcessing();
                OriginalFile file2 = new OriginalFile();
                    TreeMap<String, Integer> k = u.dictionary(file2.file(originalFile).reverse());
                    for (String keys : k.keySet()){
                        StringBuilder j = new StringBuilder().append(keys).reverse();
                            writer.write(j.toString() + " "
                                    + k.get(keys) + " "
                                    + (double) k.get(keys) / sumWords
                                    + "\n");
                            writer.flush();
                        }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
}
