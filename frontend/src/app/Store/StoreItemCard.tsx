import {BackgroundImage, Card, CardBody, CardTitle, Grid, GridItem, Text} from "@patternfly/react-core";
import React from "react";
import {
  BackgroundImageBasic
} from "@patternfly/react-core/src/components/BackgroundImage/examples/BackgroundImageBasic";

import bottleSvg from '../../assets/bottle/STANDART.png'
import {SmallBottle, StandartBottle} from "../icons/Bottles";

const bottleSwitch = {
  'STANDART': <StandartBottle />,
  'SMALL': <SmallBottle />,
}

export const StoreItemCard = ({ item }) => {
  console.log(item)
  console.log(bottleSwitch[item.batch.bottle])
  return (
    <Card style={{ minHeight: 200, minWidth: 600}}>
      <Grid>
        <GridItem span={4} rowSpan={4}>
          { bottleSwitch[item.batch.bottle] }
        </GridItem>
        <GridItem span={6} rowSpan={4}>
          <CardTitle>{item.batch.wine.name}</CardTitle>
          <CardBody>
            <Text>Volume: {item.batch.volume}</Text>
            <Text>Price: {item.batch.price}</Text>
            <Text>Available: {item.bottlesAvailable}</Text>
          </CardBody>
        </GridItem>
      </Grid>

    </Card>
  )
}
