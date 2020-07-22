insert into user(id, password, username) values
(1, '$2a$10$.bIFPo8k0dV/jHLn5GLLue0C.ig5iNVgkF62TPdKrnnbc41vTvnu6', 'doctor');

insert into role(id, role, user_id) values
(1, 'DOCTOR', 1);