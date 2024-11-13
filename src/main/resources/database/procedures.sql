CREATE OR REPLACE FUNCTION employee_exists(e_email VARCHAR, e_password VARCHAR)
    RETURNS BOOLEAN AS $$
BEGIN
    RETURN exists(select id from employers where email = e_email and password = e_password);
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION customer_exists(c_email VARCHAR, c_password VARCHAR)
    RETURNS BOOLEAN AS $$
BEGIN
    RETURN exists(select id from customers where email = c_email and password = c_password);
END;
$$ LANGUAGE plpgsql;