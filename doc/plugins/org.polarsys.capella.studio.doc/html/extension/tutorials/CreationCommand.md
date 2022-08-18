#Creation Command

## Creation of elements contribution

It is possible to extends default creation of objects (to create another elements while creating one, to rename a newly created element or other.)

- Creation tools: covered by this extension point -- Diagram Palette -- Add Element in project explorer -- Programatic calls such as modeling accelerators (i think of 'generation of component exchanges')

- Other programmatic calls: (calling only the generic "constructor" of a model element) are not covered by this extension point -- Copy paste of an element -- Transitions, Patterns, REC/RPL -- other transformation mechanism


The extension point is provided by:

* the plug-in org.polarsys.capella.common.menu.dynamic
* and its identifier MDEMenuItemContribution.

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

* `class`: a java class inheriting of [org.polarsys.capella.common.menu.dynamic.contributions.IMDEMenuItemContribution](https://github.com/eclipse/capella/blob/master/common/plugins/org.polarsys.capella.common.menu.dynamic/src/org/polarsys/capella/common/menu/dynamic/contributions/IMDEMenuItemContribution.java)
* `id`: an unique identifier for the contribution


## Sample

When creating a State Machine, we create an inner Region

* The [Java class](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.menu.contributions/src/org/polarsys/capella/core/data/menu/contributions/capellacommon/StateMachineItemContribution.java) defining the contribution

* Its registration within [plugin.xml](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.menu.contributions/plugin.xml#L361)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse/capella/blob/c55af03da4a1e2ba1aa1cc78632a365fc4fc3e51/core/plugins/org.polarsys.capella.core.data.menu.contributions/META-INF/MANIFEST.MF#L8) file we need to depend on `org.polarsys.capella.core.menu.dynamic` which export `org.polarsys.capella.common.menu.dynamic`
