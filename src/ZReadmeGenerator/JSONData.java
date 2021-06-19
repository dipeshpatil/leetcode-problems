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
        category: Array,
        levels: {
            easy: ['xyz.java'],
            medium: [''],
            hard: []
        }
    },
    {
        category: String,
        levels: {
            easy: ['xyz.java'],
            medium: [''],
            hard: []
        }
    },
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
            if (!categoryFolders.get(i).equalsIgnoreCase("ZReadmeGenerator")) {
                data.append("{");
                data.append("\"" + "category" + "\": \"").append(categoryFolders.get(i)).append("\",");
                data.append("\"" + "levels" + "\": {");
                String innerFolder = PARENT_DIR + "/" + categoryFolders.get(i);
                List<String> levels = reader.listFolders(innerFolder);

                for (int j = 0; j < levels.size(); j++) {
                    String level = levels.get(j);

                    String finalFolderName = innerFolder + "/" + level;
                    List<String> files = new ArrayList<>();

                    for (String file : reader.listFilesForFolder(finalFolderName))
                        files.add("\"" + file + "\"");

                    if (j == levels.size() - 1)
                        data.append("\"").append(level.toLowerCase()).append("\": ").append(Arrays.toString(files.toArray(new String[0])));
                    else
                        data.append("\"").append(level.toLowerCase()).append("\": ").append(Arrays.toString(files.toArray(new String[0]))).append(",");
                }

                data.append("}");

                if (i == categoryFolders.size() - 2)
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
