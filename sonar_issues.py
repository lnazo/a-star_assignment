# runs maven commands and driver class
import os, sys

def main():
	try:
		file_name = sys.argv[1]

		if (file_name.lower() == 'full'):
			os.system('mvn clean install sonar:sonar -Dsonar.host.url=http://127.0.0.1:9000/sonar/')

		elif (file_name.lower() == 'light'):
			os.system('mvn clean install sonar:sonar -Dsonar.analysis.mode=preview -Dsonar.issuesReport.html.enable=true -Dsonar.issuesReport.console.enable=true -Dsonar.host.url=http://127.0.0.1:9000/sonar/')

	except:
		os.system('mvn clean install sonar:sonar -Dsonar.host.url=http://127.0.0.1:9000/sonar/')

main()