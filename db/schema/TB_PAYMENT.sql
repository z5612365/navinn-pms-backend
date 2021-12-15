CREATE TABLE TB_PAYMENT (
  PAYMENT_SEQ INT(10) NOT NULL AUTO_INCREMENT,
  PAYMENT_KEY INT(4) NOT NULL,

  RECEIVE_WALLET varchar(200),
  REFUND_WALLET varchar(200),
  TOTAL_AMOUNT DECIMAL(8,5),
  STATUS varchar(20) CHECK (STATUS IN ('UNPAID','PAID','REFUND','CANCEL')),

  PRIMARY KEY(PAYMENT_SEQ)
);
