import * as React from "react";
import {
  Button, DataList,
  DataListCell,
  DataListItem,
  DataListItemCells,
  DataListItemRow,
  PageSection,
  Title
} from "@patternfly/react-core";
import {StoreItemsCardList} from "@app/Store/StoreItemsList";
import {CustomerBucketCardList} from "@app/CustomerBucket/CustomerBucketCardList";
import {backendApi} from "@app/utils/axios-config";
import {useState} from "react";
import {CustomerOrderCardList} from "@app/CustomerBucket/CustomerOrderCardList";

const CustomerBucket: React.FunctionComponent = () => {
  const [orders, setOrders] = useState([])

  return (
    <>
      {localStorage.getItem('role') !== 'ADMIN'
        ?
        <PageSection>
          <Title headingLevel="h1" size="lg">My Bucket</Title>
          <CustomerBucketCardList />
          <Button onClick={() => backendApi.post('/bucket/buy', {})}>BUY</Button>

         <CustomerOrderCardList />
        </PageSection>
        : <h1>No access</h1>
      }
    </>
  )
}



export { CustomerBucket };
