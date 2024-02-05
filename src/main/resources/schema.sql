CREATE TABLE IF NOT EXISTS zooTable (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50),
    age INT,
    kind varchar(50)
);

INSERT INTO zooTable (name, age, kind) VALUES ('Recks', 9, 'lion');
INSERT INTO zooTable (name, age, kind) VALUES ('Barsic', 2, 'cat');
INSERT INTO zooTable (name, age, kind) VALUES ('Misha', 13, 'bear');