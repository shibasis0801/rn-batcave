cmake_minimum_required(VERSION 3.22.1)

project(batcave)

include_directories(
        ../tester/node_modules/react-native/React
        ../tester/node_modules/react-native/React/Base
        ../tester/node_modules/react-native/ReactCommon/jsi/
        ../tester/node_modules/react-native/ReactCommon/jsi/jsi
)

set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

file(GLOB JNISOURCES "src/androidMain/jni/*")

add_compile_options(-Wall -Werror -fexceptions -frtti -fPIC)
add_library(
        batcave
        SHARED
        ${BATCAVE_ANDROID}
        ${BATCAVE_COMMON}
        ${JNISOURCES}
        #../cpp/android/bifrost.cpp
        ../tester/node_modules/react-native/ReactCommon/jsi/jsi/jsi.cpp
)

set_target_properties(
        batcave PROPERTIES
        CXX_STANDARD 17
        CXX_EXTENSIONS OFF
        POSITION_INDEPENDENT_CODE ON
)

find_library(
        log-lib
        log
)

#find_package(fbjni REQUIRED CONFIG)

target_link_libraries(
        batcave
        android
        ${log-lib}
)



