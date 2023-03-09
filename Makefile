JAVAC := javac
JAR := jar
JAVACFLAGS := -d build/java --source-path src/java

CXX := g++
CXXFLAGS := -fPIC -O2 \
	-I/usr/lib/jvm/java-19-openjdk-amd64/include \
	-I/usr/lib/jvm/java-19-openjdk-amd64/include/linux

SFML_SYSTEM_CLASSFILES := \
	build/java/org/sfml_dev/system/Clock.class \
	build/java/org/sfml_dev/system/CppObject.class \
	build/java/org/sfml_dev/system/Time.class \
	build/java/org/sfml_dev/system/Vector2f.class \
	build/java/org/sfml_dev/system/Vector2i.class \
	build/java/org/sfml_dev/system/Vector3f.class \
	build/java/org/sfml_dev/system/Vector3i.class \
	build/java/org/sfml_dev/system/sys/jni.class \
	build/java/org/sfml_dev/system/sys/new_.class \
	build/java/org/sfml_dev/system/sys/SFML_System.class \
	build/java/org/sfml_dev/system/sys/SharedLib.class \
	build/java/org/sfml_dev/system/sys/string.class \
	build/java/org/sfml_dev/system/sys/vector.class
SFML_SYSTEM_OFILES := \
	build/cpp/jni.o \
	build/cpp/new.o \
	build/cpp/SFML_System.o \
	build/cpp/string.o \
	build/cpp/vector.o

SFML_WINDOW_CLASSFILES := \
	build/java/org/sfml_dev/window/Clipboard.class \
	build/java/org/sfml_dev/window/ContextDestroyCallback.class \
	build/java/org/sfml_dev/window/ContextSettings.class \
	build/java/org/sfml_dev/window/Cursor.class \
	build/java/org/sfml_dev/window/Event.class \
	build/java/org/sfml_dev/window/EventHandler.class \
	build/java/org/sfml_dev/window/GlResource.class \
	build/java/org/sfml_dev/window/MouseMoveEvent.class \
	build/java/org/sfml_dev/window/MouseWheelEvent.class \
	build/java/org/sfml_dev/window/SizeEvent.class \
	build/java/org/sfml_dev/window/Style.class \
	build/java/org/sfml_dev/window/TextEvent.class \
	build/java/org/sfml_dev/window/VideoMode.class \
	build/java/org/sfml_dev/window/Window.class \
	build/java/org/sfml_dev/window/WindowHandle.class \
	build/java/org/sfml_dev/window/sys/SFML_Window.class \
	build/java/org/sfml_dev/window/sys/SharedLib.class
SFML_WINDOW_OFILES := \
	build/cpp/SFML_Window.o

.PHONY: all clean

all: test.jar libsfml-system.jar libsfml-window.jar

test.jar: build/java/Main.class resource/test-manifest.txt libsfml-system.jar libsfml-window.jar
	$(JAR) cfm $@ resource/test-manifest.txt -C build/java Main.class

libsfml-window.jar: $(SFML_WINDOW_CLASSFILES) build/libsfml-java-window.so
	$(JAR) cfm $@ resource/libsfml-window-manifest.txt \
	$$(for FILE in $(SFML_WINDOW_CLASSFILES); \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done) \
	-C build/java org/sfml_dev/window/GlResource\$$TransientContextLock.class \
	-C build libsfml-java-window.so

libsfml-system.jar: $(SFML_SYSTEM_CLASSFILES) build/libsfml-java-system.so
	$(JAR) cf $@ \
	$$(for FILE in $(SFML_SYSTEM_CLASSFILES); \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done) \
	-C build/java org/sfml_dev/system/CppObject\$$State.class \
	-C build libsfml-java-system.so

build/libsfml-java-window.so: $(SFML_WINDOW_OFILES)
	$(CXX) -shared -o $@ $^ -lsfml-window

build/libsfml-java-system.so: $(SFML_SYSTEM_OFILES)
	$(CXX) -shared -o $@ $^ -lsfml-system

build/java/%.class: src/java/%.java
	mkdir -p build/java
	$(JAVAC) $(JAVACFLAGS) $<

build/cpp/%.o: src/cpp/%.cpp
	mkdir -p build/cpp
	$(CXX) $(CXXFLAGS) -c -o $@ $<

clean:
	rm -rf build *.jar
