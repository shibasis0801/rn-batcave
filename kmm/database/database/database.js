(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js', './kotlinx-serialization-kotlinx-serialization-core-js-ir.js', './indexeddb-core.js', './kotlinx.coroutines-kotlinx-coroutines-core-js-ir.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'), require('./kotlinx-serialization-kotlinx-serialization-core-js-ir.js'), require('./indexeddb-core.js'), require('./kotlinx.coroutines-kotlinx-coroutines-core-js-ir.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'database'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'database'.");
    }
    if (typeof this['kotlinx-serialization-kotlinx-serialization-core-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'database'. Its dependency 'kotlinx-serialization-kotlinx-serialization-core-js-ir' was not found. Please, check whether 'kotlinx-serialization-kotlinx-serialization-core-js-ir' is loaded prior to 'database'.");
    }
    if (typeof this['indexeddb-core'] === 'undefined') {
      throw new Error("Error loading module 'database'. Its dependency 'indexeddb-core' was not found. Please, check whether 'indexeddb-core' is loaded prior to 'database'.");
    }
    if (typeof this['kotlinx.coroutines-kotlinx-coroutines-core-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'database'. Its dependency 'kotlinx.coroutines-kotlinx-coroutines-core-js-ir' was not found. Please, check whether 'kotlinx.coroutines-kotlinx-coroutines-core-js-ir' is loaded prior to 'database'.");
    }
    root.database = factory(typeof database === 'undefined' ? {} : database, this['kotlin-kotlin-stdlib-js-ir'], this['kotlinx-serialization-kotlinx-serialization-core-js-ir'], this['indexeddb-core'], this['kotlinx.coroutines-kotlinx-coroutines-core-js-ir']);
  }
}(this, function (_, kotlin_kotlin, kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core, kotlin_com_juul_indexeddb_core, kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core) {
  'use strict';
  //region block: imports
  var objectMeta = kotlin_kotlin.$_$.t2;
  var PluginGeneratedSerialDescriptor = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.e;
  var StringSerializer_getInstance = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.b;
  var Unit_getInstance = kotlin_kotlin.$_$.b1;
  var UnknownFieldException_init_$Create$ = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.a;
  var THROW_CCE = kotlin_kotlin.$_$.e3;
  var typeParametersSerializers = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.c;
  var GeneratedSerializer = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.d;
  var throwMissingFieldException = kotlin_org_jetbrains_kotlinx_kotlinx_serialization_core.$_$.f;
  var getStringHashCode = kotlin_kotlin.$_$.n2;
  var classMeta = kotlin_kotlin.$_$.j2;
  var CoroutineImpl = kotlin_kotlin.$_$.b2;
  var VersionChangeTransaction = kotlin_com_juul_indexeddb_core.$_$.c;
  var Database = kotlin_com_juul_indexeddb_core.$_$.a;
  var WriteTransaction = kotlin_com_juul_indexeddb_core.$_$.d;
  var get_COROUTINE_SUSPENDED = kotlin_kotlin.$_$.m1;
  var Transaction = kotlin_com_juul_indexeddb_core.$_$.b;
  var toString = kotlin_kotlin.$_$.u2;
  var CoroutineScope = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.f;
  var isInterface = kotlin_kotlin.$_$.r2;
  var openDatabase = kotlin_com_juul_indexeddb_core.$_$.e;
  var GlobalScope_getInstance = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.d;
  var promise$default = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.b;
  var SuspendFunction4 = kotlin_kotlin.$_$.d2;
  var SuspendFunction1 = kotlin_kotlin.$_$.c2;
  //endregion
  //region block: pre-declaration
  WebDatabase$test$slambda$slambda.prototype = Object.create(CoroutineImpl.prototype);
  WebDatabase$test$slambda$slambda.prototype.constructor = WebDatabase$test$slambda$slambda;
  WebDatabase$test$slambda$slambda_1.prototype = Object.create(CoroutineImpl.prototype);
  WebDatabase$test$slambda$slambda_1.prototype.constructor = WebDatabase$test$slambda$slambda_1;
  WebDatabase$test$slambda$slambda_3.prototype = Object.create(CoroutineImpl.prototype);
  WebDatabase$test$slambda$slambda_3.prototype.constructor = WebDatabase$test$slambda$slambda_3;
  WebDatabase$test$slambda.prototype = Object.create(CoroutineImpl.prototype);
  WebDatabase$test$slambda.prototype.constructor = WebDatabase$test$slambda;
  //endregion
  function Companion() {
    Companion_instance = this;
  }
  Companion.prototype.serializer = function () {
    return $serializer_getInstance();
  };
  Companion.$metadata$ = objectMeta('Companion');
  var Companion_instance;
  function Companion_getInstance() {
    if (Companion_instance == null)
      new Companion();
    return Companion_instance;
  }
  function $serializer() {
    $serializer_instance = this;
    var tmp0_serialDesc = new PluginGeneratedSerialDescriptor('com.myntra.appscore.database.Test', this, 1);
    tmp0_serialDesc.oa('name', false);
    this.mo_1 = tmp0_serialDesc;
  }
  $serializer.prototype.p9 = function () {
    return this.mo_1;
  };
  $serializer.prototype.la = function () {
    var tmp$ret$2;
    // Inline function 'kotlin.arrayOf' call
    var tmp0_arrayOf = [StringSerializer_getInstance()];
    var tmp$ret$1;
    // Inline function 'kotlin.js.unsafeCast' call
    var tmp$ret$0;
    // Inline function 'kotlin.js.asDynamic' call
    tmp$ret$0 = tmp0_arrayOf;
    tmp$ret$1 = tmp$ret$0;
    tmp$ret$2 = tmp$ret$1;
    return tmp$ret$2;
  };
  $serializer.prototype.no = function (decoder) {
    var tmp0_desc = this.mo_1;
    var tmp1_flag = true;
    var tmp2_index = 0;
    var tmp3_bitMask0 = 0;
    var tmp4_local0 = null;
    var tmp5_input = decoder.oo(tmp0_desc);
    if (tmp5_input.ro()) {
      tmp4_local0 = tmp5_input.qo(tmp0_desc, 0);
      tmp3_bitMask0 = tmp3_bitMask0 | 1;
    } else
      while (tmp1_flag) {
        tmp2_index = tmp5_input.po(tmp0_desc);
        switch (tmp2_index) {
          case -1:
            tmp1_flag = false;
            break;
          case 0:
            tmp4_local0 = tmp5_input.qo(tmp0_desc, 0);
            tmp3_bitMask0 = tmp3_bitMask0 | 1;
            break;
          default:
            throw UnknownFieldException_init_$Create$(tmp2_index);
        }
      }
    tmp5_input.so(tmp0_desc);
    return Test_init_$Create$(tmp3_bitMask0, tmp4_local0, null);
  };
  $serializer.prototype.to = function (encoder, value) {
    var tmp0_desc = this.mo_1;
    var tmp1_output = encoder.oo(tmp0_desc);
    tmp1_output.vo(tmp0_desc, 0, value.uo_1);
    tmp1_output.so(tmp0_desc);
  };
  $serializer.prototype.wo = function (encoder, value) {
    return this.to(encoder, value instanceof Test ? value : THROW_CCE());
  };
  $serializer.$metadata$ = objectMeta('$serializer', [GeneratedSerializer]);
  var $serializer_instance;
  function $serializer_getInstance() {
    if ($serializer_instance == null)
      new $serializer();
    return $serializer_instance;
  }
  function Test_init_$Init$(seen1, name, serializationConstructorMarker, $this) {
    if (!(1 === (1 & seen1))) {
      throwMissingFieldException(seen1, 1, $serializer_getInstance().mo_1);
    }
    $this.uo_1 = name;
    return $this;
  }
  function Test_init_$Create$(seen1, name, serializationConstructorMarker) {
    return Test_init_$Init$(seen1, name, serializationConstructorMarker, Object.create(Test.prototype));
  }
  function Test(name) {
    Companion_getInstance();
    this.uo_1 = name;
  }
  Test.prototype.xo = function () {
    return this.uo_1;
  };
  Test.prototype.component1 = function () {
    return this.uo_1;
  };
  Test.prototype.copy = function (name) {
    return this.yo(name === void 1 ? this.uo_1 : name);
  };
  Test.prototype.yo = function (name) {
    return new Test(name);
  };
  Test.prototype.zo = function (name, $mask0, $handler) {
    if (!(($mask0 & 1) === 0))
      name = this.uo_1;
    return this.yo(name);
  };
  Test.prototype.toString = function () {
    return 'Test(name=' + this.uo_1 + ')';
  };
  Test.prototype.hashCode = function () {
    return getStringHashCode(this.uo_1);
  };
  Test.prototype.equals = function (other) {
    if (this === other)
      return true;
    if (!(other instanceof Test))
      return false;
    var tmp0_other_with_cast = other instanceof Test ? other : THROW_CCE();
    if (!(this.uo_1 === tmp0_other_with_cast.uo_1))
      return false;
    return true;
  };
  Test.$metadata$ = classMeta('Test', undefined, undefined, {0: $serializer_getInstance});
  Object.defineProperty(Test.prototype, 'name', {
    configurable: true,
    get: Test.prototype.xo
  });
  function WebDatabase$test$slambda$slambda(resultContinuation) {
    CoroutineImpl.call(this, resultContinuation);
  }
  WebDatabase$test$slambda$slambda.prototype.mp = function ($this$openDatabase, database, _anonymous_parameter_1__qggqgd, _anonymous_parameter_2__qggqfi, $cont) {
    var tmp = this.np($this$openDatabase, database, _anonymous_parameter_1__qggqgd, _anonymous_parameter_2__qggqfi, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  WebDatabase$test$slambda$slambda.prototype.o9 = function (p1, p2, p3, p4, $cont) {
    var tmp = p1 instanceof VersionChangeTransaction ? p1 : THROW_CCE();
    var tmp_0 = p2 instanceof Database ? p2 : THROW_CCE();
    var tmp_1 = (!(p3 == null) ? typeof p3 === 'number' : false) ? p3 : THROW_CCE();
    return this.mp(tmp, tmp_0, tmp_1, (!(p4 == null) ? typeof p4 === 'number' : false) ? p4 : THROW_CCE(), $cont);
  };
  WebDatabase$test$slambda$slambda.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        if (tmp === 0) {
          this.j8_1 = 1;
          var pageTable = this.ip_1.go(this.jp_1, 'Page');
          return Unit_getInstance();
        } else if (tmp === 1) {
          throw this.l8_1;
        }
      } catch ($p) {
        throw $p;
      }
     while (true);
  };
  WebDatabase$test$slambda$slambda.prototype.np = function ($this$openDatabase, database, _anonymous_parameter_1__qggqgd, _anonymous_parameter_2__qggqfi, completion) {
    var i = new WebDatabase$test$slambda$slambda(completion);
    i.ip_1 = $this$openDatabase;
    i.jp_1 = database;
    i.kp_1 = _anonymous_parameter_1__qggqgd;
    i.lp_1 = _anonymous_parameter_2__qggqfi;
    return i;
  };
  WebDatabase$test$slambda$slambda.$metadata$ = classMeta('WebDatabase$test$slambda$slambda', undefined, undefined, undefined, [4], CoroutineImpl.prototype);
  function WebDatabase$test$slambda$slambda_0(resultContinuation) {
    var i = new WebDatabase$test$slambda$slambda(resultContinuation);
    var l = function ($this$openDatabase, database, _anonymous_parameter_1__qggqgd, _anonymous_parameter_2__qggqfi, $cont) {
      return i.mp($this$openDatabase, database, _anonymous_parameter_1__qggqgd, _anonymous_parameter_2__qggqfi, $cont);
    };
    l.$arity = 4;
    return l;
  }
  function WebDatabase$test$slambda$slambda_1(resultContinuation) {
    CoroutineImpl.call(this, resultContinuation);
  }
  WebDatabase$test$slambda$slambda_1.prototype.yp = function ($this$writeTransaction, $cont) {
    var tmp = this.zp($this$writeTransaction, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  WebDatabase$test$slambda$slambda_1.prototype.s8 = function (p1, $cont) {
    return this.yp(p1 instanceof WriteTransaction ? p1 : THROW_CCE(), $cont);
  };
  WebDatabase$test$slambda$slambda_1.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        switch (tmp) {
          case 0:
            this.j8_1 = 2;
            this.xp_1 = this.wp_1.jo('Page');
            this.i8_1 = 1;
            suspendResult = this.wp_1.io(this.xp_1, 'sanu', this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            return suspendResult;
          case 2:
            throw this.l8_1;
        }
      } catch ($p) {
        if (this.j8_1 === 2) {
          throw $p;
        } else {
          this.i8_1 = this.j8_1;
          this.l8_1 = $p;
        }
      }
     while (true);
  };
  WebDatabase$test$slambda$slambda_1.prototype.zp = function ($this$writeTransaction, completion) {
    var i = new WebDatabase$test$slambda$slambda_1(completion);
    i.wp_1 = $this$writeTransaction;
    return i;
  };
  WebDatabase$test$slambda$slambda_1.$metadata$ = classMeta('WebDatabase$test$slambda$slambda', undefined, undefined, undefined, [1], CoroutineImpl.prototype);
  function WebDatabase$test$slambda$slambda_2(resultContinuation) {
    var i = new WebDatabase$test$slambda$slambda_1(resultContinuation);
    var l = function ($this$writeTransaction, $cont) {
      return i.yp($this$writeTransaction, $cont);
    };
    l.$arity = 1;
    return l;
  }
  function WebDatabase$test$slambda$slambda_3(resultContinuation) {
    CoroutineImpl.call(this, resultContinuation);
  }
  WebDatabase$test$slambda$slambda_3.prototype.kq = function ($this$transaction, $cont) {
    var tmp = this.lq($this$transaction, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  WebDatabase$test$slambda$slambda_3.prototype.s8 = function (p1, $cont) {
    return this.kq(p1 instanceof Transaction ? p1 : THROW_CCE(), $cont);
  };
  WebDatabase$test$slambda$slambda_3.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        switch (tmp) {
          case 0:
            this.j8_1 = 2;
            this.jq_1 = this.iq_1.jo('Page');
            this.i8_1 = 1;
            suspendResult = this.iq_1.lo(this.jq_1, null, this, 1, null);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            var ARGUMENT = suspendResult;
            var ARGUMENT_0 = ARGUMENT[0];
            return toString(ARGUMENT_0);
          case 2:
            throw this.l8_1;
        }
      } catch ($p) {
        if (this.j8_1 === 2) {
          throw $p;
        } else {
          this.i8_1 = this.j8_1;
          this.l8_1 = $p;
        }
      }
     while (true);
  };
  WebDatabase$test$slambda$slambda_3.prototype.lq = function ($this$transaction, completion) {
    var i = new WebDatabase$test$slambda$slambda_3(completion);
    i.iq_1 = $this$transaction;
    return i;
  };
  WebDatabase$test$slambda$slambda_3.$metadata$ = classMeta('WebDatabase$test$slambda$slambda', undefined, undefined, undefined, [1], CoroutineImpl.prototype);
  function WebDatabase$test$slambda$slambda_4(resultContinuation) {
    var i = new WebDatabase$test$slambda$slambda_3(resultContinuation);
    var l = function ($this$transaction, $cont) {
      return i.kq($this$transaction, $cont);
    };
    l.$arity = 1;
    return l;
  }
  function WebDatabase$test$slambda(this$0, resultContinuation) {
    this.uq_1 = this$0;
    CoroutineImpl.call(this, resultContinuation);
  }
  WebDatabase$test$slambda.prototype.xq = function ($this$promise, $cont) {
    var tmp = this.im($this$promise, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  WebDatabase$test$slambda.prototype.s8 = function (p1, $cont) {
    return this.xq((!(p1 == null) ? isInterface(p1, CoroutineScope) : false) ? p1 : THROW_CCE(), $cont);
  };
  WebDatabase$test$slambda.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        switch (tmp) {
          case 0:
            this.j8_1 = 4;
            this.i8_1 = 1;
            suspendResult = openDatabase(this.uq_1.yq_1, 1, WebDatabase$test$slambda$slambda_0(null), this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            this.wq_1 = suspendResult;
            this.i8_1 = 2;
            suspendResult = this.wq_1.bn(['Page'], WebDatabase$test$slambda$slambda_2(null), this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 2:
            this.i8_1 = 3;
            suspendResult = this.wq_1.an(['Page'], WebDatabase$test$slambda$slambda_4(null), this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 3:
            return suspendResult;
          case 4:
            throw this.l8_1;
        }
      } catch ($p) {
        if (this.j8_1 === 4) {
          throw $p;
        } else {
          this.i8_1 = this.j8_1;
          this.l8_1 = $p;
        }
      }
     while (true);
  };
  WebDatabase$test$slambda.prototype.im = function ($this$promise, completion) {
    var i = new WebDatabase$test$slambda(this.uq_1, completion);
    i.vq_1 = $this$promise;
    return i;
  };
  WebDatabase$test$slambda.$metadata$ = classMeta('WebDatabase$test$slambda', undefined, undefined, undefined, [1], CoroutineImpl.prototype);
  function WebDatabase$test$slambda_0(this$0, resultContinuation) {
    var i = new WebDatabase$test$slambda(this$0, resultContinuation);
    var l = function ($this$promise, $cont) {
      return i.xq($this$promise, $cont);
    };
    l.$arity = 1;
    return l;
  }
  function WebDatabase(name) {
    this.yq_1 = name;
  }
  WebDatabase.prototype.xo = function () {
    return this.yq_1;
  };
  WebDatabase.prototype.test = function () {
    var tmp = GlobalScope_getInstance();
    return promise$default(tmp, null, null, WebDatabase$test$slambda_0(this, null), 3, null);
  };
  WebDatabase.$metadata$ = classMeta('WebDatabase');
  Object.defineProperty(WebDatabase.prototype, 'name', {
    configurable: true,
    get: WebDatabase.prototype.xo
  });
  //region block: post-declaration
  $serializer.prototype.ma = typeParametersSerializers;
  //endregion
  //region block: exports
  function $jsExportAll$(_) {
    var $com = _.com || (_.com = {});
    var $com$myntra = $com.myntra || ($com.myntra = {});
    var $com$myntra$appscore = $com$myntra.appscore || ($com$myntra.appscore = {});
    var $com$myntra$appscore$database = $com$myntra$appscore.database || ($com$myntra$appscore.database = {});
    $com$myntra$appscore$database.Test = Test;
    $com$myntra$appscore$database.Test.Test_init_$Create$ = Test_init_$Create$;
    Object.defineProperty($com$myntra$appscore$database.Test, 'Companion', {
      configurable: true,
      get: Companion_getInstance
    });
    Object.defineProperty($com$myntra$appscore$database.Test, '$serializer', {
      configurable: true,
      get: $serializer_getInstance
    });
    var $com = _.com || (_.com = {});
    var $com$myntra = $com.myntra || ($com.myntra = {});
    var $com$myntra$appscore = $com$myntra.appscore || ($com$myntra.appscore = {});
    var $com$myntra$appscore$database = $com$myntra$appscore.database || ($com$myntra$appscore.database = {});
    $com$myntra$appscore$database.WebDatabase = WebDatabase;
  }
  $jsExportAll$(_);
  //endregion
  return _;
}));

//# sourceMappingURL=database.js.map
