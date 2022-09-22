INSERT
INTO
  users
  (user_id,user_cod, username, password, email, type, deleted, create_date, update_date)
VALUES
  (1,'f1e81dd4-a1b4-427b-a194-33a050e3daef', 'TestUser', '1234567', 'test@gmail.com', 'ADMIN', 0, NOW(), NOW());
INSERT
INTO
  accounts
  (account_id,account_cod, name, type, deleted, create_date, update_date, user_fk)
VALUES
  (2,'7e032b59-a34f-4cfb-ae2c-e644673aee6e', 'TestAccount', 'WALLET', 0, NOW(), NOW(), 1);
INSERT
INTO
  transactions
  (transaction_id,transaction_cod, `description`, type, status, amount, deleted, transaction_date, create_date, update_date, account_fk)
VALUES
  (3,'c2fd1b14-981b-423f-9058-30c1236b96ad', 'TestTransaction', 'EXPENSES', 'OPEN', 100, 0, NOW(), NOW(), NOW(), 2);
INSERT
INTO
  transaction_entries
  (transaction_entry_cod, Amount, entry_date, create_date, update_date, transaction_fk, account_fk)
VALUES
  ('74de3753-6df9-43b0-9770-075162b9159c', 0, NOW(), NOW(), NOW(), 3, 2);