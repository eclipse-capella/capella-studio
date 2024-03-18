# Semantic Browser

By providing queries on Semantic Browser, these queries will be also available as a column on [Mass Visualization table](https://github.com/eclipse-capella/capella/blob/master/doc/plugins/org.polarsys.capella.common.ui.massactions.doc/html/Introduction.mediawiki) or accessible in Title Block.

The extension point is provided by:

* the plug-in org.polarsys.capella.common.ui.toolkit.browser
* and its identifier contentProviderCategory.

The contribution to the extension point is done in the plugin.xml file of the plugin. Open this file and focus on the plugin.xml tab:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.4"?>

<extension
         point="org.polarsys.capella.common.ui.toolkit.browser.contentProviderCategory">
  <category
      id="org.polarsys.capella.core.semantic.queries.SystemFunctionInvolvingCapabilities"
      isTopLevel="true"
      name="Involving Capabilities">
      <availableForType
         class="org.polarsys.capella.core.data.ctx.SystemFunction">
      </availableForType>
      <targetBrowserId
         id="ReferencingElementBrowser">
      </targetBrowserId>
      <categoryQuery>
      <basicQuery class="org.polarsys.capella.core.semantic.queries.basic.queries.SystemFunctionInvolvingCapabilities">
      </basicQuery>
      </categoryQuery>

      <!-- optional -->
      <itemQueries>
         <basicQuery class="org.polarsys.capella.core.semantic.queries.basic.queries.ExchangesItemExchangeItemElements">
         </basicQuery>
      </itemQueries>
  </category>
</extension>
```

## Detail of the different fields

* `availableForType: class`: an EClass class on which the query will be applied
* `targetBrowserId`: one of `ReferencingElementBrowser` - `CurrentElementBrowser` - `ReferencedElementBrowser` 
* `basicQuery: class`: a java class inheriting of [org.polarsys.capella.common.helpers.query.IQuery](https://github.com/eclipse-capella/capella/blob/master/common/plugins/org.polarsys.capella.common.helpers/src/org/polarsys/capella/common/helpers/query/IQuery.java)
* `itemQueries.basicQuery: class`: a sub query applied on all retrieved elements. For intance, for a Function, you can retrieve the outgoing exchanges, and displaying for them their target functions.

## Sample

For a Functional Exchange, we display its allocated Exchange Items and their data. 

* The [Java class](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.semantic.queries/src/org/polarsys/capella/core/semantic/queries/basic/queries/FunctionalExchangeExchangesItems.java) retrieving the Exchange Items

* The secondary [Java class](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.semantic.queries/src/org/polarsys/capella/core/semantic/queries/basic/queries/ExchangesItemExchangeItemElements.java) retrieving the Exchange Items Elements for Exchange Items

* Its registration within [plugin.xml](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.semantic.queries/plugin.xml#L1351)

* In [MANIFEST/MANIFEST.MF](https://github.com/eclipse-capella/capella/blob/6ef8e899f3503c655a1c528a2d33442dc722e90d/core/plugins/org.polarsys.capella.core.semantic.queries/META-INF/MANIFEST.MF#L9) file we need to depend on `org.polarsys.capella.core.model.helpers` 