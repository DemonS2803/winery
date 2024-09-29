import * as React from "react";
import {PageSection, Title} from "@patternfly/react-core";
import {BatchCardList} from "@app/Batch/BatchCardList";
import {StoreItemsCardList} from "@app/Store/StoreItemsList";

const Store: React.FunctionComponent = () => (
  <PageSection>
    <Title headingLevel="h1" size="lg">Store. Gimme money. more. more!</Title>
    <StoreItemsCardList />
  </PageSection>
)

export { Store };
