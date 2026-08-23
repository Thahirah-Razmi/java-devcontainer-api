# Contributing

How a change travels through this repository.

---

## The unit of work

**One issue → one branch → one pull request → one merge.**

---

## 1. Open

Every change starts as a written issue, using the task template. An issue is workable
when a second person can pick it up and finish it without asking you anything.

- Acceptance criteria must be checkable, not aspirational.
- The out-of-scope list is not optional. It is what keeps the change small.

---

## 2. Branch

Branch from an up-to-date trunk. Never commit directly to `main`.

```bash
git switch main && git pull
git switch -c feat/12-delete-item
```

Naming: `<type>/<issue-number>-<short-slug>`, using the same types as commits.

Branches are short-lived — hours or days, never weeks. A branch that lives two weeks is
not a branch, it is a fork, and merging it is somebody's afternoon.

---

## 3. Commit

Commits are **atomic**: one reason to change, and the project still works afterwards.
Code and the test that covers it belong in the same commit.

Format:

```
type(scope): imperative subject under ~50 characters

Body explaining WHY. The diff already shows what changed; it can never show what you were thinking.

Refs #12
```

| Type | Use for |
| :--- | :--- |
| `feat` | New behaviour a user can observe |
| `fix` | Corrects wrong behaviour |
| `docs` | Documentation only |
| `test` | Tests only |
| `refactor` | Same behaviour, different shape |
| `chore` | Repository plumbing |


Push on day one. Work that only exists on your laptop is invisible and unrecoverable.

---

## 4. Propose

Read your own diff first:

```bash
git diff main...feat/12-delete-item
```

Then run both gates, before you spend anyone else's attention:

```bash
pre-commit run --all-files
act --pull=false pull_request
```

Both run inside the dev container. They need one-time setup, because the configuration is
committed but the hook installation and the runner image are not:

```bash
pre-commit install                            # in the container
docker pull catthehacker/ubuntu:act-latest    # on the host, once
```

Full detail in [Run the gates locally](docs/how-to/run-the-gates.md).

Then open a pull request using the template. Fill every section, and link the issue with
a closing keyword (`Closes #12`) so the tracker maintains itself.

Small pull requests get read. Large ones get `LGTM` (Looks Good To Me). Reviewer attention is the scarcest
resource on the team, and only the author controls how it is spent.

---

## 5. Review

**As a reviewer**

- Comment on the code, never the person.
- Prefix non-blocking comments with `nit:` — otherwise the author cannot tell an opinion
  from a requirement.
- Ask rather than instruct. "What happens if the id is null?" surfaces more than
  "handle null".
- Say when something is good. Review is how conventions spread, not only how defects are
  found.

**As an author**

- Reply to every comment, even with "done". Silence reads as dismissal.
- Disagree in the pull request, with reasoning. A disagreement resolved in writing is a
  decision; resolved verbally it is a rumour.
- Push fixes as new commits so the conversation and the change stay welded together.

---

## 6. Close

A change is done when all four gates pass:

| Gate | Question |
| :--- | :--- |
| **Code** | Does it satisfy every acceptance criterion on the issue? |
| **Tests** | Is the new behaviour covered, and is the suite green? |
| **Docs** | Does the documentation still describe reality? |
| **Traceability** | Can someone get from any line to the reason it exists? |

Documentation is updated in the *same* pull request as the code. If you change a setup
step without changing the README, you have broken the README.

Tests and Docs are checked by the pipeline. Code and Traceability are not, and never will
be — no tool can tell you whether the documentation is *true*, or whether the change does
what the issue asked.

Then merge, confirm the issue closed itself, and delete the branch.

---

## Conflicts

A conflict is a question, not an error: two changes touched the same lines and git will
not guess a winner.

```bash
git fetch origin
git merge origin/main       # resolve, keeping BOTH intents
                            # run the tests, then:
git add <resolved-file>
git commit
```

`git merge --abort` returns you to before the merge. Nothing is ever lost.

The best conflict strategy is a short-lived branch.