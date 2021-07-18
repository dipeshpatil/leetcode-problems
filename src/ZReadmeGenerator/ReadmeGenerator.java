package ZReadmeGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadmeGenerator {
    static class FileReader {
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

    // LOCAL CONFIG
    private static final String PARENT_DIR = "src";
    private static final String README_FILE = "README.md";

    // REMOTE CONFIG
    private static final String GITHUB_USERNAME = "dipeshpatil";
    private static final String GITHUB_REPO_NAME = "leetcode-problems";
    private static final String GITHUB_BRANCH_NAME = "main";
    private static final String GITHUB_REPO_URL = "https://github.com/" + GITHUB_USERNAME + "/" + GITHUB_REPO_NAME;
    private static final String GITHUB_REPO_BLOB_URL = GITHUB_REPO_URL + "/blob/" + GITHUB_BRANCH_NAME + "/" + PARENT_DIR + "/";

    public static void main(String[] args) {
        final FileReader reader = new FileReader();
        final StringBuilder readme = new StringBuilder("## LeetCode Problem Solving Java\n");
        final List<String> foldersInRootDir = reader.listFolders(PARENT_DIR);

        // BreadCrumbs
        StringBuilder breadCrumbs = new StringBuilder("|");
        for (String category : foldersInRootDir) {
            if (category.equalsIgnoreCase("ZReadmeGenerator")) continue;
            breadCrumbs.append(" ");
            breadCrumbs.append("[" + category + "]").append("(" + GITHUB_REPO_URL + "/" + "#" + category.toLowerCase() + ") ");
            breadCrumbs.append("|");
        }

        readme.append(breadCrumbs).append("\n\n---\n");

        final String NOTE_FOR_GENERATING_README = "---\n### Note\n" +
                "This `README.md` file is generated via `ReadmeGenerator.java` Class.\n\n" +
                "If you want to maintain an index of your folder structure, Then run the `ReadmeGenerator.java` File located in `src/ZReadmeGenerator` before committing your changes to repository.\n" +
                "\n" +
                "Make sure to change the REMOTE CONFIG first in `ReadmeGenerator.java`\n" +
                "```java\n" +
                "// REMOTE CONFIG\n" +
                "private static final String GITHUB_USERNAME = \"<GITHUB_USERNAME>\";\n" +
                "private static final String GITHUB_REPO_NAME = \"<GITHUB_REPO_NAME>\";\n" +
                "private static final String GITHUB_BRANCH_NAME = \"<GITHUB_BRANCH_NAME>\";\n" +
                "```\n";

        for (String categoryFolder : foldersInRootDir) {
            if (categoryFolder.equalsIgnoreCase("ZReadmeGenerator")) continue;
            readme.append("### [" + categoryFolder + "](" + GITHUB_REPO_BLOB_URL + categoryFolder + ")\n");
            String innerFolder = PARENT_DIR + "/" + categoryFolder;
            List<String> folderNamesInInnerFolderOfRootDir = reader.listFolders(innerFolder);
            for (String folderName : folderNamesInInnerFolderOfRootDir) {
                readme.append("- [" + folderName + "](" + GITHUB_REPO_BLOB_URL + categoryFolder + "/" + folderName + ")\n");
                String finalFolderName = innerFolder + "/" + folderName;
                List<String> actualFilesInFolder = reader.listFilesForFolder(finalFolderName);
                for (String finalFileName : actualFilesInFolder)
                    readme.append("\t - [" + finalFileName + "](" + GITHUB_REPO_BLOB_URL + categoryFolder + "/" + folderName + "/" + finalFileName + ")\n");
                readme.append("\n");
            }
        }

        readme.append(NOTE_FOR_GENERATING_README);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(README_FILE));
            writer.write(readme.toString());
            writer.close();
            System.out.println("README.md Generated Successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
