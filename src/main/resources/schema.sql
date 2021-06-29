CREATE TABLE car_list (id INT NOT NULL Primary Key AUTO_INCREMENT, make VARCHAR(16), car_model VARCHAR(20), colour VARCHAR(16), price DEC(20,2), vin INT, dealership VARCHAR(16));

INSERT INTO car_list (make, car_model, colour, price, vin, dealership) VALUES
('dodge', 'aa', 'red', '200000.55','111', 'dealership1'),
('crystal', 'bb', 'blue', '300000.00','121', 'dealership1'),
('crystal', 'cc', 'cyan', '250000.00','131', 'dealership1'),
('dodge', 'dd', 'aqua', '254000.00','141', 'dealership1'),
('honda', 'ee', 'pink', '10000.00','151', 'dealership1'),
('hyundai', 'gg', 'purple', '14000.00','161', 'dealership1'),
('dodge', 'hh', 'black', '64000.00','171', 'dealership1'),
('toyota', 'ii', 'brown', '54000.00','181', 'dealership1'),
('honda', 'jj', 'black', '54000.00','191', 'dealership1'),
('alien', 'hh', 'green', '94000.00','200', 'dealership1'),
('dodge', 'jj', 'pink', '300000.50','211', 'dealership2'),
('catfish', 'kk', 'red', '300000.00','222', 'dealership2'),
('crystal', 'll', 'indigo', '650000.00','231', 'dealership2'),
('dodge', 'mm', 'rainbow', '354000.00','241', 'dealership2'),
('honda', 'nn', 'pink', '20000.00','251', 'dealership2'),
('hyundai', 'oo', 'purple', '14500.00','261', 'dealership2'),
('dodge', 'pp', 'black', '64700.00','271', 'dealership2'),
('toyota', 'qq', 'brown', '54400.00','281', 'dealership2'),
('honda', 'rr', 'black', '54500.00','291', 'dealership2'),
('alien', 'aa', 'green', '94600.00','300', 'dealership2'),
('alien', 'bb', 'yellow', '366000.50','310', 'dealership3'),
('subaru', 'bb', 'orange', '377000.00','321', 'dealership3'),
('catfish', 'cc', 'indigo', '770000.00','313', 'dealership3'),
('dodge', 'cc', 'rainbow', '999000.00','332', 'dealership3'),
('pineapple', 'dd', 'pink', '73000.00','343', 'dealership3'),
('hyundai', 'll', 'marine', '54500.00','355', 'dealership3'),
('dodge', 'ii', 'marine', '87700.00','333', 'dealership3'),
('pineapple', 'ii', 'brown', '64400.00','368', 'dealership3'),
('honda', 'jj', 'grass', '43500.00','377', 'dealership3'),
('alien', 'kk', 'grass', '57600.00','399', 'dealership3');