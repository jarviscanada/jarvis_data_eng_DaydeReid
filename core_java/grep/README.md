# Java Grep
## Introduction
This app is a Java implementation of the recursive `grep` function found on Linux systems.
Specifically, given a root directory, a regex pattern to search by, and an output file, the app
will recursively make its way through every file within the root and output every line that
matches the specified pattern into the output file. The app required learning how to use Java I/O
functions. Additionally, the lambda implementation required learning how to use Java 8's lambda
and stream functionality.

## Usage
Run the `main` function in either JavaGrepImplementation or JavaGrepLambdaImplementation, with
the following arguments, in order:

Argument | Explanation
--- | ---
`regex` | The regex pattern to search lines for
`rootPath` | The path to the root directory to begin the search in
`outFile` | The file to output the search results into

Sample usage:

Running the app with the arguments `*.void.*`, `./grep/src`, and `/tmp/grep.out` would print
every line in every `.java` file in this project that contains `void` to the file `/tmp/grep.out`

## Pseudocode
The app uses a central `process` function to drive the entire process. Pseudocode for `process` is as follows:

```$java
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
    if containsPattern(line)
      matchedLines.add(line)
writeToFile(matchedLines)
```

## Performance Issue
With both of the current implementations of this app, there will be an issue when particularly
large files are included in the root directory. Any file larger than the memory currently
assigned to the JVM running this app will cause performance issues such as OutOfMemoryErrors.

## Improvement
1. Modify file reading parts to allow for larger files to be read without adjusting the amount of JVM memory.
2. Allow the user to decide whether to search recursively or not
3. Add other linux grep functionality, such as the ability to ignore case