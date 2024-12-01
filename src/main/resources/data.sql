-- Insert into account_seq
INSERT INTO account_seq (next_val) VALUES (1);

-- Insert into address_seq
INSERT INTO address_seq (next_val) VALUES (1);

-- Insert into balance_sheet_seq
INSERT INTO balance_sheet_seq (next_val) VALUES (1);

-- Insert into company_seq
INSERT INTO company_seq (next_val) VALUES (1);

-- Insert into composition_seq
INSERT INTO composition_seq (next_val) VALUES (1);

-- Insert into responsible_seq
INSERT INTO responsible_seq (next_val) VALUES (1);

-- Insert into account
INSERT INTO account (id, account_number, account_name, type) VALUES (1, 123456, 'Main Account', 'Savings');

-- Insert into address
INSERT INTO address (id, city, number, state, street, zip_code) VALUES (1, 'New York', '123', 'NY', '5th Avenue', '10001');

-- Insert into company
INSERT INTO company (id, address_id, cnpj, email, name, phone) VALUES (1, 1, '12345678901234', 'info@company.com', 'Company Inc.', '123-456-7890');

-- Insert into balance_sheet
INSERT INTO balance_sheet (id, month, year, account_id, company_id, status) VALUES (1, 12, 2023, 1, 1, 'Active');

-- Insert into responsible
INSERT INTO responsible (id, company_id, email, name, phone, role) VALUES (1, 1, 'responsible@company.com', 'John Doe', '123-456-7890', 'Manager');

-- Insert into composition
INSERT INTO composition (id, credit, csrf, debit, due_date, emission_date, inss, irrf, iss, balance_sheet_id, responsible_id, tax_note_number, history)
VALUES (1, 1000.0, 50.0, 500.0, '2023-12-31', '2023-12-01', 100.0, 200.0, 300.0, 1, 1, 123456789, 'Initial composition');

-- Insert into user_app
INSERT INTO user_app (id, email, password, role, username) VALUES (1, 'user@domain.com', '$2a$12$KO/kCspWUzWaEaYWT2cZmO9jjxnzvb.OQFpqXM0AFT1Xv2yAZUV/e', 'ADMIN', 'adminuser');
