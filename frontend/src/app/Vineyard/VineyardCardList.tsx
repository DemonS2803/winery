import axios from "axios";
import {environment} from "@app/environment";
import {useEffect, useState} from "react";
import {Flex, FlexItem } from "@patternfly/react-core";
import React from "react";
import {VineyardCard} from "@app/Vineyard/VineyardCard";


export const VineyardCardList = () => {

  const [vineyards, setVineyards] = useState([])

  useEffect(() => {
    const getVineyardsListData = async () => {
      const result = await axios(`${environment.backendUrl}/vineyard/all`)
      setVineyards(result.data)
      // wineries = result.data
    }
    getVineyardsListData()
  }, []);

  // @ts-ignore
  return (
    <Flex style={{ margin: '15px' }}>
      {/*// <Gallery>*/}
      {vineyards.map(vineyard => {
        return(
          // @ts-ignore
          <FlexItem key={vineyard.id}><VineyardCard  vineyard={vineyard} /></FlexItem>


        )})}
    </Flex>
  )

}
