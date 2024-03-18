# Quickfixes

Capella offers a quickfix functionality. This functionality helps users to resolve some problems thrown by model validation warnings or errors. The quickfixes are available through a contextual menu command on a selected message (in the view Information) that provides one, or several, resolution proposals. The set of resolution proposals can be extended with additional specific quickfixes that can be contributed through an extension point. 

 The extension point is provided by:
 * org.polarsys.capella.core.validation.ui.ide
 * and its identifier is capellaQuickFix

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.4"?>
<plugin>
   <extension point="org.polarsys.capella.core.validation.ui.ide.capellaQuickFix">
      <resolver
            class=""
            desc=""
            icon=""
            label="">
         <rules ruleId=""/>
      </resolver>
   </extension>
</plugin>
```

## Detail of the different fields

* `class`: the resolver class (generated, see below for more details)
* `icon`: path to the icon to override the default one
* `label`: a short name for the quickfix
* `ruleId`: the identifier of the rule the quickfix is related to 


## Quickfix implementation

The [AbstractCapellaMarkerResolution](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.validation.ui.ide/src/org/polarsys/capella/core/validation/ui/ide/quickfix/AbstractCapellaMarkerResolution.java) class provides some facilities to manage messages.

## Sample

The quickfix for the rule `DWF_D_41` set the given Class as Abstract

* The [Java class](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.data.information.ui.quickfix/src/org/polarsys/capella/core/data/information/ui/quickfix/resolver/DWFD41Resolver.java) defining the quickfix

* Its registration within [plugin.xml](https://github.com/eclipse-capella/capella/blob/c55af03da4a1e2ba1aa1cc78632a365fc4fc3e51/core/plugins/org.polarsys.capella.core.data.information.ui.quickfix/plugin.xml#L146)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse-capella/capella/blob/c55af03da4a1e2ba1aa1cc78632a365fc4fc3e51/core/plugins/org.polarsys.capella.core.data.information.ui.quickfix/META-INF/MANIFEST.MF#L13) file we need to depends on `org.polarsys.capella.core.validation.ui.ide`
