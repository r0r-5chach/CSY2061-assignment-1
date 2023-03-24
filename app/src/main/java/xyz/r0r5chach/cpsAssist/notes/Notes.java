package xyz.r0r5chach.cpsAssist.notes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Notes {
    private final List<File> notes;
    private final File rootDir;
    private final String username;

    public Notes(File rootDir, String username) {
        this.rootDir = rootDir;
        this.username = username;
        notes = new ArrayList<>();
    }

    public void createNote() {
        String fileName = LocalDateTime.now().toString() + "-" +
                username;
        //Get current username
        File note = new File(rootDir, fileName);
        notes.add(note);
        try {
            writeFile(note);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getNote(int index) {
        return notes.get(index);
    }

    public int getAmount() {
        return notes.size();
    }

    private void writeFile(File file) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(Files.newOutputStream(file.toPath()));
        outputStreamWriter.write("Hi");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
}
