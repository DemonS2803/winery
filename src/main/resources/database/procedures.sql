CREATE OR REPLACE FUNCTION employee_exists(e_email VARCHAR, e_password VARCHAR)
    RETURNS BOOLEAN AS $$
BEGIN
    RETURN exists(select id from employers where email = e_email and password = e_password);
END;
$$ LANGUAGE plpgsql;