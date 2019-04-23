package com.wuba.flutter.wubarn_plugin;

import io.flutter.plugin.common.PluginRegistry.Registrar;

/** WubarnPlugin */
public class WubarnPlugin {

  public static final String VIEW_TYPE = "plugins.wuba.com/wubarnview";

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    registrar.platformViewRegistry().registerViewFactory(VIEW_TYPE, new WubarnViewFactory(registrar.messenger()));
  }
}
