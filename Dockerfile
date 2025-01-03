
FROM maven:3.8.6-openjdk-11
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn clean install
CMD ["mvn", "test"] 