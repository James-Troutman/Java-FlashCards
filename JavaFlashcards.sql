start transaction;

drop table if exists flashcard;

create table flashcard (
flashcard_id serial,
term varchar(100) not null,
definition varchar(2000) not null);


insert into flashcard (term, definition) values ('abstract', 'a keyword used in a class or method definition, which specifies that the method/class is not going to be instantiated, but should be inherited by other methods or classes');
insert into flashcard (term, definition) values ('API', '(Application Programming Interface) the way to expose a set of pre-defined classes and interfaces to external clients to interact with them, without sharing the implementation details');
insert into flashcard (term, definition) values ('array', 'fixed-size collection of data of the same type, which can hold zero or more items');
insert into flashcard (term, definition) values ('autoboxing', 'automatic conversion between the primitive types and their corresponding object wrapper classes');
insert into flashcard (term, definition) values ('block', 'code between two matching open and close braces, which is the single logical unit of work inside the application');
insert into flashcard (term, definition) values ('boolean', 'a primitive type, holding only two values - true or false');
insert into flashcard (term, definition) values ('break', 'a statement used to exit a loop/switch statement/labeled block; the application continues execution with the statement immediately following the containing block;');
insert into flashcard (term, definition) values ('byte', 'primitive type of the size of 8 bits');
insert into flashcard (term, definition) values ('bytecode', 'the instruction set of the Java Virtual Machine, created from source files into bytecode by the compiler');
insert into flashcard (term, definition) values ('case', 'a keyword that defines a particular group of statements executed in a switch statement');
insert into flashcard (term, definition) values ('casting', 'conversion from one data type to another');
insert into flashcard (term, definition) values ('catch', 'the block of clode inside try/catch statement, responsible for handling exceptions');
insert into flashcard (term, definition) values ('char', 'a keyword used to declare a variable of single type character');
insert into flashcard (term, definition) values ('checked exception', 'an Exception that is caught at the compilation time, usually in the block or thrown in the method header');
insert into flashcard (term, definition) values ('class', 'the core type in Java that defines the implementation of a particular kind of object: it defines instance and class variables and methods, as well as specifies the interfaces it implements and the immediate superclass of the class, by default Object');
insert into flashcard (term, definition) values ('class method', 'a synonym of static class');
insert into flashcard (term, definition) values ('class variable', 'a synonym of a static field or a static variable');
insert into flashcard (term, definition) values ('classpath', 'an environment variable or a command-line argument indicating the path searched by the Java compiler and the runtime for class definitions');
insert into flashcard (term, definition) values ('comment', 'a piece of explanatory text ignored by the compiler');
insert into flashcard (term, definition) values ('compiler', 'a program used to translate source code into the code executed by a computer');
insert into flashcard (term, definition) values ('concurrency', 'the ability of a program to run several tasks in parallel, a primary feature of multithreading');
insert into flashcard (term, definition) values ('condition', 'a boolean expression controlling a conditional statement or loop');
insert into flashcard (term, definition) values ('constant', 'a final variable in Java, which means that the reference of it cannot be changed once initialized');
insert into flashcard (term, definition) values ('constructor', 'a method inside the class, which creates and initializes objects in it - needs to be public and names the same as the class');
insert into flashcard (term, definition) values ('continue', 'a keyword used to resume application execution at the end of the current loop');
insert into flashcard (term, definition) values ('declaration', 'statement that establishes an identifier and associates attributes with it, without necessarily reserving its storage or providing the implementation');
insert into flashcard (term, definition) values ('default', 'the optional destination used in a switch statement, when neither case statement mathces the requested behavior');
insert into flashcard (term, definition) values ('definition', 'a declaration that reserves storage (for data) or provides an implementation (for methods)');
insert into flashcard (term, definition) values ('else', 'keyword used in if/else condition statements, executed when the test condition is false');
insert into flashcard (term, definition) values ('encapsulation', 'the process of protecting the state of objects by defining its attributes as private and channeling access to them through accessor and mutator methods');
insert into flashcard (term, definition) values ('enum', 'Java keyword used to declare the enumerated type (whose values are a fixed set of constraints... Ex--> public enum Day {SUNDAY, MONDAY, TUESDAY, ...})');
insert into flashcard (term, definition) values ('exception', 'an exceptional circumstance preventing the program to continue working regularly (usually an error or bug)');
insert into flashcard (term, definition) values ('expression', 'combination of operands and operators which causes particular behavior and produces results');
insert into flashcard (term, definition) values ('extends', 'keyword used to define the inheritance of classes or interfaces');
insert into flashcard (term, definition) values ('field', 'a variable defined outside of all defined methods, but inside of the class; in other words, a member of a class');
insert into flashcard (term, definition) values ('final', 'Java keyword indicating that an entity is immutable, thus, you cannot change its reference during the program execution');
insert into flashcard (term, definition) values ('finally', 'a block in a try/catch statement executed when Java exception or runtime error occurred');
insert into flashcard (term, definition) values ('float', 'Java keyword used to define a floating point number variable');
insert into flashcard (term, definition) values ('for', 'Java control structure for loop execution');
insert into flashcard (term, definition) values ('garbage collection', 'the process by which the JVM automatically frees up unused memory');
insert into flashcard (term, definition) values ('global variable', 'a variable that is visible to all mehtods in the class');
insert into flashcard (term, definition) values ('hash code', 'a value used to provide an efficient way to map object and its location, returned by a hash function');
insert into flashcard (term, definition) values ('hash function', 'method used to produce hash code from any data of abitrary size to data of fixed size');
insert into flashcard (term, definition) values ('hexadecimal', 'a number represented by the base of 16');
insert into flashcard (term, definition) values ('HTML', 'HyperText Markup Language; a web content presentation language');
insert into flashcard (term, definition) values ('HTTP(S)', 'HyperText Transfer Protocol (Source); a protocol that defines all rules how the browser should communicate with a server');
insert into flashcard (term, definition) values ('identifier', 'a name of a class, variable, method or interface defined in the code by the developer');
insert into flashcard (term, definition) values ('if', 'a Java control structure used to choose if execution of further actions should continue or not');
insert into flashcard (term, definition) values ('immutable object', 'an object whose state or value is not changeable after creation');
insert into flashcard (term, definition) values ('implements', 'Java keyword used to indicate which interfaces are implemented by the current class');
insert into flashcard (term, definition) values ('import', 'statement used to enable the user of other classes or interfaces from different Java packages');
insert into flashcard (term, definition) values ('inheritance', 'feature of object-oriented programming, where classes contain all variables and methods defined in their supertypes');
insert into flashcard (term, definition) values ('interface', 'Java keyword used to define the collection of methods and constant values that can be furthermore implemented by other classes');
insert into flashcard (term, definition) values ('iteration', 'a single execution of a loop');
insert into flashcard (term, definition) values ('JAR', 'Java Archive is the default Java packaging mechanism to aggregate multiple files into one (similar to .zip)');
insert into flashcard (term, definition) values ('Java Core', 'provides the main features of Java, also named Java Standard Edition');
insert into flashcard (term, definition) values ('JDK', 'Java Development Kit, the environment and core libraries used to write Java programs');
insert into flashcard (term, definition) values ('JVM', 'Java Virtual Machine, the abstract machine where the compiled Java bytecode is executed');
insert into flashcard (term, definition) values ('local variable', 'a variable defined in the method body, visibly only inside it');
insert into flashcard (term, definition) values ('main method', 'the starting point for Java applications');
insert into flashcard (term, definition) values ('memory leak', 'a situation during program execution where memory that is no longer being used cannot be removed by the garbage collection as there is still reference to it; eventually leads to OutOfMemoryException');
insert into flashcard (term, definition) values ('method', 'a particular function implemented in a Java class');
insert into flashcard (term, definition) values ('module', 'group of program components, in Java the thats used for it is Package');
insert into flashcard (term, definition) values ('mutual recursion', 'this happens when two methods are calling each other recursively at the same time');
insert into flashcard (term, definition) values ('namespace', 'an area of the program defined by packages, with established certain visibility rules (e.g. private access, public access, etc.)');
insert into flashcard (term, definition) values ('native', 'a keyword indicating that particular method is not implemented in Java language itself, but in another programming language');
insert into flashcard (term, definition) values ('nested class', 'a class, which is implemented inside the body of the other class');
insert into flashcard (term, definition) values ('new', 'the operator used to create an instance of a class');
insert into flashcard (term, definition) values ('object', 'an instance of a particular class; also the core concept of OOP');
insert into flashcard (term, definition) values ('OOP', 'Object Oriented Programming - a primary paradigm in modern software developement, focused on objects as primitives, not the specific actions, each object is created/instantiated from a class');
insert into flashcard (term, definition) values ('operator precedence', 'the order of processing conditions or equations with the multiple operators, similar to the mathematical concept of order of operations');
insert into flashcard (term, definition) values ('overloading', 'using the same method name for various implementations, differentiated by parameters');
insert into flashcard (term, definition) values ('overriding', 'providing a different implementation of the original mehtod in its subclass');
insert into flashcard (term, definition) values ('package', 'a name for a grouping of classes and interfaces in a namespace');
insert into flashcard (term, definition) values ('primitive type', 'one of the following non-class variable type: boolean, byte char, double, float, int, long, or short');
insert into flashcard (term, definition) values ('private', 'Java modifier, used to specify that the visibility of a method or a variable, so they can be accessed only within its class');
insert into flashcard (term, definition) values ('protected', 'Java modifier that makes variables or classes accessible to all other elements in the same package');
insert into flashcard (term, definition) values ('public', 'Java modifier allowing external access to a particular variable or method');
insert into flashcard (term, definition) values ('recursion', 'a process where a method is invoked again from its existing call stack');
insert into flashcard (term, definition) values ('reflection', 'the ability of the code to inspect and manipulate other code in the same runtime process');
insert into flashcard (term, definition) values ('return', 'Java keyword used to finish the execution of the method and return data back to the caller');
insert into flashcard (term, definition) values ('scope', 'it determines the visibility of elements in the program, for example, local or global variables');
insert into flashcard (term, definition) values ('serialization', 'the process of encoding and decoding the objects to the stream of bytes, and vice-versa');
insert into flashcard (term, definition) values ('static', 'class member variable stored and accessed as a single instance for all objects of that class');
insert into flashcard (term, definition) values ('stream', 'a byte-stream of data sent from sender to receiver');
insert into flashcard (term, definition) values ('String', 'an instance of an immutable String class, containing zero or more Unicode characters');
insert into flashcard (term, definition) values ('super', 'a keyword allowing the access to members of a class inherited by the class in which it appears');
insert into flashcard (term, definition) values ('switch', 'a control structure with multiple cases');
insert into flashcard (term, definition) values ('synchronized', 'a control statement that guarantees single-access semantics in a multithreaded environment');
insert into flashcard (term, definition) values ('this', 'a statement that references the instance of the class where it appears');
insert into flashcard (term, definition) values ('throw', 'a statement used to throw an Exception');
insert into flashcard (term, definition) values ('try', 'a block of code that allows exceptions to be caught using a catch block');
insert into flashcard (term, definition) values ('unchecked exception', 'an error without handler defined in the program implementation, cannot be dealt with at compilation time');
insert into flashcard (term, definition) values ('Unicode', 'a 16-bit character set defined by ISO 10646, designed to make exchange and display of information easier across various languages');
insert into flashcard (term, definition) values ('URI, URL', 'Uniform Resource Identifier/Locator');
insert into flashcard (term, definition) values ('upcast', 'process of casting to super type - for example String to Object');
insert into flashcard (term, definition) values ('variable', 'an item of data assocaited with a specific type');
insert into flashcard (term, definition) values ('variable declaration', 'the place in the application, where the specific variable is assigned to one of the existing Java types');
insert into flashcard (term, definition) values ('void', 'keyword used to indicate taht method does not return any value');
insert into flashcard (term, definition) values ('volatile', 'a modifier specifying how the variable behaves in a multithreaded environment; the variable will never be cached a thread-local - as its expected to be modified by different threads');
insert into flashcard (term, definition) values ('while', 'a Java control structure used for looping');
insert into flashcard (term, definition) values ('wrapper', 'an object that encapsulates primitive types into one of the classes from the java.lang package: Boolean, Byte, Character, Double, Float, Integer, Long, or Short to provide additional methods');


commit;

----

















