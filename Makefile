#General Makefile Script

Main: *.java
	@javac *.java

edit:
	@vim Main.java

clean:
	@rm *.class

run:
	@java Main
