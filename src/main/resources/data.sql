INSERT INTO category (title) SELECT 'Assignment' FROM dual
WHERE NOT EXISTS (SELECT 1 FROM category WHERE title = 'Assignment');
INSERT INTO category (title) SELECT 'work out' FROM dual
WHERE NOT EXISTS (SELECT 1 FROM category WHERE title = 'work out');
INSERT INTO category (title) SELECT 'daily' FROM dual
WHERE NOT EXISTS (SELECT 1 FROM category WHERE title = 'daily');
INSERT INTO category (title) SELECT 'meet' FROM dual
WHERE NOT EXISTS (SELECT 1 FROM category WHERE title = 'meet');