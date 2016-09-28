## Project Name
Military Phrase Dictionary

### Features
This program will allow the user to create a dictionary of military phrases and their definitions.

#### Author
Eric Krause


## Setup/Installation Requirements

* Download zip or clone files to desktop.
* Have Gradle installed on system.
* Open console to the project package folder and run "gradle run" .
* View localhost:4567 in a web browser.



## Specifications

|Behavior|Input|Output|
|---|---|---|
|The application will take a new word or phrase.| BOLO | BOLO |
|The application will take the users definition of the phrase or word. | BOLO : A soldier who cannot pass weapons qualifications | A soldier who cannot pass weapons qualifications |
|The application will save the user's phrase and definition to the dictionary. | BOLO : A soldier who cannot pass weapons qualifications | BOLO : A soldier who cannot pass weapons qualifications |
|The application will save additional definitions of a phrase to the dictionary. | BOLO: A soldier who cannot do their job (ie. shoot their weapon) | BOLO : A soldier who cannot pass weapons qualifications, BOLO: A soldier who cannot do their job (ie. shoot their weapon) |
|The application will display all of the user's phrases which link to the phrase's definitions. | BOLO | BOLO : A soldier who cannot pass weapons qualifications, BOLO: A soldier who cannot do their job (ie. shoot their weapon) |

## Known Bugs

Having issue with add to dictionary button on /phrases/new

## Support and contact details

Git Username of Author: krause197

## Technologies Used

Java, jUnit, Gradle, Spark

### License

This work can be used under the MIT License.
Copyright (c) 2016 Eric Krause
