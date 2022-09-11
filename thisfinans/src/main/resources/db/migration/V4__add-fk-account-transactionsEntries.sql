ALTER TABLE transaction_entries
    ADD account_fk BIGINT NOT NULL,
    ADD CONSTRAINT fk_transaction_entries_account_id FOREIGN KEY (account_fk) REFERENCES accounts (account_id);