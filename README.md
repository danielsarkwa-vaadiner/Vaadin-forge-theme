# Forge DS Vaadin theme

This project is a demo application showcasing themed vaadin components to look and work like forge components

## Running the Application
The project is a standard Maven project. To run it from the command line, type `mvn` and open http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to set up a development environment for
Vaadin projects](https://vaadin.com/docs/latest/guide/install) (Windows, Linux, macOS).

## Project structure

The project follow Maven's [standard directory layout structure](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html):
- Under the `srs/main/java` are located Application sources
    - `Application.java` is a runnable Java application class and the app's 
      starting point
    - `GreetService.java` is a Spring service class
    - `MainView.java` is an example Vaadin view
- Under the `srs/test` are located the TestBench test files
- `src/main/resources` contains configuration files and static resources
- The `frontend` directory in the root folder contains the theme styles
    - `frontend/themes/forge-tech/components` directory contains the specific component styles
    - `frontend/themes/forge-tech/styles.css` file has all Forge components and Vaadin lumo variables accessible by all components
    - `frontend/themes/forge-tech/views` directory contains the styles for the demo views
