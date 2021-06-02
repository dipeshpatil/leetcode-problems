package ZReadmeGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadmeGenerator {
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
        FileReader reader = new FileReader();
        StringBuilder readme = new StringBuilder("## LeetCode Problem Solving Java").append("\n\n---\n");
        List<String> foldersInRootDir = reader.listFolders(new File(PARENT_DIR));

        for (String categoryFolder : foldersInRootDir) {
            if (categoryFolder.equalsIgnoreCase("ZReadmeGenerator")) continue;
            readme.append("### [" + categoryFolder + "](" + GITHUB_REPO_BLOB_URL + categoryFolder + ")\n");
            String innerFolder = PARENT_DIR + "/" + categoryFolder;
            List<String> folderNamesInInnerFolderOfRootDir = reader.listFolders(new File(innerFolder));
            for (String folderName : folderNamesInInnerFolderOfRootDir) {
                readme.append("- [" + folderName + "](" + GITHUB_REPO_BLOB_URL + categoryFolder + "/" + folderName + ")\n");
                String finalFolderName = innerFolder + "/" + folderName;
                List<String> actualFilesInFolder = reader.listFilesForFolder(new File(finalFolderName));
                for (String finalFileName : actualFilesInFolder)
                    readme.append("\t - [" + finalFileName + "](" + GITHUB_REPO_BLOB_URL + categoryFolder + "/" + folderName + "/" + finalFileName + ")\n");
                readme.append("\n");
            }
        }

        String noteForGeneratingReadme = "---\n### Note\n" +
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

        readme.append(noteForGeneratingReadme);

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
