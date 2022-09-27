INSERT
INTO
  users
  (user_id, user_cod, username, password, email, type, deleted, create_date, update_date)
VALUES
  (1, 'a0fee7ef-2bff-4500-8991-6d8b59f30562', 'Marcos', '123456', 'marco@gmail.com', 'ADMIN', 0, NOW(), NOW());
INSERT
INTO
  accounts
  (account_id, account_cod, name, type, deleted, create_date, update_date, user_fk)
VALUES
  (2, 'd2046f83-8f06-4603-af50-2c27c58e0a47', 'testAccount', 'WALLET', 0, NOW(), NOW(), 1);
INSERT
INTO
  transactions
  (transaction_id, transaction_cod, `description`, type, status, amount, deleted, transaction_date, create_date, update_date, account_fk)
VALUES
  (3, 'e9839cc7-781b-486c-9a3a-499a2bc2e616', 'Teste', 'REVENUE', 'OPEN', 100, 0, NOW(), NOW(), NOW(), 2);
INSERT
INTO
  transaction_days
  (transaction_day, transaction_fk)
VALUES
  (2, 3);
INSERT
INTO
  transaction_entries
  (transaction_entry_cod, Amount, entry_date, create_date, update_date, transaction_fk, account_fk)
VALUES
  ('e6ac2d29-4f04-4473-b32a-e4d90c49331d', 0, NOW(), NOW(), NOW(), 3, 2),
  ('e5ac2d29-4f04-4475-b32a-e4d90c49331d', 0, NOW(), NOW(), NOW(), 3, 2);