# VisitorObserverPattern
To implement word count "wc" command using Visitor and Observer pattern in Java

Design and develop the following 2 visitors:
A visitor (Populate Visitor) that reads an input file, input.txt, and populates a data structure with all the words in the file.
Use a data structure that will maximize performance for the second visitor. Store the words in the data structure using the insert
criteria for that data structure.

A second visitor (Word Count) that counts the number of words, number of distinct words, and number of characters 
(NOT distinct characters) stored by the data structure, and then stores it in a file named output.txt. Total number 
of characters should not take whitespaces into account.

Also,If the input has the following words: the the the quick brown fox jumps jumps over the lazy dog , then the number 
of distinct words is 8, as the rest are repeated words.

A third visitor (Clone-and-Observe-Visitor) that clones the data structure so that it can be used as a backup. 
You should setup the observer pattern's subject and listener relationship as part of the implementation of this visitor.
Use the observer pattern, so that whenever any word is modified in the original data structure, the corresponding element
(or whatever is used to store the word) of the backup data structure is notified and updated. You will be graded on how
fine grained you can keep the updates. So, do not update the entire data structure, each time.
The second visitor is supposed to be specialized in extracting information such as word count, etc. from the data structure. 
The first visitor should not do any work for the second visitor. So, you CANNOT use a separate data structure,
outside the original data structure, to keep track of the word count. It is also NOT acceptable to keep a running 
count while populating the original data structure. So, your performance should depend on the choice of data structure,
choice of data structure within each node/element to store information, and traversal through the data structure to 
calculate the total number of words, distinct words, and characters.
