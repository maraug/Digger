INSERT INTO users (username, password, email, role) VALUES ('mrcs', 'abe31fe1a2113e7e8bf174164515802806d388cf4f394cceace7341a182271ab', 'marcin@digger.com', 'USER');
INSERT INTO users (username, password, email, role) VALUES ('tester', 'abe31fe1a2113e7e8bf174164515802806d388cf4f394cceace7341a182271ab', 'tester@digger.com', 'USER');
INSERT INTO users (username, password, email, role) VALUES ('admin', 'abe31fe1a2113e7e8bf174164515802806d388cf4f394cceace7341a182271ab', 'admin@digger.com', 'ADMIN');


INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 1', 'Test Description', '2017-04-05 19:15:10', 'http://www.wykop.pl', 'mrcs');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 2', 'Test Description 2', '2016-12-30 07:15:50', 'http://www.wykop.pl', 'mrcs');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 3', 'Test Description 3', '2017-02-10 22:18:40', 'http://www.wykop.pl', 'admin');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 4', 'Test Description 4', '2017-01-05 10:40:10', 'http://www.wykop.pl', 'admin');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 5', 'Test Description 5', '2017-03-05 10:40:10', 'http://www.wykop.pl', 'tester');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 6', 'Test Description 6', '2017-05-05 10:40:10', 'http://www.wykop.pl', 'tester');

INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'UP_VOTE', 1, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 02:39:02', 'DOWN_VOTE', 2, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 03:39:02', 'UP_VOTE', 3, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 04:39:02', 'DOWN_VOTE', 4, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 05:39:02', 'UP_VOTE', 3, 2);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 06:39:02', 'DOWN_VOTE', 4, 2);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 07:39:02', 'UP_VOTE', 5, 3);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 08:39:02', 'DOWN_VOTE', 6, 3);

INSERT INTO comments (content, timestamp, discovery_id, user_id) VALUES ('this is comment', '2017-05-08 08:39:02', 6, 1);
INSERT INTO comments (content, timestamp, discovery_id, user_id) VALUES ('this is comment 2', '2017-05-07 08:43:02', 6, 2);
INSERT INTO comments (content, timestamp, discovery_id, user_id) VALUES ('this is comment 3', '2017-05-06 18:39:02', 6, 3);
INSERT INTO comments (content, timestamp, discovery_id, user_id) VALUES ('this is comment 4', '2017-05-09 11:39:02', 6, 1);

