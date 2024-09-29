import React, {useEffect, useState} from "react";
import axios from "axios";
import {environment} from "@app/environment";
import {DataList, DataListCell, DataListItem, DataListItemCells, DataListItemRow, Flex, FlexItem} from "@patternfly/react-core";
import {StoreItemCard} from "@app/Store/StoreItemCard";
import {CustomerBucket} from "@app/CustomerBucket/CustomerBucket";
import {CustomerBucketItemCard} from "@app/CustomerBucket/CustomerBucketItemCard";

export const CustomerBucketCardList = () => {

  const [items, setItems] = useState([])

  useEffect(() => {
    const getCustomerBucketListData = async () => {
      const result = await axios(`${environment.backendUrl}/bucket`)
      setItems(result.data)
      console.log(result.data)
      // wineries = result.data
    }
    getCustomerBucketListData()
  }, []);

  // @ts-ignore
  return (
    <DataList aria-label={'single action data list example '} >
      {items.map(item => (
        <DataListItem aria-labelledby="single-action-item1">
          <DataListItemRow>
            <DataListItemCells dataListCells={[
              <DataListCell key="primary content">
                <span id="single-action-item1">{item.batch.wine.name}</span>
              </DataListCell>,
              <DataListCell key="secondary content">{item.batch.price}$</DataListCell>,
              <DataListCell key="secondary content">{item.id.position}</DataListCell>,
            ]}>


            </DataListItemCells>
          </DataListItemRow>
        </DataListItem>
      ))}
    </DataList>
  )

}
