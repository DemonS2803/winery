import React, {useEffect, useState} from "react";
import axios from "axios";
import {environment} from "@app/environment";
import {Flex, FlexItem} from "@patternfly/react-core";
import {BatchCard} from "@app/Batch/BatchCard";
import {StoreItemCard} from "@app/Store/StoreItemCard";

export const StoreItemsCardList = () => {

  const [items, setItems] = useState([])

  useEffect(() => {
    const getStoreItemsListData = async () => {
      const result = await axios(`${environment.backendUrl}/inventory/available`)
      setItems(result.data)
      console.log(result.data)
      // wineries = result.data
    }
    getStoreItemsListData()
  }, []);

  // @ts-ignore
  return (
    <Flex style={{ margin: '15px' }}>
      {/*// <Gallery>*/}
      {items.map(item => {
        return(
          // @ts-ignore
          <FlexItem key={item.id}><StoreItemCard  item={item} /></FlexItem>
        )})}
    </Flex>
  )

}