insert into user(id, password, username) values
(1, '$2a$10$TuiNBKpSUPpXuCyrByFFaeXPNo6WDZCi.hNVPus4FGKh9T/rB3FFO', 'doctor1'),
(2, '$2a$10$GqxqXpM4GlASQ3RB15lmROEI.Szgb08MYjTLgPOwHfGd0wjXuhNia', 'doctor2'),
(3, '$2a$10$jbO8Ti3VLC/Jwu0CRRK49eRjtCeaUSjJJf37SoQvUTMCUdjM/Cyfe', 'doctor3'),
(4, '$2a$10$tSopNg5xtzlAsrnr7qPmN.NFNSV2TUSwEG7AGW4vRR9KOvKpjReUm', 'admin');

insert into role(id, role, user_id) values
(1, 'DOCTOR', 1),
(2, 'DOCTOR', 2),
(3, 'DOCTOR', 3),
(4, 'ADMIN', 4);