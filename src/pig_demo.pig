set io.sort.mb 10;
marks_file = load '$ip_file' using PigStorage() as (roll_no:int, subject:chararray, marks:int);
formatted = foreach marks_file generate roll_no, marks;
grpd = group formatted by roll_no;
op = foreach grpd generate group, AVG(formatted,marks);
store op into 'op';