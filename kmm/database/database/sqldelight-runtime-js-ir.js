(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports'], factory);
  else if (typeof exports === 'object')
    factory(module.exports);
  else
    root['sqldelight-runtime-js-ir'] = factory(typeof this['sqldelight-runtime-js-ir'] === 'undefined' ? {} : this['sqldelight-runtime-js-ir']);
}(this, function (_) {
  'use strict';
  //region block: pre-declaration
  //endregion
  return _;
}));

//# sourceMappingURL=sqldelight-runtime-js-ir.js.map
