# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.6

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files (x86)\JetBrains\CLion 2016.3.1\bin\cmake\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files (x86)\JetBrains\CLion 2016.3.1\bin\cmake\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = E:\HackerRank

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = E:\HackerRank\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Stack.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Stack.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Stack.dir/flags.make

CMakeFiles/Stack.dir/main.cpp.obj: CMakeFiles/Stack.dir/flags.make
CMakeFiles/Stack.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=E:\HackerRank\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Stack.dir/main.cpp.obj"
	C:\MinGW\bin\g++.exe   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Stack.dir\main.cpp.obj -c E:\HackerRank\main.cpp

CMakeFiles/Stack.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Stack.dir/main.cpp.i"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E E:\HackerRank\main.cpp > CMakeFiles\Stack.dir\main.cpp.i

CMakeFiles/Stack.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Stack.dir/main.cpp.s"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S E:\HackerRank\main.cpp -o CMakeFiles\Stack.dir\main.cpp.s

CMakeFiles/Stack.dir/main.cpp.obj.requires:

.PHONY : CMakeFiles/Stack.dir/main.cpp.obj.requires

CMakeFiles/Stack.dir/main.cpp.obj.provides: CMakeFiles/Stack.dir/main.cpp.obj.requires
	$(MAKE) -f CMakeFiles\Stack.dir\build.make CMakeFiles/Stack.dir/main.cpp.obj.provides.build
.PHONY : CMakeFiles/Stack.dir/main.cpp.obj.provides

CMakeFiles/Stack.dir/main.cpp.obj.provides.build: CMakeFiles/Stack.dir/main.cpp.obj


# Object files for target Stack
Stack_OBJECTS = \
"CMakeFiles/Stack.dir/main.cpp.obj"

# External object files for target Stack
Stack_EXTERNAL_OBJECTS =

Stack.exe: CMakeFiles/Stack.dir/main.cpp.obj
Stack.exe: CMakeFiles/Stack.dir/build.make
Stack.exe: CMakeFiles/Stack.dir/linklibs.rsp
Stack.exe: CMakeFiles/Stack.dir/objects1.rsp
Stack.exe: CMakeFiles/Stack.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=E:\HackerRank\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Stack.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Stack.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Stack.dir/build: Stack.exe

.PHONY : CMakeFiles/Stack.dir/build

CMakeFiles/Stack.dir/requires: CMakeFiles/Stack.dir/main.cpp.obj.requires

.PHONY : CMakeFiles/Stack.dir/requires

CMakeFiles/Stack.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Stack.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Stack.dir/clean

CMakeFiles/Stack.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" E:\HackerRank E:\HackerRank E:\HackerRank\cmake-build-debug E:\HackerRank\cmake-build-debug E:\HackerRank\cmake-build-debug\CMakeFiles\Stack.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Stack.dir/depend

