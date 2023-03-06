JAVAC := javac
JAVAFLAGS := -d build/java --source-path src/java

CLASSFILES := \
	build/java/org/sfml_dev/system/Lib.class

.PHONY: all clean

all: test.jar

test.jar: build/java/Main.class resource/test-manifest.txt libsfml-system.jar
	jar cfm $@ resource/test-manifest.txt -C build/java Main.class

libsfml-system.jar: $(CLASSFILES)
	jar cf $@ \
	$$(for FILE in $^; \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done)

build/java/%.class: src/java/%.java
	$(JAVAC) $(JAVAFLAGS) $<

clean:
	rm -rf build *.jar