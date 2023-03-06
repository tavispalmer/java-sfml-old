JAVAC := javac
JAVACFLAGS := -d build/java --source-path src/java

CXX := g++
CXXFLAGS := -fPIC -O2 \
	-I/usr/lib/jvm/java-19-openjdk-amd64/include \
	-I/usr/lib/jvm/java-19-openjdk-amd64/include/linux

SFML_SYSTEM_CLASSFILES := \
	build/java/org/sfml_dev/system/Vector2i.class \
	build/java/org/sfml_dev/system/sys/new_.class \
	build/java/org/sfml_dev/system/sys/SFML_System.class \
	build/java/org/sfml_dev/system/sys/SharedLib.class
SFML_SYSTEM_OFILES := \
	build/cpp/new.o \
	build/cpp/System.o

.PHONY: all clean

all: test.jar libsfml-system.jar

test.jar: build/java/Main.class resource/test-manifest.txt libsfml-system.jar
	jar cfm $@ resource/test-manifest.txt -C build/java Main.class

libsfml-system.jar: $(SFML_SYSTEM_CLASSFILES) build/libsfml-java-system.so
	jar cf $@ \
	$$(for FILE in $(SFML_SYSTEM_CLASSFILES); \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done) -C build libsfml-java-system.so

build/libsfml-java-system.so: $(SFML_SYSTEM_OFILES)
	$(CC) -o $@ -shared $^

build/java/%.class: src/java/%.java
	$(JAVAC) $(JAVACFLAGS) $<

build/cpp/%.o: src/cpp/%.cpp
	mkdir -p build/cpp
	$(CXX) $(CXXFLAGS) -c -o $@ $<

clean:
	rm -rf build *.jar
