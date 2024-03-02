start transaction;

create table flashcard (
flashcard_id serial,
term varchar(100) not null,
definition varchar(2000) not null);


insert into flashcard (term, definition) values ('Abstract', 'a keyword used in a class or method definition, which specifies that the method/class is not going to be instantiated, but should be inherited by other methods or classes');
insert into flashcard (term, definition) values ('API', '(Application Programming Interface) the way to expose a set of pre-defined classes and interfaces to external clients to interact with them, without sharing the implementation details');
insert into flashcard (term, definition) values ('Array', 'fixed-size collection of data of the same type, which can hold zero or more items');
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
insert into flashcard (term, definition) values ('class', 'the core type in Java that defines the implementation of a particular kind of object: it defines')

