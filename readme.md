# Feature toggle project
Assignment for swisscom of a feature toggle web application.
The application contains a Backend (Spring-Boot) & Frotnend (Angular).
Both can be served localy.


# Assumptions:

* **When is a feature toggle for a customer active?** 1. Toggle is not expired. 2. When the `customerId` is in the `custoderIds` List. `Inverted` is false. The evaluatuion is done in the following order expired -> `customerId` -> inverted 
* **What is the `archived` flag?** As not shown in the enity or somewhere else it is assumed that this flags is existing as well. 
* **What does `archived` do?** Currently nothing as the use case is not clear.
* **What is a `customerId`?** `customerId` is just an `id` with no relation to any furhter information. In case that the feature toggle service needs to associate more informations with a `customerId` like a name a new it would be better to create a own customer table and create a relationship between both.