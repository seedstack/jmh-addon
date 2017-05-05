---
title: "JMH"
repo: "https://github.com/seedstack/jmh-addon"
author: "Tuan DO CAO"
description: "Provides integration of JHM for benchmarking SeedStack applications."
tags:
    - monitoring
zones:
    - Addons
menu:
    AddonJMH:
        weight: 10
---

SeedStack JMH add-on provides integration of [JMH](http://openjdk.java.net/projects/code-tools/jmh/) which is a harness
for building benchmarks.<!--more-->

# Dependency

To add JMH integration to your project, use the following dependency:

{{< dependency g="org.seedstack.addons.jmh" a="jmh-core" >}}

# Configuration

{{% config p="jmh" %}}
```yaml
jmh:
  # Regular expression of the benchmarks to include in the run (all by default)
  include: (String)
  # Regular expression of the benchmarks to include in the warm-up phase (all by default)
  includeWarmup: (String)
  # Regular expression of the benchmarks to exclude from the run
  exclude: (String)
  # The format of the result file (no result file by default)
  resultFormat: (TEXT|CSV|SCSV|JSON|LATEX)
  # The location of the result file (defaults to jmh-results.[ext] in the current directory) 
  result: (File)  
  # The warm-up mode (BULK by default)
  warmupMode: (INDI|BULK|BULK_INDI)
  # The run mode (AverageTime by default) 
  mode: (Throughput|AverageTime|SampleTime|SingleShotTime)
  warmup:
    # Number of forks for warming-up (0 by default)
    forks: (int)
    # The batch size of a warm-up (1 by default)
    batchSize: (int)
    # The duration of a warm-up (1 second by default)
    time: (TimeValue)
    # The number of iterations per warm-up (1 by default) 
    iterations: (int)
  measurement:
    # Number of forks for running benchmarks (0 by default)
    forks: (int)
    # The batch size of a run (1 by default)
    batchSize: (int)
    # The duration of a run (1 second by default)
    time: (TimeValue)
    # The number of iterations per run (1 by default) 
    iterations: (int)
  # Number of operation to run per benchmark invocation (1 by default)
  operationsPerInvocation: (int)
  # Number of threads to run benchmarks (1 by default)
  threads: (int)
  # If true, the whole benchmark will fail after an error
  failOnError: (boolean)
  # If true, forced garbage collection will be done between benchmarks
  garbageCollection: (boolean)
  # The duration after which the benchmark will timeout (10 seconds by default) 
  timeout: (TimeValue)
  # The reporting time unit (milliseconds by default)
  timeUnit: (TimeUnit)
  # Additional arguments passed to the forked JVMs
  jvmArgs: (String[])
```
{{% /config %}}

# Writing benchmarks

To be injectable, benchmark classes must extend the {{< java "org.seedstack.jmh.AbstractBenchmark" >}} class:

```java
@State(Scope.Thread)
public class SomeBenchmark extends AbstractBenchmark {
    @Inject
    @Named("someString")
    private String someString;

    @Benchmark
    public void someBenchmarkedMethod() {
        // ...
    }
}
```

{{% callout info %}}
Check the [JMH documentation](http://openjdk.java.net/projects/code-tools/jmh/) for more information about how to write
benchmarks.
{{% /callout %}}

# Running benchmarks

## Benchmark tool
 
A [SeedStack tool]({{< relref "docs/seed/manual/running.md#tool-mode" >}}) named `benchmark` is provided to run benchmarks
embedded in an application. It can be run using the [SeedStack Maven plugin]({{< relref "docs/overview/maven-plugin/tool.md" >}}):

```plain
mvn -Dargs="benchmark" org.seedstack:seedstack-maven-plugin:tool
```

Or you can run it from your capsule:

```plain
java -Dseedstack.tool=benchmark -jar app-capsule.jar
```

## Launcher

If you choose to package your benchmarks in their own separate module, a launcher will be needed to run them. This launcher
is provided by the following dependency:

{{< dependency g="org.seedstack.addons.jmh" a="jmh-launcher" >}}

A [capsule packaging]({{< relref "docs/overview/maven-plugin/package.md" >}}) will allows your benchmarks to be run from
the command-line:

```plain
java -jar benchmark-capsule.jar
```

## Programmatic execution

If you need more control you can inject the JMH runner and run benchmarks manually:

```java
public class SomeClass {
    @Inject
    private Runner jmhRunner;
    
    public void someMethod() {
        jmhRunner.run();
    }
}
```
