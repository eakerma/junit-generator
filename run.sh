#!/bin/bash
CLASSPATH=$CLASSPATH:`dirname $0`/target/junit-generator-1.0.jar:`dirname $0`/target/dependency/'*' 
java edu.uark.util.junit.generator.Main $*
