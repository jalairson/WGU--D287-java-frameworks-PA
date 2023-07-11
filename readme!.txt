work log
========

C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.


- [mainscreen.html] (line 14) : changed "shop page" header to read "Computer Electronics" -

============================================================================================================================================================================

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.


- [about.html] (lines 1 - 19) : CREATED and filled with placeholder text -

- [mainscreen.html] (line 90) & [about.html] (line 16) : added links -

- Created [AboutController.java] class (lines 1 -17) -

============================================================================================================================================================================

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.


--- edited [BootStrapData.java] (lines 56 - 122) to add a hardcoded sample inventory of parts and products ---

============================================================================================================================================================================

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•   The “Buy Now” button must be next to the buttons that update and delete products.
•   The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•   Display a message that indicates the success or failure of a purchase.


- added "Buy Now" buttons to [mainscreen.html] (line 82) -

- [mainscreen.html] added page breaks (line 90) for visual clarity -

- CREATED new html files [purchasesuccessful.html] and [purchasefailed.html] - 

- CREATED [BuyController.java] (lines 1 - 42) -

============================================================================================================================================================================

G. Modify the parts to track maximum and minimum inventory by doing the following:
•   Add additional fields to the part entity for maximum and minimum inventory.
•   Modify the sample inventory to include the maximum and minimum fields.
•   Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•   Rename the file the persistent storage is saved to.
•   Modify the code to enforce that the inventory is between or at the minimum and maximum value.


- added minimum and maximum inventory to part domain in [Part.java] (lines 33 - 38 & lines 60 - 83) including constructor with min and max -

- edited [BootStrapData.java] sample inventory to include min and max inventory values (lines 56 - 122) -

- added minimum and maximum inventory as fields in [InHousePartForm.html] (lines 26 -30) & [OutsourcedPartForm.html] (lines 27 -31) -

- renamed persistent storage db file to generate new db [jdbc:h2:file:~/spring-boot-h2-db103] -

- added minimum and maximum inventory controls to [Part.java] (lines 29 -33) -

- altered [AddInhousePartController.java] (lines 37 - 40) and [AddOutsourcedPartController.java] (lines 41 - 44) to reject new parts with parameters outside of minInv and maxInv -

============================================================================================================================================================================

H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
•   Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•   Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•   Display error messages when adding and updating parts if the inventory is greater than the maximum.

- created validator [InventoryValidator.java] (44 lines) and annotation [ValidInventory.java] (19 lines) to validate inventory with minInv and maxInv to produce an error message -

- updated html in [InhousePartsForm.html] (line 7) and [OutsourcedPartsForm.html] (line 7) to use auxiliary stylesheet -

- added (lines 9-11) to [productForm.html] importing the same stylesheet -

- edited [EnufPartsValidator.java] (lines 12 - 38) and [ValidEnufParts.java] (line 14) to include displaying error message when updating parts lowers inventory below minInv -

============================================================================================================================================================================

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

- added (lines 104 - 120) in [PartTest.java] to unit test minInv and MaxInv values -

============================================================================================================================================================================

J.  Remove the class files for any unused validators in order to clean your code.

- removed comments and extraneous import lines; THERE ARE NO UNUSED VALIDATOR CLASSES -