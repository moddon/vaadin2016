# OptionGroupS Add-on for Vaadin 7

OptionGroupS is a UI component add-on for Vaadin 7. Inspired by the Vaadin OptionGroup componenet vaadin-onoffswitch-addon at https://github.com/basakpie/vaadin-onoffswitch-addon by basakpie.
this add on was developed as a university project at Turku University

## Online demo

Try the add-on demo at <https://optionsgroup-switch.herokuapp.com/>

## Download release

Official add-on will be added later to the vaadin directory

## Building and running demo

git clone <https://github.com/moddon/vaadin2016>
mvn clean install
cd demo
mvn jetty:run

To see the demo, navigate tohttps://optionsgroup-switch.herokuapp.com/

## TODO list

- Refactor
- support more styling
- change value from just indexes of selected options to a more general Object with few properties 


## Development with Eclipse IDE

For further development of this add-on, the following tool-chain is recommended:
- Eclipse IDE
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging server-side

If you have not already compiled the widgetset, do it now by running vaadin:install Maven target for OptionGroupS-root project.

If you have a JRebel license, it makes on the fly code changes faster. Just add JRebel nature to your OptionGroupS-demo project by clicking project with right mouse button and choosing JRebel > Add JRebel Nature

To debug project and make code modifications on the fly in the server-side, right-click the OptionGroupS-demo project and choose Debug As > Debug on Server. Navigate to http://localhost:8080/OptionGroupS-demo/ to see the application.

### Debugging client-side

Debugging client side code in the OptionGroupS-demo project:
  - run "mvn vaadin:run-codeserver" on a separate console while the application is running
  - activate Super Dev Mode in the debug window of the application or by adding ?superdevmode to the URL
  - You can access Java-sources and set breakpoints inside Chrome if you enable source maps from inspector settings.
 
## Release notes

### Version 1.0-SNAPSHOT
- ...

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, the following features are planned for upcoming releases:
- ...
- ...

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

OptionGroupS is written by <...>

# Developer Guide

## Getting started

Here is a simple example on how to try out the add-on component:

<

final OptionGroupS component = new OptionGroupS(String_caption, Container_options);    

        component.addValueChangeListener(e -> Notification.show("Value changed:",
                String.valueOf(e.getProperty().getValue()),
                Type.TRAY_NOTIFICATION));
 >

For a more comprehensive example, see src/test/java/org/vaadin/template/demo/DemoUI.java

## Features


## API

OptionGroupS JavaDoc is available online at <...>

