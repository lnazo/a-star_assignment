# runs maven commands and driver class
import os, sys

def main():
	try:
		file_name = sys.argv[1]

		os.system('mvn clean install')
		os.system('clear')
		os.system('java -cp target/a-star_assignment-1.0-SNAPSHOT.jar com.mca.astar.MainApp.MainApp ' + file_name)

	except IndexError:
		os.system('mvn clean install')
		os.system('clear')
		os.system('java -cp target/a-star_assignment-1.0-SNAPSHOT.jar com.mca.astar.MainApp.MainApp')

main()