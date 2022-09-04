FROM maven:latest as stats-builder
ENV APPDIR /usr/local/app
RUN mkdir $APPDIR
LABEL "author"="rados" \
    "language"="java" \
    "buildtool"="maven"
WORKDIR $APPDIR
COPY . $APPDIR
RUN mvn clean package

FROM eclipse-temurin@sha256:0459336ad1b561fa60e7f71ab00aba9039acf30e8d7e1b1ff883e1f8a6aaba95
LABEL "author"="rados" \
    "language"="java"
ENV APPDIR /usr/local/app
RUN mkdir $APPDIR
WORKDIR $APPDIR
COPY --from=stats-builder $APPDIR/target/stats-service.jar $APPDIR
EXPOSE 8083
CMD ["java", "-jar", "stats-service.jar"]
