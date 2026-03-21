


-- =========================================
-- USERS
-- =========================================
INSERT INTO users (username, password, user_role) VALUES
                                                      ('admin', 'admin123', 'ADMIN'),
                                                      ('manager1', 'manager123', 'TICKET_MANAGER'),
                                                      ('manager2', 'manager456', 'TICKET_MANAGER'),
                                                      ('handler1', 'handler123', 'TICKET_HANDLER'),
                                                      ('handler2', 'handler456', 'TICKET_HANDLER');

-- =========================================
-- PROJECTS
-- =========================================
INSERT INTO projects (name, description) VALUES
                                             ('Project Alpha', 'First project for testing'),
                                             ('Project Beta', 'Second project for testing'),
                                             ('Project Gamma', 'Third project for testing');

-- =========================================
-- CATEGORIES
-- =========================================
-- Assuming Project IDs: 1=Alpha, 2=Beta, 3=Gamma
INSERT INTO categories (name, project_id) VALUES
                                              ('Frontend', 1),
                                              ('Backend', 1),
                                              ('QA', 1),
                                              ('Frontend', 2),
                                              ('Backend', 2),
                                              ('DevOps', 2),
                                              ('QA', 3),
                                              ('DevOps', 3);

-- =========================================
-- TICKETS
-- =========================================
-- Assuming Category IDs: 1-8, User IDs: 2-5
INSERT INTO tickets (title, description, status, created_at, category_id, user_id) VALUES
                                                                                       ('Login Page Bug', 'Login page throws 500 error', 'OPEN', now(), 1, 2),
                                                                                       ('API Integration', 'Integrate payment API', 'IN_PROGRESS', now(), 2, 2),
                                                                                       ('Test Case Failure', 'Payment module test failing', 'OPEN', now(), 3, 3),
                                                                                       ('Deploy Issue', 'Deployment fails on staging', 'CLOSED', now(), 6, 3),
                                                                                       ('UI Misalignment', 'Buttons are misaligned in dashboard', 'OPEN', now(), 4, 2),
                                                                                       ('Database Optimization', 'Optimize queries for reports', 'IN_PROGRESS', now(), 5, 2),
                                                                                       ('Staging Test Failed', 'QA tests failing after merge', 'OPEN', now(), 7, 4),
                                                                                       ('Server Crash', 'Production server crash after deploy', 'CLOSED', now(), 8, 5);

-- =========================================
-- COMMENTS
-- =========================================
-- Assuming Ticket IDs: 1-8, User IDs: 2-5
INSERT INTO comments (content, created_at, ticket_id, user_id) VALUES
                                                                   ('Checked the error logs, seems related to DB', now(), 1, 2),
                                                                   ('Integration in progress, API keys updated', now(), 2, 2),
                                                                   ('Retested, issue still occurs', now(), 3, 3),
                                                                   ('Deployment fixed after updating config', now(), 4, 3),
                                                                   ('UI alignment adjusted in CSS', now(), 5, 2),
                                                                   ('Optimized queries for faster report generation', now(), 6, 2),
                                                                   ('QA retested, tests passed', now(), 7, 4),
                                                                   ('Server crash traced to memory leak', now(), 8, 5),
                                                                   ('Added more logging to catch future errors', now(), 1, 2),
                                                                   ('Reviewed API integration, looks fine', now(), 2, 2);