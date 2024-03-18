#Edit

## Access to Session/ExecutionManager/EditingDomain

When we open an aird (doucle click on it),

A `Session` is created containing a `TransactionalEditingDomain` which contains a `ResourceSet` containing all `Resource(s)` loaded, containing all EObjects. It is editable through a `ExecutionManager`.

- `EObject` is the EMF element (Function, Component, graphical element, etc)

- `Resource` is the EMF representation of the XML files (aird, melodymodeller) containing all EObject

- `ResourceSet` is the list of all Resources loaded (melodymodeller, aird, odesign, etc)

- `TransactionalEditingDomain` allows to access element/model/diagrams in a Thread-safe environnement. All modifications in Capella are done within it.

- `ExecutionManager` is the API main access to be able to edit an element.

- `Session` is the API main access to Diagrams

## Session

[Session](http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/tree/plugins/org.eclipse.sirius/src/org/eclipse/sirius/business/api/session/Session.java)

[SessionManager](http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/tree/plugins/org.eclipse.sirius/src/org/eclipse/sirius/business/api/session/SessionManager.java)

[DialectManager](http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/tree/plugins/org.eclipse.sirius/src/org/eclipse/sirius/business/api/dialect/DialectManager.java)

[org.eclipse.sirius.business.api.query](http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/tree/plugins/org.eclipse.sirius/src/org/eclipse/sirius/business/api/query)

