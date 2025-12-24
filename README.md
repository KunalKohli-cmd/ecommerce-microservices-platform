# ecommerce-microservices-platform


E2E design-develop- deploy

- Auth Service
  1) Responsible for Authentication JWT creation logic user creation, Roles Management etc

 - API Gateway
   1) Responsible for routing to different microservice,
   2) Responsible for JWT validation
   3) Responsible for load balancing
   4) Need to implement rateLimiting
  
- Product Service
    1) Responsible for managing products data
    2) Create, show and delete products.

 - Order Service
   1) Responsible for creating orders from Product service
   2) Responsible to publish messages to notification service

   - Notification Service
       Yet to add

   - Inventory Service
       Yet to add
       Order service at time of order checks inventory if inventory does not have the item then cancel or revert order
