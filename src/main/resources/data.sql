insert into customer(id, name,email) values (1000, 'Sai','spasum@gmail.com');
insert into customer(id, name,email) values (1001, 'Anusha','apasum@gmail.com');

insert into TRANSACTIONS(id,customer_id,purchase_Total,rewards_Points,date)   values (1001,1000,120,0,'2021-03-01 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1002,1000,100,0,'2021-02-01 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1003,1000,70,0,'2021-01-01 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1004,1000,120,0,'2021-01-02 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1005,1000,100,0,'2020-12-01 10:21:00');

insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1102,1001,200,0,'2021-02-01 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1103,1001,90,0,'2021-01-01 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1104,1001,110,0,'2021-01-02 10:21:00');
insert into transactions(id,customer_id,purchase_Total,rewards_Points,date)  values (1105,1001,100,0,'2020-12-01 10:21:00');