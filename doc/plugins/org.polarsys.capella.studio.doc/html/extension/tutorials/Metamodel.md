#Metamodel

## Retrieve type of an element

When developping an addon, knowing by heart all metamodels is not relevant, and many of us doesn't know it either.

To manipulate or create an element with a simple API, you just need to know its type. 
It is often displayed on the top left of Property views when you click on an element.

With its type, for instance, a `PhysicalFunction`, you will be able to retrieve its sub functions `((PhysicalFunction)function).getOwnedFunctions()`.


To create a `PhysicalFunction`, you will need to know from which metamodel part it is defined. Using `Open Type` wizard with `Ctrl+Shift+T` and writing the type, you will find its metamodel.

For instance, with `PhysicalFunction`, you will see org.polarsys.capella.xxx.**pa**.PhysicalFunction, meaning it is coming from `pa` metamodel (Physical Architecture)

Using **Pa**Factory, you will have access to `PaFactory.eINSTANCE.createPhysicalFunction()` allowing you to create a Physical Function. 

> To open Open Type wizard, you have to be in Capella Studio, Eclipse development platform or at least within Capella with Java features enabled (see [Development Environment](https://github.com/eclipse/capella/wiki/Development-Environment))  (Make sure you have the view `Package Explorer` active and not the `Project Explorer`)

> Don't forget to add some dependencies to your plugin, at least `org.polarsys.capella.core.model.helpers` `org.polarsys.capella.core.model.handler` will do the job.

## Metamodels

| Name  | Package prefix | Java ePackage | Java eFactory |
|---|---|---|---|
Capella Modeller  | capellamodeller  | CapellamodellerPackage  | CapellamodellerFactory |
Capella Core  | capellacore  | CapellacorePackage  | CapellacoreFactory |
Capella Common  | capellacommon  | CapellacommonPackage  | CapellacommonFactory |
Composite Structure  | cs  | CsPackage  | CsFactory |
Operational Analysis  | oa  | OaPackage  | OaFactory |
System Analysis  | ctx  | CtxPackage  | CtxFactory |
Logical Architecture  | la  | LaPackage  | LaFactory |
Physical Architecture  | pa  | PaPackage  | PaFactory |
Deployment  | deployment  | DeploymentPackage  | DeploymentFactory  |
EPBS  | epbs  | EpbsPackage  | EpbsFactory  |
Functional Analysis  | fa  | FaPackage  | FaFactory  |
Shared Model  | sharedmodel  | SharedmodelPackage  | SharedmodelFactory  |
Requirement  | requirement  | RequirementPackage  | RequirementFactory  |
Interaction  | interaction  | InteractionPackage  | InteractionFactory  |
Information  | information  | InformationPackage  | InformationFactory  |
Communication  | communication  | CommunicationPackage  | CommunicationFactory  |
Data Type  | datatype  | DatatypePackage  | DatatypeFactory  |
Data Value  | datavalue  | DatavaluePackage  | DatavalueFactory  |
Modelling Core  | modellingcore  | ModellingcorePackage  | ModellingcoreFactory  |
Behavior  | behavior  | BehaviorPackage  | BehaviorFactory  |
Activity  | activity  | ActivityPackage  | ActivityFactory  |
Replicable Elements  | Re  | RePackage  | ReFactory  |
Libraries  | libraries  | LibrariesPackage  | LibrariesFactory  |

## Getting the Metamodel

Metamodel are defined in ecore files located under plugins ending by *.gen

## Browse

[Model Analysis documentation](https://github.com/eclipse/capella/blob/master/doc/plugins/org.polarsys.capella.ui.doc/html/12.%20Model%20Analysis/12.5.2%20Acceleo%202%20Queries.mediawiki#advanced-queries)

> One easiest way to retrieve references or attributes is to open the Properties View and go the Expert tab then choose relevant references/attributes for your query 
> 
> ![](img/metamodel-system-analysis.png)
> 
> You just have to write the reference name in a camelCaseFormat to use it with Aql (e.g. Available In States => availableInStates) or in some case with the corresponding getter function getAvailableInStates