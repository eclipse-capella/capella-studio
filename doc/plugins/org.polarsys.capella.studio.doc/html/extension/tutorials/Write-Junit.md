# Write Junits

The plugin [org.polarsys.capella.test.framework](https://github.com/eclipse/capella/tree/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.framework) define basic test cases and tests suite.

> Capella exisiting junits are currently written with JUnit3. Note that this will evolve at some point

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.navigator.ju/META-INF/MANIFEST.MF#L9) file we need to depend on `org.polarsys.capella.test.framework`

- [BasicTestCase](https://github.com/eclipse/capella/blob/master/tests/plugins/org.polarsys.capella.test.framework/src/org/polarsys/capella/test/framework/api/BasicTestCase.java)

```java
public abstract void test() throws Exception; //content of the test
public List<String> getRequiredTestModels(); //list of models to import before the test
```

- [BasicTestSuite](https://github.com/eclipse/capella/blob/master/tests/plugins/org.polarsys.capella.test.framework/src/org/polarsys/capella/test/framework/api/BasicTestSuite.java)

```java
protected List<BasicTestCase> getTests();  //list of tests to run
public List<String> getRequiredTestModels(); //OPTIONAL, list of models to import before the testsuite
```

> When the model is defined at the test suite level, the test case are not allowed to modify the content of the model.


## Sample on semantic tests

Test for the creation of elements in the Project Explorer: [CreateElement.java](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.navigator.ju/src/org/polarsys/capella/test/navigator/ju/CreateElement.java)

* List of models to load [getRequiredTestModels](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.navigator.ju/src/org/polarsys/capella/test/navigator/ju/CreateElement.java#L54)

* Content of the test method [test](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.navigator.ju/src/org/polarsys/capella/test/navigator/ju/CreateElement.java#L72)
In this method, we use `getSession` to retrieve the opened session on the model. With a `Session` we have access to the `TransactionalEditingDomain` (allowing to execute commands) and then on the `ResourceSet`, the list of all loaded files.

By looking at how to [Edit an element](https://github.com/eclipse/capella/wiki/Edit#edit-an-element), it is possible to do some modification on the model (command to test) and then asserting that result is correct.

For instance, doing a [Drag and Drop](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.model.ju/src/org/polarsys/capella/test/model/ju/dnd/DnDComponentAndPart.java) 
or [Creating a REC/RPL](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.recrpl.ju/src/org/polarsys/capella/test/recrpl/ju/testcases/CreateRPL_SimpleCase.java) ensuring that all references are created [here](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.recrpl.ju/src/org/polarsys/capella/test/recrpl/ju/RecRplTestCase.java#L156)



## Sample on diagram tests

Diagram tests are more complicated to do, as it requires to open diagram, perform some manipulations and things like that.

* The plugin [org.polarsys.capella.test.diagram.common.ju](https://github.com/eclipse/capella/tree/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.common.ju) define some helpers.

In this plugin, many `DiagramContext` defining all tools 
[org.polarsys.capella.test.diagram.common.ju.context](https://github.com/eclipse/capella/tree/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.common.ju/src/org/polarsys/capella/test/diagram/common/ju/context), like [Interface Diagram Blank](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.common.ju/src/org/polarsys/capella/test/diagram/common/ju/context/IDBDiagram.java)

* In the context, we will be able to execute all existing tools, [retrieve views](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.common.ju/src/org/polarsys/capella/test/diagram/common/ju/context/DiagramContext.java#L166), retrieve [semantic elements](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.common.ju/src/org/polarsys/capella/test/diagram/common/ju/context/DiagramContext.java#L125). 


In a Junit, a use of this diagram context, [CreateInterface.java](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.tools.ju/src/org/polarsys/capella/test/diagram/tools/ju/idb/CreateInterface.java) testing that the tool is enabled and create correct element in the right container. (All the asserts are done in super implementations, so the test is readable even if we think it does nothing).

Some other samples, [CreateFunction.java](https://github.com/eclipse/capella/blob/master/tests/plugins/org.polarsys.capella.test.diagram.tools.ju/src/org/polarsys/capella/test/diagram/tools/ju/xab/CreateFunction.java)
or [PABStyleChecksDiagramElements.java](https://github.com/eclipse/capella/blob/master/tests/plugins/org.polarsys.capella.test.diagram.misc.ju/src/org/polarsys/capella/test/diagram/misc/ju/testcases/PABStyleChecksDiagramElements.java)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse/capella/blob/91bc87ffa88a17ac5058e1d0d7f546e4ff5fc448/tests/plugins/org.polarsys.capella.test.diagram.tools.ju/META-INF/MANIFEST.MF#L9) file we need to depend on `org.polarsys.capella.test.diagram.common.ju`


