# Properties

Capella provides a Properties View to help system architects to edit their model elements. This Property View is composed of different tabs for various concerns. New tabs can be contributed to provide new specific edition facilities.. 

The extension point is provided by:

* the plug-in org.eclipse.ui.views.properties.tabbed
* and its identifier propertySections.

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

```
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.4"?>
<plugin>
   <extension point="org.eclipse.ui.views.properties.tabbed.propertySections">
      <propertySections contributorId=" ">
         <propertySection
               class=" "
               filter=" "
               id=" "
               tab=" ">
            <input
                  type=" ">
            </input>
         </propertySection>
      </propertySections>
   </extension>
</plugin>
```

## Detail of the different fields

* `contributorId`: a string defining on which active editor the tab shall appear

* `id`: an unique identifier for the command

* `class`: an unique identifier for the command

* `filter`: a class filter inheriting from org.eclipse.jface.viewers.IFilter
* or use `input/type`: a classname

* `tab`: an unique identifier for the tab on which the section shall appear

### `tab` per `contributorId` 

| tab \ contributorId	|	`org.polarsys.capella.core.data.capellamodeller.properties`	| 	`org.eclipse.sirius.diagram.ui` | 		`org.eclipse.sirius.table.ui.EditorID`| 
| ----	| 	----	| ----| ----| 
| 	 	Capella	| `BaseCapella`| `BaseSiriusDiagram`|`BaseSiriusTable` | 
| 		Management	| `ManagementCapella`| `ManagementSiriusDiagram`| `ManagementSiriusTable`| 
| 		Description	| `DescriptionCapella`| `DescriptionSiriusDiagram`| `DescriptionSiriusTable`| 
| 		Extensions	| `ExtensionsCapella`| `ExtensionsSiriusDiagram`|`ExtensionsSiriusTable` | 

## Properties implementation

The [org.polarsys.capella.core.ui.properties.AbstractSection](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.ui.properties/src/org/polarsys/capella/core/ui/properties/sections/AbstractSection.java) class provides some facilities to manage section.

## Sample

* The [Java class](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.validation.commandline/src/org/polarsys/capella/core/validation/commandline/ValidationCommandLine.java) defining the section

* Its registration within plugin.xml [for Capella views](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.ctx.properties/plugin.xml#L17-L23), [for Diagrams](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.ctx.properties/plugin.xml#L110-L117), [for Tables](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.ctx.properties/plugin.xml#L204-L211)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.common.properties/META-INF/MANIFEST.MF#L8) file we need to depend on `org.polarsys.capella.core.ui.properties`

