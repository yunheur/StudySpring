-- insert data to member
insert into members(email, pwd, mname, cre_date, mod_date)
    values ('s1@test.com', '1111', '홍길동', NOW(), NOW());
insert into members(email, pwd, mname, cre_date, mod_date)
    values ('s2@test.com', '1111', '임꺽정', NOW(), NOW());
insert into members(email, pwd, mname, cre_date, mod_date)
    values ('s3@test.com', '1111', '일지매', NOW(), NOW());
insert into members(email, pwd, mname, cre_date, mod_date)
    values ('s4@test.com', '1111', '이몽룡', NOW(), NOW());
insert into members(email, pwd, mname, cre_date, mod_date)
    values ('s5@test.com', '1111', '성춘향', NOW(), NOW());

-- insert data to projects
insert into projects(pname, content, sta_date, end_date, state, cre_date)
    values ('프로젝트1', '프로젝트 내용', NOW(), NOW(), 0, NOW());
insert into projects(pname, content, sta_date, end_date, state, cre_date)
    values ('프로젝트2', '프로젝트 내용', NOW(), NOW(), 0, NOW());
insert into projects(pname, content, sta_date, end_date, state, cre_date)
    values ('프로젝트3', '프로젝트 내용', NOW(), NOW(), 0, NOW());
insert into projects(pname, content, sta_date, end_date, state, cre_date)
    values ('프로젝트4', '프로젝트 내용', NOW(), NOW(), 0, NOW());
insert into projects(pname, content, sta_date, end_date, state, cre_date)
    values ('프로젝트5', '프로젝트 내용', NOW(), NOW(), 0, NOW());