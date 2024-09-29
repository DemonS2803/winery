import * as React from "react";
import {PageSection, Title} from "@patternfly/react-core";
import {StoreItemsCardList} from "@app/Store/StoreItemsList";
import {CustomerBucketCardList} from "@app/CustomerBucket/CustomerBucketCardList";

const CustomerBucket: React.FunctionComponent = () => (
  <PageSection>
    <Title headingLevel="h1" size="lg">My Bucket</Title>
    <CustomerBucketCardList />
  </PageSection>
)

export { CustomerBucket };
