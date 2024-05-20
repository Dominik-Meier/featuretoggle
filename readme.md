# Feature toggle project
Assignment for Swisscom of a feature toggle web application.
The application contains a Backend (Spring-Boot) & Frotnend (Angular).
Both can be served locally.


# Assumptions:
* **When is a feature toggle for a customer active?** 1. Toggle is not `expired`. 2. When the `customerId` is in the `custoderIds` List. `Inverted` is false. The evaluatuion is done in the following order `expired` -> `customerId` -> `inverted`.
* **Why is there an `archived` flag?** As not shown in the entity but requested as a function it is assumed that the `archived` flags is existing. 
* **What does `archived` do?** Currently nothing as the use case is not clear.
* **What is a `customerId`?** `customerId` is just an `id` with no relation to any furhter information. In case that the feature toggle service needs to associate more information with a `customerId`, like a name, it would be better to create a own customer table and create a relationship between both.

# General informations
* There are many TODOs to improve the code & features the list of TODOs is not complete