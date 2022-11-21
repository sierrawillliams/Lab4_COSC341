# Lab4_COSC341
Lab 4: Android Internal Storage and File Operations (20 marks) 
The purpose of this lab is to get yourself familiar with Android internal storage and file operations. 

Configuration note: 
When  you  create  your  app  on  Android  Studio,  be  sure  to  select  the  option  "Phone  and  Tablet".  
Assignments will be marked using an Android Virtual Device (AVD) running a Pixel 3a with API 33. You 
must  use  Android  Studio  (with  Java  as  the  programming  language),  which  the  TAs  will  use  to  load,  
build, and run your code. 

Submission note: 
Upload a zip file containing the following folders to Canvas: Code and APK.  
- The Code folder should include the corresponding Android code.  
- The APK folder should only contain one .apk file.  
 
You will implement an Android application which includes the following screens: 

Main Screen [2 marks] 
Your application should have a Main screen. This screen includes: 

UI requirements [1 mark] 

[0.5] A button showing the text “Read Data”.  
[0.5] A button showing the text “Write Data”.  

Functional requirements [1 mark] 

When a user clicks on the 
[0.5] “Write Data” button, the app opens the Write Data screen described in the next section. 
[0.5] “Read Data” button, the app opens the Read Data screen described later. 

Write Data Screen [8 marks] 

Your  application  should  include  a  Write  Data  screen.  Add  the  following  UI  components  to  allow  a 
student to enter their information: 

UI requirements [3 marks] 

- [0.5] An edit text widget to enter an 8-digit student number  
- [0.5] An edit text widget to enter the last name  
- [0.5] Another edit text widget to enter the first name  
- [0.5] Radio buttons to enter gender information (At least two radio buttons) 
- [0.5] A dropdown list to select a division (at least three names, e.g., COSC, DATA, MATH should be on 
the list) 
- [0.5] A “Submit” button.  

Functional Requirements [5 marks] 

[2 marks] If the student doesn’t provide an 8-digit student number or doesn’t enter the first and last 
name, show a Toast message asking to provide the correct information.
[3 marks] Once the user clicks on the submit button, the program will write the information/record 
(i.e.,  Student  ID,  Last  Name,  First  Name,  Gender,  Division)  into  a  file  (i.e.,  data.txt),  separated  with  
commas (e.g., 12345678,hasan,khalad,Male,COSC). Additionally, each new record should be written in 
a new line (you can use “\n” to write a new record in a new line). Once the information/record is written 
to the file, the program will return to the Main Screen. This should be done using the finish() method, 
which will close the activity and return to the previous activity. While it is possible to return to the main 
screen by starting it as a new activity, this may result in a stack of activities.

Read Data Screen [10 marks] 

Read Data screen will contain the following UI components: 

UI requirements [3 marks] 

- [0.5] A text view to show student number  
- [0.5] A text view to show the first name and the last name  
- [0.5] A text view to show gender information  
- [0.5] Another text view to show a division  
- [0.5] Two buttons, “Previous” and “Next”  
- [0.5] A “Main Screen” button.  

Functional Requirements [7 marks] 

[2]  Initially,  the  program  will  show  the  first  record  (e.g.,  Student  Number:  12345678,  Name:  khalad  
hasan, Gender: Male, Division: COSC) from the file. Note that if there is no record in the file, a Toast or 
some other message should be used to inform the user that they need to add some records. 
[4] If the user presses the next or the previous button, it will show the next or previous record (if it’s 
the last record, pressing the next button would show the first record. Similarly, if it’s the first record, 
pressing the previous button would show the last record).  
[1] Additionally, clicking the Main Screen button would return to the main screen. This should be done 
by using a finish() method, not starting a new activity. 
