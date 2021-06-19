package ZReadmeGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
[
    {
        Array: {
            Easy: ['xyz.java'],
            Medium: [''],
            Hard: []
        }
    }
]
 */

public class JSONData {
    // LOCAL CONFIG
    private static final String PARENT_DIR = "src";
    private static final String JSON_FILE = "data.json";

    // REMOTE CONFIG
    private static final String GITHUB_USERNAME = "dipeshpatil";
    private static final String GITHUB_REPO_NAME = "leetcode-problems";
    private static final String GITHUB_BRANCH_NAME = "main";
    private static final String GITHUB_REPO_URL = "https://github.com/" + GITHUB_USERNAME + "/" + GITHUB_REPO_NAME;
    private static final String GITHUB_REPO_BLOB_URL = GITHUB_REPO_URL + "/blob/" + GITHUB_BRANCH_NAME + "/" + PARENT_DIR + "/";

    public static void main(String[] args) {
        final FileReader reader = new FileReader();
        final List<String> categoryFolders = reader.listFolders(PARENT_DIR);

        final StringBuilder data = new StringBuilder("[");

        for (int i = 0; i < categoryFolders.size(); i++) {
            String categoryFolder = categoryFolders.get(i);
            if (!categoryFolder.equalsIgnoreCase("ZReadmeGenerator")) {
                data.append("\"").append(categoryFolder).append("\"").append(":").append(" {");
                String innerFolder = PARENT_DIR + "/" + categoryFolder;
                List<String> listFolders = reader.listFolders(innerFolder);
                for (int j = 0; j < listFolders.size(); j++) {
                    String level = listFolders.get(j);
                    data.append("\"").append(level).append("\"").append(": ");
                    String finalFolder = innerFolder + "/" + level;
                    List<String> files = reader.listFilesForFolder(finalFolder);

                    List<String> finalFilesWithQuotes = new ArrayList<>();
                    for (String file : files)
                        finalFilesWithQuotes.add("\"" + file + "\"");

                    if (j == listFolders.size() - 1)
                        data.append(Arrays.toString(finalFilesWithQuotes.toArray(new String[0])));
                    else
                        data.append(Arrays.toString(finalFilesWithQuotes.toArray(new String[0]))).append(',');
                }
                if (i == categoryFolders.size() - 1)
                    data.append("}");
                else
                    data.append("},");
            }
        }

        data.append("]");

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(JSON_FILE));
            writer.write(data.toString());
            writer.close();
            System.out.println("data.json Generated Successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
