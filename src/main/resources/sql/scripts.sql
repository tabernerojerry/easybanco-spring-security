--PostgreSQL

create database easy_banco;

set schema 'easy_banco';

drop table users;
drop table authorities;
drop table customers;

CREATE TABLE customer (
  customer_id SERIAL,
  name varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  mobile_number varchar(20) NOT NULL,
  pwd varchar(500) NOT NULL,
  role varchar(100) NOT NULL,
  create_dt date DEFAULT CURRENT_DATE,
  PRIMARY KEY (customer_id)
);

INSERT INTO customer (name,email,mobile_number,pwd,role)
 VALUES ('Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin');

CREATE TABLE accounts (
  customer_id int NOT NULL,
  account_number int NOT NULL,
  account_type varchar(100) NOT NULL,
  branch_address varchar(200) NOT NULL,
  create_dt date DEFAULT CURRENT_DATE,
  PRIMARY KEY (account_number),
  CONSTRAINT customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);
CREATE INDEX idx_accounts_customer_id ON accounts (customer_id);

INSERT INTO accounts (customer_id, account_number, account_type, branch_address)
 VALUES (1, 1865764534, 'Savings', '123 Main Street, New York');

CREATE TABLE account_transactions (
  transaction_id varchar(200) NOT NULL,
  account_number int NOT NULL,
  customer_id int NOT NULL,
  transaction_dt date NOT NULL,
  transaction_summary varchar(200) NOT NULL,
  transaction_type varchar(100) NOT NULL,
  transaction_amt int NOT NULL,
  closing_balance int NOT NULL,
  create_dt date DEFAULT NULL,
  PRIMARY KEY (transaction_id),
  CONSTRAINT accounts_ibfk_2 FOREIGN KEY (account_number) REFERENCES accounts (account_number) ON DELETE CASCADE,
  CONSTRAINT acct_user_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);
CREATE INDEX idx_account_transactions_customer_id ON account_transactions (customer_id);
CREATE INDEX idx_account_transactions_account_number ON account_transactions (account_number);


INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, NOW() - INTERVAL '7 hour', 'Coffee Shop', 'Withdrawal', 30,34500, NOW() - INTERVAL '7 hour');

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, NOW() - INTERVAL '6 hour', 'Uber', 'Withdrawal', 100,34400,NOW() - INTERVAL '6 hour');

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, NOW() - INTERVAL '5 hour', 'Self Deposit', 'Deposit', 500,34900,NOW() - INTERVAL '5 hour');

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, NOW() - INTERVAL '4 hour', 'Ebay', 'Withdrawal', 600,34300,NOW() - INTERVAL '4 hour');

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, NOW() - INTERVAL '2 hour', 'OnlineTransfer', 'Deposit', 700,35000,NOW() - INTERVAL '2 hour');

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, NOW() - INTERVAL '1 hour', 'Amazon.com', 'Withdrawal', 100,34900,NOW() - INTERVAL '1 hour');

CREATE TABLE loans (
  loan_number SERIAL,
  customer_id int NOT NULL,
  start_dt date NOT NULL,
  loan_type varchar(100) NOT NULL,
  total_loan int NOT NULL,
  amount_paid int NOT NULL,
  outstanding_amount int NOT NULL,
  create_dt date DEFAULT NULL,
  PRIMARY KEY (loan_number),
  CONSTRAINT loan_customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);
CREATE INDEX idx_loans_customer_id ON loans (customer_id);

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13');

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06');

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14');

INSERT INTO loans ( customer_id, start_dt, loan_type, total_loan, amount_paid, outstanding_amount, create_dt)
 VALUES ( 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

CREATE TABLE cards (
  card_id SERIAL,
  card_number varchar(100) NOT NULL,
  customer_id int NOT NULL,
  card_type varchar(100) NOT NULL,
  total_limit int NOT NULL,
  amount_used int NOT NULL,
  available_amount int NOT NULL,
  create_dt date DEFAULT NULL,
  PRIMARY KEY (card_id),
  CONSTRAINT card_customer_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id) ON DELETE CASCADE
);
CREATE INDEX idx_cards_customer_id ON cards (customer_id);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, NOW());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, NOW());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, NOW());

CREATE TABLE notice_details (
  notice_id SERIAL,
  notice_summary varchar(200) NOT NULL,
  notice_details varchar(500) NOT NULL,
  notic_beg_dt date NOT NULL,
  notic_end_dt date DEFAULT NULL,
  create_dt date DEFAULT NULL,
  update_dt date DEFAULT NULL,
  PRIMARY KEY (notice_id)
);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
NOW() - INTERVAL '30 DAY', NOW() + INTERVAL '30 DAY', NOW(), null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
NOW() - INTERVAL '30 DAY', NOW() + INTERVAL '30 DAY', NOW(), null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Mobile App Downtime', 'The mobile application of the EasyBanco will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
NOW() - INTERVAL '30 DAY', NOW() + INTERVAL '30 DAY', NOW(), null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
NOW() - INTERVAL '30 DAY', NOW() + INTERVAL '30 DAY', NOW(), null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EasyBanco. With these cards, you will get 5% cashback for each purchase',
NOW() - INTERVAL '30 DAY', NOW() + INTERVAL '30 DAY', NOW(), null);

INSERT INTO notice_details ( notice_summary, notice_details, notic_beg_dt, notic_end_dt, create_dt, update_dt)
VALUES ('COVID-19 Insurance', 'EasyBanco launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
NOW() - INTERVAL '30 DAY', NOW() + INTERVAL '30 DAY', NOW(), null);

CREATE TABLE contact_messages (
  contact_id varchar(50) NOT NULL,
  contact_name varchar(50) NOT NULL,
  contact_email varchar(100) NOT NULL,
  subject varchar(500) NOT NULL,
  message varchar(2000) NOT NULL,
  create_dt date DEFAULT NULL,
  PRIMARY KEY (contact_id)
);

CREATE TABLE authorities (
  id SERIAL,
  customer_id int NOT NULL,
  name varchar(50) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);
CREATE INDEX idx_authorities_customer_id on authorities (customer_id);

-- Authorities Demo
INSERT INTO authorities (customer_id, name)
 VALUES (1, 'VIEWACCOUNT');

INSERT INTO authorities (customer_id, name)
 VALUES (1, 'VIEWCARDS');

INSERT INTO authorities (customer_id, name)
VALUES (1, 'VIEWLOANS');

INSERT INTO authorities (customer_id, name)
VALUES (1, 'VIEWBALANCE');

-- Roles Demo
DELETE FROM authorities;

INSERT INTO authorities (customer_id, name)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO authorities (customer_id, name)
VALUES (2, 'ROLE_ADMIN');