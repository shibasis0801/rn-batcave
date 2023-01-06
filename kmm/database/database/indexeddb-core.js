(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', './kotlin-kotlin-stdlib-js-ir.js', './kotlinx.coroutines-kotlinx-coroutines-core-js-ir.js', './indexeddb-external.js'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('./kotlin-kotlin-stdlib-js-ir.js'), require('./kotlinx.coroutines-kotlinx-coroutines-core-js-ir.js'), require('./indexeddb-external.js'));
  else {
    if (typeof this['kotlin-kotlin-stdlib-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'indexeddb-core'. Its dependency 'kotlin-kotlin-stdlib-js-ir' was not found. Please, check whether 'kotlin-kotlin-stdlib-js-ir' is loaded prior to 'indexeddb-core'.");
    }
    if (typeof this['kotlinx.coroutines-kotlinx-coroutines-core-js-ir'] === 'undefined') {
      throw new Error("Error loading module 'indexeddb-core'. Its dependency 'kotlinx.coroutines-kotlinx-coroutines-core-js-ir' was not found. Please, check whether 'kotlinx.coroutines-kotlinx-coroutines-core-js-ir' is loaded prior to 'indexeddb-core'.");
    }
    if (typeof this['indexeddb-external'] === 'undefined') {
      throw new Error("Error loading module 'indexeddb-core'. Its dependency 'indexeddb-external' was not found. Please, check whether 'indexeddb-external' is loaded prior to 'indexeddb-core'.");
    }
    root['indexeddb-core'] = factory(typeof this['indexeddb-core'] === 'undefined' ? {} : this['indexeddb-core'], this['kotlin-kotlin-stdlib-js-ir'], this['kotlinx.coroutines-kotlinx-coroutines-core-js-ir'], this['indexeddb-external']);
  }
}(this, function (_, kotlin_kotlin, kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core, kotlin_com_juul_indexeddb_external) {
  'use strict';
  //region block: imports
  var CoroutineImpl = kotlin_kotlin.$_$.b2;
  var Unit_getInstance = kotlin_kotlin.$_$.b1;
  var THROW_CCE = kotlin_kotlin.$_$.e3;
  var CoroutineScope = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.f;
  var isInterface = kotlin_kotlin.$_$.r2;
  var isArray = kotlin_kotlin.$_$.q2;
  var get_COROUTINE_SUSPENDED = kotlin_kotlin.$_$.m1;
  var classMeta = kotlin_kotlin.$_$.j2;
  var Dispatchers_getInstance = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.c;
  var withContext = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.a;
  var get_indexedDB = kotlin_com_juul_indexeddb_external.$_$.a;
  var toString = kotlin_kotlin.$_$.u2;
  var IllegalStateException_init_$Create$ = kotlin_kotlin.$_$.p;
  var SuspendFunction1 = kotlin_kotlin.$_$.c2;
  var captureStack = kotlin_kotlin.$_$.i2;
  var Exception = kotlin_kotlin.$_$.a3;
  var Exception_init_$Init$ = kotlin_kotlin.$_$.l;
  var intercepted = kotlin_kotlin.$_$.o1;
  var get_MODE_CANCELLABLE = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.g;
  var CancellableContinuationImpl = kotlin_org_jetbrains_kotlinx_kotlinx_coroutines_core.$_$.e;
  var throwUninitializedPropertyAccessException = kotlin_kotlin.$_$.k3;
  var Companion_getInstance = kotlin_kotlin.$_$.a1;
  var _Result___init__impl__xyqfz8 = kotlin_kotlin.$_$.v;
  var createFailure = kotlin_kotlin.$_$.g3;
  //endregion
  //region block: pre-declaration
  Database$transaction$slambda.prototype = Object.create(CoroutineImpl.prototype);
  Database$transaction$slambda.prototype.constructor = Database$transaction$slambda;
  Database$writeTransaction$slambda.prototype = Object.create(CoroutineImpl.prototype);
  Database$writeTransaction$slambda.prototype.constructor = Database$writeTransaction$slambda;
  openDatabase$slambda.prototype = Object.create(CoroutineImpl.prototype);
  openDatabase$slambda.prototype.constructor = openDatabase$slambda;
  EventException.prototype = Object.create(Exception.prototype);
  EventException.prototype.constructor = EventException;
  ErrorEventException.prototype = Object.create(EventException.prototype);
  ErrorEventException.prototype.constructor = ErrorEventException;
  OpenBlockedException.prototype = Object.create(EventException.prototype);
  OpenBlockedException.prototype.constructor = OpenBlockedException;
  AbortTransactionException.prototype = Object.create(EventException.prototype);
  AbortTransactionException.prototype.constructor = AbortTransactionException;
  EventHandlerException.prototype = Object.create(EventException.prototype);
  EventHandlerException.prototype.constructor = EventHandlerException;
  ObjectStore.prototype = Object.create(Queryable.prototype);
  ObjectStore.prototype.constructor = ObjectStore;
  WriteTransaction.prototype = Object.create(Transaction.prototype);
  WriteTransaction.prototype.constructor = WriteTransaction;
  VersionChangeTransaction.prototype = Object.create(WriteTransaction.prototype);
  VersionChangeTransaction.prototype.constructor = VersionChangeTransaction;
  //endregion
  function Database$transaction$slambda(this$0, $store, $action, resultContinuation) {
    this.bm_1 = this$0;
    this.cm_1 = $store;
    this.dm_1 = $action;
    CoroutineImpl.call(this, resultContinuation);
  }
  Database$transaction$slambda.prototype.hm = function ($this$withContext, $cont) {
    var tmp = this.im($this$withContext, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  Database$transaction$slambda.prototype.s8 = function (p1, $cont) {
    return this.hm((!(p1 == null) ? isInterface(p1, CoroutineScope) : false) ? p1 : THROW_CCE(), $cont);
  };
  Database$transaction$slambda.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        switch (tmp) {
          case 0:
            this.j8_1 = 3;
            var tmp_0 = this;
            var tmp_1 = this.cm_1;
            tmp_0.fm_1 = new Transaction(this.bm_1.jm_1.transaction(isArray(tmp_1) ? tmp_1 : THROW_CCE(), 'readonly'));
            this.i8_1 = 1;
            suspendResult = this.dm_1(this.fm_1, this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            this.gm_1 = suspendResult;
            this.i8_1 = 2;
            suspendResult = this.fm_1.lm(this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 2:
            return this.gm_1;
          case 3:
            throw this.l8_1;
        }
      } catch ($p) {
        if (this.j8_1 === 3) {
          throw $p;
        } else {
          this.i8_1 = this.j8_1;
          this.l8_1 = $p;
        }
      }
     while (true);
  };
  Database$transaction$slambda.prototype.im = function ($this$withContext, completion) {
    var i = new Database$transaction$slambda(this.bm_1, this.cm_1, this.dm_1, completion);
    i.em_1 = $this$withContext;
    return i;
  };
  Database$transaction$slambda.$metadata$ = classMeta('Database$transaction$slambda', undefined, undefined, undefined, [1], CoroutineImpl.prototype);
  function Database$transaction$slambda_0(this$0, $store, $action, resultContinuation) {
    var i = new Database$transaction$slambda(this$0, $store, $action, resultContinuation);
    var l = function ($this$withContext, $cont) {
      return i.hm($this$withContext, $cont);
    };
    l.$arity = 1;
    return l;
  }
  function Database$writeTransaction$slambda(this$0, $store, $action, resultContinuation) {
    this.um_1 = this$0;
    this.vm_1 = $store;
    this.wm_1 = $action;
    CoroutineImpl.call(this, resultContinuation);
  }
  Database$writeTransaction$slambda.prototype.hm = function ($this$withContext, $cont) {
    var tmp = this.im($this$withContext, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  Database$writeTransaction$slambda.prototype.s8 = function (p1, $cont) {
    return this.hm((!(p1 == null) ? isInterface(p1, CoroutineScope) : false) ? p1 : THROW_CCE(), $cont);
  };
  Database$writeTransaction$slambda.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        switch (tmp) {
          case 0:
            this.j8_1 = 3;
            var tmp_0 = this;
            var tmp_1 = this.vm_1;
            tmp_0.ym_1 = new WriteTransaction(this.um_1.jm_1.transaction(isArray(tmp_1) ? tmp_1 : THROW_CCE(), 'readwrite'));
            this.i8_1 = 1;
            suspendResult = this.wm_1(this.ym_1, this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            this.zm_1 = suspendResult;
            this.i8_1 = 2;
            suspendResult = this.ym_1.lm(this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 2:
            return this.zm_1;
          case 3:
            throw this.l8_1;
        }
      } catch ($p) {
        if (this.j8_1 === 3) {
          throw $p;
        } else {
          this.i8_1 = this.j8_1;
          this.l8_1 = $p;
        }
      }
     while (true);
  };
  Database$writeTransaction$slambda.prototype.im = function ($this$withContext, completion) {
    var i = new Database$writeTransaction$slambda(this.um_1, this.vm_1, this.wm_1, completion);
    i.xm_1 = $this$withContext;
    return i;
  };
  Database$writeTransaction$slambda.$metadata$ = classMeta('Database$writeTransaction$slambda', undefined, undefined, undefined, [1], CoroutineImpl.prototype);
  function Database$writeTransaction$slambda_0(this$0, $store, $action, resultContinuation) {
    var i = new Database$writeTransaction$slambda(this$0, $store, $action, resultContinuation);
    var l = function ($this$withContext, $cont) {
      return i.hm($this$withContext, $cont);
    };
    l.$arity = 1;
    return l;
  }
  function Database(database) {
    this.jm_1 = database;
  }
  Database.prototype.an = function (store, action, $cont) {
    var tmp = Dispatchers_getInstance().mj_1;
    return withContext(tmp, Database$transaction$slambda_0(this, store, action, null), $cont);
  };
  Database.prototype.bn = function (store, action, $cont) {
    var tmp = Dispatchers_getInstance().mj_1;
    return withContext(tmp, Database$writeTransaction$slambda_0(this, store, action, null), $cont);
  };
  Database.$metadata$ = classMeta('Database');
  function openDatabase(name, version, initialize, $cont) {
    var tmp = Dispatchers_getInstance().mj_1;
    return withContext(tmp, openDatabase$slambda_0(name, version, initialize, null), $cont);
  }
  function openDatabase$slambda$lambda($name) {
    return function (event) {
      var tmp0_subject = event.type;
      var tmp;
      switch (tmp0_subject) {
        case 'upgradeneeded':
          tmp = event instanceof IDBVersionChangeEvent ? event : THROW_CCE();
          break;
        case 'error':
          throw new ErrorEventException(event);
        case 'blocked':
          throw new OpenBlockedException($name, event);
        default:
          tmp = null;
          break;
      }
      return tmp;
    };
  }
  function openDatabase$slambda($name, $version, $initialize, resultContinuation) {
    this.kn_1 = $name;
    this.ln_1 = $version;
    this.mn_1 = $initialize;
    CoroutineImpl.call(this, resultContinuation);
  }
  openDatabase$slambda.prototype.wn = function ($this$withContext, $cont) {
    var tmp = this.im($this$withContext, $cont);
    tmp.k8_1 = Unit_getInstance();
    tmp.l8_1 = null;
    return tmp.r8();
  };
  openDatabase$slambda.prototype.s8 = function (p1, $cont) {
    return this.wn((!(p1 == null) ? isInterface(p1, CoroutineScope) : false) ? p1 : THROW_CCE(), $cont);
  };
  openDatabase$slambda.prototype.r8 = function () {
    var suspendResult = this.k8_1;
    $sm: do
      try {
        var tmp = this.i8_1;
        switch (tmp) {
          case 0:
            this.j8_1 = 5;
            var tmp_0 = this;
            l$ret$1: do {
              var tmp0_checkNotNull = get_indexedDB(window);
              if (tmp0_checkNotNull == null) {
                var message = "Your browser doesn't support IndexedDB.";
                throw IllegalStateException_init_$Create$(toString(message));
              } else {
                this.on_1 = tmp0_checkNotNull;
                break l$ret$1;
              }
            }
             while (false);
            tmp_0.pn_1 = this.on_1;
            this.qn_1 = this.pn_1.open(this.kn_1, this.ln_1);
            this.i8_1 = 1;
            suspendResult = onNextEvent(this.qn_1, ['success', 'upgradeneeded', 'error', 'blocked'], openDatabase$slambda$lambda(this.kn_1), this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 1:
            this.rn_1 = suspendResult;
            var tmp_1 = this;
            tmp_1.sn_1 = new Database(this.qn_1.result);
            if (!(this.rn_1 == null)) {
              var tmp_2 = this;
              var tmp_3 = this;
              tmp_3.tn_1 = this.qn_1.transaction;
              l$ret$3: do {
                if (this.tn_1 == null) {
                  var message_0 = 'Required value was null.';
                  throw IllegalStateException_init_$Create$(toString(message_0));
                } else {
                  this.un_1 = this.tn_1;
                  break l$ret$3;
                }
              }
               while (false);
              tmp_2.vn_1 = new VersionChangeTransaction(this.un_1);
              this.i8_1 = 2;
              suspendResult = this.mn_1(this.vn_1, this.sn_1, this.rn_1.oldVersion, this.rn_1.newVersion, this);
              if (suspendResult === get_COROUTINE_SUSPENDED()) {
                return suspendResult;
              }
              continue $sm;
            } else {
              this.i8_1 = 4;
              continue $sm;
            }

            break;
          case 2:
            this.i8_1 = 3;
            suspendResult = this.vn_1.lm(this);
            if (suspendResult === get_COROUTINE_SUSPENDED()) {
              return suspendResult;
            }

            continue $sm;
          case 3:
            this.i8_1 = 4;
            continue $sm;
          case 4:
            return this.sn_1;
          case 5:
            throw this.l8_1;
        }
      } catch ($p) {
        if (this.j8_1 === 5) {
          throw $p;
        } else {
          this.i8_1 = this.j8_1;
          this.l8_1 = $p;
        }
      }
     while (true);
  };
  openDatabase$slambda.prototype.im = function ($this$withContext, completion) {
    var i = new openDatabase$slambda(this.kn_1, this.ln_1, this.mn_1, completion);
    i.nn_1 = $this$withContext;
    return i;
  };
  openDatabase$slambda.$metadata$ = classMeta('openDatabase$slambda', undefined, undefined, undefined, [1], CoroutineImpl.prototype);
  function openDatabase$slambda_0($name, $version, $initialize, resultContinuation) {
    var i = new openDatabase$slambda($name, $version, $initialize, resultContinuation);
    var l = function ($this$withContext, $cont) {
      return i.wn($this$withContext, $cont);
    };
    l.$arity = 1;
    return l;
  }
  function ErrorEventException(event) {
    EventException.call(this, 'An error event was received.', null, event);
    captureStack(this, ErrorEventException);
  }
  ErrorEventException.$metadata$ = classMeta('ErrorEventException', undefined, undefined, undefined, undefined, EventException.prototype);
  function OpenBlockedException(name, event) {
    EventException.call(this, 'Resource in use: ' + name + '.', null, event);
    this.yn_1 = name;
    captureStack(this, OpenBlockedException);
  }
  OpenBlockedException.$metadata$ = classMeta('OpenBlockedException', undefined, undefined, undefined, undefined, EventException.prototype);
  function AbortTransactionException(event) {
    EventException.call(this, 'Transaction aborted while waiting for completion.', null, event);
    captureStack(this, AbortTransactionException);
  }
  AbortTransactionException.$metadata$ = classMeta('AbortTransactionException', undefined, undefined, undefined, undefined, EventException.prototype);
  function EventHandlerException(cause, event) {
    EventException.call(this, 'An inner exception was thrown: ' + cause, cause, event);
    captureStack(this, EventHandlerException);
  }
  EventHandlerException.$metadata$ = classMeta('EventHandlerException', undefined, undefined, undefined, undefined, EventException.prototype);
  function EventException(message, cause, event) {
    Exception_init_$Init$(message, cause, this);
    this.zn_1 = event;
    captureStack(this, EventException);
  }
  EventException.$metadata$ = classMeta('EventException', undefined, undefined, undefined, undefined, Exception.prototype);
  function ObjectStore(objectStore) {
    Queryable.call(this);
    this.ao_1 = objectStore;
  }
  ObjectStore.prototype.bo = function (query) {
    var tmp0_safe_receiver = query;
    return new Request(this.ao_1.getAll(tmp0_safe_receiver == null ? null : tmp0_safe_receiver.do()));
  };
  ObjectStore.$metadata$ = classMeta('ObjectStore', undefined, undefined, undefined, undefined, Queryable.prototype);
  function onNextEvent(_this__u8e3s4, types, action, $cont) {
    var tmp$ret$0;
    // Inline function 'kotlinx.coroutines.suspendCancellableCoroutine.<anonymous>' call
    var tmp0__anonymous__q1qw7t = $cont;
    var cancellable = new CancellableContinuationImpl(intercepted(tmp0__anonymous__q1qw7t), get_MODE_CANCELLABLE());
    cancellable.qe();
    // Inline function 'com.juul.indexeddb.onNextEvent.<anonymous>' call
    var callback = {_v: null};
    callback._v = onNextEvent$lambda(types, _this__u8e3s4, callback, action, cancellable);
    // Inline function 'kotlin.collections.forEach' call
    var indexedObject = types;
    var inductionVariable = 0;
    var last = indexedObject.length;
    while (inductionVariable < last) {
      var element = indexedObject[inductionVariable];
      inductionVariable = inductionVariable + 1 | 0;
      // Inline function 'com.juul.indexeddb.onNextEvent.<anonymous>.<anonymous>' call
      var tmp;
      if (callback._v == null) {
        throwUninitializedPropertyAccessException('callback');
      } else {
        tmp = callback._v;
      }
      _this__u8e3s4.addEventListener(element, tmp);
    }
    cancellable.rd(onNextEvent$lambda_0(types, _this__u8e3s4, callback));
    tmp$ret$0 = cancellable.ad();
    return tmp$ret$0;
  }
  function onNextEvent$lambda($types, $this_onNextEvent, $callback, $action, $cancellable) {
    return function (event) {
      var indexedObject = $types;
      var inductionVariable = 0;
      var last = indexedObject.length;
      while (inductionVariable < last) {
        var element = indexedObject[inductionVariable];
        inductionVariable = inductionVariable + 1 | 0;
        // Inline function 'com.juul.indexeddb.onNextEvent.<anonymous>.<anonymous>.<anonymous>' call
        var tmp;
        if ($callback._v == null) {
          throwUninitializedPropertyAccessException('callback');
        } else {
          tmp = $callback._v;
        }
        $this_onNextEvent.removeEventListener(element, tmp);
      }
      var tmp_0;
      try {
        var tmp$ret$1;
        // Inline function 'kotlin.coroutines.resume' call
        var tmp0_resume = $action(event);
        var tmp$ret$0;
        // Inline function 'kotlin.Companion.success' call
        var tmp0_success = Companion_getInstance();
        tmp$ret$0 = _Result___init__impl__xyqfz8(tmp0_resume);
        $cancellable.q1(tmp$ret$0);
        tmp$ret$1 = Unit_getInstance();
        tmp_0 = tmp$ret$1;
      } catch ($p) {
        var tmp_1;
        if ($p instanceof Error) {
          var tmp$ret$3;
          // Inline function 'kotlin.coroutines.resumeWithException' call
          var tmp1_resumeWithException = new EventHandlerException($p, event);
          var tmp$ret$2;
          // Inline function 'kotlin.Companion.failure' call
          var tmp0_failure = Companion_getInstance();
          tmp$ret$2 = _Result___init__impl__xyqfz8(createFailure(tmp1_resumeWithException));
          $cancellable.q1(tmp$ret$2);
          tmp$ret$3 = Unit_getInstance();
          tmp_1 = tmp$ret$3;
        } else {
          throw $p;
        }
        tmp_0 = tmp_1;
      }
      return Unit_getInstance();
    };
  }
  function onNextEvent$lambda_0($types, $this_onNextEvent, $callback) {
    return function (it) {
      var indexedObject = $types;
      var inductionVariable = 0;
      var last = indexedObject.length;
      while (inductionVariable < last) {
        var element = indexedObject[inductionVariable];
        inductionVariable = inductionVariable + 1 | 0;
        // Inline function 'com.juul.indexeddb.onNextEvent.<anonymous>.<anonymous>.<anonymous>' call
        var tmp;
        if ($callback._v == null) {
          throwUninitializedPropertyAccessException('callback');
        } else {
          tmp = $callback._v;
        }
        $this_onNextEvent.removeEventListener(element, tmp);
      }
      return Unit_getInstance();
    };
  }
  function Queryable() {
  }
  Queryable.$metadata$ = classMeta('Queryable');
  function Request(request) {
    this.eo_1 = request;
  }
  Request.$metadata$ = classMeta('Request');
  function VersionChangeTransaction(transaction) {
    WriteTransaction.call(this, transaction);
  }
  VersionChangeTransaction.prototype.go = function (_this__u8e3s4, name) {
    return new ObjectStore(_this__u8e3s4.jm_1.createObjectStore(name));
  };
  VersionChangeTransaction.$metadata$ = classMeta('VersionChangeTransaction', undefined, undefined, undefined, undefined, WriteTransaction.prototype);
  function WriteTransaction$add$lambda($request) {
    return function (event) {
      var tmp0_subject = event.type;
      var tmp;
      if (tmp0_subject === 'error') {
        throw new ErrorEventException(event);
      } else {
        tmp = $request.result;
      }
      return tmp;
    };
  }
  function WriteTransaction(transaction) {
    Transaction.call(this, transaction);
  }
  WriteTransaction.prototype.io = function (_this__u8e3s4, item, $cont) {
    var request = _this__u8e3s4.ao_1.add(item);
    return onNextEvent(request, ['success', 'error'], WriteTransaction$add$lambda(request), $cont);
  };
  WriteTransaction.$metadata$ = classMeta('WriteTransaction', undefined, undefined, undefined, undefined, Transaction.prototype);
  function Transaction$awaitCompletion$lambda(event) {
    var tmp0_subject = event.type;
    switch (tmp0_subject) {
      case 'abort':
        throw new AbortTransactionException(event);
      case 'error':
        throw new ErrorEventException(event);
      default:
        ;
        break;
    }
    return Unit_getInstance();
  }
  function Transaction$getAll$lambda($request) {
    return function (event) {
      var tmp0_subject = event.type;
      var tmp;
      if (tmp0_subject === 'error') {
        throw new ErrorEventException(event);
      } else {
        tmp = $request.result;
      }
      return tmp;
    };
  }
  function Transaction(transaction) {
    this.km_1 = transaction;
  }
  Transaction.prototype.lm = function ($cont) {
    return onNextEvent(this.km_1, ['complete', 'abort', 'error'], Transaction$awaitCompletion$lambda, $cont);
  };
  Transaction.prototype.jo = function (name) {
    return new ObjectStore(this.km_1.objectStore(name));
  };
  Transaction.prototype.ko = function (_this__u8e3s4, query, $cont) {
    var request = _this__u8e3s4.bo(query).eo_1;
    return onNextEvent(request, ['success', 'error'], Transaction$getAll$lambda(request), $cont);
  };
  Transaction.prototype.lo = function (_this__u8e3s4, query, $cont, $mask0, $handler) {
    if (!(($mask0 & 1) === 0))
      query = null;
    return this.ko(_this__u8e3s4, query, $cont);
  };
  Transaction.$metadata$ = classMeta('Transaction');
  //region block: exports
  _.$_$ = _.$_$ || {};
  _.$_$.a = Database;
  _.$_$.b = Transaction;
  _.$_$.c = VersionChangeTransaction;
  _.$_$.d = WriteTransaction;
  _.$_$.e = openDatabase;
  //endregion
  return _;
}));

//# sourceMappingURL=indexeddb-core.js.map
