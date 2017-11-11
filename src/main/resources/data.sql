/* 15 test users */
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Adam@email.com', 'Adam', 'Bell');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Alan@email.com', 'Alan', 'Berry');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Andrew@email.com', 'Andrew', 'Bower');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Anthony@email.com', 'Anthony', 'Buckland');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Austin@email.com', 'Austin', 'Butler');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Benjamin@email.com', 'Benjamin', 'Cameron');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Brian@email.com', 'Brian', 'Davidson');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Charles@email.com', 'Charles', 'Duncan');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Chris@email.com', 'Chris', 'Fisher');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Dan@email.com', 'Dan', 'Gibson');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'David@email.com', 'David', 'Gill');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Eric@email.com', 'Eric', 'Glover');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'John@email.com', 'John', 'Graham');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Max@email.com', 'Max', 'Grant');
INSERT INTO USER(EMAIL, FIRST_NAME, LAST_NAME) VALUES( 'Michael@email.com', 'Michael', 'Gray');

/* Andrew with userId 3 following 5 other users */
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(1, 3);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(4, 3);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(5, 3);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(7, 3);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(9, 3);
/* John with userId 13 following 10 other users */
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(1, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(2, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(3, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(4, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(5, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(6, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(7, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(8, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(9, 13);
Insert into FOLLOWER_USER_MAP(followed_user_id, following_user_id) values(10, 13);

/* Every user has posted a message but first two user has additional one message */
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Adam', 1);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Alan', 2);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Andrew', 3);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Anthony', 4);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Austin', 5);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Benjamin', 6);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Brian', 7);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Charles', 8);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Chris', 9);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Dan', 10);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Dvaid', 11);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Eric', 12);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from John', 13);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Max', 14);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is tweet from Michael', 15);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is 2nd tweet from Adam', 1);
Insert into MESSAGE_FEED(created_ts, message, user_id) values(CURRENT_TIMESTAMP(), 'This is 2nd tweet from Alan', 2);