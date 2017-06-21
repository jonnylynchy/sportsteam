# Sports Team Website

This is a Springboot application that serves a static website and a SpringMVC REST API. 

## Installation Steps

- Clone this branch into your projects directory: 
`git clone https://github.com/jonnylynchy/sportsteam.git`
- Import project into IntelliJ
	- File > New > Project from existing sources
	- Navigate to sportsteam directory
	- Choose the file "pom.xml"
- IntelliJ will create a project and start importing dependencies
- Once all imports and indexing is complete:
	- Right-click on folder and select "maven" from the menu > "clean install"
- You should see a terminal open with build output
- Once that is complete you should see "SUCCESS"
- Now you should should be able to create a run configuration: 
	- General Instructions: https://www.jetbrains.com/help/idea/creating-and-editing-run-debug-configurations.html
	- You should see a button with a down arrow in the top right area of IntelliJ.
		- Click that and select "Edit Configurations".
	- Choose "spring boot" in the type menu from the "+" button.
	- In the name field, enter "Sports Team Web" or whatever you wish.
	- Select the "App" class from "..." button next to  the main class field.
	- Hit the "apply" and "OK" buttons.
- You should be able to run the project now by clicking on the green play icon directly next to the configuration dropdown in the top right area.
- If you didn't receive any errors in the terminal,  navigate to http://localhost:8080 in your browser.
- You should now see "Sports Team Website up and running!"


