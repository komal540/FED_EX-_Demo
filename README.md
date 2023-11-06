#FED EX Demo Backend Developer  The assignment is to develop a logistics company's inventory tracking system. You may find project details here.

Project Description
This is a Dummy project of FED EX logistics system for tracking inventory that has CRUD capabilities and the ability to load all inventory data into a CSV file.
Java was used to build the project using SpringBoot.

#Prerequisites

Java 11
Maven
PostMan
MySQL
##To build

mvn clean install


#Rest API Usage

##Find Main Store Item

GET http://localhost:8080/FEDEXMainScreen
#####Parameter

{
"productName": "Skirts",
"brand": "Nike",
"productCategory": "Woman",
"price": "2000"
}
##Response ####200 OK on successful request

{
"id": "Long",
"productName": "String",
"brand": "String",
"productCategory": "String",
"price": "Double",
"createdAt": "ISO 8601 timestamp",
"updatedAt":"ISO 8601 timestamp"
}
##Find  Inventory BY iD

POST http://localhost:8080/showPartFormForUpdate?partID=2
#####Parameter

Inventory Id: Provide the id of the inventory
##Response ####302 FOUND on successful request

[
{
"id": "Long",
"productName": "String",
"brand": "String",
"productCategory": "String",
"price": "Double",
"createdAt": "ISO 8601 timestamp",
"updatedAt":"ISO 8601 timestamp"
}
]
##Delete Inventory

DELETE http://localhost:8080/deletepart/partID=2
#####Parameter

Inventory Id
##Response ####200 Ok on successful request

##Update Inventory Item

PATCH http://localhost:8080/showPartFormForUpdate?partID=2
#####Parameters Path Parameter: id

{
"productName": "String",
"brand": "String",
"productCategory": "String",
"price": "Double"
}
##Response ####200 OK on successful request

#ERROR http://localhost:8080/errorPage
