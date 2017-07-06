---
layout: default
---
## [](#header-2)Abstract

The MD5-SHA checker program calculates and compares the selected hash code of the choosed file. This Java program uses the [MessageDigest](https://docs.oracle.com/javase/7/docs/api/java/security/MessageDigest.html) class, and generate MD5, SHA-1, SHA-256, SHA-384, SHA-512 hash codes. On Windows plattform runs the [md5hash.jar](https://github.com/furedi/md5-sha/raw/master/md5hash.jar) code with jre1.8.0_131 or higher version of JVM. Under Linux operating system must install the openjdk-8.
```
sudo apt install openjdk-8-jdk openjdk-8-jre-headless
```
If the default associated program for jar files is ```java```, then download and double click to start. Otherwise the application runs with the following command: 

```
$ java -jar md5hash.jar
```

### [](#header-3)How to check hash codes?
1.  Choose a file or type the path and file name.
2.  Copy or type the added hash code.
3.  Calculate and check the selected hash value.

### [](#header-3)If the typed and calculated hash values are the same:
![](./assets/images/match.png?raw=true)

### [](#header-3)And the two hash values are different:
![](./assets/images/mismatch.png?raw=true)

GitHub Pages: [Link to slate page themes](https://github.com/pages-themes/slate).
