# budgetMaker

============================
Personal Budget Builder
Edward Shen and Tommy Li, Period 2
============================

Summary:
The budget builder allows the user to modify and create budgets that allow them to keep track of their expenses in one place. Storing the budget in a tree proved useful due to the node's ability to have multiple children, allowing expenses to be catagorized rather easily.

----------------------------
ChangeLog
----------------------------
May 23 - Create repository,  Wrote basic monthly budget builder class, expense builder and expense class, added add method

May 26 - Add Tommy as Contributor

May 27 - Add budgetGrabber class

May 29 - Add Execute, Control, budgetTree and treeNode class

June 06 - Changed expense storage into tree format

June 07 - Make the config java file

June 08 - Make the config text file

June 09 - Finished Config.java and started creating a function to read the config string

June 10 - Continue to write the config string decoder function

June 11 - Debugged and found "|" to break the String split function, fixed traverse function to print all parent nodes, integrated budgetTree and config java files, begin work on budgetGrabber file

June 12 - Continued to debug and work on the driver to bring everything together

June 13 - Overhauled driver and continued to work on the writing and printing functionalities

June 14 - Fine tuned the file creation and reading functions of the budgetGrabber class, and work on Driver

June 15 - Cleaning up execute and control.

----------------------------
To Be Changed/Implemented
----------------------------
- Store Income with a Tree
- Finish Execute and Control class
- Add remove functions (for category and item changes)
- Write write function in budgetGrabber
- Find a way to print out the tree nicely to allow the user to visualize their budget

----------
Problems:
----------
- The driver file - how to get the user to visualize their budget
- Budget Editing functionality - allowing the user to modify a current budget
- Combining Expenses and monthly budget so they work together
- Making the code efficient (removing the need for multiple nested loops)

