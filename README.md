# Teaching

This repository deals with various Java code snippets related to teaching activities.

To compile LaTeX documentation, navigate to the folder where the `INPUT.md` 
file is, and execute the following command, assuming `readme2tex` is installed.

```
python3.7 -m readme2tex --output README.md --nocdn INPUT.md --htmlize --rerender --usepackage amsmath --usepackage amssymb
```