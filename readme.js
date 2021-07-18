const fs = require('fs');
const util = require('util');

const THINGS_TO_EXCLUDE = ['TreeNode.java', undefined];
const ROOT_DIR = './src';
const index = [];

// REMOTE CONFIGs
const GITHUB_USERNAME = 'dipeshpatil';
const GITHUB_REPO_NAME = 'leetcode-problems';
const GITHUB_BRANCH_NAME = 'main';
const GITHUB_REPO_URL =
  'https://github.com/' + GITHUB_USERNAME + '/' + GITHUB_REPO_NAME;
const GITHUB_REPO_BLOB_URL =
  GITHUB_REPO_URL + '/blob/' + GITHUB_BRANCH_NAME + '/src/';

const getDirectories = (path, exclude = []) => {
  if (exclude)
    return fs.readdirSync(path).filter((item) => !exclude.includes(item));
  else return fs.readdirSync(path);
};

const categoriesDirArray = getDirectories(ROOT_DIR, THINGS_TO_EXCLUDE);

for (let i = 0; i < categoriesDirArray.length; i++) {
  const category = categoriesDirArray[i];

  const item = {
    category: category,
    levels: {},
  };

  const levelsDirArray = getDirectories(
    ROOT_DIR + '/' + category,
    THINGS_TO_EXCLUDE
  );

  for (let j = 0; j < levelsDirArray.length; j++) {
    const level = levelsDirArray[j];
    const files = getDirectories(
      ROOT_DIR + '/' + category + '/' + level,
      THINGS_TO_EXCLUDE
    );
    item['levels'][level] = files;
  }
  index.push(item);
}

let breadCrumbs = '|';

for (let i = 0; i < index.length; i++) {
  let category = index[i].category;
  breadCrumbs += ` [${category}](${GITHUB_REPO_URL}/#${category.toLowerCase()}) |`;
}

let content = breadCrumbs + '\n\n---\n';

for (let i = 0; i < index.length; i++) {
  const item = index[i];
  content += `### [${item.category}](${GITHUB_REPO_BLOB_URL}${item.category})\n`;

  const levels = Object.keys(item.levels);

  for (let j = 0; j < levels.length; j++) {
    if (item.levels[levels[j]]) {
      content += `- [${levels[j]}](${GITHUB_REPO_BLOB_URL}${item.category}/${levels[j]})\n`;

      for (let l = 0; l < item.levels[levels[j]].length; l++) {
        const file = item.levels[levels[j]][l];
        content += `\t - [${file}](${GITHUB_REPO_BLOB_URL}${item.category}/${levels[j]}/${file})\n`;
      }
      content += '\n';
    }
  }
}

fs.writeFileSync('README.md', content);