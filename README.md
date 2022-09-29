ToDo

1. Platform Name
2. Key Value Store
3. SQL Query / Cursor
4. Location
5. Camera 
6. Permissions


Open Issues:
1. Web Bundle size (try commonjs => ES transformer)
2. Bidirectional interop with web (typescript)
3. Bidirectional interop with ios (swift)
4. Allow optional compatibility with no-op functions ( Example: adopt something first in android then web then ios  )

Native Modules

BifrostJSI -> Interface React with C++ using BifrostPlatform

BifrostPlatform -> Interface C++ with BifrostJNI / BifrostObjC depending on Platform

BifrostJNI -> Interface C++ with Android 
BifrostObjC -> Interface C++ with ObjC

Later
BifrostWASM -> Interface C++ with Web
BifrostTS -> 


