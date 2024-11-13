-- Insert 1: Inserting details for "Vineyard Valley".id
INSERT INTO wineries (id, name, address, build_date, phone, email, description)
VALUES (1, 'Vineyard Valley', '1234 Vine Lane, Napa, CA', '1985-05-15', '555-123-4567', 'info@vineyardvalley.com', 'www.vineyardvalley.com'),
       (2, 'Sunset Hills Winery', '5678 Sunset Road, Sonoma, CA', '1992-08-21', '555-987-6543', 'contact@sunsethillswinery.com', 'www.sunsethillswinery.com'),
       (3, 'Golden Grape Estate', '91011 Golden Avenue, Paso Robles, CA', '2005-03-10', '555-654-3210', 'support@goldengrapeestate.com', 'www.goldengrapeestate.com');


-- Insert 1: "Hillside Vineyard" for Winery 1 (Vineyard Valley)
INSERT INTO vineyards (id, name, address, description, area, elevation, winery_id)
VALUES (1, 'Hillside Vineyard', '456 Grape Road, Napa, CA', 'A small vineyard located on a steep hillside, ideal for Cabernet Sauvignon.', 25.5, 300.0, 1),
       (2, 'Sunny Acres', '789 Sunlight Dr, Napa, CA', 'Known for its excellent sunlight exposure, great for Chardonnay.', 40.0, 150.0, 1),
       (3, 'Sunset Ridge Vineyard', '123 Sunset Ridge, Sonoma, CA', 'High elevation vineyard producing bold Zinfandel.', 35.2, 400.5, 2),
       (4, 'Riverbank Vineyards', '678 Riverbank Rd, Sonoma, CA', 'Vineyard located near a river, providing rich, fertile soil.', 50.0, 50.0, 2),
       (5, 'Golden Hills Vineyard', '345 Golden Hills Ave, Paso Robles, CA', 'Produces award-winning Pinot Noir, known for its cooler climate.', 75.8, 200.0, 3),
       (6, 'Windy Crest Vineyard', '987 Crestline Drive, Paso Robles, CA', 'Located on a windy hillside, ideal for Syrah and Grenache.', 60.0, 250.0, 3),
       (7, 'Mountain Peak Vineyard', '654 Mountain View Road, Paso Robles, CA', 'One of the highest vineyards in the region, known for its Merlot.', 45.0, 500.0, 1);


-- Insert 1: Cabernet Sauvignon for Vineyard 1 (Hillside Vineyard)
INSERT INTO grape_sorts (id, name, description, vineyard_id)
VALUES (1, 'Cabernet Sauvignon', 'A full-bodied red wine grape with high tannins, often used in blends.', 1),
       (2, 'Chardonnay', 'A versatile white wine grape known for its range of styles from crisp to oaky.', 2),
       (3, 'Zinfandel', 'A bold red wine grape with rich, fruity flavors and high alcohol content.', 3),
       (4, 'Merlot', 'A soft, elegant red wine grape often used for blending and single varietal wines.', 7),
       (5, 'Pinot Noir', 'A delicate, thin-skinned red wine grape, known for its complexity and elegance.', 5),
       (6, 'Syrah', 'A rich, dark red wine grape with flavors of black fruit, pepper, and spice.', 6),
       (7, 'Sauvignon Blanc', 'A crisp, aromatic white wine grape known for its high acidity and citrus flavors.', 2),
       (8, 'Grenache', 'A red wine grape known for its fruity, spicy character and high alcohol potential.', 6),
       (9, 'Riesling', 'A white wine grape known for its aromatic qualities and a wide range of sweetness levels.', 4),
       (10, 'Tempranillo', 'A red wine grape with bold flavors of plum and tobacco, popular in Spanish wines.', 3),
       (11, 'Malbec', 'A robust red wine grape known for its dark fruit flavors and smoky finish.', 1),
        (12, 'Petit Verdot', 'A full-bodied red grape used primarily in blending, adding tannins and color.', 1),
        (13, 'Viognier', 'A rich, aromatic white wine grape with floral and stone fruit notes.', 2),
        (14, 'Sangiovese', 'A red wine grape with high acidity, commonly found in Italian wines.', 3),
        (15, 'Barbera', 'An Italian red grape known for its deep color and vibrant acidity.', 4),
        (16, 'Mourvèdre', 'A dark, tannic red wine grape often used in blends for structure.', 6);

