# executable-jar-with-maven-example

[![Build Status](https://travis-ci.org/bingoohuang/execjar.svg?branch=develop)](https://travis-ci.org/bingoohuang/execjar)

Generates executable jar files with dependencies.

## Just build it

```bash
➜  execjar git:(master) ✗ mvn clean package

```

## And see what you got

```bash
➜  execjar git:(master) ✗ ls -lh target
total 5864
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 classes
-rw-r--r--  1 bingoobjca  staff   2.9M  7 29 19:53 execjar-0.0.1-exec.jar
-rw-r--r--  1 bingoobjca  staff   3.0K  7 29 19:53 execjar-0.0.1.jar
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 generated-sources
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 maven-archiver
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 maven-status
```

## And run it

```bash
➜  execjar git:(master) ✗ java -jar target/execjar-0.0.1-exec.jar
class com.google.common.io.BaseEncoding
➜  execjar git:(master) ✗
```