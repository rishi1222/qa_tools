Cucumber for CAT


Important commands when adding new repository.

echo "# qa_tools" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/rishi1222/qa_tools.git
git push -u origin main

Important Git documentation

Working with push protection from the command line
Learn your options for unblocking your push from the command line to GitHub if secret scanning detects a secret in your changes.

Who can use this feature?
Users with write access

In this article
Resolving a blocked push
Bypassing push protection
Requesting bypass privileges
Further reading
Resolving a blocked push
To resolve a blocked push, you must remove the secret from all of the commits it appears in.

If the secret was introduced by your latest commit, see Removing a secret introduced by the latest commit on your branch.
If the secret appears in earlier commits, see Removing a secret introduced by an earlier commit on your branch.
Removing a secret introduced by the latest commit on your branch
Remove the secret from your code.
To commit the changes, run git commit --amend --all. This updates the original commit that introduced the secret instead of creating a new commit.
Push your changes with git push.
Removing a secret introduced by an earlier commit on your branch
Examine the error message that displayed when you tried to push your branch, which lists all of the commits that contain the secret.

remote:   —— GitHub Personal Access Token ——————————————————————
remote:    locations:
remote:      - commit: 8728dbe67
remote:        path: README.md:4
remote:      - commit: 03d69e5d3
remote:        path: README.md:4
remote:      - commit: 8053f7b27
remote:        path: README.md:4
Next, run git log to see a full history of all the commits on your branch, along with their corresponding timestamps.

test-repo (test-branch)]$ git log
commit 8053f7b27 (HEAD -> main)
Author: Octocat <1000+octocat@users.noreply.github.com
Date:   Tue Jan 30 13:03:37 2024 +0100

my fourth commit message

commit 03d69e5d3
Author: Octocat <1000+octocat@users.noreply.github.com>
Date:   Tue Jan 30 13:02:59 2024 +0100

my third commit message

commit 8728dbe67
Author: Octocat <1000+octocat@users.noreply.github.com
Date:   Tue Jan 30 13:01:36 2024 +0100

my second commit message

commit 6057cbe51
Author: Octocat <1000+octocat@users.noreply.github.com
Date:   Tue Jan 30 12:58:24 2024 +0100

my first commit message

Focusing only on the commits that contain the secret, use the output of git log to identify which commit comes earliest in your Git history.

In the example, commit 8728dbe67 was the first commit to contain the secret.
Start an interactive rebase with git rebase -i <COMMIT-ID>~1.

For <COMMIT-ID>, use the commit identified in step 3. For example, git rebase -i 8728dbe67~1.
In the editor, choose to edit the commit identified in step 3 by changing pick to edit on the first line of the text.

edit 8728dbe67 my second commit message
pick 03d69e5d3 my third commit message
pick 8053f7b27 my fourth commit message
Save and close the editor to start the interactive rebase.

Remove the secret from your code.

Add your changes to the staging area using git add ..

Note

The full command is git add .:

There is a space between add and ..
The period following the space is part of the command.
Commit your changes using git commit --amend.

Run git rebase --continue to finish the rebase.

Push your changes with git push.

Bypassing push protection