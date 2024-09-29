import React from 'react';
import {
  Card,
  CardBody,
  CardTitle,
  CardFooter,
  Button,
  Title,
  Text,
  TextContent
} from '@patternfly/react-core';
import {ShoppingCartIcon, StorageDomainIcon} from '@patternfly/react-icons';
import { wineImage } from '../../assets/icons/wine1.png'


const WineCard = ({ name, type, description, price, onAddToCart }) => {
  return (
    <Card isHoverable isCompact>
      <CardTitle>
        <Title headingLevel="h3" size="lg">
          {name}
        </Title>
      </CardTitle>

      <CardBody>
        {/* Wine Image */}
        <img src={wineImage} alt={name} style={{ width: '100%', marginBottom: '1rem' }} />
        {/*<StorageDomainIcon />*/}
        {/* Wine Type and Description */}
        <TextContent>
          <Text component="small" style={{ fontStyle: 'italic' }}>
            {type}
          </Text>
          <Text component="p">{description}</Text>
        </TextContent>
      </CardBody>

      <CardFooter>
        {/* Price and Add to Cart Button */}
        <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
          <Text component="p" style={{ fontWeight: 'bold', fontSize: '1.25rem' }}>
            ${price}
          </Text>
          <Button onClick={onAddToCart} variant="primary" icon={<ShoppingCartIcon />} iconPosition="left">
            Add to Cart
          </Button>
        </div>
      </CardFooter>
    </Card>
  );
};

export default WineCard;
