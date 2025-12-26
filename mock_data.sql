-- 插入宿舍数据 (Dorm)
INSERT INTO Dorm (DormID, Building, BedCount) VALUES 
('D101', 'A栋', 4),
('D102', 'A栋', 4),
('D201', 'B栋', 6);

-- 插入学生数据 (Student)
INSERT INTO Student (StudentID, Name, Gender, BirthDate, Grade, DormID, BedNumber, Phone) VALUES 
('S2023001', '张三', 'M', '2005-03-15', '2023级计算机', 'D101', 1, '13800138001'),
('S2023002', '李四', 'M', '2005-06-20', '2023级计算机', 'D101', 2, '13800138002'),
('S2023003', '王五', 'M', '2004-11-11', '2023级土木', 'D102', 1, '13900139003');

-- 插入床位数据 (Bed)
-- D101 (4个床位，假设入住了2人)
INSERT INTO Bed (DormID, BedNumber, IsAssigned, StudentID) VALUES 
('D101', 1, TRUE, 'S2023001'),
('D101', 2, TRUE, 'S2023002'),
('D101', 3, FALSE, NULL),
('D101', 4, FALSE, NULL);

-- D102 (4个床位，假设入住了1人)
INSERT INTO Bed (DormID, BedNumber, IsAssigned, StudentID) VALUES 
('D102', 1, TRUE, 'S2023003'),
('D102', 2, FALSE, NULL),
('D102', 3, FALSE, NULL),
('D102', 4, FALSE, NULL);

-- D201 (6个床位，全空)
INSERT INTO Bed (DormID, BedNumber, IsAssigned, StudentID) VALUES 
('D201', 1, FALSE, NULL),
('D201', 2, FALSE, NULL),
('D201', 3, FALSE, NULL),
('D201', 4, FALSE, NULL),
('D201', 5, FALSE, NULL),
('D201', 6, FALSE, NULL);

-- 插入费用数据 (Fee)
-- 使用 UUID() 生成主键，或者手动指定 UUID 字符串
INSERT INTO Fee (FeeID, StudentID, FeeType, Amount, PayDate) VALUES 
(UUID(), 'S2023001', '2023秋季住宿费', 1200.00, '2023-09-01'),
(UUID(), 'S2023001', '2023秋季水电费', 150.50, '2023-10-15'),
(UUID(), 'S2023002', '2023秋季住宿费', 1200.00, '2023-09-02'),
(UUID(), 'S2023003', '2023秋季住宿费', 1200.00, '2023-09-05'),
(UUID(), 'S2023003', '晚归罚款', 50.00, '2023-11-20');
