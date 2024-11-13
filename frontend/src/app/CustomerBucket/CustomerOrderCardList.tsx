import React, {useEffect, useState} from "react";
import axios from "axios";
import {environment} from "@app/environment";
import {DataList, DataListCell, DataListItem, DataListItemCells, DataListItemRow, Flex, FlexItem} from "@patternfly/react-core";
import {StoreItemCard} from "@app/Store/StoreItemCard";
import {CustomerBucket} from "@app/CustomerBucket/CustomerBucket";
import {CustomerBucketItemCard} from "@app/CustomerBucket/CustomerBucketItemCard";
import {backendApi} from "@app/utils/axios-config";

export const CustomerOrderCardList = () => {

  const [orders, setOrders] = useState([])

  useEffect(() => {
    const getCustomerBucketListData = async () => {
      const result = await backendApi.get(`/bucket/orders`)
      setOrders(result)
      console.log(result)
      // wineries = result.data
    }
    getCustomerBucketListData()
  }, []);

  // @ts-ignore
  return (
    <DataList aria-label={'single action data list example '} >
      {orders.map(item => (
        <DataListItem aria-labelledby="single-action-item1">
          <DataListItemRow>
            <DataListItemCells dataListCells={[
              <DataListCell key="primary content">
                <span id="single-action-item1">{item.id}</span>
              </DataListCell>,
              <DataListCell key="secondary content">{item.created}</DataListCell>,
              <DataListCell key="secondary content">{item.status}</DataListCell>,
              <DataListCell key="secondary content">{item.totalPrice}</DataListCell>,
            ]}>


            </DataListItemCells>
          </DataListItemRow>
        </DataListItem>
      ))}
    </DataList>
  )

}
