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