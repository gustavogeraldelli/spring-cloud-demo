### 1. Start the containers

```bash
docker compose up -d
```

### 2. Configure RabbitMQ
- `http://localhost:15672` (user: `guest`, pass: `guest`)`
- Create a new queue with name `card-issuance`
- Bind this queue to the `amq.fanout` exchange

### 3. Configure Keycloak
- `http://localhost:8081`

### 4. Running the services

#### Local 
For local development, start services from the IDE. The default profile (using localhost) will be active. RabbitMQ and Keycloak containers must be running.

#### Containerized
The `Dockerfiles` are set up to activate the Spring `prod` profile, ensuring proper communication between the containers.
```bash
# build each dockerfile
docker build -t eureka-svc eurekaserver
docker build -t api-gateway api-gateway
docker build -t client-ms client-ms
docker build -t card-ms card-ms
docker build -t credit-ms credit-ms

# create a network
docker network create cloudnetwork 

# run the containers with correct names for references
docker run --name eureka-svc -p 8761:8761 --network cloudnetwork -e ADMIN_USERNAME=adm -e ADMIN_PASSWORD=adm eureka-svc
docker run --name api-gateway -p 8080:8080 --network cloudnetwork -e KEYCLOAK_HOST=keycloak -e EUREKA_SERVER=eureka-svc api-gateway
docker run --name client-ms --network cloudnetwork -e EUREKA_SERVER=eureka-svc -e ADMIN_USERNAME=adm -e ADMIN_PASSWORD=adm client-ms
docker run --name card-ms --network cloudnetwork -e RABBITMQ_HOST=rabbitmq -e EUREKA_SERVER=eureka-svc -e ADMIN_USERNAME=adm -e ADMIN_PASSWORD=adm card-ms
docker run --name credit-ms --network cloudnetwork -e RABBITMQ_HOST=rabbitmq -e EUREKA_SERVER=eureka-svc -e ADMIN_USERNAME=adm -e ADMIN_PASSWORD=adm credit-ms
```
