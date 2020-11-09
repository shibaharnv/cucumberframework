Feature: Feaure to test email functionality


@Aconexemailtest
Scenario Outline: Validate the send email functionality with valid credentials

Given Open the aconex application
When login into the application with valid "<username>" username and "<password>" password
And  Navigate to blank mail section through page mail
And  Enter the required fields in mail page
And  Set the receipient by clicking on directory button and navigate to global tab
And  Search for groupname and familyname and click on the ok button
And  Click on send button
Then Verify if the mail is sent as per the standard practices

Examples:

|username|password|
|poleary|ac0n3x72|

@Aconexuploaddoctest
Scenario Outline: Verify document upload search and save the search

Given Open the aconex application
When login into the application with valid "<username>" username and "<password>" password
And  Navigate to documents and upload a new document
And  Enter the required fields and upload a document and verify and close
Then Navigate to document register and search for the document and save and display it

Examples:

|username|password|
#|nichol.kilback|iuy837lq2bi3a1|
|poleary|ac0n3x72|
