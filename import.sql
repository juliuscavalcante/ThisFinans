INSERT
INTO
  users
  (user_id, user_cod, username, password, email, type, deleted, creation_date, update_date)
VALUES
  (1, 'ecef1767-f940-4c17-b599-60ebdfc5687b', 'Marcos', '12345', 'marco@gmail.com', 'ADMIN', 0, NOW(), NOW());
INSERT
INTO
  accounts
  (account_id,account_cod, name, type, deleted, creation_date, update_date,user_fk)
VALUES
  (2, '7c1e25e4-de63-4113-97d3-1431f05b945b', 'test', 'WALLET', 0, NOW(), NOW(),1);
INSERT
INTO
  transactions
  (transaction_id,transaction_cod, `description`, type, status, amount, deleted, transaction_date, creation_date, account_fk, update_date)
VALUES
  (3,'097dfab0-5270-43ee-8798-3e610b9a581c', 'test', 'REVENUE', 'OPEN', 100, 0, NOW(), NOW(), 2, NOW());
INSERT
INTO
  transaction_days
  (transaction_day_id,transaction_day, transaction_fk)
VALUES
  (4, 3, 3);
INSERT
INTO
  transaction_entries
  (transaction_entry_id, transaction_entry_cod, Amount, entry_date, creation_date, update_date, transaction_fk, account_fk)
VALUES
  (5, 'f9dd3f20-ef8a-474f-aedd-df7fe586d790', 100, NOW(), NOW(), NOW(), 3, 2);