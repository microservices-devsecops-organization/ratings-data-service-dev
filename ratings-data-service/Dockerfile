FROM amd64/openjdk:8-jre-alpine3.9

LABEL author="Dhiego Duarte"
LABEL email="Dhiego.Duarte.terceiros@claro.com.br"
LABEL company="Claro BR"
# same version in jar file
LABEL version="0.0.001-SNAPSHOT" 

RUN apk --no-cache add -u musl=1.1.20-r5 \
    && apk --no-cache add -u libtasn1=4.14-r0 \
    && apk --no-cache add libjpeg-turbo=1.5.3-r5

RUN addgroup -g 3000 ratings-data-service-group
RUN adduser -D -g '' -G ratings-data-service-group -u 1000 ratings-data-service-user

USER ratings-data-service-user
WORKDIR /home/ratings-data-service-user

COPY --chown=ratings-data-service-user:ratings-data-service-group target/ratings-data-service-0.0.1-SNAPSHOT.jar /home/ratings-data-service-user

EXPOSE 8083

ENTRYPOINT ["/usr/bin/java", "-jar"]

CMD ["ratings-data-service-0.0.1-SNAPSHOT.jar"]

