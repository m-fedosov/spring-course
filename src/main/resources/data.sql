INSERT INTO sensor(name, created_at, created_by) VALUES ('testSensor', now(), 'ADMIN');
INSERT INTO measurements(value, raining, measure_time, measure_by) VALUES (21, false, now(), (SELECT id FROM sensor WHERE name = 'testSensor'));

