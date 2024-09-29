import {Card, CardBody, CardTitle} from "@patternfly/react-core";
import React from "react";


export const WineryCard = ({ winery }) => {
  return (
    <Card style={{ minHeight: 200, minWidth: 600}}>
      <CardTitle>{winery.name}</CardTitle>
      <CardBody>
        {winery.description}
      </CardBody>
    </Card>
  )
}