[org.eclipse.sirius.diagram](http://git.eclipse.org/c/sirius/org.eclipse.sirius.git/tree/plugins/org.eclipse.sirius.diagram/src-gen/org/eclipse/sirius/diagram)

[org.eclipse.sirius.diagram.business.api.query](https://git.eclipse.org/c/sirius/org.eclipse.sirius.git/tree/plugins/org.eclipse.sirius.diagram/src-core/org/eclipse/sirius/diagram/business/api/query)

```java
Session session = SessionManager.INSTANCE.getSession(EObject object);
Session session = SessionManager.INSTANCE.getExistingSession(EcoreUtil2.getURI(airdFile));
TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
```

## TransactionalEditingDomain

[TransactionalEditingDomain](https://git.eclipse.org/c/emf-transaction/org.eclipse.emf.transaction.git/tree/org.eclipse.emf.transaction/src/org/eclipse/emf/transaction/TransactionalEditingDomain.java)

[TransactionHelper](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common.helpers/src/org/polarsys/capella/common/helpers/TransactionHelper.java)

```java
TransactionalEditingDomain domain = TransactionHelper.getEditingDomain(element)
TransactionalEditingDomain domain = TransactionHelper.getEditingDomain(resource)
```

[TransactionUtil](http://git.eclipse.org/c/emf-transaction/org.eclipse.emf.transaction.git/tree/org.eclipse.emf.transaction/src/org/eclipse/emf/transaction/util/TransactionUtil.java)

[EObjectExt](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common.helpers/src/org/polarsys/capella/common/helpers/EObjectExt.java)

```java
Collection<EObject> subComponents = EObjectExt.getAll(element, CsPackage.Literals.COMPONENT)
```

## ExecutionManager

[ExecutionManager](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common.ef/src/org/polarsys/capella/common/ef/ExecutionManager.java)

[TransactionHelper](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common.helpers/src/org/polarsys/capella/common/helpers/TransactionHelper.java)

[AbstractReadWriteCommand](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common.ef/src/org/polarsys/capella/common/ef/command/AbstractReadWriteCommand.java)

```java
ExecutionManager manager = TransactionHelper.getExecutionManager(element)
ExecutionManager manager = TransactionHelper.getExecutionManager(resource)
```

Create a new TransactionalEditingDomain for Capella models:

```java
ExecutionManager manager = ExecutionManagerRegistry.getInstance().addNewManager();
TransactionalEditingDomain domain = manager.getEditingDomain();
```

## IFile/Resource

[EcoreUtil2](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common/src/org/polarsys/capella/common/helpers/EcoreUtil2.java)

```java
EcoreUtil2.getFile(Resource)
EcoreUtil2.getURI(file)
```

```java
element.eResource()
```

[ResourcesPlugin](https://git.eclipse.org/c/platform/eclipse.platform.resources.git/tree/bundles/org.eclipse.core.resources/src/org/eclipse/core/resources/ResourcesPlugin.java)

```java
ResourcesPlugin.getWorkspace().getRoot().getProject("project").getFile("toto.melodymodeller");
```


## Helpers

Many helpers exist in Capella, they are mainly located inside following plugins and have *Ext name

[org.polarsys.capella.core.data.helpers](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.data.helpers)

[org.polarsys.capella.core.model.helpers](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.model.helpers)

`CapellaElementExt.creationService(x)` Helps to create additional elements like if it was created from Add Element menu. (for instance, the Part aside the Component, or min/max cardinalities on a Property)

For instance

`FunctionExt, FunctionalExchangeExt, ComponentExt`

All capella elements have derived methods allowing direct access to other interesting elements. For instance, for an actor, actor.getAllocatedFunctions() retrieve the list of the allocated functions). These methods are computed in :

```
org.polarsys.capella.core.data.helpers
org.polarsys.capella.core.data.helpers.*.delegates.**Helper
```

It can be interesting to see how these methods are computed to understand how a reference between two element is stocked in the model. 


## Access all diagrams

```java
IFile airdFile = ...
Session session = SessionManager.INSTANCE.getExistingSession(EcoreUtil2.getURI(airdFile));
for (DRepresentationDescriptor descriptor :  DialectManager.INSTANCE.getAllRepresentationDescriptors(session)) {
   descriptor.getRepresentation(); //will return the diagram
   descriptor.getTarget()); //will return the element owning the diagram (for instance, the PhysicalComponent in a PAB diagram)
}
```

## Access all graphical elements in a diagram

```java
DDiagram diagram = (DDiagram)descriptor.getRepresentation(); //warning! directCast but there may have also DTable, DTree..
for (DDiagramElement element: diagram.getDiagramElements()) { //for all main elements in diagram
   System.out.println(element); //here we have the graphical element

   if (element instanceof DEdge) {
     DEdge edge = (DEdge)element;
     edge.getSourceNode()
     edge.getTargetNode()
     edge.getStyle()

   } else if (element instanceof DNodeContainer, DNode, DNodeList) {
     ((DNodeContainer/DNode/DNodeList)element).getOwnedBorderedNodes()
     ((DNodeContainer/DNode/DNodeList)element).getStyle()

     Node a = SiriusGMFHelper.getGmfNode(element); //here we have the GMF graphical element
     System.out.println("located: "+a.getLayoutConstraint()); //display the location of the element
   }

}
```

## Edit an element

All editions in Capella is made through an TransactionalEditingDomain that guarantee a Thread-safe environnement. Any modification on model, diagram must be done through a command, like :

```java
EObject element = ...
ExecutionManager manager = TransactionHelper.getExecutionManager(element).execute(new AbstractReadWriteCommand() {
            
  @Override
  public void run() {
    if (element instanceof PhysicalComponent) {
      PhysicalComponent pc = (PhysicalComponent)element;
      pc.setName("toto");
      CapellaElementExt.creationService(pc); //to create the related part
    }
  }
});
```

## Create an element

To create an element, you need to know its type (for instance by looking at the properties view) and know from which metamodel it comes from. [See Metamodel Tutorial](https://github.com/eclipse-capella/capella/wiki/Metamodel)

```java
EObject element = ... //an element from physical layer
ExecutionManager manager = TransactionHelper.getExecutionManager(element).execute(new AbstractReadWriteCommand() {
            
  @Override
  public void run() {
    BlockArchitecture physicalArchitecture = BlockArchitectureExt.getRootBlockArchitexture(element);
    PhysicalFunction pf = (PhysicalFunction)BlockArchitectureExt.getRootFunction(physicalArchitecture);

    PhysicalFunction myNewFunc = PaFactory.eINSTANCE.createPhysicalFunction("new function");
    pf.getOwnedPhysicalFunctions().add(myNewFunc);

  }
});
```

## EMF API (Generic access)

[EObject](https://git.eclipse.org/c/emf/org.eclipse.emf.git/tree/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EObject.java)

[EClass](https://git.eclipse.org/c/emf/org.eclipse.emf.git/tree/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EClass.java)

[EStructuralFeature](https://git.eclipse.org/c/emf/org.eclipse.emf.git/tree/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/EStructuralFeature.java)

[Resource](https://git.eclipse.org/c/emf/org.eclipse.emf.git/tree/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/resource/Resource.java)

[ResourceSet](https://git.eclipse.org/c/emf/org.eclipse.emf.git/tree/plugins/org.eclipse.emf.ecore/src/org/eclipse/emf/ecore/resource/ResourceSet.java)

```java
EObject object = ...

element.eResource()

object.eContents() //returns all direct children of the element

object.eAllContents() //returns all children recursively

object.eClass() //returns the Metaclass of the given element

object.eClass().getAllReferences() //returns the Metaclass references of the given element

object.eClass().getAllAttributes() //returns the Metaclass references of the given element

object.eGet(object.eClass().getEStructuralFeature("name")) // returns the name of the element

//BUT, if you know the metaclass, it's faster to use getName() method. ((PhysicalFunction)object.getName()) for instance

object.eSet(object.eClass().getEStructuralFeature("name"), "newName") //set the name of the element

((EList)object.eGet(object.eClass().getEStructuralFeature("ownedElements"))).add(element) //add element to object.ownedElements 

```