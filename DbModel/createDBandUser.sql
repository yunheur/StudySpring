--Database와 User 생성이 재대로 안된 경우
create database studydb;
create user 'study'@'localhost' identified by 'wer053mysql';
grant all on studydb.* to 'study'@'localhost'; 