INSERT INTO wines (id, name, description, year, alcohol_percent, type, sort_id, winery_id)
VALUES
    (1, 'Cabernet Reserve', 'A full-bodied wine with dark fruit flavors and firm tannins.', 2018, 14.5, 'RED_SWEET', 1, 1),
    (2, 'Chardonnay Estate', 'A smooth, buttery Chardonnay with hints of oak and vanilla.', 2020, 13.2, 'WHITE_DRY', 2, 1),
    (3, 'Zinfandel Bold', 'A robust Zinfandel with notes of ripe berries and pepper.', 2019, 15.0, 'RED_SWEET', 3, 2),
    (4, 'Merlot Classic', 'A soft and fruity Merlot with notes of cherry and plum.', 2021, 13.9, 'ROSE', 4, 3),
    (5, 'Pinot Noir Elegance', 'A delicate Pinot Noir with flavors of red berries and earthy undertones.', 2020, 12.8, 'RED_SWEET', 5, 3),
    (6, 'Syrah Reserve', 'A rich Syrah with bold flavors of blackberry and spice.', 2019, 14.8, 'RED_SWEET', 6, 3),
    (7, 'Sauvignon Blanc Crisp', 'A fresh Sauvignon Blanc with citrus and green apple flavors.', 2021, 12.5, 'WHITE_DRY', 7, 1),
    (8, 'Grenache Estate', 'A fruity Grenache with hints of strawberry and white pepper.', 2019, 13.7, 'RED_SWEET', 8, 3),
    (9, 'Riesling Sweet', 'A semi-sweet Riesling with floral aromas and flavors of peach.', 2020, 10.5, 'WHITE_DRY', 9, 2),
    (10, 'Tempranillo Reserva', 'A bold Tempranillo with flavors of plum, tobacco, and vanilla.', 2018, 14.3, 'RED_SWEET', 10, 2);


INSERT INTO batches (id, wine_id, fill_date, volume, bottle, price)
VALUES
    (1, 1, '2023-05-10', 0.75, 'STANDART', 25.99),
    (2, 2, '2023-06-15', 0.75, 'STANDART', 19.99),
    (3, 3, '2023-04-20', 0.75, 'STANDART', 29.99),
    (4, 4, '2022-11-10', 0.75, 'STANDART', 22.50),
    (5, 5, '2023-07-05', 0.75, 'STANDART', 35.00),
    (6, 6, '2022-09-18', 0.75, 'STANDART', 27.49),
    (7, 7, '2023-03-12', 0.375, 'SMALL', 14.99),
    (8, 8, '2023-08-22', 0.75, 'STANDART', 24.99),
    (9, 9, '2023-05-30', 0.375, 'SMALL', 12.99),
    (10, 10, '2022-10-05', 0.75, 'STANDART', 32.00),
    (11, 1, '2023-09-05', 375.0, 'SMALL', 13.99),
    (12, 2, '2023-06-30', 375.0, 'SMALL', 10.99),
    (13, 3, '2022-12-15', 375.0, 'SMALL', 15.99),
    (14, 4, '2023-01-22', 750.0, 'STANDART', 22.99),
    (15, 5, '2023-07-25', 375.0, 'SMALL', 17.99),
    (16, 6, '2022-08-14', 375.0, 'SMALL', 14.49),
    (17, 7, '2023-02-10', 750.0, 'STANDART', 24.99),
    (18, 8, '2023-08-30', 375.0, 'SMALL', 12.49),
    (19, 9, '2023-04-18', 750.0, 'STANDART', 16.99),
    (20, 10, '2023-03-05', 375.0, 'SMALL', 15.49);


INSERT INTO Inventory (id, bottles_available, bottles_total, last_update, batch_id)
VALUES
    (1, 120, 150, '2024-09-01', 1),
    (2, 80, 100, '2024-08-28', 2),
    (3, 200, 250, '2024-09-05', 3),
    (4, 50, 60, '2024-08-25', 4),
    (5, 100, 120, '2024-09-10', 5),
    (6, 150, 200, '2024-08-30', 6),
    (7, 60, 75, '2024-09-12', 7),
    (8, 40, 50, '2024-09-05', 8),
    (9, 30, 50, '2024-09-02', 9),
    (10, 90, 100, '2024-08-31', 10),
    (11, 0, 150, '2024-09-12', 11),
    (12, 70, 100, '2024-08-29', 12),
    (13, 0, 75, '2024-09-01', 13),
    (14, 45, 60, '2024-08-30', 14),
    (15, 20, 120, '2024-09-08', 15),
    (16, 0, 50, '2024-08-28', 16),
    (17, 30, 75, '2024-09-11', 17),
    (18, 0, 50, '2024-09-03', 18),
    (19, 10, 50, '2024-09-07', 19),
    (20, 0, 100, '2024-08-25', 20);

