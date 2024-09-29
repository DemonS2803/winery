import {BackgroundImage, Card, CardBody, CardTitle, Text} from "@patternfly/react-core";
import React from "react";
import {ImageIcon} from "@patternfly/react-icons";


export const VineyardCard = ({ vineyard }) => {
  return (
    <Card style={{ minHeight: 200, minWidth: 600}}>
      <CardTitle>{vineyard.name}</CardTitle>
      <CardBody>
        <Text>Winery: {vineyard.winery.name}</Text>
        <Text>{vineyard.description}</Text>
      </CardBody>
    </Card>
  )
}
