# First stage: complete build environment
FROM maven:3.8.6-eclipse-temurin-11-alpine AS builder
RUN apk add --update nodejs npm
RUN mkdir -p /app
WORKDIR /app
# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/
ADD ./frontend frontend/
# package jar
RUN mvn clean verify -DskipTests

# Second stage: minimal runtime environment
From eclipse-temurin:11-jre-alpine

# copy jar from the first stage
COPY --from=builder /app/target/aadhaar.jar /app/aadhaar.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/aadhaar.jar"]