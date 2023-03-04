# Pets-Care-Management-System
This project is Pet Shop Management System; it is written in Java and connected to the Apache Derby database for storing and retrieving information. It is designed with many interfaces made by the NetBeans API. This system serves three types of users, which are: (Admin, Employee, and Customer). Each type of user has its own interfaces and functionalities.

# The Basic Functionalities
All IDs Field is filled automatically

## Admin: 
* Manage Employee 
* Manage Pets 
* Manage Food 
* Manage Supplies


**Note:**
* The admin has the ability to add, edit, and remove information on the records.
* All Information is retrieved from the database, and any changes will reflect on it.
* While editing, adding, or removing products the changes will reflect automatically on the products menu.


## Employee: 
* Manage Customers
* Manage Orders

**Note:**
<br>
* The employee has the ability to add, edit, and remove information on the records.
* All Information is retrieved from the database, and any changes will reflect on it.
* For manage order, specific customer ID can be searched to facilitate the search process.

## Customer: 
* Sign-up to The System
* Log-in to The System
* View The Menu
  * If The Product is Out of Stock, Will Not Show in The Menu
* Read About The Shop's Information or Watch a Video
* Add and Edit to The Cart
  *  If Customer try to buy more than available stock, adding process will reject
* Receive An Email With The Order Information
* View The Bill
* Print PDF Bill
* Rate The Shop Services
