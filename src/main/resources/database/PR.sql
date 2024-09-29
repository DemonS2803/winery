-- lab 1

DELIMITER |
CREATE TRIGGER log_postorder AFTER INSERT on orders
    for EACH row
    BEGIN
        INSERT INTO logs (log_level, message) VALUES ('INFO', 'some user made order');
    END|


DELIMITER |
CREATE TRIGGER log_doctor_postcreate AFTER INSERT on doctors
    for EACH row
BEGIN
INSERT INTO logs (log_level, message) VALUES ('INFO', 'we have new doctor!');
END|

DELIMITER |
CREATE TRIGGER update_null_birthdays
    AFTER UPDATE ON clients
    FOR EACH ROW
BEGIN
IF NEW.birthday IS NULL THEN
UPDATE clients
SET birthday = now()
WHERE id = NEW.id;
END IF;
END;|

UPDATE `clients` SET `cl_surname`= 'data2' WHERE id = 2



-- lab 2
    DELIMITER $$

CREATE PROCEDURE add_salary_for_3_doctors()
BEGIN
    DECLARE d_id INT DEFAULT 0;

    doctor_loop: LOOP

        IF d_id > 3 THEN
            LEAVE doctor_loop;
        END IF;

        -- Update the salary of the doctor
        UPDATE doctors
        SET salary = salary + 1000
        WHERE id = d_id;

        -- Increment the counter
        SET d_id = d_id + 1;
    END LOOP doctor_loop;
END $$

    DELIMITER ;