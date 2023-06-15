# power-up-twilio

This microservice is in charge of managing SMS notifications to customers, using Twilio's API for its management:
ENDPOINT /twilio/notification/
This microservice is consumed by the employee by means of the subscriber microservice, the subscriber system is connected to this microservice and when actions are managed, these are reflected in this microservice when they depend on them.
This microservice is responsible for generating messages and verification codes and return them to the system so that the employee knows this information and saves in the database the verification code of their respective order, also, through the Twilio APi the system is responsible for making notifications to the customer's cell phone.
