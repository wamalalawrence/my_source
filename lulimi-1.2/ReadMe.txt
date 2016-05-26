Logging files located outside the application:
${USER_HOME}/${app.name}/${app.name}.log
/var/log/${app.name}/logback-production.xml

Run example:
sudo java -jar target/lulimi.war --spring.profiles.active=development

