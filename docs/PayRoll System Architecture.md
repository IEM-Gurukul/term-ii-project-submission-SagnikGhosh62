\# Project Architecture: Multi-Tiered Employee Payroll Manager

                     \+----------------------+  
                     |      Employee        |   \<\<abstract\>\>  
                     \+----------------------+  
                     | \- id: String         |  
                     | \- name: String       |  
                     | \# baseSalary: double |  
                     \+----------------------+  
                     | \+ calculateSalary()\* |  
                     | \+ getId()            |  
                     | \+ getName()          |  
                     \+-----------▲----------+  
                                 |  
                \+----------------+----------------+  
                |                                 |  
     \+----------------------+          \+----------------------+  
     |   FullTimeEmployee   |          |   PartTimeEmployee   |  
     \+----------------------+          \+----------------------+  
     | \- bonus: double      |          | \- hourlyRate: double |  
     |                      |          | \- hoursWorked: int   |  
     \+----------------------+          \+----------------------+  
     | \+ calculateSalary()  |          | \+ calculateSalary()  |  
     | \+ toCsvRow()         |          | \+ toCsvRow()         |  
     \+----------------------+          \+----------------------+

                     \+----------------------+  
                     |      ConsoleView     |  
                     \+----------------------+  
                     |                      |  
                     \+----------------------+  
                     | \+ showMenu()         |  
                     | \+ displayMessage()   |  
                     | \+ displayHeader()    |  
                     \+----------------------+

                     \+----------------------+  
                     |   PayrollController  |  
                     \+----------------------+  
                     | \- employees: List    |  
                     | \- FILE\_PATH: String  |  
                     \+----------------------+  
                     | \+ addEmployee()      |  
                     | \+ getEmployees()     |  
                     | \+ saveToDatabase()   |  
                     \+----------------------+

                     \+----------------------+  
                     |         Main         |  
                     \+----------------------+  
                     |                      |  
                     \+----------------------+  
                     | \+ main(String\[\] args)|  
                     \+----------------------+  
                     | Uses ConsoleView     |  
                     | Uses Controller      |  
                     | Logic Flow Orchestrator|  
                     \+----------------------+

\#\# Architecture Description  
The system follows a layered object-oriented architecture:

1. 1\. *Model Layer*: Contains the \`Employee\` abstract class and specialized subclasses (\`FullTime\` and \`PartTime\`) which implement different fiscal logic\[cite: 215, 231\].  
2. 2\. *Controller Layer*: The \`PayrollController\` manages the collection of employees and handles persistent storage (CSV File I/O)\[cite: 240, 241\].  
3. 3\. *View Layer*: \`ConsoleView\` handles all user interactions and console formatting\[cite: 242\].  
4. 4\. *Execution Layer*: \`Main\` serves as the entry point, coordinating the flow between the user and the system components\[cite: 59, 89\].

