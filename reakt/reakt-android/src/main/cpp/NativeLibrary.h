#include <string>
#include <jsi/jsi.h>

using namespace facebook;

namespace NativeLibrary {
    class NativeClass {
        public:
            const std::string& get_property() { return property; }
            void set_property(const std::string& property) { this->property = property; }
            std::string property;
            void test(jsi::Runtime *runtime) {
                return;
            }
    };
}
