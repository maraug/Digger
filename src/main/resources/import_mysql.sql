INSERT INTO users (username, password, email, role) VALUES ('mrcs', 'abe31fe1a2113e7e8bf174164515802806d388cf4f394cceace7341a182271ab', 'marcin@digger.com', 'USER');
INSERT INTO users (username, password, email, role) VALUES ('admin', 'abe31fe1a2113e7e8bf174164515802806d388cf4f394cceace7341a182271ab', 'admin@digger.com', 'ADMIN');


INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 1', 'Test Description', '2017-04-05 19:15:10', 'http://www.wykop.pl', 'mrcs');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 2', 'Test Description 2', '2016-12-30 07:15:50', 'http://www.wykop.pl', 'mrcs');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 4', 'Test Description 4', '2017-01-05 10:40:10', 'http://www.wykop.pl', 'admin');
INSERT INTO discoveries (name, description, timestamp, url, username) VALUES ('Test 3', 'Test Description 3', '2017-02-10 22:18:40', 'http://www.wykop.pl', 'admin');

INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'UP_VOTE', 1, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'DOWN_VOTE', 2, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'UP_VOTE', 3, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'DOWN_VOTE', 4, 1);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'UP_VOTE', 3, 2);
INSERT INTO votes (timestamp, voteType, discovery_id, user_id) VALUES ('2017-05-08 01:39:02', 'DOWN_VOTE', 4, 2);