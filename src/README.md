# D287 Java Frameworks Web-Based Spring Inventory

Below are descriptions of where in the code to find the changes made in Task 1 parts C to J.

## Part C.  
Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
File changes: 
#### mainscreen.html
line 22, 23 - Changed shop name and gave it a tag, centered it with bootstrap  
line 27 - Changed part name  
line 62 - Changed product name  
line 13 - Added link to stylesheet  
line 14 - Changed title of page  
line 19 - Added header for background image  
line 31, 33, 36, 37, 52, 53, 66, 68, 76, 91, 92 - Added button class for styling  
line 59 - Added break row  
#### InhousePartForm.html
line 6-8 - Added bootstrap and css links  
line 14 - added container  
line 15 - added header  
line 16 - centered title  
line 32 - added class to button for styling  
line 36 - changed 'Link to main screen' to 'Return to main screen' and gave it a class for styling  
#### OutsourcedPartForm.html
line 6-8 - Added bootstrap and css links  
line 14 - added container  
line 15 - added header  
line 16 - centered title  
line 33 - added button classes  
line 35 - added class to return link and changed text to "return to main screen"  
#### productForm.html
line 7-9 - Added bootstrap and css links  
line 15 - added container  
line 16 - added header  
line 17 - centered title  
line 34, 53, 73 - added classes to button  
#### styles.css
line 1-3 - Added background color  
line 5-13 - Added header image  
line 15-17 - Added header padding  
line 19-29 - Added button styles  
line 31-33 - Added table styles  
line 35-37 - Changed return link color  
line 39-41 - Changed subheading font style to italic  
#### confirmationaddpart.html
line 7 - Added stylesheet link
#### confirmationaddproduct.html
line 7 - Added stylesheet link
#### confirmationassocpart.html
line 7 - Added stylesheet link
#### confirmationdeletepart.html
line 7 - Added stylesheet link
#### confirmationdeleteproduct.html
line 7 - Added stylesheet link
#### negativeerror.html
line 6 - Added stylesheet link
#### saveproductscreen.html
line 6 - Added stylesheet link

## Part D. 
Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
#### about.html
line 1-15 Added head information with thymeleaf, bootstrap, css links  
line 14 - Added title  
line 19-25 - Copied in container, header image, title and subheading from mainscreen.html  
line 27-32 - Added paragraph describing the guitar shop  
line 35-36 - Added button to return to main screen  
line 35-37 - Added div to center and space the button  
#### AboutController.java
line 6 - Added @Controller annotation to the class  
line 11 - Added @GetMapping to route the /about webpage request  
line 12-14 - Added method to return about.html template when url is /about  
#### styles.css
line 43-48 - Added styles to about page link on mainscreen  
line 50-53 - Added styles to about page link on mainscreen when hovered over  
line 55-57 - Added padding to navbar on mainscreen  
line 59-62 - Added padding to return to mainscreen button on about page  
#### mainscreen.html
line 24-26 - Added navbar with link to about page

## Part E. 
Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
#### BootStrapData.java
line 45-87 - Added a sample inventory of 5 parts with an if statement to avoid duplicates  
line 110-125 - Added a sample inventory of 5 products with an if statement to avoid duplicates
#### application.properties
line 6 - renamed database

## Part F. 
Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
* The “Buy Now” button must be next to the buttons that update and delete products.  
#### mainscreen.html
line 97 - Added "Buy Now" button
#### styles.css
line 25-30 - Added styles for "Buy Now" button
line 37-42 - Added styles for "Buy Now" button on hover  

* The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.  
#### AddProductController.java
line 193-201 - Added code to decrement inventory of product by one  

* Display a message that indicates the success or failure of a purchase.  
#### AddProductController.java
line 177-206 - Added mapping and code to buyProduct method that returns success.html or failure.html
#### Failure.html
line 15 - Shows a failure message if the inventory was 0 when "Buy Now" clicked
#### Success.html
line 15 - Shows a success message if they successfully bought a product

## Part G.
Modify the parts to track maximum and minimum inventory by doing the following:
* Add additional fields to the part entity for maximum and minimum inventory.
* Modify the sample inventory to include the maximum and minimum fields.
* Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
* Rename the file the persistent storage is saved to.
* Modify the code to enforce that the inventory is between or at the minimum and maximum value.
#### application.properties
line 6 - Changed database name
#### BootStrapData.java
line 49-50, 59-60, 69-70, 79-80, 89-90 - Added sample max and min inventory values
#### InhousePartForm.html
line 16 - Changed heading  
line 24-27, 30-33, 36-39 - Added floating label to field  
line 41-45 - Added minimum inventory field to the form  
line 47-51 - Added maximum inventory field to the form
#### mainscreen.html
line 47-48, 57-58 - Added min and max inventory fields to table on mainscreen
#### OutsourcedPartForm.html
line 25-28, 31-34 - Added floating label to field  
line 37-41 - Added minimum inventory field to the form  
line 43-47 - Added maximum inventory field to the form
#### Part.java
line 36-37 - Added minInv variable  
line 39-40 - Added maxInv variable  
line 103-115 - Added getters and setters for minInv and maxInv


## Part H.
Add validation for between or at the maximum and minimum fields. The validation must include the following:
* Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
* Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
* Display error messages when adding and updating parts if the inventory is greater than the maximum.
#### InventoryValidator.java
line 19-47 - Created new validator to display error messages when updating parts
#### ValidInventory.java
line 16-24 - Created interface for InventoryValidator
#### InhousePartForm.html
line 53-57 - Added capability to show validation errors
#### OutsourcedPartForm.html
line 51-55 - Added capability to show validation errors
#### Part.java
line 23 - Added annotation @ValidInventory to Part Entity
#### EnufPartsValidator.java
line 38-41 - Added logic to display error message for adding and updating products
#### ValidEnufParts.java
line 20 - Added text "low inventory" to error message

## Part I
Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
#### PartTest.java
line 160-176 - Added getMinInv() and getMaxInv() unit tests

## Part J
Remove the class files for any unused validators in order to clean your code.
#### DeletePartValidator.java
Removed class file