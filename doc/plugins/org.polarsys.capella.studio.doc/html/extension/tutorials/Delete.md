#Delete

The extension point is provided by:

* the plug-in org.polarsys.capella.core.model.handler
* and its identifier deleteCommandProvider.

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.4"?>
<extension point="org.polarsys.capella.common.menu.dynamic.MDEMenuItemContribution">
  <MDEMenuItemContribution
            class=""
            id="">
  </MDEMenuItemContribution>
</extension>
```

### Detail of the different fields

* `class`: a java class inheriting of [org.polarsys.capella.core.model.handler.command.IDeleteHelper](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.model.handler/src/org/polarsys/capella/core/model/handler/command/IDeleteHelper.java)
* `id`: an unique identifier for the contribution

## Sample

When we delete an element, we need to delete its reference into any REC/RPL. 

* The [Java class](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.re/src/org/polarsys/capella/core/re/delete/ReDeleteHelper.java) defining the contribution

* Its registration within [plugin.xml](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.re/plugin.xml#L423)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.re/META-INF/MANIFEST.MF#L18) file we need to depend on `org.polarsys.capella.core.model.handler` 