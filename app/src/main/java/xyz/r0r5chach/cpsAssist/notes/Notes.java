package xyz.r0r5chach.cpsAssist.notes;


import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Notes {
    private final List<File> notes;
    private final File rootDir;
    private final String username;

    public Notes(File rootDir, String username) {
        this.rootDir = rootDir;
        this.username = username;
        notes = new ArrayList<>();
        getStoredNotes();
    }

    private void getStoredNotes() {
        notes.addAll(Arrays.asList(Objects.requireNonNull(rootDir.listFiles())));
    }

    public void createNote() {
        String fileName = LocalDateTime.now().toString() + "-" + username;
        //Get current username
        File note = new File(rootDir, fileName);
        notes.add(note);
        try {
            writeFile(note, "");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int deleteNote(String path) {
        File tmp = new File(rootDir.getAbsolutePath() + "/" + path);
        int index = getNoteIndex(tmp);
        notes.remove(index);
        if (tmp.delete()) {
            return index;
        }
        return -1;
    }

    public void updateNote(File note, String content) {
        try {
            writeFile(note, content);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getNote(int index) {
        return notes.get(index);
    }

    public int getNoteIndex(File note) {
        return notes.indexOf(note);
    }

    public int getAmount() {
        return notes.size();
    }

    private void writeFile(File file, String content) throws IOException {
        OutputStreamWriter fileWriter = new OutputStreamWriter(Files.newOutputStream(file.toPath()));
        fileWriter.write(content);
        fileWriter.flush();
        fileWriter.close();
    }
}
