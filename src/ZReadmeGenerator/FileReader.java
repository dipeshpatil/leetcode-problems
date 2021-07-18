package ZReadmeGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReader {
    public List<String> listFilesForFolder(final String folder) {
        List<String> files = new ArrayList<>();
        listFilesForFolderUtil(folder, files);
        return files;
    }

    public List<String> listFolders(final String folder) {
        List<String> folders = new ArrayList<>();
        for (final File fileEntry : Objects.requireNonNull(new File(folder).listFiles())) {
            if (fileEntry.isDirectory()) {
                folders.add(fileEntry.getName());
            }
        }
        return folders;
    }

    private void listFilesForFolderUtil(final String folder, List<String> files) {
        for (final File fileEntry : Objects.requireNonNull(new File(folder).listFiles())) {
            if (fileEntry.isDirectory()) {
                listFilesForFolderUtil(fileEntry.getName(), files);
            } else {
                files.add(fileEntry.getName());
            }
        }
    }

    public void display(List<String> items) {
        for (String item : items)
            System.out.println(item);
    }
}