INSERT INTO customers (id, first_name, last_name, address, email, phone, type)
VALUES
    (1, 'John', 'Doe', '123 Main St, Napa, CA', 'john.doe@example.com', '555-1234', 'PHYSICAL'),
    (2, 'Wine Distributors Inc.', '', '456 Corporate Dr, Sonoma, CA', 'sales@winedist.com', '555-5678', 'COMPANY'),
    (3, 'Emily', 'Davis', '789 Vine Lane, Paso Robles, CA', 'emily.davis@example.com', '555-9876', 'PHYSICAL'),
    (4, 'Gourmet Grocers Ltd.', '', '321 Market St, San Francisco, CA', 'info@gourmetgrocers.com', '555-4321', 'COMPANY'),
    (5, 'Michael', 'Smith', '654 Sunset Blvd, Santa Barbara, CA', 'michael.smith@example.com', '555-8765', 'PHYSICAL'),
    (6, 'Beverage World LLC', '', '987 Beverage Ave, Los Angeles, CA', 'orders@bevworld.com', '555-6543', 'COMPANY');

INSERT INTO orders (id, created, shipping_address, total_price, customer_id)
VALUES
    (1, '2024-08-10', '123 Main St, Napa, CA', 250.00, 1),
    (2, '2024-08-12', '456 Corporate Dr, Sonoma, CA', 1200.50, 2),
    (3, '2024-08-15', '789 Vine Lane, Paso Robles, CA', 325.75, 3),
    (4, '2024-08-18', '321 Market St, San Francisco, CA', 1875.00, 4),
    (5, '2024-08-20', '654 Sunset Blvd, Santa Barbara, CA', 150.00, 5),
    (6, '2024-08-22', '987 Beverage Ave, Los Angeles, CA', 2200.00, 6),
    (7, '2024-08-25', '123 Main St, Napa, CA', 275.25, 1),
    (8, '2024-08-28', '456 Corporate Dr, Sonoma, CA', 1800.75, 2),
    (9, '2024-08-30', '789 Vine Lane, Paso Robles, CA', 400.00, 3),
    (10, '2024-09-01', '321 Market St, San Francisco, CA', 950.00, 4),
    (11, '2024-09-03', '654 Sunset Blvd, Santa Barbara, CA', 200.00, 5),
    (12, '2024-09-05', '987 Beverage Ave, Los Angeles, CA', 2750.00, 6),
    (13, '2024-09-07', '123 Main St, Napa, CA', 325.00, 1);

INSERT INTO order_positions (batch_id, order_id, count, position, price)
VALUES
    (1, 1, 3, 1, 25.99),
    (2, 2, 10, 1, 19.99),
    (3, 3, 4, 1, 29.99),
    (4, 4, 15, 1, 22.50),
    (5, 5, 2, 1, 35.00),
    (6, 6, 20, 1, 27.49),
    (7, 7, 5, 1, 24.99),
    (8, 8, 12, 1, 24.99),
    (9, 9, 3, 1, 16.99),
    (10, 10, 8, 1, 32.00),
    (11, 1, 4, 2, 13.99),
    (12, 2, 6, 2, 10.99),
    (13, 3, 5, 2, 15.99),
    (14, 4, 8, 2, 22.99),
    (15, 5, 3, 2, 17.99),
    (16, 6, 10, 2, 14.49),
    (17, 7, 1, 2, 24.99),
    (18, 8, 7, 2, 12.49),
    (19, 9, 4, 2, 16.99),
    (20, 10, 9, 2, 15.49);


INSERT INTO customer_bucket_items (customer_id, batch_id, position, count)
VALUES
    (1, 1, 1, 3),
    (2, 2, 1, 10),
    (3, 3, 1, 4),
    (4, 4, 1, 15),
    (5, 5, 1, 2),
    (6, 6, 1, 20),
    (1, 7, 2, 5),
    (2, 8, 2, 12),
    (3, 9, 2, 3),
    (4, 10, 2, 8);