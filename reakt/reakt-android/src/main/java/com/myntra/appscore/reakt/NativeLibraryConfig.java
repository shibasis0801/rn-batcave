package com.myntra.appscore.reakt;

import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;
import org.bytedeco.javacpp.tools.*;

@Properties(
    value = @Platform(include = "NativeLibrary.h"),
    target = "com.myntra.appscore.reakt.generated.NativeLibrary"
)
public class NativeLibraryConfig implements InfoMapper {
    static {
        // Let Android take care of loading JNI libraries for us
        System.setProperty("org.bytedeco.javacpp.loadLibraries", "false");
    }
    public void map(InfoMap infoMap) {}
}

