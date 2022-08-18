# Create Addons

## Development Platform

See [Development Environment](https://github.com/eclipse/capella/wiki/Development-Environment) to use an IDE for development.

## How to create an basic addon adding a menu

* Do `File` > `New` > `Others` > `Plugin Project`, then follow the wizard. Give a name `org.polarsys.capella.addonXX` for instance.
(There is some templates on the last page, but you can click on Finish after the second page).
* In the opened editor, (this editor can opened again if you double click on Manifest.mf file)
  * in Dependencies, add for instance `org.eclipse.ui` `org.polarsys.capella.core.model.helpers` `org.polarsys.capella.core.model.handler`
  * in Extensions, click Add, and untick `show only extensions point from requiring plugin`
     * add `org.eclipse.ui.commands`, `org.eclipse.ui.menus` (when eclipse ask you to add them as dependencies, answer Yes)
  * if you go to `plugin.xml` tab, you will see similar xml sections like in [Add a Menu](https://github.com/eclipse/capella/wiki/Add-Menu)
  * based on these extensions points, you will create a command, a menu containing the command, then a handler, which is java code done when user click the command.
     * The `Command1Handler` in the sample sets the name of a System Function. In this class, you can manipulate capella model elements as you want. (see [command-handler](https://github.com/eclipse/capella/wiki/Add-Menu#command-handler) and API [Edit an Element](https://github.com/eclipse/capella/wiki/Edit))

## Test you addon in Capella as Debug

In the `Run` menu, `Debug Configuration`, double click on `Eclipse Application`. Ensure that `org.polarsys.capella.rcp.product` is selected in `Product to Run` in the right pane, then `Debug` it will launch a Capella in debug mode, with you new menu in it. If you click on an element of your model in the `Project Explorer` then menu shall appear.

## Export as deployable plugin

* If you want to deploy your plugin, use `File > Export > Plugin Development > Deployable plug-ins and fragments` to export it as a jar.

> Note `File > Export > Java > JAR` will not export it as a valid plugin.

## Deploy an addon

If you have several plugins, you can export the whole content by creating a `Feature`.

* Create a new `Feature Project`.

* In the `Included Plugins`, add the one you created

* In the `Overview` tab, you can click on `Exporting` > `Export Wizard`.
  * In the output folder, you will have all the files necessary.
  * Embed the files in a Addon/eclipse/ folder, and your users will be able to install it in a dropin folder of capella, like any other addons.

## Automatic deployment

Of course, this is a first step, then you will have to create some automatic packaging, automatic tests, using Jenkins for instance

You can inspire from existing addons to see how it can be done :

**Existing addons**
* https://github.com/eclipse/capella-sss-transition
* https://github.com/eclipse/capella-filtering
* https://github.com/eclipse/capella-requirements-vp

