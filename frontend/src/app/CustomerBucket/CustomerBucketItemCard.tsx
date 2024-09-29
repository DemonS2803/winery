import {Card, CardBody, CardTitle, Text} from "@patternfly/react-core";
import React from "react";

export const CustomerBucketItemCard = ({ item }) => {
  console.log(item)
  return (
    <Card style={{ minHeight: 200, minWidth: 600}}>
      <CardTitle>{item.batch.wine.name}</CardTitle>
      <CardBody>
        {/*<Text>Volume: {item.batch.volume}</Text>*/}
        {/*<Text>Price: {item.batch.price}</Text>*/}
        {/*<Text>Available: {item.bottlesAvailable}</Text>*/}
      </CardBody>
    </Card>
  )
}
