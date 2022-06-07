## Module 1 Capstone - Taste Elevator CaTEring Corp

You've been asked to develop an application for a catering(food) distributor,
Taste Elevator CaTEring Corp. Customers purchased food items from the catering machine and are charged accordingly.

### Application Requirements

1. The CaTEring machine dispenses munchies, sandwiches, drinks, and desserts.
   - Each item has a Name and a Price.
2. A main menu must display when the software runs, presenting the following options:
    > ```
    > (D) Display caTEring Items
    > (P) Purchase
    > (E) Exit
    > ```
3. The inventory is stocked via an input file when the application starts.  **2 different files are provided, make sure your program will work with either one.**
4. Each time the application runs, the inventory is restocked.  The only time the inventory is stocked is when it is started.
5. When the customer selects "(D) Display caTEring Items", they're presented
   with a list of all items in the machine with its quantity remaining:
   
    - Each item has a slot identifier and a purchase price.
    - Each slot has enough room for 7 of those items.
    - Every item is initially stocked to the maximum amount.
    - An item that has run out must indicate that it is NO LONGER AVAILABLE.
6. When the customer selects "(P) Purchase", they are guided through the purchasing
   process menu:
   
    >```
    >(M) Feed Money
    >(S) Select Item
    >(F) Finish Transaction
    >
    > Current Money Provided: $2.00
    >```
7. The purchase process flow is as follows:
    1. Selecting "(M) Feed Money" allows the customer to repeatedly feed money into the
       machine in valid, whole dollar amounts—for example, $1, $5, $10, or $20.
        - The "Current Money Provided" indicates how much money the customer
        has fed into the machine.
    2. Selecting "(S) Select Item" allows the customer to select an item to
       purchase.
        - Show the list of items available and allow the customer to enter
        a slot identifier to select an item.
        - If the item (slot identifier) does not exist, the customer is informed and returned
        to the Purchase menu.
        - If an item is NO LONGER AVAILABLE, the customer is informed and returned to the
        Purchase menu.
        - If a valid item is selected, it is dispensed to the customer.
        - Dispensing an item prints the item name, cost, and the money
        remaining. Dispensing also returns a message:
          - All munchy items print "Munchy, Munchy, so Good!"
          - All sandwich items print "Sandwich So Delicious, Yum!"
          - All drink items print "Drinky, Drinky, Slurp Slurp!"
          - All dessert items print "Sugar, Sugar, so Sweet!"
        - After the item is dispensed, the machine must update its balance
        accordingly and return the customer to the Purchase menu.
    3. Selecting "(F) Finish Transaction" allows the customer to complete the
       transaction and receive any remaining change.
        - The customer's money is returned using nickels, dimes, quarters, and dollars (single dollars)
        (using the smallest amount of dollars and coins possible).
        - The machine's current balance must be updated to $0 remaining.
    4. After completing their purchase, the user is returned to the "Main" menu to
    continue using the caTEring machine.
8. All purchases must be audited to prevent theft by creating a Audit file:
   - Each purchase must generate a line in a file called `Audit.txt`.
   - The audit entry must be in the format:
        >```
        > 01/01/2016 12:00:00 PM MONEY FED:         $5.00 $5.00
         >01/01/2016 12:00:15 PM MONEY FED:         $5.00 $10.00
         >01/01/2016 12:00:20 PM Bruschetta     B4 $10.00 $8.50
         >01/01/2016 12:01:25 PM Turkey Sandwich B2 $8.50 $7.50
         >01/01/2016 12:01:35 PM CHANGE GIVEN:      $7.50 $0.00
         >```
9. Create as many of your classes as possible to be "testable" classes. **Limit console**
**input and output to as few classes as possible**.
10. Optional - Sales Report
    - Provide a "Hidden" menu option on the main menu ("S") that writes to a sales
    report that shows the total sales since the machine was started. The name of the
    file must include the date and time so each sales report is uniquely named.
    - An example of the output format is provided below.
11. Provide unit tests demonstrating that your code works correctly.
___
### CaTEring Data File
The input file that stocks the items is a comma separated values file (csv). Each line is a separate item in the file and follows the below format:

 Column Name   | Description 
----------------|-------------
 Slot Location | The slot location in the machine where the item is set. 
 Item Name | The display name of the item.                
 Price         | The purchase price for the item.                             
 Type          | The item type for this row.                                 

For example:

```
A1,NACHOS,3.85,Munchy
A1,WALKING TACOS,4.55,Sandwich
B2,TURKEY SANDWICH,5.35,Sandwich
D1,CHOCOLATE BAR,3.75,Dessert
```

An input file has been provided for testing with your repository: `catering.csv`.

---
### Sales Report
The output sales report file is a comma separated values (csv) file. Each line is a separate item with the number of sales for the applicable item. At the end of the report is a blank line followed by the **TOTAL SALES** dollar amount indicating the gross sales from the caTEring machine.

**Example Output**

>```
>Nachos,10
>Popcorn,3
>Turkey Sandwich,0
>Mountain Melter,50
>7Down,23
>Chewy Bar,2
>Walking Tacos,1
>Gum,3
>Ginger Ayle,4
>Veggie Wrap,8
>Papsi,9
>Chocolate Bar,12
>Chippos,11
>Caramel Bar,6
>Burrito,4
>Preengles,2
>```
