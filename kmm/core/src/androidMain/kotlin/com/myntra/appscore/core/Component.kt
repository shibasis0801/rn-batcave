package com.myntra.appscore.core

import androidx.lifecycle.DefaultLifecycleObserver

/*
Components are standalone lifecycle based plugins (Should have no reference to activity)
Adapters are connections between Components and Activity framework (Should have a reference to activity)
(since we don't have a global window like web)
(This is a SingleActivity Application)
 */
open class Component: DefaultLifecycleObserver {}
