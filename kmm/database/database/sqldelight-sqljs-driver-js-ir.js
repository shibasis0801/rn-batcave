(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports'], factory);
  else if (typeof exports === 'object')
    factory(module.exports);
  else
    root['sqldelight-sqljs-driver-js-ir'] = factory(typeof this['sqldelight-sqljs-driver-js-ir'] === 'undefined' ? {} : this['sqldelight-sqljs-driver-js-ir']);
}(this, function (_) {
  'use strict';
  //region block: pre-declaration
  //endregion
  return _;
}));

//# sourceMappingURL=sqldelight-sqljs-driver-js-ir.js.map
