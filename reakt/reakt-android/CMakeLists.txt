cmake_minimum_required(VERSION 3.22.1)

# Declares and names the project.
project("reakt")

include_directories(
        ../node_modules/react-native/React
        ../node_modules/react-native/React/Base
        ../node_modules/react-native/ReactCommon/jsi
        ../node_modules/react-native/ReactCommon/jsi/jsi
)

set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
add_compile_options(-Wall -Werror -fexceptions -frtti -fPIC)

# Should not use GLOB for speed
file(GLOB REAKT_CPP "../reakt-cpp/**/*")
file(GLOB REAKT "src/main/cpp/**/*")
file(GLOB REACT "../node_modules/react-native/ReactCommon/jsi/**/*")

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.


add_library( # Sets the name of the library.
        reakt

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        src/main/cpp/reakt.cpp

        #${REAKT_CPP}

        ${REACT}
        ${REAKT}
)

set_target_properties(
        reakt PROPERTIES
        CXX_STANDARD 17
        CXX_EXTENSIONS OFF
        POSITION_INDEPENDENT_CODE ON
)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

#find_library(
# Sets the name of the path variable.
#        log-lib
#
# Specifies the name of the NDK library that
# you want CMake to locate.
#        log
#        )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        reakt

        # Links the target library to the log library
        # included in the NDK.
#        ${log-lib}
)
