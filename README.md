# let-gen
This is a simple example to generate a bunch of unique strings of charaters and write them to a file

Please run below commands to run let-gen:

```bash
./gradlew clean build
java -jar build/libs/let-gen.jar -nol 230 -cl 100 -fp let_gen.txt
```

Explain args:
* -nol : number of lines
* -cl  : length of unique string of characters.
* -fp  : desired file path

NOTE:
- all args are mandatory.
- Jacoco unit test report is integrated. Run below command to run unit tests and generate Jacoco report:
```bash
      ./gradlew clean test
```
- reportHtml: build/reports/jacoco/test/html/index.html
