Feature: Feaure to document upload


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
