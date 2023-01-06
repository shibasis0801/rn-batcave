(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'indexeddb-external'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'indexeddb-external'.");
    }
    root['indexeddb-external'] = factory(typeof this['indexeddb-external'] === 'undefined' ? {} : this['indexeddb-external'], this['kotlin-kotlin-stdlib-js-ir']);
  }
}(this, function (_, kotlin_kotlin) {
  'use strict';
  //region block: imports
  var Unit_getInstance = kotlin_kotlin.$_$.b1;
  var isObject = kotlin_kotlin.$_$.s2;
  //endregion
  //region block: pre-declaration
  //endregion
  function get_indexedDB(_this__u8e3s4) {
    var tmp$ret$0;
    // Inline function 'kotlin.js.asDynamic' call
    tmp$ret$0 = _this__u8e3s4;
    var tmp = tmp$ret$0.indexedDB;
    return (!(tmp == null) ? isObject(tmp) : false) ? tmp : null;
  }
  //region block: exports
  _.$_$ = _.$_$ || {};
  _.$_$.a = get_indexedDB;
  //endregion
  return _;
}));

//# sourceMappingURL=indexeddb-external.js.map
