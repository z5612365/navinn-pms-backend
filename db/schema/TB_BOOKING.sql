CREATE TABLE TB_BOOKING (
  BOOKING_SEQ INT(10) NOT NULL AUTO_INCREMENT,
  ROOM_SEQ INT(10),
  PAYMENT_KEY INT(4),
  BOOK_DATE varchar(8),

  PRIMARY KEY(BOOKING_SEQ)
);