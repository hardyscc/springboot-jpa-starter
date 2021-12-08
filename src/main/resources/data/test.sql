insert into test (code, version, update_date, create_date) values ('dummy', 1, '2021-01-01T00:00:00+8:00', '2021-01-01T00:00:00+8:00');
insert into test_ver (id, test_code, ver, name, attributes, register_info, update_date, create_date) values (0, 'dummy', 1, 'dummy', '[]', '{}', '2021-01-01T00:00:00+8:00', '2021-01-01T00:00:00+8:00');
update test set test_ver_latest_id = 0 where test.code = 'dummy'
