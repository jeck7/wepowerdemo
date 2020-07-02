-- inserts in prices table
INSERT INTO prices (id, quarter,energyprice,lgsprice) VALUES (1,'Q3-2020','52.50','29.00');
INSERT INTO prices (id, quarter,energyprice,lgsprice) VALUES (2,'Q4-2020','54.67','29.00');

INSERT INTO prices (id, quarter,energyprice,lgsprice) VALUES (3,'Q1-2021','66.75','21.00');
INSERT INTO prices (id, quarter,energyprice,lgsprice) VALUES (4,'Q2-2021','49.07','21.00');
INSERT INTO prices (id, quarter,energyprice,lgsprice) VALUES (5,'Q3-2021','48.70','21.00');
INSERT INTO prices (id, quarter,energyprice,lgsprice) VALUES (6,'Q4-2021','51.46','21.00');


INSERT INTO customer_type (id, type,value ,prices_id) VALUES (1,'mining',1.2000,1);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (2,'industrial',1.0150,1);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (3,'commercial company',0.8000,1);

INSERT INTO customer_type (id, type,value ,prices_id) VALUES (4,'mining',1.2000,2);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (5,'industrial',1.0150,2);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (6,'commercial company',0.8000,2);

INSERT INTO customer_type (id, type,value ,prices_id) VALUES (7,'mining',1.2000,3);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (8,'industrial',1.0150,3);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (9,'commercial company',0.8000,3);

INSERT INTO customer_type (id, type,value ,prices_id) VALUES (10,'mining',1.2000,4);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (11,'industrial',1.0150,4);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (12,'commercial company',0.8000,4);

INSERT INTO customer_type (id, type,value ,prices_id) VALUES (13,'mining',1.2000,5);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (14,'industrial',1.0150,5);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (15,'commercial company',0.8000,5);

INSERT INTO customer_type (id, type,value ,prices_id) VALUES (16,'mining',1.2000,6);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (17,'industrial',1.0150,6);
INSERT INTO customer_type (id, type,value,prices_id) VALUES (18,'commercial company',0.8000,6);

