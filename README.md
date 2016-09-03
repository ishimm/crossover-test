# Crossover Java Trial Project - Weather

# Introduction
# -----------
  
  The System Airport Weather Service (AWS) is described in assignment.md and modified by Ishim Manon in order to complete the Project Test for the Application Process as a Java Software Architect for CrossOver.
  
  Created by Ishim Manon
  
  This release has only been tested on the following configurations:

	on the following JDK:
	    * Sun JDK 1.8.0_92
	on the following OS:
	    * Windows 10

# Release notes
# -------------
- In this release classes had been moved into packages as a bet parectice. I tried to place all items related to a single feature into  a single package, avoiding the obsolete package-by-layer way.
This results in packages with high cohesion and high modularity, and with minimal coupling between packages. Items that work closely together are placed next to each other. They aren't spread out all over the application.

- Code was cleaned removing warnings as possible bye deleting unused imports for example.

- Code was properly intented to make it more readable.

- Unit test were added into their corresponding packages.

- Delete Collect/Airport was implemented on RestWeatherCollectorEndpoint.

- AirportLoader was implemented to allow the system upload airports from a dat file using Scanner utility.

- Comments where added to indicate what's been coded to other developers.

#Build
#------------
 - Unzip JSA_AWS_Manon_Ishim.zip.
 - Use maven to build and test project
 - Code may also be cloned from Git repository: https://github.com/ishimm/crossover-test.git
	
#System requirements
#------------

- A Container or server that supports REST services.
- JDK 1.7 or later
- Maven 3.2.1 or later
- Git 2.9.2


#References and acknowledgments
#---

  NOTE: This product includes software developed by the Crossover team.

#Licensing
#---------

  This program is free software; you can redistribute it and/or
  modify it under the terms of the GNU General Public License
  as published by the Free Software Foundation
 
  This distribution may include software that has been designed for learning purposes and under the terms of the GNU General Public License. 
   
   