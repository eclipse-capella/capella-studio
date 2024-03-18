#Add Menu

## Extensions Points
Add some dependencies to your plugins, as [Create Basic Addon](https://github.com/eclipse-capella/capella/wiki/Create-Addons#how-to-create-an-basic-addon-adding-a-menu)

**org.eclipse.ui.commands**

```java
<extension point="org.eclipse.ui.commands">
   <command
         id="org.polarsys.capella.xxxx.command1"
         defaultHandler="org.polarsys.capella.xxxx.handlers.Command1Handler"
         name="Command 1">
   </command>
</extension>
```

**org.eclipse.ui.menus**

```java
<extension point="org.eclipse.ui.menu">
   <!-- Create an empty -->
   <menuContribution locationURI="popup:org.eclipse.ui.popup.any?after=additions">
      <menu id="org.polarsys.capella.xxxx"
           label="XXXXXX">
           <separator visible="true" name="mainCommands"/>
      </menu>
   </menuContribution>

   <!-- Add a command to this menu -->
   <menuContribution locationURI="popup:org.polarsys.capella.xxxx?after=mainCommands">
      <command
            commandId="org.polarsys.capella.xxxx.command1"
            id="org.polarsys.capella.xxxx.command1"
            style="push">
      </command>
   </menuContribution>

</extension>
```

## Command Handler

Create a class for your command in the src folder (with java packages) similar to:

```java
import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.polarsys.capella.common.ef.command.ICommand;
import org.polarsys.capella.common.helpers.TransactionHelper;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.common.ef.command.AbstractReadWriteCommand;
import org.polarsys.capella.core.data.ctx.SystemFunction;

public class Command1Handler extends AbstractHandler {

  //Execute command from createCommand on the selected model elements
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
    Collection<EObject> semanticElements = CapellaAdapterHelper.resolveSemanticObjects(selection.toList());

    ICommand cmd = createCommand(semanticElements);
    TransactionHelper.getExecutionManager(semanticElements).execute(cmd);
    return null;
  }

  protected ICommand createCommand(Collection<EObject> selection) {

    //Rename the selected System Function
    return new AbstractReadWriteCommand() {

      @Override
      public void run() {
        System.out.println(selection.toString());

        for (EObject object : selection) {
          if (object instanceof SystemFunction) {
            ((SystemFunction) object).setName("new name");
          }
        }
      }

    };
  }
}
```

Don't forget, this class shall be referenced into the `defaultHandler` section of the command in the plugin.xml file (there shall have no warning)

## Fine menu tuning

### Location of menu
Now that the menu appears, you can choose to put it somewhere more convenient.

In the locationURI of your menu, `locationURI="popup:org.eclipse.ui.popup.any?after=additions"`, instead of `additions`, you can choose `group.showIn` allowing you to add a menu aside `Show in Project Explorer`

If you want to restrict the menu to a dedicated view, instead of `org.eclipse.ui.popup.any`, you can choose `capella.project.explorer#PopupMenu`

[List of insertion points in Project Explorer](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.platform.sirius.ui.navigator/plugin.xml#L32)

[List of insertion points and id of existing views](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.platform.sirius.ui.menu/plugin.xml#L17)

The most important insertion points `group.showIn` and `group.sendTo` are available on most of views (see above).

If you create a new View, you will also be able to display all menus registered under these insertion points by registering them like other views did ([Semantic Browser](https://github.com/eclipse-capella/capella/blob/master/core/plugins/org.polarsys.capella.core.platform.sirius.ui.menu/plugin.xml#L72)).


### Visibility of commands

In your menu, where you choose to add a command, you can add conditions on command visibility.

```java
<command commandId="org.polarsys.capella.xxxx.command1" id="org.polarsys.capella.xxxx.command1" style="push">
  <visibleWhen checkEnabled="false">
		   <with variable="activeMenuSelection">
		      <iterate ifEmpty="false">
		         <or>
                <!-- Enable on Diagram elements -->
                <instanceof value="org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart">
                </instanceof>

                <!-- Enable on Model elements -->
                <instanceof value="org.eclipse.emf.ecore.EObject">
                </instanceof>

                <!-- Enable on Aird file -->
                <adapt type="org.eclipse.core.resources.IResource">
			              <test property="org.eclipse.core.resources.extension" value="aird" />
			          </adapt>
            </or>
		      </iterate>
		   </with>
	</visibleWhen>

</command>
```

### Command icon

You can add an icon on your command

**org.eclipse.ui.commandImages**

```java
<extension point="org.eclipse.ui.commandImages">
    
     <image commandId="org.polarsys.capella.xxxx.command1"
            icon="icons/full/etool16/add_element.gif">
     </image>

</extension>
```

### Command category

You can add an category on your command, regrouping all your commands

**org.eclipse.ui.commands**

```java
<extension point="org.eclipse.ui.commands">
   <category
         id="org.polarsys.capella.xxxx.category1"
         name="Extension commands">
   </category>
   <command
         id="org.polarsys.capella.xxxx.command1"
         categoryId="org.polarsys.capella.xxxx.category1"
         <!-- ... -->
         >
   </command>
</extension>
```