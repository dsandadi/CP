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
CMAKE_SOURCE_DIR = C:\Users\DINESH\ClionProjects\Change

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Users\DINESH\ClionProjects\Change\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Change_2.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Change_2.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Change_2.dir/flags.make

CMakeFiles/Change_2.dir/main.cpp.obj: CMakeFiles/Change_2.dir/flags.make
CMakeFiles/Change_2.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Users\DINESH\ClionProjects\Change\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Change_2.dir/main.cpp.obj"
	C:\MinGW\bin\g++.exe   $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Change_2.dir\main.cpp.obj -c C:\Users\DINESH\ClionProjects\Change\main.cpp

CMakeFiles/Change_2.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Change_2.dir/main.cpp.i"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Users\DINESH\ClionProjects\Change\main.cpp > CMakeFiles\Change_2.dir\main.cpp.i

CMakeFiles/Change_2.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Change_2.dir/main.cpp.s"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Users\DINESH\ClionProjects\Change\main.cpp -o CMakeFiles\Change_2.dir\main.cpp.s

CMakeFiles/Change_2.dir/main.cpp.obj.requires:

.PHONY : CMakeFiles/Change_2.dir/main.cpp.obj.requires

CMakeFiles/Change_2.dir/main.cpp.obj.provides: CMakeFiles/Change_2.dir/main.cpp.obj.requires
	$(MAKE) -f CMakeFiles\Change_2.dir\build.make CMakeFiles/Change_2.dir/main.cpp.obj.provides.build
.PHONY : CMakeFiles/Change_2.dir/main.cpp.obj.provides

CMakeFiles/Change_2.dir/main.cpp.obj.provides.build: CMakeFiles/Change_2.dir/main.cpp.obj


# Object files for target Change_2
Change_2_OBJECTS = \
"CMakeFiles/Change_2.dir/main.cpp.obj"

# External object files for target Change_2
Change_2_EXTERNAL_OBJECTS =

Change_2.exe: CMakeFiles/Change_2.dir/main.cpp.obj
Change_2.exe: CMakeFiles/Change_2.dir/build.make
Change_2.exe: CMakeFiles/Change_2.dir/linklibs.rsp
Change_2.exe: CMakeFiles/Change_2.dir/objects1.rsp
Change_2.exe: CMakeFiles/Change_2.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Users\DINESH\ClionProjects\Change\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Change_2.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Change_2.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Change_2.dir/build: Change_2.exe

.PHONY : CMakeFiles/Change_2.dir/build

CMakeFiles/Change_2.dir/requires: CMakeFiles/Change_2.dir/main.cpp.obj.requires

.PHONY : CMakeFiles/Change_2.dir/requires

CMakeFiles/Change_2.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Change_2.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Change_2.dir/clean

CMakeFiles/Change_2.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Users\DINESH\ClionProjects\Change C:\Users\DINESH\ClionProjects\Change C:\Users\DINESH\ClionProjects\Change\cmake-build-debug C:\Users\DINESH\ClionProjects\Change\cmake-build-debug C:\Users\DINESH\ClionProjects\Change\cmake-build-debug\CMakeFiles\Change_2.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Change_2.dir/depend

