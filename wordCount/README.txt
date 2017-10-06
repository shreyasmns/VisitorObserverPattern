
README FILE

PURPOSE: To implement word count "wc" command using Visitor and Observer pattern in Java.

FILES:
		------driver:
				  --Driver.java [Base Class]
		------bst:
				  --BST.java
				  --Node.java
				  --TreeInterface.java [Interface]
		------observer:
				  --ObserverInterface.java [Interface]
				  --SubjectInterface.java [Interface]
		------util:
				  --FileProcessor.java
				  --InputReaderInterface.java [Interface]
				  --Logger.java
				  --OutputWriterInterface.java [Interface]
		------visitors:
				  --BackupVisitor.java
				  --PopulateVisitor.java
				  --TreeUtil.java
				  --VisitorInterface.java [Interface]
				  --WordCountVisitor.java
				  
				  
SAMPLE OUTPUT:
=====================================================
Total Words      : 10123
Distinct Words   : 3152
Total Characters : 43475

Amortized Time of Operation : 8 mili seconds
=====================================================


TO COMPILE:
ant -buildfile build.xml all

NOTE: Please Place the Input file parallel to the src directory

TO RUN:
Navigate to directory where build.xml is present and run 

ant -buildfile build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=40

TO UN-TAR:
tar xvzf mahanthappa_shreyas_assign2.tar.gz

===================================================
Data Structure Used:
===================================================
1) ArrayList: Have used ArrayList to store references to all the Observers/Listeners
			   as it is easy to add, remove observers and amortized time of these operations is O(1)
			   
2) RandomAccessFile, FileChannel, MappedByteBuffer:  
			  Have Used the RandomAccessFile, FileChannel and MappedByteBuffer ie.e file.nio library 
			  for read and write operations as we can read the input file of 2GB in approximately 20ms.

			  
Sources referred : 
http://stackoverflow.com/questions/9046820/fastest-way-to-incrementally-read-a-large-file



			
