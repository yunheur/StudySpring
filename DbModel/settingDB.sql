use studydb;
-- members 테이블 생성
create table members (
    mno      integer     not null    comment '회원일련번호',
    email    varchar(40) not null    comment '이메일',
    pwd      varchar(100)not null    comment '암호',
    mname    varchar(50) not null    comment '이름',
    cre_date datetime    not null    comment '가입일',
    mod_date datetime    not null    comment '마지막암호변경일'
) 
comment '회원기본정보';
-- members 테이블 기본키 설정
alter table members 
    add constraint pk_members 
        primary key (
            mno
        );
-- members 테이블 유니크키 설정
create unique index uix_members 
    on members (
        email asc
    );
-- members 테이블 기본키 자동 증가 설정 
alter table members 
    modify column mno integer not null auto_increment
    comment '회원일련번호';

-- projects 테이블 생성 
create table projects (
    pno         integer         not null    comment '프로젝트일련번호',
    pname       varchar(255)    not null    comment '프로젝트명',
    content     text            not null    comment '설명',
    sta_date    datetime        not null    comment '시작일',
    end_date    datetime        not null    comment '종료일',
    state       integer         not null    comment '상태',
    cre_date    datetime        not null    comment '생성일',
    tags        varchar(255)    null        comment '태그'
)
comment '프로젝트';
-- projects 테이블 기본키 설정
alter table projects 
    add constraint pk_projects
        primary key (
            pno
        );
-- projects pno 칼럼에 대해 제약조건 설정
alter table projects
    modify column pno integer not null auto_increment comment '프로젝트일련번호';

-- project member 테이블 생성
create table prj_membs (
    pno         integer     not null    comment '프로젝트일련번호',
    mno         integer     not null    comment '회원일련번호',
    level       integer     not null    comment '등급',
    state       integer     not null    comment '상태',
    mod_date    integer     not null    comment '상태변경일'
)
comment '프로젝트멤버';

-- project member 테이블 기본키 설정
alter table prj_membs
    add constraint pk_prj_membs
        primary key (
            pno,
            mno
        );