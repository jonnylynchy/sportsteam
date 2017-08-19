# Sports Team Website

This is a Spring Boot application that serves a static website and a SpringMVC REST API. 

## Installation Steps
- Clone this branch into your projects directory: 
`git clone https://github.com/jonnylynchy/sportsteam.git`
- Create a local MySQL database
- Import project into IntelliJ
	- File > New > Project from existing sources
	- Navigate to sportsteam directory
	- Choose the file "pom.xml"
- IntelliJ will create a project and start importing dependencies
- Once all imports and indexing is complete:
	- Right-click on folder and select "maven" from the menu > "clean install"
- You should see a terminal open with build output
- Once that is complete you should see "SUCCESS"
- Edit application-local.properties
	- Edit the datasource url, username, and password for both spring (top of file) and flyway (bottom of file)
- Now you should should be able to create a run configuration: 
	- General Instructions: https://www.jetbrains.com/help/idea/creating-and-editing-run-debug-configurations.html
	- You should see a button with a down arrow in the top right area of IntelliJ.
		- Click that and select "Edit Configurations".
	- Choose "spring boot" in the type menu from the "+" button.
	- In the name field, enter "Sports Team Web" or whatever you wish.
	- Select the "App" class from "..." button next to  the main class field.
	- In VM options, enter "-Dspring.profiles.active=local".
	- Be sure to choose 1.8 SDK in the JRE options.
	- Hit the "apply" and "OK" buttons.
- You should be able to run the project now by clicking on the green play icon directly next to the configuration dropdown in the top right area.
- If you didn't receive any errors in the terminal,  navigate to http://localhost:8080 in your browser.
- You should now see "Sports Team Website up and running!"

## Enabling Live Reloading/Restarts
When you save a static file in the src/main/resources/static directory, the changes will not automatically show up when you refresh your browser. To enable this, you must install the dev-tools and make a couple of configurations in your project.

Here's a great video tutorial on how to do that: https://www.youtube.com/watch?v=VWF7vCJSqrA



