echo "Deploying esporte"
ssh -i ~/Project/Octle/aws/esporte_api.pem ubuntu@52.77.244.46 sudo  cp /opt/tomcat/apache-tomcat-7.0.65/webapps/esporte-api.war esporte-api-backup.war
scp -i ~/Project/Octle/aws/esporte_api.pem /Users/mukund.thakur/Project/Octle/Esporte/esporte-api/target/esporte-api.war ubuntu@52.77.244.46:~/.
ssh -i ~/Project/Octle/aws/esporte_api.pem ubuntu@52.77.244.46 cp esporte-api.war /opt/tomcat/apache-tomcat-7.0.65/webapps/
ssh -i ~/Project/Octle/aws/esporte_api.pem ubuntu@52.77.244.46 sudo sh /opt/tomcat/apache-tomcat-7.0.65/bin/shutdown.sh
ssh -i ~/Project/Octle/aws/esporte_api.pem ubuntu@52.77.244.46 sudo sh /opt/tomcat/apache-tomcat-7.0.65/bin/startup.sh
