
### Table of Contents
- [Viewpoint Development](#viewpoint-development)
  * [First Steps](#first-steps)
  * [Option #1: Creation of viewpoint](#option-1-creation-of-viewpoint)
  * [Option #2: Import of the Basic Mass viewpoint](#option-2-import-of-the-basic-mass-viewpoint)
- [Viewpoint Aspects](#viewpoint-aspects)
  * [Configuration](#configuration)
  * [Data](#data)
    + [Inheritance](#inheritance)
    + [Extension](#extension)
  * [User Interface (Property views)](#user-interface--property-views-)
  * [Diagram](#diagram)
- [Viewpoint Guidelines](#viewpoint-guidelines)

## Viewpoint Development

- The abstract principles to develop viewpoints are explained in [Kitalpha](https://github.com/eclipse/kitalpha/wiki/Viewpoint-development).

- The [Technical Information section](https://github.com/eclipse/capella/wiki#development) will help you to setup a development environment

- Access to the page of the [Basic Viewpoints](https://github.com/eclipse/capella-basic-vp/wiki) for existing viewpoint samples.

### First Steps

There is 2 means to start working with a viewpoint in a workspace:

* Creating a new viewpoint
* Importing a sample viewpoint for inspiration

### Option #1: Creation of viewpoint

Instead of importing the viewpoint, it is possible to create it from scratch:

* Apply the commands: File/New…/Project – Viewpoint DSL Project
* Set the name, choose Capella

![image](https://user-images.githubusercontent.com/34767327/139406514-835f856f-f5a0-40e6-99f3-a93a8e273ae2.png)

To create a new aspect, in the mass.spec.vptext:

    CTRL+Space: choose the new aspect to be created
    Modify the name of the aspect file and Finish 

![image](https://user-images.githubusercontent.com/34767327/139406548-a7e29dcf-beb3-4556-94a9-34867e831431.png)


## Viewpoint Aspects

The `spec.vptext` is the root file containing the VPDSL information. 

### Configuration
The `conf.vptext` will contain the configuration of the viewpoint.

- Target is the targeted application. This can be `Capella`, `CDO for Capella` (targeting for instance Team for Capella), `XML` (generating additional files)

### Data

The Data aspect is essential because information of some other aspects (e.g., UI, Diagram) is deducted from the data description. 

![image](https://user-images.githubusercontent.com/34767327/139406762-7a49ed37-b657-46bd-83f4-6f699e945204.png)

In this figure, the classes Mass and PartMass have attributes and no association. 

#### Inheritance

Inheritance is identified by the key word superClass, such as for PartMass. Mass has no inheritance. Due to the "Capella" Target Application, during the generation of the ecore file (Cf. org.polarsys.capella.vp.mass plugin), a class without superclass inherits from the Capella NamedElement class.

The mechanism of inheritance enables to a have complete inheritance at the viewpoint level, not only from the data but also for the diagrams for instance. 

#### Extension

An extension creates extension elements in an extended element. For Basic Mass, PartMass extends (Capella) Part. All the PartMass elements are contained by a Part element

![image](https://user-images.githubusercontent.com/34767327/139406827-3ace6dec-decf-4f9d-b77c-d603330ea3ed.png)

### User Interface (Property views)

The UI contents is empty at the beginning. Populate it by CTRL-Space and selection of the "UI - Generate User Interface for all classes" option in the menu. The generated contents is deduced from the data description. The generation is not incremental. This means that when the Data aspect part evolves, a new generation is produced apart and ignores the previous one.

By CTRL-Mouse on an attribute (e.g. mass.data.Mass.value), it is possible to navigate toward the attribute defined in the Data aspect. 

![image](https://user-images.githubusercontent.com/34767327/139406960-04c46cca-4043-47ac-88eb-317e250d3828.png)

#### Sirius Property Views

⚠️ Using [Sirius Property Views](https://www.eclipse.org/sirius/doc/specifier/properties/Properties_View_Description.html) in a Capella Viewpoint requires some adaptations of the tooling. It is possible but may cause some problems with existing extensions and tools integrations in Capella. For this reason we do not provide it in the Capella Studio release and the specific dependencies needs to be added. ⚠️ 

In order to develop your viewpoint with this capability, it is first necessary to update your Capella Studio to include the dedicated features and their dependencies. The Sirius update site located under: https://download.eclipse.org/sirius/updates/ contains the required features. Please use the correct repository depending on your version of capella (to get this information head to `https://download.eclipse.org/capella/core/updates/releases/[YOUR_CAPELLA_VERSION_HERE]/targets/capella.target-definition.targetplatform` and check the line with Sirius). Then install the "Sirius Specification Environment" feature. After installing this, the dedicated Sirius Property views will be available.

You will then need to bundle you viewpoint and install it on Capella. 

In order to get it working on Capella it will be necessary to update your Capella installation and install [EEF](https://download.eclipse.org/modeling/emft/eef/updates/releases/) and then `Sirius Specification Environment` from the Sirius update site. As an alternative, one may add the following features as dependencies in your viewpoint build (in `<my_viewpoint_name>.representation.feature/feature.xml` or `<my_viewpoint_name>.feature/feature.xml`) and publish again the viewpoint (these files are not re-generated when publishing the viewpoint):

```
<includes id="org.eclipse.sirius.runtime.ide.eef" version="0.0.0"/>
<includes id="org.eclipse.sirius.properties.feature" version="0.0.0"/>
<includes id="org.eclipse.eef.ext.widgets.reference.feature" version="0.0.0"/>
<includes id="org.eclipse.eef.sdk.feature" version="0.0.0"/>
```

### Diagram

A diagram is made of three parts: 1) the diagram extension when a diagram extends an existing one, 2) the mapping of the data onto diagram elements, 3) the actions applicable on the diagram. 

![image](https://user-images.githubusercontent.com/34767327/139407034-88b1f410-1730-4799-92ff-7f82d5f6f59f.png)

🚩 Even if it is possible to generate a skeleton for diagram tools using VPDSL , the `odesign` file will be the place to edit and maintain diagram representations. See [Sirius Tutorials](https://github.com/eclipse/capella/wiki/Tutorials)

### Option #2: Import of the Basic Mass viewpoint

This first option is to import the viewpoint as depicted below from the Plug-ins view, with the "Import As"/"Source Project" command. 

![image](https://user-images.githubusercontent.com/34767327/139406188-36ab66e6-1c27-4c63-90ac-46f69c59d2af.png)

After the import of the viewpoint plugins, open the model folder in the vpdsl plugin. 

![image](https://user-images.githubusercontent.com/34767327/139406237-b7ccb2b2-9079-4603-a947-b42af191e99c.png)

Open a vptext file by double-click. If an error occurs, this means that the vptext is not recognized automatically. In this case, on the vptext file, right-click and Open With Data / User Interface / Diagram / Configuration for the data / ui / diagram / conf vptext files

#### Viewpoint description: Model and text equivalence

The viewpoint description with Kitalpha is stored in a model (.vpdesc file) and edited with a set of editors dedicated by aspect. 

![image](https://user-images.githubusercontent.com/34767327/139406299-ad7662c5-b024-47d0-ab21-67e335e5d99a.png)

## Viewpoint Technical Guidelines

⚡ See [Viewpoint Guidelines](https://github.com/eclipse/capella/blob/master/doc/plugins/org.polarsys.capella.developer.doc/html/Viewpoint%20Guidelines.mediawiki)

⚡ For CDO for Capella, due to [#141](https://github.com/eclipse/capella-studio/issues/141), the generated code may not be directly compliant with the targeted application.
* If you inherit from a `ModelElement`, please ensure that the viewpoint Factory is initializing the id within the contructor, like [FilteringFactoryImpl](https://github.com/eclipse/capella-filtering/blob/master/plugins/org.polarsys.capella.filtering.model.cdo/src/org/polarsys/capella/filtering/impl/FilteringFactoryImpl.java#L144-L146)**

