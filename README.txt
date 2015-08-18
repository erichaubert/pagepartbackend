Instructions
===========
run main method in PageInputBoundary class using file path as the only argument
run 'gradlew eclipse' in the root project to generate project files for importing into a workspace

Questions
=========
-Is there a desire for page_parts to be removed?
-Is there a schema available for the xml?
-Why did the example not have quotes around the namespace attributes and the quotes around hashkey were not standard?

Comments
========
-My server backend would be a simple restful api if the document were being passed in directly instead of via file path.  This would allow me to spin up tomcat instances in my build to run some nice integration tests on my endpoint(likely using a derby/hsql in memory database)
-Using JPA to manage db updates for me instead of manual checks on xml content vs database content
-Assumed that the input is valid or errors are thrown by database for missing fields.  Would consider using some kind of bean validation on the input layer to throw meaningful errors(easier in a container).
-Written without a container for simplicity.  In a production scenario, I would be injecting the EM from a container and not manage my own transactions.
-With more time, I would add integration tests using a secondary persistence unit.  I would run all entity manager tests using a test PU.  If the mappings were more complicated I would be more concerned with extracting them and testing with more rigor.
-With a couple more queries on the existing objects, I would start to build controllers (PageEntityController).  These would manage entity specific business logic.
-Would probably want to make a base entity class if all DB tables are going to share the same created and updated date behavior.