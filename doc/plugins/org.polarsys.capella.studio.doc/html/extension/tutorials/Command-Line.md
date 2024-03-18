# Command Line

Capella provides a command line functionality. This functionality helps users to launch some Capella commands from a shell or a build engine like Jenkins.

The set of command proposals can be extended with additional specific commands that can be contributed through an extension point. 

The extension point is provided by:

* the plug-in org.polarsys.capella.core.commandline.core
* and its identifier commandline.

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

```
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.4"?>
<plugin>
   <extension point="org.polarsys.capella.core.commandline.core.commandline">
      <CommandlineExtension
         class=""
         id="">
      </CommandlineExtension>
   </extension>
</plugin>
```

## Detail of the different fields

* `class`: a java class inheriting of [org.polarsys.capelle.core.commandline.core.ICommandLine](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.commandline.core/src/org/polarsys/capella/core/commandline/core/ICommandLine.java)
* `id`: an unique identifier for the command

## CommandLine implementation

The [org.polarsys.capelle.core.commandline.core.ICommandLine](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.commandline.core/src/org/polarsys/capella/core/commandline/core/ICommandLine.java) class provides some facilities to manage messages.

You can also inherits of  [org.polarsys.capelle.core.commandline.core.AbstractCommandLine](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.commandline.core/src/org/polarsys/capella/core/commandline/core/AbstractCommandLine.java) providing some helpers.

## Sample

The validation can be triggered by command line

* The [Java class](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.validation.commandline/src/org/polarsys/capella/core/validation/commandline/ValidationCommandLine.java) defining the quickfix

* Its registration within [plugin.xml](https://github.com/eclipse-capella/capella/blob/c55af03da4a1e2ba1aa1cc78632a365fc4fc3e51/core/plugins/org.polarsys.capella.core.validation.commandline/plugin.xml#L14)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse-capella/capella/blob/c55af03da4a1e2ba1aa1cc78632a365fc4fc3e51/core/plugins/org.polarsys.capella.core.validation.commandline/META-INF/MANIFEST.MF#L9) file we need to depend on `org.polarsys.capella.core.commandline.core`

