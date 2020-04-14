FROM azul/zulu-openjdk-alpine:11-jre

LABEL author="Dhiego Duarte"
LABEL email="Dhiego.Duarte.terceiros@claro.com.br"
LABEL company="Claro BR"
# same version in jar file 
LABEL version="1.0.0.RELEASE" 

RUN addgroup -g 3000 ratings-data-service-group

RUN adduser -D -g '' -G ratings-data-service-group -u 1000 ratings-data-service-user

USER ratings-data-service-user

WORKDIR /home/ratings-data-service-user

COPY --chown=ratings-data-service-user:ratings-data-service-group target/ratings-data-service-1.0.0.RELEASE.jar /home/ratings-data-service-user

EXPOSE 8083

ENTRYPOINT ["/usr/bin/java", "-jar"]

CMD ["ratings-data-service-1.0.0.RELEASE.jar"]

