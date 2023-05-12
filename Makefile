JAVAC := /usr/lib/jvm/java-20-openjdk/bin/javac
JAR := /usr/lib/jvm/java-20-openjdk/bin/jar
JAVACFLAGS := -d build/java --source-path src/java

CXX := g++
CXXFLAGS := -fPIC -O2 \
	-I/usr/lib/jvm/java-20-openjdk/include \
	-I/usr/lib/jvm/java-20-openjdk/include/linux

SFML_SYSTEM_CLASSFILES := \
	build/java/org/sfml_dev/OpenGL.class \
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
	build/java/org/sfml_dev/window/Joystick.class \
	build/java/org/sfml_dev/window/JoystickButtonEvent.class \
	build/java/org/sfml_dev/window/JoystickConnectEvent.class \
	build/java/org/sfml_dev/window/JoystickMoveEvent.class \
	build/java/org/sfml_dev/window/Keyboard.class \
	build/java/org/sfml_dev/window/KeyEvent.class \
	build/java/org/sfml_dev/window/Mouse.class \
	build/java/org/sfml_dev/window/MouseButtonEvent.class \
	build/java/org/sfml_dev/window/MouseMoveEvent.class \
	build/java/org/sfml_dev/window/MouseWheelEvent.class \
	build/java/org/sfml_dev/window/MouseWheelScrollEvent.class \
	build/java/org/sfml_dev/window/Sensor.class \
	build/java/org/sfml_dev/window/SensorEvent.class \
	build/java/org/sfml_dev/window/SizeEvent.class \
	build/java/org/sfml_dev/window/Style.class \
	build/java/org/sfml_dev/window/TextEvent.class \
	build/java/org/sfml_dev/window/Touch.class \
	build/java/org/sfml_dev/window/TouchEvent.class \
	build/java/org/sfml_dev/window/VideoMode.class \
	build/java/org/sfml_dev/window/Window.class \
	build/java/org/sfml_dev/window/WindowHandle.class \
	build/java/org/sfml_dev/window/sys/SFML_Window.class \
	build/java/org/sfml_dev/window/sys/SharedLib.class
SFML_WINDOW_OFILES := \
	build/cpp/SFML_Window.o

SFML_GRAPHICS_CLASSFILES := \
	build/java/org/sfml_dev/graphics/Color.class \
	build/java/org/sfml_dev/graphics/FloatRect.class \
	build/java/org/sfml_dev/graphics/IntRect.class \
	build/java/org/sfml_dev/graphics/Transform.class \
	build/java/org/sfml_dev/graphics/Transformable.class \
	build/java/org/sfml_dev/graphics/sys/SFML_Graphics.class \
	build/java/org/sfml_dev/graphics/sys/SharedLib.class
SFML_GRAPHICS_OFILES := \
	build/cpp/SFML_Graphics.o

.PHONY: all clean

all: test.jar libsfml-system.jar libsfml-window.jar libsfml-graphics.jar

test.jar: build/java/Main.class resource/test-manifest.txt libsfml-system.jar libsfml-window.jar
	$(JAR) cfm $@ resource/test-manifest.txt -C build/java Main.class

libsfml-graphics.jar: $(SFML_GRAPHICS_CLASSFILES) build/libjava-sfml-graphics.so libsfml-system.jar libsfml-window.jar
	$(JAR) cfm $@ resource/libsfml-graphics-manifest.txt \
	$$(for FILE in $(SFML_GRAPHICS_CLASSFILES); \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done) \
	-C build/java org/sfml_dev/graphics/Transform\$$ImmutableTransform.class \
	-C build libjava-sfml-graphics.so

libsfml-window.jar: $(SFML_WINDOW_CLASSFILES) build/libjava-sfml-window.so libsfml-system.jar
	$(JAR) cfm $@ resource/libsfml-window-manifest.txt \
	$$(for FILE in $(SFML_WINDOW_CLASSFILES); \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done) \
	-C build/java org/sfml_dev/window/Cursor\$$Type.class \
	-C build/java org/sfml_dev/window/GlResource\$$TransientContextLock.class \
	-C build/java org/sfml_dev/window/Joystick\$$Axis.class \
	-C build/java org/sfml_dev/window/Joystick\$$Identification.class \
	-C build/java org/sfml_dev/window/Keyboard\$$Key.class \
	-C build/java org/sfml_dev/window/Mouse\$$Button.class \
	-C build/java org/sfml_dev/window/Mouse\$$Wheel.class \
	-C build/java org/sfml_dev/window/Sensor\$$Type.class \
	-C build libjava-sfml-window.so

libsfml-system.jar: $(SFML_SYSTEM_CLASSFILES) build/libjava-sfml-system.so
	$(JAR) cf $@ \
	$$(for FILE in $(SFML_SYSTEM_CLASSFILES); \
		do echo -C build/java $$(expr substr $$FILE 12 $$(expr $$(expr length $$FILE) - 11)); \
	done) \
	-C build/java org/sfml_dev/system/CppObject\$$State.class \
	-C build libjava-sfml-system.so

build/libjava-sfml-graphics.so: $(SFML_GRAPHICS_OFILES)
	$(CXX) -shared -o $@ $^ -lsfml-graphics

build/libjava-sfml-window.so: $(SFML_WINDOW_OFILES)
	$(CXX) -shared -o $@ $^ -lsfml-window

build/libjava-sfml-system.so: $(SFML_SYSTEM_OFILES)
	$(CXX) -shared -o $@ $^ -lsfml-system

build/java/%.class: src/java/%.java
	mkdir -p build/java
	$(JAVAC) $(JAVACFLAGS) $<

build/cpp/%.o: src/cpp/%.cpp
	mkdir -p build/cpp
	$(CXX) $(CXXFLAGS) -c -o $@ $<

clean:
	rm -rf build *.jar
