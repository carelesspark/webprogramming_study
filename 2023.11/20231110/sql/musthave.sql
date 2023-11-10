select * from member;

---------------------------------------------------- 페이징 관련 쿼리문

select * 
from (select rownum rnum, tb.* 
    from (select * from board
        order by num desc) tb)
where rnum between 11 AND 20;

------------------------------------------------------ 페이징 + 검색어 관련 쿼리문

select * 
from (select rownum rnum, tb.* 
    from (select * from board
        where title like '%100%'
        order by num desc) tb)
where rnum between 1 AND 10;