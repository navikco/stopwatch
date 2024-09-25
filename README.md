STOP WATCH DEMO
===================================

## Build And Run Microservice App

```shell

	#Install Gradle if you don't have it yet
	brew install gradle 

	git clone https://github.com/navikco/stopwatch.git
    
	cd stopwatch/
	
	./gradlew clean build
	
	java -jar build/libs/stopwatch-1.0.0-SNAPSHOT.jar


``` 


## Test it out 

* **Browse** http://localhost:63342/stopwatch/src/main/resources/Timer.html
* **Input** Time lesser than 100 seconds 
* **Click** the Timer Button and witness the Stopwatch going off 



