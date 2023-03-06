JAVAC := javac
JAVAFLAGS := -d build/java --source-path src/java

CLASSFILES := \
	build/java/Main.class

.PHONY: all clean

all: test.jar

test.jar: $(CLASSFILES)
	jar cvfe $@ Main \
	$$(for FILE in $^; \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done)

build/java/%.class: src/java/%.java
	$(JAVAC) $(JAVAFLAGS) $<

clean:
	rm -rf build *.jar