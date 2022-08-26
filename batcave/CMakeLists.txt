cmake_minimum_required(VERSION 3.22.1)

project(batcave)

set(CMAKE_VERBOSE_MAKEFILE ON)
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

file(GLOB JNISOURCES "src/androidMain/jni/*.cpp")

add_compile_options(-Wall -Werror -fexceptions -frtti)
add_library(${PROJECT_NAME}
    SHARED
    ${JNISOURCES}
)

include_directories(
    cpp
)

#find_library(
#    log-lib
#    log
#)

target_link_libraries(
    ${PROJECT_NAME}
    android
)
