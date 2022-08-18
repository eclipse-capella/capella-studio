# Model Validation Rules

Capella offers a model validation functionality. This validation is available through a contextual menu command that executes a set of rules on the selected model element.

The set of executed rules can be customized through the preferences (non-mandatory rules can be activated or deactivated), and additional specific rules can be contributed through an extension point.
Extension Point Description

An Eclipse extension point allows plug-ins to contribute constraints into the EMF model validation framework.

The extension point is provided by:

* the plug-in org.eclipse.emf.validation
* and its identifier constraintProviders.

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.2"?>
<plugin>
   <extension point="org.eclipse.emf.validation.constraintProviders">
      <constraintProvider>
         <package namespaceUri=""/>
         <constraints categories="">
            <constraint
                  class=""
                  id=" "
                  isEnabledByDefault="true"
                  lang="Java"
                  mode="Batch"
                  name=" "
                  severity="ERROR"
                  statusCode="1">
               <message>
               </message>
               <target class=""/>
               <description>
               </description>
            </constraint>
         </constraints>
      </constraintProvider>
   </extension>
</plugin>
```

## Detail of the different fields

* `namespaceUri`: Namespace URI of one of the Capella metamodel subset. [see Metamodel](https://github.com/eclipse/capella/wiki/Metamodel)

* `categories`: [See definition of all categories](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.validation/plugin.xml)

```
    capella.category/quality
    capella.category/integrity
    capella.category/design
    capella.category/design/coverage
    capella.category/design/well-formedness
    capella.category/design/well-formedness/state_machines
    capella.category/design/well-formedness/dataflows
    capella.category/design/well-formedness/components
    capella.category/design/well-formedness/data
    capella.category/design/well-formedness/interfaces
    capella.category/design/well-formedness/scenarios
    capella.category/design/well-formedness/capabilities
    capella.category/design/well-formedness/use_cases
    capella.category/design/consistency
    capella.category/design/completeness
    capella.category/transition
    capella.category/transition/consistency
    capella.category/transition/consistency/data
    capella.category/transition/consistency/state_machines
    capella.category/transition/consistency/interfaces
    capella.category/transition/consistency/dataflows
    capella.category/transition/consistency/scenarios
    capella.category/transition/consistency/capabilities
    capella.category/transition/justification
    capella.category/transition/justification/physical_architecture
    capella.category/transition/justification/logical_architecture
    capella.category/transition/justification/epbs
    capella.category/transition/justification/generic
    capella.category/transition/justification/system_analysis
```

* `id`: A unique identifier for the constraint.
* `name`: A localizable name for the constraint (appears in the GUI). Note that {0} identify the element type and {1} its name.
* `severity`: The severity of the problem if the constraint is violated. This correlates to the severity of tasks in the Tasks view of the Eclipse environment. The default severity (if none specified) is ERROR. The CANCEL severity should be used with caution, as it causes the validation operation to be interrupted, possibly resulting in the loss of valuable diagnostic information from other constraints.
* `class`: For "Java" language constraints only, identifies a class implementing the constraint. The class must extend the AbstractValidationRule class, providing an implementation of the abstract method: `validate()`
* `target`: The type on which the rule is applied.
* `message`: A localizable name for the constraint (appears in the GUI). You can use {0}, {1} to make dynamic messages computed by tour Java code.
* `statusCode`: The plug-in unique status code, useful for logging.
* `lang`: Identifies the language in which the constraint is expressed. The language is not case-sensitive. The currently supported languages are Java and OCL. For the Java language, this element identifies a class that extends the AbstractValidationRule class. Other languages, such as OCL, may make use of the body of the constraint element and/or one or more parameters.
* `mode`: Describes whether a constraint operates in batch mode, live mode, or feature mode. The default is batch if not specified.
* `isEnabledByDefault`: Indicates if this constraint should be enabled by default. User can change this setting in preferences. The default value is true.


## Validation Rule implementation

The [AbstractValidationRule](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.validation/src/org/polarsys/capella/core/validation/rule/AbstractValidationRule.java) class provides some facilities to manage messages.

**Notes:**

To return a valid status, return the result of the call to the method:

`createSuccessStatus()`

To return an invalid status, return the result of the call to the method:

`createFailureStatus(...)`

The parameters are the validation context and a set of parameters that will be passed to your message (they will be used only if you defined {0}, {1}, etc. parameters in your message text: see the previous section).

## Sample

The rule `DCOM_11` checks that a Function is allocated to a Component

* The [Java class](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.fa.validation/src/org/polarsys/capella/core/data/fa/validation/function/LFCompAllocationLeastwise.java) defining the rule

* Its registration within [plugin.xml](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.fa.validation/plugin.xml#L29)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse/capella/blob/master/core/plugins/org.polarsys.capella.core.data.fa.validation/META-INF/MANIFEST.MF#L8) file we need to depends on `org.polarsys.capella.core.validation`
