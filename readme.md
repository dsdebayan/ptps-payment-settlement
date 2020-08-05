# Currency Exchange Micro Service - H2

## Run application in Eclipse
1. Run com.cde.microservices.currencyconversionservice.CurrencyConversionServiceApplicationH2 as a Java Application.
2. check http://localhost:8000/currency-exchange/from/USD/to/INR
3. stop application

## H2 Console
- http://localhost:8000/h2-console
- Use `jdbc:h2:mem:testdb` as JDBC URL

## Containerization

### Creating and running Container in local vm using docker
1. cd C:\Users\dsaha\eclipse-workspace\currency-exchange-service
2. mvn clean install
3. docker image ls
4. docker network create currency-network
5. docker container run --publish 8000:8000 --network=currency-network --name=currency-exchange dsdebayan/currency-exchange:0.0.1-RELEASE
6. docker container ls
7. check http://localhost:8000/currency-exchange/from/USD/to/INR
8. docker container stop [image]
9. docker container rm [image]
10. docker container prune
11. docker image rm [image]

### push image to docker hub
1. docker login
2. docker push dsdebayan/currency-exchange:0.0.1-RELEASE


##Deploy in kubernetes
1. kubectl apply -f deployment.yaml


## Auto Scaling

### Cluster Auto Scaling

```
gcloud container clusters create example-cluster \
--zone us-central1-a \
--node-locations us-central1-a,us-central1-b,us-central1-f \
--num-nodes 2 --enable-autoscaling --min-nodes 1 --max-nodes 4
```


### Horizontal Pod Auto Scaling

```
kubectl autoscale deployment currency-exchange-service --max=3 --min=1 --cpu-percent=50
```