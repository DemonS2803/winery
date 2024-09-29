import {Card, CardBody, CardTitle, Text} from "@patternfly/react-core";
import React from "react";

export const BatchCard = ({ batch }) => {
  return (
    <Card style={{ minHeight: 200, minWidth: 600}}>
      <CardTitle>{batch.wine.name}</CardTitle>
      <CardBody>
        <Text>Volume: {batch.volume}</Text>
        <Text>Price: {batch.price}</Text>
      </CardBody>
    </Card>
  )
}
