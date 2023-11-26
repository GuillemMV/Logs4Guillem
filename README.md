# Logs4Guillem
I just made a very simple log generator for my other projects. The intention is to use it as an external jar. 
I wrote this project because I thought that using bigger libraries like Log4j in small projects is a bit counterproductive at the moment of setting up the util.
So, this is the best option for me to get a log register in my projects without configuring dependencies.

# What if i want to use it?
Export it as a JAR file, and put it on the project where you want to use it. Then create a config.properties file and put this:
```
date.format=dd-MM-yyyy
time.format=HH:mm:ss
log.mode=0
logfile.path=./
```
You can modify the values following the Java date and time formatting rules. The ```logfile.mode``` can be in 0 (For console mode) or 1 (External file mode).
