INSERT INTO sensor(name, created_at, created_by) VALUES ('testSensor', now(), 'ADMIN');
INSERT INTO measurement(value, raining, measure_time, sensor) VALUES (21.0, false, now(), (SELECT id FROM sensor WHERE name = 'testSensor'));

