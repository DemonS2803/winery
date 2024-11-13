import * as React from "react";
import {Button, PageSection, Title} from "@patternfly/react-core";
import {StoreItemsCardList} from "@app/Store/StoreItemsList";
import {CustomerBucketCardList} from "@app/CustomerBucket/CustomerBucketCardList";
import {backendApi} from "@app/utils/axios-config";

const CustomerBucket: React.FunctionComponent = () => (
  <>
    {localStorage.getItem('role') !== 'ADMIN'
      ?
        <PageSection>
          <Title headingLevel="h1" size="lg">My Bucket</Title>
          <CustomerBucketCardList />
          <Button onClick={() => backendApi.post('/bucket/buy', {})}>BUY</Button>
        </PageSection>
      : <h1>No access</h1>
    }
  </>
)

export { CustomerBucket };
